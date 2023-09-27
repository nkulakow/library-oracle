CREATE OR replace FUNCTION calculate_penalty(b_id NUMBER)
RETURN NUMBER

AS

b_return_date DATE;
b_borrow_date DATE;
day_penalty CONSTANT NUMBER := 3;
total_penalty NUMBER:= 0;

BEGIN

SELECT return_date, borrow_date
INTO b_return_date, b_borrow_date
FROM borrowed
WHERE borrow_id = b_id;

IF b_return_date < b_borrow_date THEN
total_penalty := (b_borrow_date - b_return_date) * day_penalty;
END IF;

RETURN total_penalty;

END;