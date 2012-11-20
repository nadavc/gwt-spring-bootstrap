package com.mycompany.shared;

public class TenantContextImpl implements TenantContext {

    private ThreadLocal<String> tenantId = new ThreadLocal<String>();

    @Override
    public String getTenantId() {
        return tenantId.get();
    }

    @Override
    public void setTenantId(String id) {
        tenantId.set(id);
    }

}
