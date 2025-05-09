package io.security.springsecuritystudy.admin.service.impl;

import io.security.springsecuritystudy.admin.repository.RoleRepository;
import io.security.springsecuritystudy.admin.repository.UserManagementRepository;
import io.security.springsecuritystudy.admin.service.UserManagementService;
import io.security.springsecuritystudy.domain.dto.AccountDto;
import io.security.springsecuritystudy.domain.entity.Account;
import io.security.springsecuritystudy.domain.entity.Role;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@Service("userManagementService")
@RequiredArgsConstructor
public class UserManagementServiceImpl implements UserManagementService {

    private final UserManagementRepository userManagementRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public List<Account> getUsers() {
        return userManagementRepository.findAll();
    }

    @Transactional
    @Override
    public AccountDto getUser(Long id) {
        Account account = userManagementRepository.findById(id).orElse(new Account());
        ModelMapper modelMapper = new ModelMapper();
        AccountDto accountDto = modelMapper.map(account, AccountDto.class);

        List<String> roles = account.getUserRoles()
                .stream()
                .map(Role::getRoleName)
                .toList();

        accountDto.setRoles(roles);
        return accountDto;
    }

    @Transactional
    @Override
    public void modifyUser(AccountDto accountDto) {
        ModelMapper modelMapper = new ModelMapper();
        Account account = modelMapper.map(accountDto, Account.class);

        if(accountDto.getRoles() != null){
            Set<Role> roles = new HashSet<>();
            accountDto.getRoles().forEach(role -> {
                Role r = roleRepository.findByRoleName(role);
                roles.add(r);
            });
            account.setUserRoles(roles);
        }
        account.setPassword(passwordEncoder.encode(accountDto.getPassword()));
        userManagementRepository.save(account);
    }

    @Override
    public void deleteUser(Long id) {
        userManagementRepository.deleteById(id);
    }
}
