------ Insertar datos en la tabla Institucion
INSERT INTO Institucion (nombre, email, password) VALUES ('ADRA Chile', 'contacto@adra.cl', 'pass9090');
INSERT INTO Institucion (nombre, email, password) VALUES ('Colegio Medico Veterinario de Chile', 'contacto@colmedvet.cl', 'pass9091');
INSERT INTO Institucion (nombre, email, password) VALUES ('Desafío Levantemos Chile', 'contacto@desafio.cl', 'pass9092');
INSERT INTO Institucion (nombre, email, password) VALUES ('Cruz Roja Chilena', 'contacto@cruzroja.cl', 'pass9093');
INSERT INTO Institucion (nombre, email, password) VALUES ('Instito Nacional de la Juventud', 'contacto@injuv.cl', 'pass9094');
INSERT INTO Institucion (nombre, email, password) VALUES ('Un Techo para Chile', 'contacto@techo.cl', 'pass9095');
INSERT INTO Institucion (nombre, email, password) VALUES ('Bomberos de Chile', 'contacto@bomberos.cl', 'pass9096');
INSERT INTO Institucion (nombre, email, password) VALUES ('Hogar de Cristo', 'contacto@hogardecristo.cl', 'pass9097');
INSERT INTO Institucion (nombre, email, password) VALUES ('Coordinadora Social Shishigang', 'contacto@shishigang.cl', 'pass9098');
INSERT INTO Institucion (nombre, email, password) VALUES ('Donaciones Naya Facil', 'contacto@nayafacil.cl', 'pass9099');

-- Insertar datos en la tabla Voluntario
INSERT INTO Voluntario (nombre, email, password, rut, ubicacion_voluntario) VALUES ('Andrea Juárez', 'andrea.juarez@example.com', 'pass123', '12345678-9',ST_GeomFromText('POINT(-33.475460477185464 -70.72326024012591)', 4326)); --SANTIAGO
INSERT INTO Voluntario (nombre, email, password, rut,ubicacion_voluntario) VALUES ('Luis Navarro', 'luis.navarro@example.com', 'pass456', '23456789-0',ST_GeomFromText('POINT(-33.47538868364822 -70.72413394422644)', 4326));
INSERT INTO Voluntario (nombre, email, password, rut,ubicacion_voluntario) VALUES ('Carla Espinoza', 'carla.espinoza@example.com', 'pass789', '14567890-1',ST_GeomFromText('POINT(-39.295751618022386 -72.23595293617713)', 4326));--VILLARICA
INSERT INTO Voluntario (nombre, email, password, rut,ubicacion_voluntario) VALUES ('Marco Antonio', 'marco.antonio@example.com', 'pass012', '15678901-2',ST_GeomFromText('POINT(-39.295938693967116 -72.23591193023263)', 4326));
INSERT INTO Voluntario (nombre, email, password, rut,ubicacion_voluntario) VALUES ('Ximena Soto', 'ximena.soto@example.com', 'pass345', '16789012-3',ST_GeomFromText('POINT(-39.295938693967116 -72.23591193023263)', 4326));
INSERT INTO Voluntario (nombre, email, password, rut,ubicacion_voluntario) VALUES ('Diego Morales', 'diego.morales@example.com', 'pass678', '17890123-4',ST_GeomFromText('POINT(-39.29429961138347 -72.23642324842609)', 4326));
INSERT INTO Voluntario (nombre, email, password, rut,ubicacion_voluntario) VALUES ('Rosa Campos', 'rosa.campos@example.com', 'pass901', '18901234-5',ST_GeomFromText('POINT(-39.294483889806955 -72.23594449904962)', 4326));
INSERT INTO Voluntario (nombre, email, password, rut,ubicacion_voluntario) VALUES ('Javier López', 'javier.lopez@example.com', 'pass234', '19012345-6',ST_GeomFromText('POINT(-39.29408053252056 -72.23546478607034)', 4326));
INSERT INTO Voluntario (nombre, email, password, rut,ubicacion_voluntario) VALUES ('Mónica Gutiérrez', 'monica.gutierrez@example.com', 'pass567', '20123456-7',ST_GeomFromText('POINT(-39.29572248782302 -72.23887361702606)', 4326));
INSERT INTO Voluntario (nombre, email, password, rut,ubicacion_voluntario) VALUES ('Esteban Rojas', 'esteban.rojas@example.com', 'pass890', '21234567-8',ST_GeomFromText('POINT(-39.29436198328951 -72.23953432795741)', 4326));
INSERT INTO Voluntario (nombre, email, password, rut,ubicacion_voluntario) VALUES ('Carmen Herrera', 'carmen.herrera@example.com', 'pass1234', '20345678-0',ST_GeomFromText('POINT(-39.29418905819766 -72.23939122721433)', 4326));
INSERT INTO Voluntario (nombre, email, password, rut,ubicacion_voluntario) VALUES ('Fernando Mora', 'fernando.mora@example.com', 'pass5678', '23456789-1',ST_GeomFromText('POINT(-53.161673785843504 -70.94343055289791)', 4326));--PUNTA ARENAS
INSERT INTO Voluntario (nombre, email, password, rut,ubicacion_voluntario) VALUES ('Gabriela Castillo', 'gabriela.castillo@example.com', 'pass91011', '21567890-2',ST_GeomFromText('POINT(-53.160851706087755 -70.94572199434975)', 4326));
INSERT INTO Voluntario (nombre, email, password, rut,ubicacion_voluntario) VALUES ('Mauricio Pinto', 'mauricio.pinto@example.com', 'pass1213', '22678901-3',ST_GeomFromText('POINT(-27.3590183560186 -70.31368820371438)', 4326));--COPIAPÓ
INSERT INTO Voluntario (nombre, email, password, rut,ubicacion_voluntario) VALUES ('Lucia Méndez', 'lucia.mendez@example.com', 'pass1415', '22789012-4',ST_GeomFromText('POINT(-27.35836069846974 -70.31283756029991)', 4326));
INSERT INTO Voluntario (nombre, email, password, rut,ubicacion_voluntario) VALUES ('Carmen Rosario', 'carmen.reosario@example.com', 'pass1234', '21445678-0',ST_GeomFromText('POINT(-20.235032129183317 -70.13005699582126)', 4326));--IQUIQUE
INSERT INTO Voluntario (nombre, email, password, rut,ubicacion_voluntario) VALUES ('Fernando Martinez', 'fernando.martinez@example.com', 'pass5678', '22456789-2',ST_GeomFromText('POINT(-20.237267679052415 -70.13047671112301)', 4326));
INSERT INTO Voluntario (nombre, email, password, rut,ubicacion_voluntario) VALUES ('Gabriela Gaete', 'gabriela.gaete@example.com', 'pass91011', '20567890-2',ST_GeomFromText('POINT(-20.236845974454152 -70.1310180399508)', 4326));
INSERT INTO Voluntario (nombre, email, password, rut,ubicacion_voluntario) VALUES ('Mauricio Martinez', 'mauricio.martinez@example.com', 'pass1213', '20678901-2',ST_GeomFromText('POINT(-20.236312329044015 -70.13053487778923)', 4326));
INSERT INTO Voluntario (nombre, email, password, rut,ubicacion_voluntario) VALUES ('Lucia Petinelli', 'lucia.petinelli@example.com', 'pass1415', '21789012-2',ST_GeomFromText('POINT(-33.23262573587894 -70.80860877689753)', 4326));
-- Insertar datos en la tabla Emergencia
INSERT INTO Emergencia (id_institucion, nombre) VALUES (1, 'Inundación en Curanilahue');
INSERT INTO Emergencia (id_institucion, nombre) VALUES (2, 'Terremoto en la Falla de San Ramón');
INSERT INTO Emergencia (id_institucion, nombre) VALUES (3, 'Incendio en la Quinta Región');
INSERT INTO Emergencia (id_institucion, nombre) VALUES (4, 'Erupción Volcan Villarrica');
INSERT INTO Emergencia (id_institucion, nombre) VALUES (5, 'Deslizamiento de Tierra en Arica');
INSERT INTO Emergencia (id_institucion, nombre) VALUES (6, 'Accidente de Tránsito ruta 5');
INSERT INTO Emergencia (id_institucion, nombre) VALUES (7, 'Aluvión en San José de Maipo');

