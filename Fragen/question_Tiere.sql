CREATE TABLE IF NOT EXISTS Tiere (
	question_id INTEGER PRIMARY KEY,
	question_text TEXT NOT NULL,
	question_answer INTEGER NOT NULL,
	question_complement TEXT NULL
);

INSERT INTO Tiere VALUES (NULL, 'Ist der Elefant das größte Tier der Welt?', 0, 'Falsch! Der Blauwal ist mit einer Länge von 33m das größter Tier.');
INSERT INTO Tiere VALUES (NULL, 'Ist das Flusspferd gefährlich?', 1, 'Korrekt! Das Flusspferd gehört zu den 10 tödlichsten Tieren der Welt.');
INSERT INTO Tiere VALUES (NULL, 'Kann ein Hippo schneller als 25km/h laufen?', 1, 'Korrekt! Ein Hippo kann bis zu 30 km/h erreichen.');
INSERT INTO Tiere VALUES (NULL, 'Ist der Engmaulfrosch eines der kleinsten Tiere der Welt?', 1, 'Korrekt! Der Engmaulfrosch ist kleiner als eine Münze.');
