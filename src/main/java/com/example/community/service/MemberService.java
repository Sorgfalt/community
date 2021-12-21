package com.example.community.service;

import com.example.community.dto.MemberDto;
import com.example.community.repository.MemberRepository;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MemberService {

  private MemberRepository memberRepository;

  public MemberService(MemberRepository memberRepository){
    this.memberRepository = memberRepository;
  }

  @Transactional
  public Long joinMember(MemberDto memberDto) {
    return memberRepository.save(memberDto.toJoinMember()).getId();
  }
}
