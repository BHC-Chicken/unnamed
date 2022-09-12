package dev.ioexception.unnamed.service;

import dev.ioexception.unnamed.domain.UserAccount;
import dev.ioexception.unnamed.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    UserAccountRepository userAccountRepository;
    public UserAccount findByUsername(String username) {
        return userAccountRepository.findByUsername(username);

    }
}
