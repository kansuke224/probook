// var data = [{"社員コード":"0001","氏名":"浦岡 友也","役職":"正社員"},{"社員コード":"0002","氏名":"山村 洋代","役職":"役員"}];

var data;

var token;
var header;

var initialBookId = 0;

$(function(){

  token = $("meta[name='_csrf']").attr("content");
  header = $("meta[name='_csrf_header']").attr("content");

  setup();

});

function setup() {
  //フォームにtype="hidden"のinput要素を追加
  $('#combo-search-form').append('<input name="key" type="hidden" value="" />');

  // ボタンクリック時、type="hidden"のinput要素に自分の値を設定
  $('#post-book-search-btn, #post-book-new-btn').click(function(){
      $('input[name=key]').val($(this).val());
  });

  setupCombobox();

  setSearchSubmit();
  setPostSubmit();
}


function setSearchSubmit() {

  $("#combo-search-form").submit(function(event) {
    event.preventDefault();

    // 操作対象のフォーム要素を取得
    var form = $(this);

    var url = "";
    var ajaxData = {};

    if($('input[name=key]').val() == 'search'){
      var subInfoStr = $("#combobox1").attr("sub_info");
      if (!subInfoStr) {
        return;
      }
      subInfoStr = subInfoStr.replace(/'/g, '\"');
      var subInfo = JSON.parse(subInfoStr);
      ajaxData = {
          "bookId": subInfo.bookId
      };
      url = form.attr('action').replace("combo", "edit");
    } else {
      url = form.attr('action').replace("combo", "new");
    }

    console.log(url);

    // 送信ボタンを取得
    // （後で使う: 二重送信を防止する。）
    var searchButton = form.find('#post-book-search-btn');
    var newButton = form.find('#post-book-new-btn');

    // fragment(html)取得
    $.ajax({
      url: url,
      type: form.attr('method'),
      // contentType: "application/json",
      data: ajaxData,
      timeout: 10000,  // 単位はミリ秒

      // 送信前
      beforeSend: function(xhr, settings) {
        // ボタンを無効化し、二重送信を防止
        searchButton.attr('disabled', true);
        newButton.attr('disabled', true);
      },
      // 応答後
      complete: function(xhr, textStatus) {
        // ボタンを有効化し、再送信を許可
        searchButton.attr('disabled', false);
        newButton.attr('disabled', false);
      },

      // 通信成功時の処理
      success: function(result, textStatus, xhr) {
        $('#ajaxResult').html(result);
        // contentをまるごと更新しているので、初期setupを更新時に行わないといけない
        // (clickイベント等)
        initialBookId = $("#bookIdDiv").text();
        initialBookId = Number(initialBookId);
        // $("#combo-search-form").prepend($('<input type="text" id="combobox1">'));
        setup();
        setPostSubmit();
      },

      // 通信失敗時の処理
      error: function(xhr, textStatus, error) {
        console.log("error");
      }
    });

  });
  // クリックイベント付与完了
}



function setPostSubmit() {

  $("#post-book-form").submit(function(event) {
    event.preventDefault();

    // イベントを解除しないと、重複登録されてイベントがどんどん増えてしまう
    $('#post-book-form').off('submit');

    console.log("onsubmit");

    // 操作対象のフォーム要素を取得
    var form = $(this);
    var data = new FormData(form[0]);

    // 送信ボタンを取得
    // （後で使う: 二重送信を防止する。）
    var button = form.find('button');

    // fragment(html)取得
    $.ajax({
      url: form.attr('action'),
      type: form.attr('method'),
      // data: form.serialize(),
      data: data,
      enctype: 'multipart/form-data',
      processData: false,
      contentType: false,
      cache: false,
      timeout: 10000,  // 単位はミリ秒


      // 送信前
      beforeSend: function(xhr, settings) {
        xhr.setRequestHeader(header, token);
        // ボタンを無効化し、二重送信を防止
        button.attr('disabled', true);
      },
      // 応答後
      complete: function(xhr, textStatus) {
        // ボタンを有効化し、再送信を許可
        button.attr('disabled', false);
      },

      // 通信成功時の処理
      success: function(result, textStatus, xhr) {
        $('#ajaxResult').html(result);
        // contentをまるごと更新しているので、初期setupを更新時に行わないといけない
        // (clickイベント等)
        $("#combo-search-form").prepend($('<input type="text" id="combobox1">'));
        setup();
      },

      // 通信失敗時の処理
      error: function(xhr, textStatus, error) {
        console.log("error");
      }
    });

  });
  // クリックイベント付与完了
}


// comboboxの更新
function setupCombobox() {
  // data -> タイトル、値段、投稿日、ジャンル
  $.ajax({
    url: $('#combo-search-form').attr('action'),
    type: 'GET',
    timeout: 10000,  // 単位はミリ秒

    // 通信成功時の処理
    success: function(result, textStatus, xhr) {
      data = result;
      // console.log(data);

      data.forEach((book, index) => {
        var dateStr = book.bookPublishedDate;
        var dateSplitArray = dateStr.split(/[T.]/);
        dateStr = dateSplitArray[0] + " " + dateSplitArray[1];
        data[index].bookPublishedDate = dateStr;
      });

      $(".ac_container").remove();

      var comboDetail = {
                sub_info: true,
                per_page: 10,
                lang: 'ja',
                button_img: $("#combo-img").attr("src"),
                primary_key: 'bookId',
                field: 'bookName',
                sub_as: {
                  bookName: 'タイトル',
                  bookId: 'ID',
                  bookPrice: '値段',
                  bookPublishedDate: '投稿日'
                },
                show_field: 'bookName, bookId, bookPrice, bookPublishedDate'
              };

      if (initialBookId !== 0) {
        comboDetail["init_record"] = initialBookId;
      }

      $('#combobox1').css({ "width": "350px" })
      .ajaxComboBox(
        data,
        comboDetail
      );
    },

    // 通信失敗時の処理
    error: function(xhr, textStatus, error) {
      console.log("error");
    }
  });

}
