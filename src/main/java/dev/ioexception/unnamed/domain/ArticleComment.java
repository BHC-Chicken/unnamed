package dev.ioexception.unnamed.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@ToString
@Entity
public class ArticleComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @ManyToOne(optional = false)
    @JoinColumn(name = "username")
    private UserAccount userAccount;

    @Setter
    @ManyToOne(optional = false)
    private Article article;

    @Setter
    @Column(nullable = false, length = 500)
    private String content; // 본문

    @CreatedDate
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @CreatedBy
    @Column(nullable = false, length = 100)
    private String createdBy;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(nullable = false)
    @LastModifiedDate
    private LocalDateTime modifiedAt;

    @LastModifiedBy
    @Column(nullable = false, length = 100)
    private String modifiedBy;

    public ArticleComment() {
    }

    public ArticleComment(UserAccount userAccount, Article article, String content) {
        this.userAccount = userAccount;
        this.article = article;
        this.content = content;
    }

    public static ArticleComment of(UserAccount userAccount, Article article, String content) {
        return new ArticleComment(userAccount, article, content);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArticleComment that)) return false;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
