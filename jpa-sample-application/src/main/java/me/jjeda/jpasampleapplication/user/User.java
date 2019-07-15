package me.jjeda.jpasampleapplication.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String userName;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String auth;

    @Builder
    public User(String userName, String email, String password, String auth) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.auth = auth;
    }
}
