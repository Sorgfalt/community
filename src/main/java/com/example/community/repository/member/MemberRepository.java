package com.example.community.repository.member;

import com.example.community.domain.entity.member.Member;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
  Optional<Member> findByEmail(String email);
}
