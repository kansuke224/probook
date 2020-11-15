package com.example.probook.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.probook.dto.UserDto;

@ControllerAdvice
public class CommonController {

  @Autowired
  HttpSession session;

  @ModelAttribute
  public UserDto setUpUser() {

    // Object -> UserDto へキャスト
    UserDto user = (UserDto) session.getAttribute("user");

    return user;

  }

}
