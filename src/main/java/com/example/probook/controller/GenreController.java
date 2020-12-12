/*
* GenreController.java [2020/11/15]
*
* Copyright SnapShot Inc.
*/
package com.example.probook.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Conventions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.probook.dto.UserDto;
import com.example.probook.form.GenreForm;
import com.example.probook.service.GenreService;

/**
 *
 * GenreController
 * @author MYOUJI, Namae(【メールアドレス】)
 *
 * @since 2020/11/15 10:49:28
 */

@Controller
@RequestMapping("/genre")
public class GenreController {

  @Autowired
  GenreService service;

  // ジャンル追加画面の表示
  @RequestMapping(value="/", method=RequestMethod.GET)
  public String show(@ModelAttribute UserDto user, Model model) {

    model.addAttribute("user", user);

    // formの初期化
    if (!model.containsAttribute("genreForm")) {
      model.addAttribute("genreForm", new GenreForm());
    }

    return "/admin_new_genre";

  }


  // ジャンルPOST
  @RequestMapping(value = "/insert", method=RequestMethod.POST)
  public String insert(@Validated GenreForm form, BindingResult result, RedirectAttributes redirectAttributes) {

    // バリデーションエラーがあった時
    if (result.hasErrors()) {
      redirectAttributes.addFlashAttribute("genreForm" ,form);
      // テンプレート内で#fieldsやth:errorsでバリデーションエラーを参照するには、
      // org.springframework.validation.BindingResult.{クラス名 (Camel Case)}というキー名で設定する必要があるらしい
      redirectAttributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + Conventions.getVariableName(form), result);
      redirectAttributes.addFlashAttribute("errorMsg", "入力内容が正しくありません");
      return "redirect:/genre/";
    }

    int updateNum = service.insertGenre(form);

    if(updateNum == 1) {
      // 更新件数が1件の場合
      redirectAttributes.addFlashAttribute("successMsg", "ジャンル登録が完了しました");
      return "redirect:/genre/";
    } else {
      redirectAttributes.addFlashAttribute("form", form);
      redirectAttributes.addFlashAttribute("errorMsg", "ジャンル登録で問題が発生しました");
      return "redirect:/genre/";
    }
  }


//ジャンルPOST
 @RequestMapping(value = "/insertAjax", method=RequestMethod.POST)
 public String insertAjax(@Validated GenreForm form, BindingResult result, Model model) {
   System.out.println("insertajax");

   // バリデーションエラーがあった時
   if (result.hasErrors()) {
     model.addAttribute("genreForm" ,form);
     // テンプレート内で#fieldsやth:errorsでバリデーションエラーを参照するには、
     // org.springframework.validation.BindingResult.{クラス名 (Camel Case)}というキー名で設定する必要があるらしい
     model.addAttribute(BindingResult.MODEL_KEY_PREFIX + Conventions.getVariableName(form), result);
     model.addAttribute("errorMsg", "入力内容が正しくありません");
     return "/admin_new_genre :: contentFragment";
   }

   int updateNum = service.insertGenre(form);

   if(updateNum == 1) {
     // 更新件数が1件の場合
     model.addAttribute("successMsg", "ジャンル登録が完了しました");
     return "/admin_new_genre :: contentFragment";
   } else {
     model.addAttribute("form", form);
     model.addAttribute("errorMsg", "ジャンル登録で問題が発生しました");
     return "/admin_new_genre :: contentFragment";
   }
 }

}