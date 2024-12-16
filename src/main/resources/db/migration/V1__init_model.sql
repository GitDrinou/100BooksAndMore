-- BOOKS TABLE
CREATE TABLE IF NOT EXISTS tBooks (
    book_id SERIAL PRIMARY KEY,
    title VARCHAR(200),
    author VARCHAR(75),
    publication_date VARCHAR(10),
    isbn VARCHAR(20) UNIQUE,
    description TEXT NOT NULL
);