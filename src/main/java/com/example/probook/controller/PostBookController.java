package com.example.probook.controller;


import java.util.Map;

import org.seasar.doma.jdbc.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.probook.dto.BookDto;
import com.example.probook.dto.UserDto;
import com.example.probook.form.PostBookForm;
import com.example.probook.service.BookService;

@Controller
@RequestMapping("/postBook")
public class PostBookController {

  @Autowired
  BookService service;

  @RequestMapping(value="/", method=RequestMethod.GET)
  public String show(PostBookForm form, @ModelAttribute UserDto user, Model model) {
    model.addAttribute("user", user);
    model.addAttribute("postBookForm", form);
    model.addAttribute("kbn", "new");
    return "/post_book";
  }

  //検索した投稿書籍の情報を表示
  @RequestMapping(value="/edit", method=RequestMethod.GET)
  public String editShow(PostBookForm form, @ModelAttribute UserDto user, Model model) {
    model.addAttribute("user", user);
    model.addAttribute("postBookForm", form);
    model.addAttribute("kbn", "edit");
    return "/post_book :: contentFragment";
  }

  // 投稿書籍編集処理




  // 新規書籍投稿フォームを表示
  @RequestMapping(value="/new", method=RequestMethod.GET, consumes={ "multipart/form-data" })
  public String newShow(PostBookForm form, @ModelAttribute UserDto user, Model model) {
    model.addAttribute("user", user);
    model.addAttribute("postBookForm", form);
    model.addAttribute("kbn", "new");
    return "/post_book :: contentFragment";
  }


  //新規書籍投稿処理
  @RequestMapping(value="/new", method=RequestMethod.POST)
  public String newPost(
    @Validated PostBookForm form,
    BindingResult result,
    @ModelAttribute UserDto user,
    Model model
  ){

    System.out.println(model);

    if (result.hasErrors()) {
      model.addAttribute("form", form);
      model.addAttribute("errorMsg", "入力内容が正しくありません");
      return "/post_book :: contentFragment";
    }

    Map<String, Object> insertResult = service.newBook(form, user.getUserId());

    if ((int) insertResult.get("updateNum") == 0) {
      // insert失敗
      model.addAttribute("form", form);
      model.addAttribute("errorMsg", "ジャンル登録で問題が発生しました");
    } else {
      // insert成功
      model.addAttribute("form", (PostBookForm) insertResult.get("editForm"));
      model.addAttribute("successMsg", "ジャンル登録が完了しました");
    }


    return "/post_book :: contentFragment";
  }

}


