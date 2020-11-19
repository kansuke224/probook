/*
* GenreForm.java [2020/11/15]
*
* Copyright SnapShot Inc.
*/
package com.example.probook.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 *
 * GenreForm
 * @author MYOUJI, Namae(【メールアドレス】)
 *
 * @since 2020/11/15 11:04:32
 */

@Data
public class GenreForm {

  @NotBlank
  private String genreName;

  @NotBlank
  @Size(max = 1)
  @Pattern(regexp = "^[a-zA-Z0-9(), ]*$")
  private String genreColor;

}
