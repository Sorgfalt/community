package com.example.community.dto;

import com.example.community.domain.entity.Member;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberDto {
  private Long id;
  private String regId;
  private String password;
  private String userName;
  private String email;
  private String picture;
  private com.example.community.domain.entity.Role role;

  public Member toJoinMember(){
    return Member.builder()
      .id(id)
      .regId(regId)
      .password(password)
      .userName(userName)
      .email(email)
      .picture(picture)
      .role(role)
      .build();
  }

  @Builder
  public MemberDto(Long id, String regId, String password, String userName, String email, String picture, com.example.community.domain.entity.Role role) {
    this.id = id;
    this.regId = regId;
    this.password = password;
    this.userName = userName;
    this.email = email;
    this.picture = picture;
    this.role = role;
  }
}
