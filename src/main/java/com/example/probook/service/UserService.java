package com.example.probook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.probook.dao.UserDao;
import com.example.probook.dto.UserDto;

@Service
@Transactional
public class UserService {

  // UserDaoは勝手に実装クラスが作られるのでインスタンス化しなくていい
  // Autowiredが何やってるのかよくわからん=>たぶんnew UserDaoImpl()してるだけ
  @Autowired
  UserDao userDao;

  /*
  public List<UserDto> getUsers() {
    return userDao.selectAll();
  }
  */

  public UserDto findUserById(String userId) {
    return userDao.findUserById(userId);
  }

  public UserDto findUserByUsername(String username) {
    return userDao.findUserByUsername(username);
  }

  public UserDto findUserByMail(String mail) {
    return userDao.findUserByMail(mail);
  }

}
