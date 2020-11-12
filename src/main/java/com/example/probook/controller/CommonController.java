package com.example.probook.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.probook.dto.UserDto;

@ControllerAdvice
public class CommonController {

  @ModelAttribute
  public UserDto setUpUser() {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    //Principalからログインユーザの情報を取得
    String userName = auth.getName();

    UserDto user = new UserDto();
    user.setUserName(userName);

    return user;
  }

}
