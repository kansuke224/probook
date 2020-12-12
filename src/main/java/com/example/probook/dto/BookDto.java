package com.example.probook.dto;

import java.util.Date;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.SequenceGenerator;
import org.seasar.doma.Table;
import org.seasar.doma.TableGenerator;
import org.seasar.doma.jdbc.entity.NamingType;

import lombok.Data;

@Entity(naming = NamingType.SNAKE_LOWER_CASE)
@Table(name = "book")
@Data
public class BookDto {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(sequence = "BOOKID_SEQ")
  private Integer bookId = -1;

  private String bookName;

  private String bookDescription;

  // private String authorName;

  private Integer bookPrice;

  private String fileName;

  private Integer imageExtNum;

  @Column(insertable = false)
  private Date bookPublishedDate;

  private Integer userId;

  private Integer genreId;

}
