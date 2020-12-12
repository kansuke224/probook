// var data = [{"社員コード":"0001","氏名":"浦岡 友也","役職":"正社員"},{"社員コード":"0002","氏名":"山村 洋代","役職":"役員"}];

var data;

var token;
var header;

$(function(){

  token = $("meta[name='_csrf']").attr("content");
  header = $("meta[name='_csrf_header']").attr("content");

  setup();

});

function setup() {
  $(".ac_container").remove();

  $('#combobox1').css({ "width": "350px" })
  .ajaxComboBox(
    data,
    {
      sub_info: true,
      per_page: 10,
      lang: 'ja',
      button_img: $("#combo-img").attr("src"),
      primary_key: '社員コード',
      field: '氏名',
      order_by: [
        '社員コード'
        ]
    }
  );

  setSearchSubmit();
  setPostSubmit();
}


function setSearchSubmit() {

  $("#combo-search-form").submit(function(event) {
    event.preventDefault();

    // 操作対象のフォーム要素を取得
    var form = $(this);

    // 送信ボタンを取得
    // （後で使う: 二重送信を防止する。）
    var button = form.find('button');

    // fragment(html)取得
    $.ajax({
      url: form.attr('action') + 'new',
      type: form.attr('method'),
      data: form.serialize(),
      timeout: 10000,  // 単位はミリ秒

      // 送信前
      beforeSend: function(xhr, settings) {
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
        // $("#combo-search-form").prepend($('<input type="text" id="combobox1">'));
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


}
