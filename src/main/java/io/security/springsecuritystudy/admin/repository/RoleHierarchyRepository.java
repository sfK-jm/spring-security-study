package io.security.springsecuritystudy.admin.repository;

import io.security.springsecuritystudy.domain.entity.RoleHierarchy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleHierarchyRepository extends JpaRepository<RoleHierarchy, Long> {
}
