CREATE TABLE IF NOT EXISTS Java (
	question_id INTEGER PRIMARY KEY,
	question_text TEXT NOT NULL,
	question_answer INTEGER NOT NULL,
	question_complement TEXT NULL
);

INSERT INTO Java VALUES (NULL, 'Ist Java eine objektorientierte Programmiersprache?', 1, NULL);
INSERT INTO Java VALUES (NULL, 'Ist Java Plattformunabhängigkeit?', 1, NULL);
INSERT INTO Java VALUES (NULL, 'Java ist im Jahr 1980 erschienen?', 0, 'Falsch! Java ist im Jahr 1995 erschienen.');
