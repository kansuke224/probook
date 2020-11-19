/*
* PurchaseDto.java [2020/11/15]
*
* Copyright SnapShot Inc.
*/
package com.example.probook.dto;

import org.seasar.doma.Entity;
import org.seasar.doma.jdbc.entity.NamingType;

import lombok.Data;

/**
 *
 * PurchaseDto
 * @author MYOUJI, Namae(【メールアドレス】)
 *
 * @since 2020/11/15 10:29:48
 */
@Entity(naming = NamingType.SNAKE_LOWER_CASE)
@Data
public class PurchaseDto {

  private Integer purchaseId;

  private String memo;

  private Integer userId;

}
