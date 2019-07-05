package me.ssafy.demo.user;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String eamil;

    @Column
    private String pass;

    @Column
    private String adress;

    @Builder
    public User(String eamil, String pass, String adress) {
        this.eamil = eamil;
        this.pass = pass;
        this.adress = adress;
    }
}
