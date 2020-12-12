-- project name : probook
-- date/time    : 2020/11/01 11:12:55
-- author       : nhs90453
-- rdbms type   : oracle database
-- application  : a5:sql mk-2

/*
  backuptotemptable, restorefromtemptable疑似命令が付加されています。
  これにより、drop table, create table 後もデータが残ります。
  この機能は一時的に $$tablename のような一時テーブルを作成します。
*/
-- ポイントチャージ履歴
--* restorefromtemptable
create table point (
  point_id int not null
  , point_price int not null
  , point_date date not null
  , user_id int not null
  , constraint point_pkc primary key (point_id)
) ;

-- レビュー
--* restorefromtemptable
create table review (
  review_id int not null
  , review_comment varchar2(2000) not null
  , review_star_no int not null
  , review_date date not null
  , purchase_id int not null
  , constraint review_pkc primary key (review)
) ;

-- 購入履歴
--* restorefromtemptable
create table purchase (
  purchase_id int not null
  , memo varchar2(4000)
  , user_id int not null
  , constraint purchase_pkc primary key (purchase_id)
) ;

-- 書籍
--* restorefromtemptable
create table book (
  book_id int
  , book_name varchar2(500) not null
  , book_description varchar2(2000) not null
  , book_price int not null
  , book_published_date date default sysdate not null
  , file_name varchar2(20) not null
  , image_ext_num varchar2(10) not null
  , user_id int not null
  , genre_id int not null
  , constraint book_pkc primary key (book_id)
) ;

-- ジャンル
--* restorefromtemptable
create table genre (
  genre_id int not null
  , genre_name varchar2(300) not null
  , genre_color varchar2(100) not null
  , constraint genre_pkc primary key (genre_id)
) ;

-- 後で買うテーブル
--* restorefromtemptable
create table buy_after (
  buy_after_id int not null
  , user_id int not null
  , book_id int not null
  , constraint buy_after_pkc primary key (buy_after_id)
) ;

-- ユーザテーブル
--* restorefromtemptable
create table users (
  user_id int not null
  , user_name varchar2(100) not null
  , user_pass varchar2(100) not null
  , user_mail varchar2(100) not null
  , user_point int default 0 not null
  , constraint user_pkc primary key (user_id)
) ;

comment on table point is 'ポイントチャージ履歴';
comment on column point.point_id is 'ポイント履歴id';
comment on column point.point_price is 'チャージ額';
comment on column point.point_date is 'チャージ日時';
comment on column point.user_id is 'ユーザid';

comment on table review is 'レビュー';
comment on column review.review_id is 'レビューid';
comment on column review.review_comment is 'コメント';
comment on column review.review_star_no is '星の数';
comment on column review.review_date is 'レビュー日時';
comment on column review.purchase_id is '購入id';

comment on table purchase is '購入履歴';
comment on column purchase.purchase_id is '購入id';
comment on column purchase.memo is 'メモ';
comment on column purchase.user_id is 'ユーザid';

comment on table book is '書籍';
comment on column book.book_id is '書籍id';
comment on column book.book_name is '書籍名';
comment on column book.book_description is '説明';
comment on column book.book_price is '値段';
comment on column book.book_published_date is '出版日時';
comment on column book.user_id is 'ユーザid';
comment on column book.genre_id is 'ジャンルid';

comment on table genre is 'ジャンル';
comment on column genre.genre_id is 'ジャンルid';
comment on column genre.genre_name is 'ジャンル名';
comment on column genre.genre_color is 'イメージカラー';

comment on table buy_after is '後で買うテーブル';
comment on column buy_after.buy_after_id is '後で買うid';
comment on column buy_after.user_id is 'ユーザid';
comment on column buy_after.book_id is '書籍id';

comment on table users is 'ユーザテーブル';
comment on column users.user_id is 'ユーザid';
comment on column users.user_name is 'ユーザ名';
comment on column users.user_pass is 'パスワード';
comment on column users.user_mail is 'メール';
comment on column users.user_point is '保有ポイント';

