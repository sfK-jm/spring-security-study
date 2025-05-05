package io.security.springsecuritystudy.admin.service;

import io.security.springsecuritystudy.domain.dto.AccountDto;
import io.security.springsecuritystudy.domain.entity.Account;

import java.util.List;

public interface UserManagementService {

    List<Account> getUsers();
    AccountDto getUser(Long id);

    void modifyUser(AccountDto accountDto);
    void deleteUser(Long id);
}
