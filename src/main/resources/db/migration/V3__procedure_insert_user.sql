create or replace procedure insert_user(
    username in varchar
    ,userpass in varchar
    ,usermail in varchar
    ,updatenumber out number
)
-- 宣言部
is
    vcurrno  number;
    sql_user_name varchar(100);
    -- null;
-- 処理部
begin
    select
        user_name
    into
        sql_user_name
    from
        probook.users
    where
        user_name = username;

    updatenumber := 0;

exception
  when no_data_found then
  insert
    into probook.users(
        user_name
        , user_pass
        , user_mail
        , user_point
    )
    values (
        username
        , userpass
        , usermail
        , 0
    )
    returning user_id into vcurrno;

    updatenumber := 1;
end;