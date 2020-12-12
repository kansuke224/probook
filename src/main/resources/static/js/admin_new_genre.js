$(function(){

  setup();

});

function setup() {
  setClick();

  var pickr = new Pickr({

      el: '#color-picker',
      showAlways: false,
      position: 'left',
      defaultRepresentation: 'RGBA',

      components: {

          preview: true, // Left side color comparison
          opacity: true, // Opacity slider
          hue: true,     // Hue slider

          // Bottom output bar, theoretically you could use 'true' as propery.
          // But this would also hide the save-button.
          interaction: {
              // hex: true,
              rgba: true,
              // hsla: true,
              // hsva: true,
              // cmyk: true,
              input: true,
              clear: true,
              save: true
          }
      },



      strings: {
         save: 'Save',  // Default for save button
         clear: 'Clear' // Default for clear button
      },

      // User has changed the color
      onChange(hsva, instance) {
          hsva;     // HSVa color object, if cleared null
          instance; // Current Pickr instance
      },

      // User has clicked the save button
      onSave(hsva, instance) {
          // same as onChange
          console.log("save");

          console.log($(".pcr-result").val());
      }

  });

  pickr.on('save', (color, instance) => {
      // console.log('save', color.toRGBA(), instance);

      // console.log($(".pcr-result").val());

      $(".image-color-input").val($(".pcr-result").val());
  }).on('clear', instance => {
      // console.log('clear', instance);
      $(".image-color-input").val("");
  })
}


function setClick() {

  $("#genreForm").submit(function(event) {
    event.preventDefault();

    // 操作対象のフォーム要素を取得
    var form = $(this);

    // 送信ボタンを取得
    // （後で使う: 二重送信を防止する。）
    var button = form.find('button');

    // fragment(html)取得
    $.ajax({
      url: form.attr('action'),
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