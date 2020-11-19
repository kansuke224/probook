/*
* BuyAfterDto.java [2020/11/15]
*
* Copyright SnapShot Inc.
*/
package com.example.probook.dto;

import org.seasar.doma.Entity;
import org.seasar.doma.jdbc.entity.NamingType;

import lombok.Data;

/**
 *
 * BuyAfterDto
 * @author MYOUJI, Namae(【メールアドレス】)
 *
 * @since 2020/11/15 10:33:16
 */
@Entity(naming = NamingType.SNAKE_LOWER_CASE)
@Data
public class BuyAfterDto {

  private Integer buyAfterId;

  private Integer userId;

  private Integer bookId;

}
