/*
* GenreService.java [2020/11/15]
*
* Copyright SnapShot Inc.
*/
package com.example.probook.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.probook.dao.GenreDao;
import com.example.probook.dto.GenreDto;
import com.example.probook.form.GenreForm;

/**
 *
 * GenreService
 * @author MYOUJI, Namae(【メールアドレス】)
 *
 * @since 2020/11/15 10:46:42
 */
@Service
public class GenreService {

  @Autowired
  GenreDao dao;

  public int insertGenre(GenreForm form) {
    GenreDto dto = new GenreDto();
    // formの中身をuserdtoにコピー
    BeanUtils.copyProperties(form, dto);
    return dao.insertGenre(dto);
  }

}
