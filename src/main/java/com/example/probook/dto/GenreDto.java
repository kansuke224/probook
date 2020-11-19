/*
* GenreDto.java [2020/11/15]
*
* Copyright SnapShot Inc.
*/
package com.example.probook.dto;

import org.seasar.doma.Entity;
import org.seasar.doma.jdbc.entity.NamingType;

import lombok.Data;

/**
 *
 * GenreDto
 * @author MYOUJI, Namae(【メールアドレス】)
 *
 * @since 2020/11/15 10:03:01
 */
@Entity(naming = NamingType.SNAKE_LOWER_CASE)
@Data
public class GenreDto {

  private Integer genreId;

  private String genreName;

  private String genreColor;

}
