package io.security.springsecuritystudy.users.service;

import io.security.springsecuritystudy.domain.entity.Account;
import io.security.springsecuritystudy.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void createUser(Account account) {
        userRepository.save(account);
    }
}
