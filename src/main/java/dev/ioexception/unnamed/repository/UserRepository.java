package dev.ioexception.unnamed.repository;

import dev.ioexception.unnamed.domain.UserAccount;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    UserAccount findByUsername(String username);
}
