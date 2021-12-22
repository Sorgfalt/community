package com.example.community.dto;

import com.example.community.domain.entity.Member;
import com.example.community.domain.entity.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberDto {
  private Long id;
  private String name;
  private String email;
  private String picture;
  private Role role;

  public Member toJoinMember(){
    return Member.builder()
      .id(id)
      .name(name)
      .email(email)
      .picture(picture)
      .role(role)
      .build();
  }

  @Builder
  public MemberDto(Long id, String name, String email, String picture, Role role) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.picture = picture;
    this.role = role;
  }
}
