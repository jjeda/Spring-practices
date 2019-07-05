package me.ssafy.demo.user;

import me.ssafy.demo.user.User;
import me.ssafy.demo.user.UserRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @After
    public void cleanup() {
        /**
         이후 테스트 코드에 영향을 끼치지 않기 위해
         테스트 메소드가 끝날때 마다 respository 전체 비우는 코드
         **/
        userRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        //given
        userRepository.save(User.builder()
                .eamil("email")
                .pass("pass")
                .adress("adress")
                .build());

        //when
        List<User> userList = userRepository.findAll();

        //then
        User user = userList.get(0);
        assertThat(user.getEamil(), is("email"));
        assertThat(user.getAdress(), is("adress"));
    }

}