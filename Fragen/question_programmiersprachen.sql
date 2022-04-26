CREATE TABLE IF NOT EXISTS Programmiersprachen (
	question_id INTEGER PRIMARY KEY,
	question_text TEXT NOT NULL,
	question_answer INTEGER NOT NULL,
	question_complement TEXT NULL
);

INSERT INTO Programmiersprachen VALUES (NULL, 'War Java, die erste Programmiersprache der Welt?', 0, 'Falsch! Einer der ersten Sprachen war Fortran. Diese wurde in den 1950er entwickelt.');
INSERT INTO Programmiersprachen VALUES (NULL, 'Ist James Gosling der Erfinder von Java?', 1, NULL);
INSERT INTO Programmiersprachen VALUES (NULL, 'Der Compiler übersetzt die jeweilige Programmiersprache in einem Maschinencode, korrekt?', 1, 'Korrekt! Bei Deklarativen Programmiersprachen, beschreibt der Programmierer, welche Bedingungen die Ausgabe des Programmes erfüllen muss.');
INSERT INTO Programmiersprachen VALUES (NULL, 'Ist SQL eine Deklarative Programmiersprache?', 1, NULL);
INSERT INTO Programmiersprachen VALUES (NULL, 'Besteht eine imperativen Programmiersprache Aus Anweisungen?', 1, 'Korrekt! Eine imperativen Programmiersprache, besteht aus Anweisungen (Befehlen), Schleifen, if else etc.');
