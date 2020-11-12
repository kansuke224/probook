package com.example.probook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.probook.dto.UserDto;

@Controller
@RequestMapping("/account")
public class AccountController {

  @RequestMapping(value="/", method=RequestMethod.GET)
  public ModelAndView show(@ModelAttribute UserDto user, ModelAndView mav) {
    mav.addObject("user", user);
    mav.setViewName("/account");
    return mav;
  }

}
