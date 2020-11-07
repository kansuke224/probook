/*
* UserDao.java [2020/11/01]
*
* Copyright SnapShot Inc.
*/
package com.example.probook.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.In;
import org.seasar.doma.Insert;
import org.seasar.doma.Out;
import org.seasar.doma.Procedure;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.Reference;

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
  UserDto findUserById(int userId);

  @Select
  UserDto findUserByUsername(String username);

  @Select
  UserDto findUserByMail(String mail);

  //@Insert
  //int insertUser(UserDto dto);

  @Procedure(name="insert_user")
  void insertUser(@In String username, @In String userpass, @In String userMail, @Out Reference<Integer> updateNumber);

}
