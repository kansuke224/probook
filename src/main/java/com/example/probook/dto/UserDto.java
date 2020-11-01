package com.example.probook.dto;

import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.jdbc.entity.NamingType;

import lombok.Getter;
import lombok.Setter;

// Entityクラスには、@Entityを付与する
@Entity(naming = NamingType.SNAKE_LOWER_CASE)
@Getter
@Setter
public class UserDto {

  // 主キーに対応するフィールドは、@Idをつける
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public int userId;
  public String userName;

  public String userPass;
  public String userPoint;
  public String userMail;

}
