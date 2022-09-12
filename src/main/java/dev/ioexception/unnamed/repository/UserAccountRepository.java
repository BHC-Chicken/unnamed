package dev.ioexception.unnamed.repository;

import dev.ioexception.unnamed.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, String> {
    UserAccount findByUsername(String username);
}
