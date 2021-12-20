package com.example.community.domain.entity;

@lombok.Getter
@lombok.RequiredArgsConstructor
public enum Role {
  GUEST("ROLE_GUEST","손님"),
  USER("ROLE_USER","일반 사용자");

  private final String key;
  private final String title;

}
