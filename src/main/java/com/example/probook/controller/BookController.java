package com.example.probook.controller;

import org.springframework.stereotype.Controller;
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
@RequestMapping("/book/")
public class BookController {

  @RequestMapping(value="/", method=RequestMethod.GET)
  public ModelAndView show(@ModelAttribute UserDto user, ModelAndView mav) {
    mav.addObject("user", user);
    mav.setViewName("/book");
    return mav;
  }



  @RequestMapping(value="/post", method=RequestMethod.GET)
  public ModelAndView postShow(@ModelAttribute UserDto user, ModelAndView mav) {
    mav.addObject("user", user);
    mav.setViewName("/post_book");
    return mav;
  }

  @RequestMapping(value="/post", method=RequestMethod.POST)
  public String post(
      @Validated PostBookForm form,
      BindingResult result,
      @RequestParam("bookImage") MultipartFile bookImageFile,
      @RequestParam("bookContent") MultipartFile bookContentFile
  ) {

    System.out.println("");


    /*
    File uploadFile = new File(uploadDir.getPath() + "/" + fileType);
    byte[] bytes = multipartFile.getBytes();
    BufferedOutputStream uploadFileStream =
            new BufferedOutputStream(new FileOutputStream(uploadFile));
    uploadFileStream.write(bytes);
    uploadFileStream.close();
     */


    return "redirect:/account/";
  }



  @RequestMapping(value="/edit", method=RequestMethod.GET)
  public ModelAndView editShow(@ModelAttribute UserDto user, ModelAndView mav) {
    mav.addObject("user", user);
    mav.setViewName("/post_book_control");
    return mav;
  }

  @RequestMapping(value="/edit", method=RequestMethod.POST)
  public ModelAndView edit(@ModelAttribute UserDto user, ModelAndView mav) {
    mav.addObject("user", user);
    mav.setViewName("/post_book_control");
    return mav;
  }

}
