package com.example.probook.dto;

import org.seasar.doma.Entity;
import org.seasar.doma.jdbc.entity.NamingType;

import lombok.Getter;
import lombok.Setter;

// Entityクラスには、@Entityを付与する
//
@Entity(naming = NamingType.SNAKE_LOWER_CASE)
@Getter
@Setter
public class UserDto {

  // 主キーに対応するフィールドは、@Idをつける
  // @SequenceGenerator(sequence = "useridSeq")
  // @Id
  // @GeneratedValue(strategy = GenerationType.TABLE)
  // @TableGenerator(table = "seq_table", pkColumnName = "seq_name", pkColumnValue = "user_seq", valueColumnName = "seq_value", initialValue = 1, allocationSize = 1 )
  private Integer userId;

  private String userName;

  private String userPass;
  private Integer userPoint;
  private String userMail;

}
