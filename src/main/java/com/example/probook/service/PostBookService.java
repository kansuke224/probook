package com.example.probook.service;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.probook.dao.BookDao;
import com.example.probook.dto.BookDto;
import com.example.probook.form.PostBookForm;



@Service
public class PostBookService {

  @Autowired
  BookDao dao;

  // dbの拡張子番号に対応した配列
  private String[] extArray = {".jpg", ".png"};

  public List<BookDto> selectComboList(int userId) {
    BookDto dto = new BookDto();
    dto.setUserId(userId);
    List<BookDto> comboList = dao.selectPostBooks(dto);
    return comboList;
  }

  /*
   * 編集フォーム表示
   */
  public BookDto selectBook(PostBookForm form) {
    BookDto dto = new BookDto();
    // formの中身をuserdtoにコピー
    BeanUtils.copyProperties(form, dto);
    dto = dao.selectBook(dto);
    return dto;
  }


  /*
   * 投稿書籍編集処理
   */
  public Map<String, Object> updateBook(PostBookForm form) {

    BookDto dto = new BookDto();
    // formの中身をuserdtoにコピー
    BeanUtils.copyProperties(form, dto);

    // filename,image_ext_numを取得するために保存済みの情報を取得
    BookDto savedDto = dao.selectBook(dto);
    dto.setFileName(savedDto.getFileName());
    dto.setImageExtNum(savedDto.getImageExtNum());

    String filename = savedDto.getFileName();

    // ファイルアップロード処理
    if (form.getBookImage() != null) {
      int imageExtNum = uploadFile(form.getBookImage(), "bookImage", filename);
      dto.setImageExtNum(imageExtNum);
    }
    if (form.getBookContent() != null) {
      uploadFile(form.getBookContent(), "bookContent", filename);
    }

    // update処理  更新件数
    int updateNum = dao.updateBook(dto);

    PostBookForm editForm = new PostBookForm();
    // update結果のdtoの中身をeditFormにコピー
    BeanUtils.copyProperties(dto, editForm);

    Map<String, Object> resultMap = new HashMap<>();
    resultMap.put("updateNum", updateNum);
    resultMap.put("editForm", editForm);

    return resultMap;

  }



  /*
   * 新規書籍投稿処理
   */
  public Map<String, Object> newBook(PostBookForm form, int userId) {

    String filename = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS").format(LocalDateTime.now());

    // ファイルアップロード処理
    int imageExtNum = uploadFile(form.getBookImage(), "bookImage", filename);
    uploadFile(form.getBookContent(), "bookContent", filename);

    BookDto dto = new BookDto();
    // formの中身をuserdtoにコピー
    BeanUtils.copyProperties(form, dto);

    dto.setFileName(filename);
    dto.setImageExtNum(imageExtNum);
    dto.setUserId(userId);

    // insert処理  更新件数
    int updateNum = dao.insertBook(dto);

    PostBookForm editForm = new PostBookForm();
    // insert結果のdtoの中身をeditFormにコピー
    BeanUtils.copyProperties(dto, editForm);

    Map<String, Object> resultMap = new HashMap<>();
    resultMap.put("updateNum", updateNum);
    resultMap.put("editForm", editForm);

    return resultMap;

  }


  private int uploadFile(MultipartFile file, String fileKbn, String filename) {
    int dot = file.getOriginalFilename().lastIndexOf(".");
    String extention = "";
    if (dot > 0) {
      extention = file.getOriginalFilename().substring(dot).toLowerCase();
    }

    // TODO 環境によってpathを変更する
    // Path uploadfile = Paths.get("/Users/nhs90453/workspace/uploadfile/" + fileKbn + "/" + filename + extention);
    Path uploadfile = Paths.get("C:/workspace/uploadfile/" + fileKbn + "/" + filename + extention);

    try (OutputStream os = Files.newOutputStream(uploadfile, StandardOpenOption.CREATE)) {
      byte[] bytes = file.getBytes();
      os.write(bytes);
    } catch (IOException ex) {
      System.err.println(ex);
    }

    List<String> list = Arrays.asList(extArray);
    int extNum = list.indexOf(extention);

    // -1になる todo 修正
    return extNum;

  }

}
