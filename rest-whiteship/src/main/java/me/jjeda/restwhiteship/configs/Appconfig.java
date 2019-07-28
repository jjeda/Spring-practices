package me.jjeda.restwhiteship.configs;

import me.jjeda.restwhiteship.account.Account;
import me.jjeda.restwhiteship.account.AccountRole;
import me.jjeda.restwhiteship.account.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.cache.annotation.AbstractCachingConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Configuration
public class Appconfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public ApplicationRunner applicationRunner() {
        return new ApplicationRunner() {

            @Autowired
            AccountService accountService;

            @Override
            public void run(ApplicationArguments args) throws Exception {
                Account jjeda = Account.builder()
                        .email("jjeda@naver.com")
                        .password("jjeda")
                        .roles(Set.of(AccountRole.ADMIN,AccountRole.USER))
                        .build();
                accountService.saveAccount(jjeda);
            }
        };
    }
}
