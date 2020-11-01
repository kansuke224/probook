package com.example.probook.dto;

import org.seasar.doma.*;
import org.seasar.doma.jdbc.entity.NamingType;

import lombok.Getter;
import lombok.Setter;

// Entityクラスには、@Entityを付与する
@Entity(naming = NamingType.SNAKE_LOWER_CASE)
@Getter
@Setter
public class User {

  // 主キーに対応するフィールドは、@Idをつける
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public int userId;
  public String userName;

  public String userPass;
  public String address;
  public String mail;

}
