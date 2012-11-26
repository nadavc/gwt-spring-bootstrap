package com.mycompany.services;

import com.mycompany.dal.dao.UserDao;
import com.mycompany.shared.TenantContext;
import com.mycompany.shared.User;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

@Component("authenticationProvider")
public class AuthenticationProviderImpl implements AuthenticationProvider {

    @Inject
    private UserDao userDao;

    @Inject
    private TenantContext tenantContext;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // Username must be formatted as 'username@tenantId'
        if (!Pattern.matches("[^@]+@.+", authentication.getName())) {
            throw new RuntimeException("Invalid username format");
        }

        String[] split = authentication.getName().split("@");
        String username = split[0];
        String tenantId = split[1];

        // Since this is the first entry point for the system, we need to set the
        // tenant id for the datasource and other factories
        tenantContext.setTenantId(tenantId);

        User user = userDao.readUser(username);
        if (user == null) {
            throw new UsernameNotFoundException("Could not find " + username);
        }

        if (!user.getPassword().equals(authentication.getCredentials())) {
            throw new BadCredentialsException("Bad credentials");
        }

        List<GrantedAuthority> grantedAuthorities = new LinkedList<GrantedAuthority>();
        String[] userAuths = user.getAuthorities().split(",");
        for (String auth : userAuths) {
            grantedAuthorities.add(createGrantedAuthority(auth));
        }
        return new UsernamePasswordAuthenticationToken(user, user.getPassword(), grantedAuthorities);
    }

    private GrantedAuthority createGrantedAuthority(final String name) {
        return new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return name;
            }
        };
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.equals(authentication);
    }
}
