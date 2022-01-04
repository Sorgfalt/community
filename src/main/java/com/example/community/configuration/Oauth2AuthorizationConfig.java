package com.example.community.configuration;

import com.example.community.service.user.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@EnableAuthorizationServer // 해당 어노테이션을 추가하면 구체적인 환경설정 가능
@Configuration
@Order(100)
public class Oauth2AuthorizationConfig extends AuthorizationServerConfigurerAdapter {
  //AuthorizationServerConfigurerAdapter 클래스 상속

  @Autowired
  private UserDetailService userDetailService;

  @Override
  public void configure(AuthorizationServerSecurityConfigurer security) throws Exception{
    super.configure(security);
  }

  //client setting
  @Override
  public void configure(ClientDetailsServiceConfigurer clients) throws Exception{
    clients.inMemory() // 클라이언트 정보를 메모리에 저장, jdbc()는 DB에 저장 - 운영 환경에서 적합
      .withClient("clientId") // 클라이언트 아이디
      .secret("{noop}secretKey") // 시크릿키 ({} 안에 암호화 알고리즘을 명시 하면 된다. 암호화가 되어 있지 않다면 {noop}로 설정 해야 한다. 실제 요청은 암호화 방식인 {noop}를 입력 하지 않아도 된다.)
      .authorizedGrantTypes("authorization_code","password", "refresh_token") // 가능한 토큰 발행 타입
      .scopes("read", "write") // 가능한 접근 범위
      .accessTokenValiditySeconds(60) // 토큰 유효 시간 : 1분
      .refreshTokenValiditySeconds(60*60) // 토큰 유효 시간 : 1시간
      .redirectUris("http://localhost:8080/callback") // 가능한 redirect uri
      .autoApprove(true); // 권한 동의는 자동으로 yes (false 로 할시 권한 동의 여부를 묻는다.)
  }

  //인증, 토근 설정
  @Override
  public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception{
    endpoints.userDetailsService(userDetailService);
  }
}
