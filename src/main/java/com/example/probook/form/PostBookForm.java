package com.example.probook.form;

import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class PostBookForm {

  @NotBlank
  private String bookName;

  /*
  @NotBlank
  private String authorName;
  */

  private Integer genreId;

  private Integer bookPrice;

  @NotBlank
  private String bookDescription;

  private MultipartFile bookImage;

  private MultipartFile bookContent;

}
