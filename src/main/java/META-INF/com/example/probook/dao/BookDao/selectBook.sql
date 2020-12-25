SELECT
    BOOK_ID                                     -- BOOK_ID
    , BOOK_NAME                                 -- BOOK_NAME
    , BOOK_DESCRIPTION                          -- BOOK_DESCRIPTION
    , BOOK_PRICE                                -- BOOK_PRICE
    , BOOK_PUBLISHED_DATE                       -- BOOK_PUBLISHED_DATE
    , FILE_NAME                                 -- FILE_NAME
    , IMAGE_EXT_NUM                             -- IMAGE_EXT_NUM
    , USER_ID                                   -- USER_ID
    , GENRE_ID                                  -- GENRE_ID
FROM
    PROBOOK.BOOK
WHERE
    BOOK_ID = /*dto.bookId*/1