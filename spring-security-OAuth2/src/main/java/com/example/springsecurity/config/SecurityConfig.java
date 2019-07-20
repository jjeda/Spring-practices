package com.example.springsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
@EnableWebSecurity // 웹에서 시큐리티 기능을 사용하겠다 -> 자동설정 적용
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    //자동설정을 그냥 사용할 수도 있지만 요청, 권한, 기타 설정에 대해서 필수적으로 최적화한 설정이 들어가야한다.
    //configure를 오버라이드하여 원하는 형식의 시큐리티 설정

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();

        http
            .authorizeRequests() // 인증 메커니즘을 요청한 HttpServletRequest 기반으로 설정 -> 권한 설정을 시작하겠다
                //설정을 먼저 할 수록 우선 순위가 높다
                //antMathcers() : 요청 패턴을 리스트 형식으로 설정
                //permitAll() : 설정한 리퀘스트 패턴을 누구나 접근할 수 있도록 허용
                //anyRequest() : 설정한 요청 이외의 리퀘스트 요청
                //authenticated() : 인증된 사용자만 허용
                .antMatchers("/","/oauth2/**", "login/**", "/css/**","/images/**", "/js/**", "console/**").permitAll()
                .antMatchers("/facebook").hasAuthority(FACEBOOK.getRoleType())
                .antMatchers("/google").hasAuthority(GOOGLE.getRoleType())
                .anyRequest().authenticated()
            .and()
                .oauth2Login()
                .defaultSuccessUrl("/loginSucess") //인증이 성공했을때
                .failureUrl("/loginFailure") //인증이 실패했을 때
            .and()
                .headers().frameOptions().disable() // resoponse header 설정 -> frameOption 최적화 설정 허용x
            .and()
                .exceptionHandling()
                //인증의 진입 지점 : 인증되지 않은 사용자가 허용되지 않은 경로로 리퀘스트를 요청할 경우
                .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login")) //로 이동
            .and()
                //로그인에 성공하면 설정된 경로로 포워딩
                .formLogin()
                .successForwardUrl("/board/list")
            .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .deleteCookies("JESSIONID") //쿠키 날리고
                .invalidateHttpSession(true) //세션 날리고
            .and()
                //첫 번째 인자보다 먼저 시작될 필터를 등록
                //filter(문자인코딩) 보다 CsrfFilter가 먼저 적용되도록 설정
                .addFilterBefore(filter, CsrfFilter.class)
                .csrf().disable();
    }
}
