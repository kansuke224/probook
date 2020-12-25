/*
* BookDao.java [2020/11/15]
*
* Copyright SnapShot Inc.
*/
package com.example.probook.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.In;
import org.seasar.doma.Insert;
import org.seasar.doma.Out;
import org.seasar.doma.Procedure;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.Reference;
import org.seasar.doma.jdbc.Result;

import com.example.probook.dto.BookDto;

/**
 *
 * BookDao
 * @author MYOUJI, Namae(【メールアドレス】)
 *
 * @since 2020/11/15 9:16:43
 */
@ConfigAutowireable
@Dao
public interface BookDao {

  @Insert
  int insertBook(BookDto dto);

  @Update
  int updateBook(BookDto dto);

  @Select
  List<BookDto> selectPostBooks(BookDto dto);

  @Select
  BookDto selectBook(BookDto dto);


  // bookidの現在値を取得
  @Select
  int selectCurrBookId();

  @Select
  int selectNextBookId();

}


/*
  doma、insertの結果取得について
  domaのエンティティは、ミュータブルとイミュータブルで使い方が変わってくる

  今回のようにミュータブルの場合は、引数に渡したエンティティがinsert(update?)結果で上書きされる
  イミュータブルのときは、Result<Entity>を返り値として使える？？
*/