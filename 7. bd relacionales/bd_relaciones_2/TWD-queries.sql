
DROP TABLE twd;

CREATE TEMPORARY TABLE twd 
(SELECT episodes.id, title, season_id FROM episodes 
JOIN (SELECT id from seasons WHERE serie_id = 
	(SELECT id from series where title = "The Walking Dead")) 
AS auxiliar_table ON season_id = auxiliar_table.id);




SELECT episodes.id, title, season_id FROM episodes 
JOIN (SELECT id from seasons WHERE serie_id = 
	(SELECT id from series where title = "The Walking Dead")) 
AS auxiliar_table ON season_id = auxiliar_table.id;


SELECT title, season_id FROM episodes 
JOIN (SELECT id from seasons WHERE serie_id = 
	(SELECT id from series where title = "The Walking Dead")) 
AS auxiliar_table ON season_id = auxiliar_table.id;

SELECT * FROM twd;



SELECT id from series where title = "The Walking Dead";

SELECT id from seasons WHERE serie_id = (SELECT id from series where title = "The Walking Dead");

SELECT * from episodes WHERE season_id = 23;
