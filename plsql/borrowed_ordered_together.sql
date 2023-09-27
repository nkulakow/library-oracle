CREATE VIEW borrowed_ordered_together AS
SELECT borrowed.user_id AS "user", borrowed.book_id AS "book",'B' AS "borrowed_or_ordered" 
FROM borrowed
UNION
SELECT ordered.users_user_id AS "user", ordered.books_book_id AS "book",'O' AS "borrowed_or_ordered" 
FROM ordered;