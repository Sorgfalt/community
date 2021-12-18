package com.example.community.service;

import com.example.community.dto.MemberDto;
import com.example.community.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
