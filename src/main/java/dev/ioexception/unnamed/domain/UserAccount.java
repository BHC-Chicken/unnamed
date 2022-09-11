package dev.ioexception.unnamed.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "email", unique = true),
        @Index(columnList = "userId", unique = true),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
})
@Entity
public class UserAccount implements UserDetails {
    @Id
    @Column(length = 50)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Setter
    @Column(nullable = false)
    private String username;

    @Setter
    @Column(length = 100)
    private String password;
    @Setter
    @Column(length = 100)
    private String nickname;

    @Setter
    @Column(length = 100)
    private String authority;

    @Setter
    @Column(nullable = false)
    private boolean isEmailVerifiedFlag;

    @Setter
    @Column(nullable = false)
    private boolean isSuspendedFlag;

    @Setter
    @Column(nullable = false)
    private boolean isDeletedFlag;

    @Setter
    @Column(nullable = false)
    private boolean isStdCardVerifiedFlag;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt; // 생성일시

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime modifiedAt; // 수정일시



    protected UserAccount() {
    }

    public UserAccount(String username, String password, String nickname, String authority) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.authority = authority;
    }

    public static UserAccount of(String username, String password, String email, String nickname) {
        return new UserAccount(username, password, email, nickname);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserAccount that)) return false;
        return username != null && username.equals(that.getUsername());
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton((GrantedAuthority) () -> authority);
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
