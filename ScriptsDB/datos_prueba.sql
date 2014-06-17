/* CONFIG */
TRUNCATE config;
INSERT INTO config VALUES ('oid', '53');

/* CABALLOS */
TRUNCATE caballos;
INSERT INTO caballos VALUES ('Chispazo', 'Adrian', 1);
INSERT INTO caballos VALUES ('Alegre', 'Adrian', 2);
INSERT INTO caballos VALUES ('Retonto', 'Adrian', 3);
INSERT INTO caballos VALUES ('El Manco', 'Jorge', 4);
INSERT INTO caballos VALUES ('Negro', 'Jorge', 5);
INSERT INTO caballos VALUES ('Diente', 'Jorge', 6);
INSERT INTO caballos VALUES ('El Corto', 'Esteban', 7);
INSERT INTO caballos VALUES ('Rebelde', 'Esteban', 8);
INSERT INTO caballos VALUES ('Tornado', 'Esteban', 9);
INSERT INTO caballos VALUES ('El Rayo', 'Esteban', 10);
INSERT INTO caballos VALUES ('Mengano', 'Pedro', 11);
INSERT INTO caballos VALUES ('Babieca', 'Pedro', 12);
INSERT INTO caballos VALUES ('Kekeke', 'Pedro', 13);

/* HIPODROMOS */
TRUNCATE hipodromos;
INSERT INTO hipodromos VALUES (14, 'Maroñas', 'General Flores');
INSERT INTO hipodromos VALUES (15, 'Colonia', 'Calle 1234');
INSERT INTO hipodromos VALUES (16, 'Paysandú', 'Ruta 15');
INSERT INTO hipodromos VALUES (17, 'Artigas', 'Av. Brasil');

/* JUGADORES */
TRUNCATE jugadores;
INSERT INTO jugadores VALUES (18, 'Pedro', 'Jugador_1', 'pedro', '111', 1500);
INSERT INTO jugadores VALUES (19, 'Juan', 'Jugador_2', 'juan', '222', 2500);
INSERT INTO jugadores VALUES (20, 'Ana', 'Jugador_3', 'ana', '333', 4500);
INSERT INTO jugadores VALUES (21, 'Jose', 'Jugador_4', 'jose', '444', 8000);
INSERT INTO jugadores VALUES (22, 'María', 'Jugador_5', 'maria', '555', 15000);

/* ADMINISTRADORES */
TRUNCATE administradores;
INSERT INTO administradores VALUES (23, 'Admin', 'Rodríguez', 'admin', 'admin');
INSERT INTO administradores VALUES (24, 'Root', 'González', 'root', 'root');

/* CARRERAS */
TRUNCATE carreras;
INSERT INTO carreras VALUES (25, 'Carrera_1', 1, CURDATE(), 4, 26, 14);
INSERT INTO carreras VALUES (29, 'Carrera_2', 2, CURDATE(), 4, 30, 14);
INSERT INTO carreras VALUES (33, 'Carrera_3', 3, CURDATE(), 4, 34, 14);
INSERT INTO carreras VALUES (37, 'Carrera_4', 4, CURDATE(), 2, NULL, 14);
INSERT INTO carreras VALUES (41, 'Carrera_5', 5, CURDATE(), 1, NULL, 14);
INSERT INTO carreras VALUES (45, 'Carrera_6', 6, CURDATE(), 1, NULL, 14);
INSERT INTO carreras VALUES (49, 'Carrera_7', 7, CURDATE(), 1, NULL, 14);

/* CABALLOS CARRERA */
TRUNCATE caballoscarrera;
INSERT INTO caballoscarrera VALUES (26, 1, 25, 1, 1.10, 0);
INSERT INTO caballoscarrera VALUES (27, 2, 25, 2, 1.20, 0);
INSERT INTO caballoscarrera VALUES (28, 3, 25, 3, 1.30, 0);
INSERT INTO caballoscarrera VALUES (30, 4, 29, 1, 1.10, 0);
INSERT INTO caballoscarrera VALUES (31, 5, 29, 2, 1.20, 0);
INSERT INTO caballoscarrera VALUES (32, 6, 29, 3, 1.30, 0);
INSERT INTO caballoscarrera VALUES (34, 7, 33, 1, 1.10, 0);
INSERT INTO caballoscarrera VALUES (35, 8, 33, 2, 1.20, 0);
INSERT INTO caballoscarrera VALUES (36, 9, 33, 3, 1.30, 0);
INSERT INTO caballoscarrera VALUES (38, 10, 37, 1, 1.10, 0);
INSERT INTO caballoscarrera VALUES (39, 11, 37, 2, 1.20, 0);
INSERT INTO caballoscarrera VALUES (40, 12, 37, 3, 1.30, 0);
INSERT INTO caballoscarrera VALUES (42, 13, 41, 1, 1.10, 0);
INSERT INTO caballoscarrera VALUES (43, 1, 41, 2, 1.20, 0);
INSERT INTO caballoscarrera VALUES (44, 2, 41, 3, 1.30, 0);
INSERT INTO caballoscarrera VALUES (46, 3, 45, 1, 1.10, 0);
INSERT INTO caballoscarrera VALUES (47, 4, 45, 2, 1.20, 0);
INSERT INTO caballoscarrera VALUES (48, 5, 45, 3, 1.30, 0);
INSERT INTO caballoscarrera VALUES (50, 6, 49, 1, 1.10, 0);
INSERT INTO caballoscarrera VALUES (51, 7, 49, 2, 1.20, 0);
INSERT INTO caballoscarrera VALUES (52, 8, 49, 3, 1.30, 0);