-- Insertar datos en la tabla Habilidad
INSERT INTO Habilidad (nombre, descripcion) VALUES ('Primeros Auxilios', 'Capacidad para realizar atención inicial en emergencias médicas.');
INSERT INTO Habilidad (nombre, descripcion) VALUES ('Incendios Forestales', 'Experiencia en combate de incendios en áreas naturales.');
INSERT INTO Habilidad (nombre, descripcion) VALUES ('Remoción de escombros', 'Capacacidad para realizar labores de remoción de escombros.');
INSERT INTO Habilidad (nombre, descripcion) VALUES ('Asistencia Psicológica', 'Experiencia en el rubro de la psicología y trata de personas.');
INSERT INTO Habilidad (nombre, descripcion) VALUES ('Búsqueda y Rescate','Habilidades especializadas en la localización y recuperación de personas atrapadas o perdidas.');
INSERT INTO Habilidad (nombre, descripcion) VALUES ('Cocinero','Experiencia en Cocina para ollas comunes.');

-- Asociar voluntarios con habilidades
INSERT INTO Vol_Habilidad (id_voluntario, id_habilidad) VALUES (1, 1);
INSERT INTO Vol_Habilidad (id_voluntario, id_habilidad) VALUES (2, 2);
INSERT INTO Vol_Habilidad (id_voluntario, id_habilidad) VALUES (3, 3);
INSERT INTO Vol_Habilidad (id_voluntario, id_habilidad) VALUES (4, 4);
INSERT INTO Vol_Habilidad (id_voluntario, id_habilidad) VALUES (5, 5);
INSERT INTO Vol_Habilidad (id_voluntario, id_habilidad) VALUES (6, 6);

