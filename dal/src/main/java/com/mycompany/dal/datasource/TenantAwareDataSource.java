package com.mycompany.dal.datasource;

import com.mycompany.shared.TenantContext;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.inject.Inject;

public class TenantAwareDataSource extends AbstractRoutingDataSource {

    @Inject
    private TenantContext tenantContext;

    @Override
    protected Object determineCurrentLookupKey() {
        return tenantContext.getTenantId();
    }
}
