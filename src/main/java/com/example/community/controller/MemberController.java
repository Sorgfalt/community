package com.example.community.controller;

import com.example.community.dto.MemberDto;
import com.example.community.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class MemberController {
  private MemberService memberService;

  @Autowired
  public void MemberService(MemberService memberService) {
    this.memberService = memberService;
  }

  @RequestMapping("/logIn")
  public String logIn(){
    return "logIn/logIn";
  }
  @RequestMapping("/logInForm")
  public String logInForm(HttpServletRequest request){

    String regId = request.getParameter("regId");
    String password = request.getParameter("password");

    HttpSession session = request.getSession();
    session.setAttribute("regId", regId);
    session.setAttribute("password", password);

    return "redirect:/main";
  }

  @RequestMapping("signUp")
  public String signUp(){
    return "logIn/signUp";
  }

  @PostMapping("/signUpForm")
  public String signUpMember(MemberDto memberDto){
    memberService.joinMember(memberDto);

    return "redirect:/logIn";
  }

}
