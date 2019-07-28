package me.jjeda.restwhiteship.configs;


import me.jjeda.restwhiteship.account.Account;
import me.jjeda.restwhiteship.account.AccountRole;
import me.jjeda.restwhiteship.account.AccountService;
import me.jjeda.restwhiteship.common.RestDocsConfiguration;
import me.jjeda.restwhiteship.commons.TestDescription;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Set;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
/*@WebMvcTest*/
@SpringBootTest //더이상 슬라이싱 테스트면안된다
@AutoConfigureMockMvc // mockMvc 쓰려면
@AutoConfigureRestDocs
@Import(RestDocsConfiguration.class)
public class AuthServerConfigTest {
    @Autowired
    AccountService accountService;

    @Autowired
    MockMvc mockMvc;

    @Test
    @TestDescription("인증 토큰을 발급 받는 테스트")
    public void getAuthToken() throws Exception {
        //Given
        String username = "jjeda@naver.com";
        String password = "jjeda";
        Account jjeda = Account.builder()
                .email(username)
                .password(password)
                .roles(Set.of(AccountRole.ADMIN,AccountRole.USER))
                .build();
        this.accountService.saveAccount(jjeda);

        String clientId="myApp";
        String clientSecret = "pass";


         this.mockMvc.perform(post("/oauth/token")
                     .with(httpBasic(clientId,clientSecret))
                     .param("username",username)
                     .param("password",password)
                     .param("grant_type", "password"))
                     .andDo(print())
                 .andExpect(status().isOk())
                 .andExpect(jsonPath("access_token").exists());

    }
}