package com.example.community.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
@Table(name="member")
public class Member {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, name = "regId")
  private String regId;

  @Column(nullable = false, name = "password")
  private String password;

  @Column(nullable = false, name = "userName")
  private String userName;

  @Column(nullable = false, name = "email")
  private String email;

  @Column(name = "picture")
  private String picture;

  @Column(nullable = false, name = "role")
  private Role role;

  @Builder
  public Member(Long id, String regId, String password, String userName, String email, String picture, Role role) {
    this.id = id;
    this.regId = regId;
    this.password = password;
    this.userName = userName;
    this.email = email;
    this.picture = picture;
    this.role = role;
  }

  public Member update(String userName, String picture){
    this.userName = userName;
    this.picture = picture;

    return this;
  }

  public String getRoleKey(){
    return this.role.getKey();
  }
}
