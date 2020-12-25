update probook.book
set
    book_name = /*dto.bookName*/'1'
    , book_description = /*dto.bookDescription*/'1'
    , book_price = /*dto.bookPrice*/1
    , genre_id = /*dto.genreId*/1
    , image_ext_num = /*dto.imageExtNum*/1
where
    book_id = /*dto.bookId*/1