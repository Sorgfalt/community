package com.example.community.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception{
    http.csrf().disable() // csrf의 공격을 막기 위해서 disable
      .formLogin()  //  기본 제공하는 로그인 화면 사용
      .and()
      .httpBasic();  // http 통신으로 basic auth 사용 가능
  }
}
