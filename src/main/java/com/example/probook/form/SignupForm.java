package com.example.probook.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class SignupForm {

  @NotNull
  private String userName;

  @NotNull
  @Pattern(regexp = "[a-zA-Z0-9@.,_-]*")
  private String userMail;

  @NotNull
  @Pattern(regexp = "[a-zA-Z0-9]*")
  private String userPass;

}
