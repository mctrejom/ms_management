CREATE TABLE IF NOT EXISTS
loan(
    id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    user_id int,
    book_id int,
    created_at datetime,
    return_date date,
    returned boolean);