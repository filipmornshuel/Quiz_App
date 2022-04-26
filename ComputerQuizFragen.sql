CREATE TABLE IF NOT EXISTS Computer(
	question_id integer PRIMARY KEY,
	question_text TEXT NOT NULL,
	question_answer INTEGER NOT NULL,
	question_complement TEXT NULL
);

INSERT INTO Computer VALUES(NULL, 'Wurde Apple II im Jahr 1977 veröffentlicht?', 1, NULL);
INSERT INTO Computer VALUES(NULL, 'Wurde im Jahr 1981 der erste Personal Computer vorgestellt?', 1, NULL);
INSERT INTO Computer VALUES(NULL, 'Hat Konrad Zuse den ersten vollelektronischen Computer entwickelt?', 0, 'Falsch! Konrad Zuse verwendete Relais. Damit war der Computer noch nicht vollelektrisch.');
INSERT INTO Computer VALUES(NULL, 'War Pong von Atari das erste Spiel der Welt?', 1, NULL);
INSERT INTO Computer VALUES(NULL, 'Die erste Xbox ist im Jahr 1998 erschienen.', 0, 'Falsch! Die erste Xbox ist im Jahr2001 in den USA erschienen.');


-- CREATE TABLE IF NOT EXISTS Programmiersprachen(	);

