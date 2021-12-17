package com.example.community.domain.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
@Table(name = "member")
public class Member {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String regId;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false)
  private String userName;

  @Builder
  public Member(Long id, String regId, String password, String userName) {
    this.id = id;
    this.regId = regId;
    this.password = password;
    this.userName = userName;
  }
}
