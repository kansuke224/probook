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
  // @Pattern(regexp = "^[a-zA-Z0-9(), ]*$", message = "")
  @Pattern(
      regexp = "^rgba\\(((\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\,\\s?){3}(0|0?\\.\\d+|1|1\\.0+)\\)$",
      message = "rgba()の形式ではありません"
  )
  private String genreColor;

}
