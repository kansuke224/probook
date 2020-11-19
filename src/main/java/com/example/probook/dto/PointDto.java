/*
* PointDto.java [2020/11/15]
*
* Copyright SnapShot Inc.
*/
package com.example.probook.dto;

import java.util.Date;

import org.seasar.doma.Entity;
import org.seasar.doma.jdbc.entity.NamingType;

import lombok.Data;

/**
 *
 * PointDto
 * @author MYOUJI, Namae(【メールアドレス】)
 *
 * @since 2020/11/15 10:29:07
 */
@Entity(naming = NamingType.SNAKE_LOWER_CASE)
@Data
public class PointDto {

  private Integer pointId;

  private Integer pointPrice;

  private Date pointDate;

  private Integer userId;

}
