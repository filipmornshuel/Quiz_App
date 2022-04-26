CREATE TABLE IF NOT EXISTS Schweiz (
	question_id INTEGER PRIMARY KEY,
	question_text TEXT NOT NULL,
	question_answer INTEGER NOT NULL,
	question_complement TEXT NULL
);

INSERT INTO Schweiz VALUES (NULL, 'Ist die Hauptstadt von der Schweiz Zürich?', 0, 'Falsch! Hauptstadt ist Bern.');
INSERT INTO Schweiz VALUES (NULL, 'Hat die Schweiz über 8 Millionen Einwohner?', 1, 'Korrekt! Die Schweiz hat ca. 8.637 Millionen Einwohner.');
INSERT INTO Schweiz VALUES (NULL, 'Ist der Kanton Zürich der Kanton mit den meisten Einwohnern?', 1, 'Korrekt! Im Kanton Zürich leben mehr als 1.5 Millionen Menschen.');
INSERT INTO Schweiz VALUES (NULL, 'Ist der Prime Tower der höchste Turm in Zürich?', 1, 'Korrekt! Der Prime Tower hat eine Höhe von 126 meter.');
