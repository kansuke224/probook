package com.example.probook.dao;

import java.util.List;

import org.seasar.doma.*;
import org.seasar.doma.boot.ConfigAutowireable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.probook.dto.User;


// @ConfigAutowireableでdaoの実装クラスに、@Repositoryと@Autowiredが付与されるらしい
// 効果はよくしらん
// @Repositoryの指定があると、Spring側から、「データソースへのやり取りを記述するクラス」なんだなと解釈される
// ==> @Daoとの差異は？？
@ConfigAutowireable
@Dao
public interface UserRepository {

  // Doma Toolsをインストールしている場合
  // メソッドを右クリック > Doma > SOL fileへジャンプをクリックでsqlファイルの作成、アクセスができる
  @Select
  List<User> selectAll();

  @Select
  User selectUserInfo(String userId);

  @Insert
  @Transactional
  int insert(User reservation);

}