-- Asociar emergencias con habilidades requeridas
INSERT INTO Eme_Habilidad (id_emergencia, id_habilidad) VALUES (1, 1);
INSERT INTO Eme_Habilidad (id_emergencia, id_habilidad) VALUES (2, 2);
INSERT INTO Eme_Habilidad (id_emergencia, id_habilidad) VALUES (3, 3);
INSERT INTO Eme_Habilidad (id_emergencia, id_habilidad) VALUES (4, 4);
INSERT INTO Eme_Habilidad (id_emergencia, id_habilidad) VALUES (5, 5);

-- Insertar datos en la tabla Tarea
INSERT INTO Tarea (id_emergencia, nombre, estado) VALUES (1, 'Distribución de Víveres', 'pendiente');
INSERT INTO Tarea (id_emergencia, nombre, estado) VALUES (1, 'Mantenimiento de Comunicaciones', 'en curso');
INSERT INTO Tarea (id_emergencia, nombre, estado) VALUES (2, 'Reparación de Infraestructura Vial', 'completada');
INSERT INTO Tarea (id_emergencia, nombre, estado) VALUES (2, 'Instalación de Refugios Temporales', 'pendiente');
INSERT INTO Tarea (id_emergencia, nombre, estado) VALUES (3, 'Coordinación de Evacuación de Zona de Riesgo', 'en curso');
INSERT INTO Tarea (id_emergencia, nombre, estado) VALUES (4, 'Asistencia Médica en Campo', 'completada');
INSERT INTO Tarea (id_emergencia, nombre, estado) VALUES (4, 'Recopilación de Datos de Afectados', 'pendiente');
INSERT INTO Tarea (id_emergencia, nombre, estado) VALUES (5, 'Control de Plagas y Enfermedades', 'en curso');
INSERT INTO Tarea (id_emergencia, nombre, estado) VALUES (6, 'Soporte Psicológico a Víctimas', 'pendiente');
INSERT INTO Tarea (id_emergencia, nombre, estado) VALUES (7, 'Evaluación de Seguridad Post-desastre', 'en curso');

-- Asociar tareas con habilidades
INSERT INTO Tarea_Habilidad (id_tarea, id_habilidad) VALUES (1, 6);
INSERT INTO Tarea_Habilidad (id_tarea, id_habilidad) VALUES (2, 5);
INSERT INTO Tarea_Habilidad (id_tarea, id_habilidad) VALUES (3, 3);
INSERT INTO Tarea_Habilidad (id_tarea, id_habilidad) VALUES (4, 3);
INSERT INTO Tarea_Habilidad (id_tarea, id_habilidad) VALUES (5, 5);
INSERT INTO Tarea_Habilidad (id_tarea, id_habilidad) VALUES (6, 1);
INSERT INTO Tarea_Habilidad (id_tarea, id_habilidad) VALUES (7, 4);
INSERT INTO Tarea_Habilidad (id_tarea, id_habilidad) VALUES (8, 5);
INSERT INTO Tarea_Habilidad (id_tarea, id_habilidad) VALUES (9, 4);
INSERT INTO Tarea_Habilidad (id_tarea, id_habilidad) VALUES (10, 5);

-- Registrar la disponibilidad de voluntarios para emergencias
INSERT INTO Disponible (id_voluntario, id_emergencia) VALUES (1, 1);
INSERT INTO Disponible (id_voluntario, id_emergencia) VALUES (2, 1);
INSERT INTO Disponible (id_voluntario, id_emergencia) VALUES (1, 2);
INSERT INTO Disponible (id_voluntario, id_emergencia) VALUES (3, 1);
INSERT INTO Disponible (id_voluntario, id_emergencia) VALUES (4, 3);
INSERT INTO Disponible (id_voluntario, id_emergencia) VALUES (5, 4);
INSERT INTO Disponible (id_voluntario, id_emergencia) VALUES (6, 2); 
INSERT INTO Disponible (id_voluntario, id_emergencia) VALUES (7, 5); 
INSERT INTO Disponible (id_voluntario, id_emergencia) VALUES (8, 6);
INSERT INTO Disponible (id_voluntario, id_emergencia) VALUES (9, 7);

-- Establecer el ranking de los voluntarios para una emergencia
INSERT INTO Ranking (id_voluntario, id_tarea, ranking) VALUES (1, 1, 1);
INSERT INTO Ranking (id_voluntario, id_tarea, ranking) VALUES (2, 1, 2);
INSERT INTO Ranking (id_voluntario, id_tarea, ranking) VALUES (3, 1, 3);
INSERT INTO Ranking (id_voluntario, id_tarea, ranking) VALUES (4, 2, 1);
INSERT INTO Ranking (id_voluntario, id_tarea, ranking) VALUES (5, 2, 2);
INSERT INTO Ranking (id_voluntario, id_tarea, ranking) VALUES (6, 3, 1);
INSERT INTO Ranking (id_voluntario, id_tarea, ranking) VALUES (7, 4, 1);
INSERT INTO Ranking (id_voluntario, id_tarea, ranking) VALUES (8, 5, 1);
INSERT INTO Ranking (id_voluntario, id_tarea, ranking) VALUES (9, 6, 1);
INSERT INTO Ranking (id_voluntario, id_tarea, ranking) VALUES (10, 7, 1);

