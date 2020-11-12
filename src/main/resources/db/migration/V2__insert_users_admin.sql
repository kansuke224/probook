insert
into probook.users(
    user_id                                     -- ユーザid
    , user_name                                 -- ユーザ名
    , user_pass                                 -- パスワード
    , user_mail                                 -- メール
    , user_point                                -- 保有ポイント
)
values (
    1                                    -- ユーザid
    , 'admin'                                -- ユーザ名
    , 'admin'                                -- パスワード
    , 'admin@gmail.com'                                -- メール
    , 0                               -- 保有ポイント
)
