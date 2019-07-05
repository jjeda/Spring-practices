package me.ssafy.demo.user;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@RequestMapping("/api")
public class UserController {

    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> list() {
        List<User> list ;
        userRepository.save(new User("email","pass","adress"));
        list=userRepository.findAll();
        return list;
    }

}
