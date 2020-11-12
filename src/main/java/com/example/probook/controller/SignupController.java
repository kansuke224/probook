package com.example.probook.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.probook.dto.UserDto;
import com.example.probook.form.SignupForm;
import com.example.probook.service.UserService;

@Controller
@RequestMapping("/signup")
public class SignupController {

  @Autowired
  UserService userservice;

  @Autowired
  private AuthenticationManager authManager;

  @RequestMapping(value = "/", method=RequestMethod.GET)
  public ModelAndView show(SignupForm form, Model model, ModelAndView mav) {
    // 引数のformには、空のsignupformインスタンスが格納される
    // System.out.println(model.getAttribute("msg"));
    // Flash Scopeから値を取り出す -> 存在しない場合はnullになる
    mav.addObject("result", model.getAttribute("result"));
    mav.addObject("msgList", model.getAttribute("msgList"));
    mav.addObject("signupForm", form);
    mav.setViewName("/signup");
    return mav;
  }

  @RequestMapping(value = "/insert", method=RequestMethod.POST)
  public String insert(@Validated SignupForm form,BindingResult result, HttpServletRequest request, RedirectAttributes redirectAttributes) {
    // System.out.println(form);
    if (result.hasErrors()) {
      redirectAttributes.addFlashAttribute("form", form);
      // redirectAttributes.addFlashAttribute("result", result);
      System.out.println(result.getFieldError());
      String[] msgList = {};
      redirectAttributes.addFlashAttribute("msgList", msgList);
      return "redirect:/signup/";
    }

    UserDto dto = userservice.insertUser(form);
    System.out.println(dto);
    if(dto.getUserId() != null) {
      // signupが問題なく終了した場合
      login(request, dto.getUserMail(), dto.getUserPass());
      Authentication auth = SecurityContextHolder.getContext().getAuthentication();
      //Principalからログインユーザの情報を取得
      String userName = auth.getName();
      System.out.println(userName);
      return "redirect:/index/";
    } else {
      redirectAttributes.addFlashAttribute("msg", "会員登録で問題が発生しました");
      return "redirect:/signup/";
    }
  }

  public void login(HttpServletRequest request, String userName, String password){

      UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(userName, password);

      // Authenticate the user

      Authentication authentication = authManager.authenticate(authRequest);
      SecurityContext securityContext = SecurityContextHolder.getContext();
      securityContext.setAuthentication(authentication);

      // Create a new session and add the security context.
      HttpSession session = request.getSession(true);
      session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
  }

}
