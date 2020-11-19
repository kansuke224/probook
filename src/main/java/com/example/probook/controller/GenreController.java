/*
* GenreController.java [2020/11/15]
*
* Copyright SnapShot Inc.
*/
package com.example.probook.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Conventions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
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

  @RequestMapping(value="/", method=RequestMethod.GET)
  public ModelAndView show(GenreForm form , @ModelAttribute UserDto user, Model model, ModelAndView mav) {
    mav.addObject("user", user);

    // ObjectからGenreFormへキャスト
    GenreForm flashForm = (GenreForm) model.getAttribute("form");
    BindingResult flashResult = (BindingResult) model.getAttribute("resutl");
    if (model.getAttribute("form") != null) {
      // flashformがnullでないとき、flashFormをセット
      mav.addObject("genreForm", flashForm);

      System.out.println(BindingResult.MODEL_KEY_PREFIX + Conventions.getVariableName(flashForm));
      mav.addObject(BindingResult.MODEL_KEY_PREFIX + Conventions.getVariableName(flashForm), flashResult);
    } else {
      // flashformがnullのとき、空のformをセット
      mav.addObject("genreForm", form);
    }

    mav.setViewName("/admin_new_genre");
    return mav;
  }

  @RequestMapping(value = "/insert", method=RequestMethod.POST)
  public String insert(@Validated GenreForm form, BindingResult result, RedirectAttributes redirectAttributes) {
    // System.out.println(result.getAllErrors());
    if (result.hasErrors()) {
      redirectAttributes.addFlashAttribute("form", form);
      redirectAttributes.addFlashAttribute("result", result);
      ArrayList<String> msgList = new ArrayList<String>();
      msgList.add("入力内容が正しくありません");
      redirectAttributes.addFlashAttribute("msgList", msgList);
      return "redirect:/genre/";
    }

    int updateNum = service.insertGenre(form);

    if(updateNum == 1) {
      // 更新件数が1件の場合
      // redirectAttributes.addFlashAttribute("successMsg", "ジャンル登録が完了しました");
      ArrayList<String> msgList = new ArrayList<String>();
      msgList.add("ジャンル登録が完了しました");
      redirectAttributes.addFlashAttribute("msgList", msgList);
      return "redirect:/genre/";
    } else {
      redirectAttributes.addFlashAttribute("form", form);
      // redirectAttributes.addFlashAttribute("errorMsg", "ジャンル登録で問題が発生しました");
      ArrayList<String> msgList = new ArrayList<String>();
      msgList.add("ジャンル登録で問題が発生しました");
      redirectAttributes.addFlashAttribute("msgList", msgList);
      return "redirect:/genre/";
    }
  }

}
