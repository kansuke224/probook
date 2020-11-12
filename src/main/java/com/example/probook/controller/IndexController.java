package com.example.probook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.probook.dto.UserDto;
import com.example.probook.service.UserService;

@Controller
@RequestMapping("/index")
public class IndexController {

  @Autowired
  UserService userservice;

  //@Autowired
  //private AuthenticationManager authManager;

  @RequestMapping(value = "/", method=RequestMethod.POST)
  public String showPost() {
    // ログイン成功時に  /index/  へリダイレクト
    // (ログインに成功するとsuccessForwardUrlにPOSTが投げられるが、
    // urlの変更がされず、sign_inのままなのでリダイレクトさせる)
    return "redirect:/index/";
  }

  @RequestMapping(value = "/", method=RequestMethod.GET)
  public ModelAndView show(@ModelAttribute UserDto user, ModelAndView mav) {
    /*
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    //Principalからログインユーザの情報を取得
    String userName = auth.getName();

    UserDto user = new UserDto();
    user.setUserName(userName);
    */
    System.out.println(user.getUserName());

    mav.addObject("user", user);
    mav.setViewName("/index");
    return mav;
  }




}
