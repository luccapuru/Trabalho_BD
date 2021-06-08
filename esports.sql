BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "joga" (
	"fase"	INTEGER,
	"rodada"	INTEGER,
	"numero"	INTEGER,
	"id_jogador"	INTEGER,
	FOREIGN KEY("id_jogador") REFERENCES "jogador"("id_jogador"),
	FOREIGN KEY("fase","rodada","numero") REFERENCES "partida"("fase","rodada","numero"),
	PRIMARY KEY("fase","rodada","numero","id_jogador")
);
CREATE TABLE IF NOT EXISTS "participa_campeonato" (
	"nome_time"	TEXT,
	"nome_campeonato"	TEXT,
	"ano"	INTEGER,
	"colocacao"	INTEGER,
	"local"	TEXT,
	FOREIGN KEY("nome_campeonato") REFERENCES "campeonato"("nome"),
	FOREIGN KEY("nome_time") REFERENCES "time"("nome"),
	PRIMARY KEY("nome_time","nome_campeonato")
);
CREATE TABLE IF NOT EXISTS "tecnico" (
	"id_tecnico"	INTEGER,
	"nome"	TEXT,
	"nacionalidade"	TEXT,
	"data_nascimento"	TEXT,
	PRIMARY KEY("id_tecnico")
);
CREATE TABLE IF NOT EXISTS "partida" (
	"fase"	INTEGER,
	"rodada"	INTEGER,
	"numero"	INTEGER,
	"nome_campeonato"	TEXT,
	FOREIGN KEY("nome_campeonato") REFERENCES "campeonato"("nome"),
	PRIMARY KEY("fase","rodada","numero")
);
CREATE TABLE IF NOT EXISTS "patrocina_time" (
	"id_patrocinador"	INTEGER,
	"nome_time"	TEXT,
	FOREIGN KEY("id_patrocinador") REFERENCES "patrocinador"("id_patrocinador"),
	FOREIGN KEY("nome_time") REFERENCES "time"("nome"),
	PRIMARY KEY("nome_time","id_patrocinador")
);
CREATE TABLE IF NOT EXISTS "contrata_tecnico" (
	"id_tecnico"	INTEGER,
	"nome_time"	TEXT,
	FOREIGN KEY("id_tecnico") REFERENCES "tecnico"("id_tecnico"),
	FOREIGN KEY("nome_time") REFERENCES "time"("nome"),
	PRIMARY KEY("nome_time","id_tecnico")
);
CREATE TABLE IF NOT EXISTS "contrata_jogador" (
	"id_jogador"	INTEGER,
	"nome_time"	TEXT,
	FOREIGN KEY("id_jogador") REFERENCES "jogador"("id_jogador"),
	FOREIGN KEY("nome_time") REFERENCES "time"("nome"),
	PRIMARY KEY("nome_time","id_jogador")
);
CREATE TABLE IF NOT EXISTS "patrocinador" (
	"id_patrocinador"	INTEGER,
	"nome"	TEXT,
	PRIMARY KEY("id_patrocinador")
);
CREATE TABLE IF NOT EXISTS "campeonato" (
	"nome"	TEXT,
	"premiacao"	REAL,
	PRIMARY KEY("nome")
);
CREATE TABLE IF NOT EXISTS "jogador" (
	"id_jogador"	INTEGER,
	"nome"	TEXT,
	"nacionalidade"	TEXT,
	"data_nascimento"	TEXT,
	PRIMARY KEY("id_jogador")
);
CREATE TABLE IF NOT EXISTS "time" (
	"nome"	TEXT,
	"jogo"	TEXT,
	"dono"	TEXT,
	"pais"	TEXT,
	"datacriacao"	TEXT,
	PRIMARY KEY("nome")
);
INSERT INTO "joga" VALUES (3,3,3,15);
INSERT INTO "participa_campeonato" VALUES ('Revengers','Copa Manga',2018,1,'Jardel CIty');
INSERT INTO "tecnico" VALUES (6,'Carlos','mexicano','2004-06-03');
INSERT INTO "tecnico" VALUES (10,'Antonio','italiano','1961-06-08');
INSERT INTO "partida" VALUES (3,3,3,'Copa Manga');
INSERT INTO "patrocina_time" VALUES (21,'Revengers');
INSERT INTO "contrata_tecnico" VALUES (10,'texugods');
INSERT INTO "contrata_jogador" VALUES (2,'Revengers');
INSERT INTO "contrata_jogador" VALUES (15,'Revengers');
INSERT INTO "patrocinador" VALUES (7,'cocacola');
INSERT INTO "patrocinador" VALUES (21,'yankes');
INSERT INTO "campeonato" VALUES ('Copa Manga',999.989990234375);
INSERT INTO "jogador" VALUES (2,'Joao','português','22/01/1999');
INSERT INTO "jogador" VALUES (3,'Lucca','brasileiro','23/01/1999');
INSERT INTO "jogador" VALUES (4,'Francisco','francês','1999-12-09');
INSERT INTO "jogador" VALUES (15,'Rafael','suiço','1997-06-03');
INSERT INTO "time" VALUES ('texugods','League of Legends','John Kawagoe','Brasil','null');
INSERT INTO "time" VALUES ('Revengers','Elsword','Victor Santos','Irlanda','2014-06-05');
COMMIT;
