package me.jjeda.springsecurity.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long userid;

    @Column
    @NotNull
    private String passwd;

    @Column
    @NotNull
    private String name;

    @Column
    private int enabled;

    @Column
    private String authority;

    @Builder
    public User(@NotNull String passwd, @NotNull String name, int enabled, String authority) {
        this.passwd = passwd;
        this.name = name;
        this.enabled = enabled;
        this.authority = authority;
    }
}
