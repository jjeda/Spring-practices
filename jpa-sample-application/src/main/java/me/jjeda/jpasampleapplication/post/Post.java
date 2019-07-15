package me.jjeda.jpasampleapplication.post;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String title;

    @Column
    private String body;

    @Column
    private String imgSrc;

    @Column(name ="created_at")
    private LocalDateTime createdAt;

    public void setCreatedDateNow() {
        this.createdAt = LocalDateTime.now();
    }

    @Builder
    public Post(String title, String body, String imgSrc) {
        this.title = title;
        this.body = body;
        this.imgSrc = imgSrc;
    }
}
