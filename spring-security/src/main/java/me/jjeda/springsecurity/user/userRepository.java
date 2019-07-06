package me.jjeda.springsecurity.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<User,Long> {
}
