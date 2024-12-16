CREATE TABLE IF NOT EXISTS tCategories (
    category_id SERIAL PRIMARY KEY,
    name VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS tKinds (
    kind_id SERIAL PRIMARY KEY,
    name VARCHAR(100)
);

ALTER TABLE tBooks ADD category_id INT;
ALTER TABLE tBooks ADD kind_id INT;
ALTER TABLE tBooks ADD FOREIGN KEY (category_id) REFERENCES tCategories(category_id);
ALTER TABLE tBooks ADD FOREIGN KEY (kind_id) REFERENCES tKinds(kind_id);