package com.example.demo.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.probook.dao.UserRepository;
import com.example.probook.dto.User;

// @SpringBootTestでDIコンテナを使えるようになるっぽい
// ないと@autowiredでエラーになる => なぜ？？
/*
 * @SpringBootTest
 * コンフィグレーションクラスを自動で検出してくれる
 * @ContextConfigurationを利用することで明示的に設定することもできる
 * 自動検出されるのは @SpringBootConfiguration がついたクラス
 *
 * b2eproは、テスト用にconfigクラスを作って@ContextConfigrationを利用しているのか？？
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class UserRepositoryTest {

  @Autowired
  UserRepository dao;

  @Test
  public void selectAll() {
      List<User> users = dao.selectAll();

      for(User user : users) {
        System.out.println(user.userName);
    }
  }

}
