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

  public Member toJoinMember(){
    return Member.builder()
      .id(id)
      .regId(regId)
      .password(password)
      .userName(userName)
      .build();
  }

  @Builder
  public MemberDto(Long id, String regId, String password, String userName){
    this.id = id;
    this.regId = regId;
    this.password = password;
    this.userName = userName;

  }
}
