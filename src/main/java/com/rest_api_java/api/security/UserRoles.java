package com.rest_api_java.api.security;

import org.springframework.security.core.GrantedAuthority;

public enum UserRoles implements GrantedAuthority {

    ROLE_ADMIN, ROLE_CLIENT;

    //----------------------------------------------------------------------

    @Override
    public String getAuthority() {
        return name();
    }
}
