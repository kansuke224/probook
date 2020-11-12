package com.example.probook.form;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class PostBookForm {

  @NotNull
  private String title;

  // @NotNull
  // private String authorName;

  @NotNull
  private int price;

}
