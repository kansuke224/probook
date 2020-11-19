/*
* GenreDao.java [2020/11/15]
*
* Copyright SnapShot Inc.
*/
package com.example.probook.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.boot.ConfigAutowireable;

import com.example.probook.dto.GenreDto;

/**
 *
 * GenreDao
 * @author MYOUJI, Namae(【メールアドレス】)
 *
 * @since 2020/11/15 10:36:43
 */
@ConfigAutowireable
@Dao
public interface GenreDao {

  @Insert(sqlFile = true)
  int insertGenre(GenreDto dto);

}
