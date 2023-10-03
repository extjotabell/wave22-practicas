USE movies_db;

CREATE TEMPORARY TABLE TWD (title VARCHAR(55));
INSERT INTO TWD
SELECT episodes.title
FROM episodes
JOIN seasons ON episodes.season_id = seasons.id
JOIN series ON seasons.serie_id = series.id
WHERE series.title = "The Walking Dead";

DROP TABLE IF EXISTS TWD;
SELECT * FROM TWD;

CREATE INDEX idx_rating ON movies(rating);
CREATE INDEX idx_title ON movies(title);
CREATE INDEX idx_release_date ON movies(release_date);
SHOW INDEX FROM movies;