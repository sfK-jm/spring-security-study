package io.security.springsecuritystudy.admin.repository;

import io.security.springsecuritystudy.domain.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserManagementRepository extends JpaRepository<Account, Long> {
}
