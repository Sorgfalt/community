package com.example.community.configuration;

import com.example.community.service.user.UserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebMvcConfig {

  @Bean
  public UserDetailService userDetailService(){
    return new UserDetailService();
  }
}
