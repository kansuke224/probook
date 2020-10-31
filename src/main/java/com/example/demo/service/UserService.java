package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
@Transactional
public class UserService {

  // UserRepositoryは勝手に実装クラスが作られるのでインスタンス化しなくていいらしい？
  // Autowiredが何やってるのかよくわからん
  @Autowired
  UserRepository userRepository;

  public List<User> getUsers() {
    return userRepository.selectAll();
  }

  public User getUserInfo(String userId) {
    return userRepository.selectUserInfo(userId);
  }

}
