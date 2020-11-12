package com.example.probook.dto;

import java.util.Date;

import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.TableGenerator;
import org.seasar.doma.jdbc.entity.NamingType;

import lombok.Data;

@Entity(naming = NamingType.SNAKE_LOWER_CASE)
@Data
public class BookDto {

  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  @TableGenerator(table = "seq_table", pkColumnName = "seq_name", pkColumnValue = "user_seq", valueColumnName = "seq_value", initialValue = 1, allocationSize = 1 )
  Integer bookId;

  private String bookName;

  private String bookDescription;

  // private String authorName;

  private String bookPrice;

  private Date bookPublishedDate;

  private Integer userId;

  private Integer genreId;

}
