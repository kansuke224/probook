package com.example.probook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.probook.dto.UserDto;
import com.example.probook.service.UserService;

// RestControllerとは？
// => viewに遷移せずメソッドの返り値が、そのままコンテンツになる
// => Json,xmlを返すweb apiのコントローラーを作るときに利用できる

// Controller
// メソッドの返り値は、String, ModelAndViewなど
// 今回はModelAndViewを利用していく
@Controller
public class HelloController {

  @Autowired
  UserService userService;

  // @RequestMapping
  // => メソッドに付与することで、クライアントからのリクエストにメソッドをマッピングできる
  // 属性として、value, method, headers, params を指定し、マッチの条件を付けることができる
  // デフォルトでは,value(urlの相対パスor絶対パス)のみ
  //
  // メソッドだけでなく、クラスにも付与ができる

  // @RequestParams()などを使い、クエリパラメータや、postなどの値を取得することができるらしい
//  @RequestMapping("/user/{userId}")
//  private ModelAndView showUserInfo(@PathVariable("userId") String userId ,ModelAndView mav) {
//    UserDto user = userService.findUserById(userId);
//
//    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//    //Principalからログインユーザの情報を取得
//    String userName = auth.getName();
//
//    System.out.println(auth);
//
//    user.userName = userName + "認証済み";
//
//    mav.addObject("user", user);
//    mav.setViewName("demo/showUserInfo");
//    return mav;
//  }

  @RequestMapping("/hello")
  private ModelAndView hello(ModelAndView mav) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String userName = auth.getName();

    UserDto dto = userService.findUserByUsername(userName);

    mav.addObject("user", dto);
    mav.setViewName("demo/showUserInfo");
    return mav;
  }


}
