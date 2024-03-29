package me.jjeda.jpasampleapplication.portfolio;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Portfolio {

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
    public Portfolio(String title, String body, String imgSrc) {
        this.title = title;
        this.body = body;
        this.imgSrc = imgSrc;
    }
}
