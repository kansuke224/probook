insert
into probook.book(
	book_name
	, book_description
	, book_price
	, book_published_date
	, FILE_NAME
  , IMAGE_EXT_NUM
	, user_id
	, genre_id
)
values (
	/*dto.bookName*/'1'
	, /*dto.bookDescription*/'1'
	, /*dto.bookPrice*/1
	, sysdate
	, /*dto.fileName*/''
	, /*dto.imageExtNum*/1
	, /*dto.userId*/1
	, /*dto.genreId*/1
)
