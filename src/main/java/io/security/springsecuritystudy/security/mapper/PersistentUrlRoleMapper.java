package io.security.springsecuritystudy.security.mapper;

import java.util.Map;

public class PersistentUrlRoleMapper implements UrlRoleMapper{
    @Override
    public Map<String, String> getUrlRoleMappings() {
        return Map.of();
    }
}
