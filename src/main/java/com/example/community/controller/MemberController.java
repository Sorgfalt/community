package com.example.community.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class MemberController {

  @RequestMapping("logIn")
  public String logIn(){
    return "logIn/logIn";
  }
  @RequestMapping("/logInForm")
  public String logInForm(Model model, HttpServletRequest request) throws Exception{

    String regId = request.getParameter("regId");
    String password = request.getParameter("password");

    HttpSession session = request.getSession();
    session.setAttribute("regId", regId);
    session.setAttribute("password", password);

    return "redirect:/main";

  }

}
