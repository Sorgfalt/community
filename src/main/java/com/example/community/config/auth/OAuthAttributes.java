package com.example.community.config.auth;

import java.util.Map;
import lombok.Builder;
import lombok.Getter;

@Getter
public class OAuthAttributes {
  private Map<String, Object> attributes;
  private String nameAttributeKey;
  private String name;
  private String email;
  private String picture;

  @Builder
  public OAuthAttributes(Map<String, Object> attributes,
                        String nameAttributeKey, String name, String email, String picture) {
      this.attributes = attributes;
      this.nameAttributeKey = nameAttributeKey;
      this.name = name;
      this.email = email;
      this.picture = picture;
  }

  public static OAuthAttributes of( ){

  }
}