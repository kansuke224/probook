/*
* BookDao.java [2020/11/15]
*
* Copyright SnapShot Inc.
*/
package com.example.probook.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.boot.ConfigAutowireable;

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

  @Insert(sqlFile = true)
  int insertBook(BookDto dto);

}
