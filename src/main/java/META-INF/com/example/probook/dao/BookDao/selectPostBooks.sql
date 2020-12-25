select
    book_id                                     -- book_id
    , book_name                                 -- book_name
    , book_description                          -- book_description
    , book_price                                -- book_price
    , book_published_date                       -- book_published_date
    , file_name                                 -- file_name
    , image_ext_num                             -- image_ext_num
    , user_id                                   -- user_id
    , genre_id                                  -- genre_id
from
    probook.book
where
    user_id = /*dto.userId*/'1'
