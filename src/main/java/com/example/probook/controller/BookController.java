package com.example.probook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.probook.dto.UserDto;
import com.example.probook.form.PostBookForm;

@Controller
@RequestMapping("/book")
public class BookController {

  @RequestMapping(value="/", method=RequestMethod.GET)
  public String show(@ModelAttribute UserDto user, Model model) {
    model.addAttribute("user", user);
    return "/book";
  }

}
