package dev.ioexception.unnamed.repository;

import dev.ioexception.unnamed.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    User findByUsername(String username);
}
