package com.example.probook.service;

import org.seasar.doma.jdbc.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.probook.dao.UserDao;
import com.example.probook.dto.UserDto;
import com.example.probook.form.SignupForm;

@Service
@Transactional
public class UserService {

  // UserDaoは勝手に実装クラスが作られるのでインスタンス化しなくていい
  // Autowiredが何やってるのかよくわからん=>たぶんnew UserDaoImpl()してるだけ
  @Autowired
  UserDao dao;

  /*
  public List<UserDto> getUsers() {
    return userDao.selectAll();
  }
  */

  public UserDto findUserById(int userId) {
    return dao.findUserById(userId);
  }

  public UserDto findUserByUsername(String username) {
    return dao.findUserByUsername(username);
  }

  public UserDto findUserByMail(String mail) {
    return dao.findUserByMail(mail);
  }

  public UserDto insertUser(SignupForm form) {
    UserDto dto = new UserDto();
    // formの中身をuserdtoにコピー
    BeanUtils.copyProperties(form, dto);

    System.out.println(dto.getUserId());


    Reference<Integer> ref = new Reference<Integer>();
    dao.insertUser(dto.getUserName(), dto.getUserPass(), dto.getUserMail() ,ref);
    int updateNumber = ref.get();


    dto = dao.findUserById(updateNumber);
    System.out.println("dto作成");
    if (dto == null) {
      dto = new UserDto();
    }

    return dto;


    // return 0;
  }

}
