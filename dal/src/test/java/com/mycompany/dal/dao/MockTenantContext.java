package com.mycompany.dal.dao;

import com.mycompany.shared.TenantContext;
import org.springframework.stereotype.Component;

@Component
public class MockTenantContext implements TenantContext{

    @Override
    public String getTenantId() {
        return "firstTenant";
    }

    @Override
    public void setTenantId(String id) {
    }
}
