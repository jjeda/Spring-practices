package me.ssafy.demo.user;

import me.ssafy.demo.user.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class UserControllerTest {


    @Autowired
    private MockMvc mvc;

    @MockBean
    public UserRepository userRepository;

    @Test
    public void 유저리스트_확인() throws Exception {
            mvc.perform(get("/api/users"))
                    .andExpect(status().isOk());

    }
}