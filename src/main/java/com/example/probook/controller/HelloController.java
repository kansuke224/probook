package com.example.probook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

import com.example.probook.dto.User;
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
  @RequestMapping("/user/{userId}")
  private ModelAndView showUserInfo(@PathVariable("userId") String userId ,ModelAndView mav) {
    User user = userService.getUserInfo(userId);

    mav.addObject("user", user);
    mav.setViewName("showUserInfo");
    return mav;
  }

}
