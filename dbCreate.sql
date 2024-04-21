-- Instituciones
CREATE TABLE Institucion (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL
);

-- Voluntarios
CREATE TABLE Voluntario (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    rut VARCHAR(12) UNIQUE NOT NULL
);

-- Emergencias
CREATE TABLE Emergencia (
    id SERIAL PRIMARY KEY,
    id_institucion INTEGER NOT NULL,
    nombre VARCHAR(255) NOT NULL,
    activa BOOLEAN NOT NULL DEFAULT TRUE,
    FOREIGN KEY (id_institucion) REFERENCES Institucion(id)
);

-- Habilidades
CREATE TABLE Habilidad (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion TEXT
);

-- Tabla intermedia entre Voluntarios y Habilidades
CREATE TABLE Vol_Habilidad (
    id SERIAL PRIMARY KEY,
    id_voluntario INTEGER NOT NULL,
    id_habilidad INTEGER NOT NULL,
    FOREIGN KEY (id_voluntario) REFERENCES Voluntario(id),
    FOREIGN KEY (id_habilidad) REFERENCES Habilidad(id)
);

-- Tabla intermedia entre Emergencias y Habilidades
CREATE TABLE Eme_Habilidad (
    id SERIAL PRIMARY KEY,
    id_emergencia INTEGER NOT NULL,
    id_habilidad INTEGER NOT NULL,
    FOREIGN KEY (id_emergencia) REFERENCES Emergencia(id),
    FOREIGN KEY (id_habilidad) REFERENCES Habilidad(id)
);

-- Tareas
CREATE TABLE Tarea (
    id SERIAL PRIMARY KEY,
    id_emergencia INTEGER NOT NULL,
    nombre VARCHAR(255) NOT NULL,
    estado VARCHAR(50), -- 'pendiente', 'en curso', 'completada'
    FOREIGN KEY (id_emergencia) REFERENCES Emergencia(id)
);

-- Tabla intermedia entre Tareas y Habilidades
CREATE TABLE Tarea_Habilidad (
    id SERIAL PRIMARY KEY,
    id_tarea INTEGER NOT NULL,
    id_habilidad INTEGER NOT NULL,
    FOREIGN KEY (id_tarea) REFERENCES Tarea(id),
    FOREIGN KEY (id_habilidad) REFERENCES Habilidad(id)
);

-- Disponibilidad
CREATE TABLE Disponible (
    id SERIAL PRIMARY KEY,
    id_voluntario INTEGER NOT NULL,
    id_emergencia INTEGER NOT NULL,
    FOREIGN KEY (id_voluntario) REFERENCES Voluntario(id),
    FOREIGN KEY (id_emergencia) REFERENCES Emergencia(id)
);

-- Ranking
CREATE TABLE Ranking (
	id SERIAL PRIMARY KEY,
    id_voluntario INTEGER NOT NULL,
    id_tarea INTEGER NOT NULL,
    ranking INTEGER,
    FOREIGN KEY (id_voluntario) REFERENCES Voluntario(id),
    FOREIGN KEY (id_tarea) REFERENCES Tarea(id)
);
