insert
into probook.book(
	book_name
	, book_description
	, book_price
	, book_published_date
	, user_id
	, genre_id
)
values (
	/*dto.bookName*/'1'
	, /*dto.bookDescription*/'1'
	, /*dto.bookPrice*/1
	, sysdate
	, /*dto.userId*/1
	, /*dto.genreId*/1
)
