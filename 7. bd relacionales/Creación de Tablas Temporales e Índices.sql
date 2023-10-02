USE movies_db;
DROP TEMPORARY TABLE IF EXISTS TWD;

# Forma 1

CREATE TEMPORARY TABLE TWD AS
SELECT e.title AS 'Episode Title', e.release_date, s.title AS 'Season Title', s.number FROM episodes e
JOIN seasons s ON e.season_id = s.id
JOIN series se ON s.serie_id = se.id
WHERE se.title LIKE '%The Walking Dead%';

# Forma 2
# CREATE TEMPORARY TABLE TWD (
# 
# );

# INSERT INTO TWD 
# SELECT e.title AS 'Episode Title', e.release_date, s.title AS 'Season Title', s.number FROM episodes e
# JOIN seasons s ON e.season_id = s.id
# JOIN series se ON s.serie_id = se.id
# WHERE se.title LIKE '%The Walking Dead%';

SELECT * FROM TWD WHERE number = 1;

CREATE INDEX index_rating
ON movies (rating);

SHOW INDEX FROM movies;