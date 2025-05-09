package io.security.springsecuritystudy.admin.service.impl;

import io.security.springsecuritystudy.admin.repository.RoleHierarchyRepository;
import io.security.springsecuritystudy.admin.service.RoleHierarchyService;
import io.security.springsecuritystudy.domain.entity.Resources;
import io.security.springsecuritystudy.domain.entity.RoleHierarchy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;

@Service
public class RoleHierarchyServiceImpl implements RoleHierarchyService {

    private RoleHierarchyRepository roleHierarchyRepository;

    @Autowired
    public RoleHierarchyServiceImpl(RoleHierarchyRepository roleHierarchyRepository) {
        this.roleHierarchyRepository = roleHierarchyRepository;
    }


    @Transactional
    @Override
    public String findAllHierarchy() {

        List<RoleHierarchy> rolesHierarchy = roleHierarchyRepository.findAll();

        Iterator<RoleHierarchy> itr = rolesHierarchy.iterator();
        StringBuilder hierarchyRole = new StringBuilder();

        while (itr.hasNext()) {
            RoleHierarchy roleHierarchy = itr.next();
            if (roleHierarchy.getParent() != null) {
                hierarchyRole.append(roleHierarchy.getParent().getRoleName());
                hierarchyRole.append(" > ");
                hierarchyRole.append(roleHierarchy.getRoleName());
                hierarchyRole.append("\n");
            }
        }
        return hierarchyRole.toString();
    }
}
