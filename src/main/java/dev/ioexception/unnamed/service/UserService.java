package dev.ioexception.unnamed.service;

import dev.ioexception.unnamed.domain.UserAccount;
import dev.ioexception.unnamed.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    UserRepository userRepository;
    public UserAccount findByUsername(String username) {
        return userRepository.findByUsername(username);

    }
}
