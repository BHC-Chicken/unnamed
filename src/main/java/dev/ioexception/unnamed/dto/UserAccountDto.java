package dev.ioexception.unnamed.dto;

import dev.ioexception.unnamed.domain.UserAccount;

import java.time.LocalDateTime;

public record UserAccountDto(
        String username,
        String password,
        String nickname,
        String authority,
        LocalDateTime createdAt,
        LocalDateTime modifiedAt
) {

    public static UserAccountDto of(String username, String password, String nickname, String authority) {
        return new UserAccountDto(username, password, nickname, authority, null, null);
    }

    public static UserAccountDto of(String userId, String userPassword, String email, String nickname, String memo, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        return new UserAccountDto(userId, userPassword, email, nickname, createdAt, modifiedAt);
    }

    public static UserAccountDto from(UserAccount entity) {
        return new UserAccountDto(
                entity.getUsername(),
                entity.getPassword(),
                entity.getNickname(),
                entity.getAuthority(),
                entity.getCreatedAt(),
                entity.getModifiedAt()
        );
    }

    public UserAccount toEntity() {
        return UserAccount.of(
                username,
                password,
                nickname,
                authority
        );
    }

}
