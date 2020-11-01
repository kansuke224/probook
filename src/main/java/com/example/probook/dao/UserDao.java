/*
* UserDao.java [2020/11/01]
*
* Copyright SnapShot Inc.
*/
package com.example.probook.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import com.example.probook.dto.UserDto;


/**
 *
 * UserDao
 * @author MYOUJI, Namae(【メールアドレス】)
 *
 * @since 2020/11/01 15:21:56
 */
@ConfigAutowireable
@Dao
public interface UserDao {

  @Select
  UserDto findUserById(String userId);

  @Select
  UserDto findUserByUsername(String username);

  @Select
  UserDto findUserByMail(String mail);

}
