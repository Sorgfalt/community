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

  @Column(nullable = false, name = "name", columnDefinition = "varchar(20)")
  private String name;

  @Column(nullable = false, name = "email", columnDefinition = "varchar(50)")
  private String email;

  @Column(name = "picture")
  private String picture;

  @Column(nullable = false, name = "role", columnDefinition = "varchar(30)")
  private Role role;

  @Builder
  public Member(Long id, String name, String email, String picture, Role role) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.picture = picture;
    this.role = role;
  }

  public Member update(String name, String picture){
    this.name = name;
    this.picture = picture;

    return this;
  }

  public static String getRoleKey(){
    return this.role.getKey();
  }
}
