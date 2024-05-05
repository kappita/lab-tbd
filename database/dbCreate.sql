-- Instituciones
CREATE TABLE Institucion (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
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
    FOREIGN KEY (id_voluntario) REFERENCES Voluntario(id) ON DELETE CASCADE,
    FOREIGN KEY (id_habilidad) REFERENCES Habilidad(id) ON DELETE CASCADE
);

-- Tabla intermedia entre Emergencias y Habilidades
CREATE TABLE Eme_Habilidad (
    id SERIAL PRIMARY KEY,
    id_emergencia INTEGER NOT NULL,
    id_habilidad INTEGER NOT NULL,
    FOREIGN KEY (id_emergencia) REFERENCES Emergencia(id) ON DELETE CASCADE,
    FOREIGN KEY (id_habilidad) REFERENCES Habilidad(id) ON DELETE CASCADE
);

-- Tareas
CREATE TABLE Tarea (
    id SERIAL PRIMARY KEY,
    id_emergencia INTEGER NOT NULL,
    nombre VARCHAR(255) NOT NULL,
    estado VARCHAR(50), -- 'pendiente', 'en curso', 'completada'
    FOREIGN KEY (id_emergencia) REFERENCES Emergencia(id) ON DELETE CASCADE
);

-- Tabla intermedia entre Tareas y Habilidades
CREATE TABLE Tarea_Habilidad (
    id SERIAL PRIMARY KEY,
    id_tarea INTEGER NOT NULL,
    id_habilidad INTEGER NOT NULL,
    FOREIGN KEY (id_tarea) REFERENCES Tarea(id) ON DELETE CASCADE,
    FOREIGN KEY (id_habilidad) REFERENCES Habilidad(id) ON DELETE CASCADE
);

-- Disponibilidad
CREATE TABLE Disponible (
    id SERIAL PRIMARY KEY,
    id_voluntario INTEGER NOT NULL,
    id_emergencia INTEGER NOT NULL,
    FOREIGN KEY (id_voluntario) REFERENCES Voluntario(id) ON DELETE CASCADE,
    FOREIGN KEY (id_emergencia) REFERENCES Emergencia(id) ON DELETE CASCADE
);

-- Ranking
CREATE TABLE Ranking (
	id SERIAL PRIMARY KEY,
    id_voluntario INTEGER NOT NULL,
    id_tarea INTEGER NOT NULL,
    ranking INTEGER,
    FOREIGN KEY (id_voluntario) REFERENCES Voluntario(id) ON DELETE CASCADE,
    FOREIGN KEY (id_tarea) REFERENCES Tarea(id) ON DELETE CASCADE
);


CREATE OR REPLACE FUNCTION get_voluntary_eligible_tasks_by_email(voluntary_email TEXT)
RETURNS TABLE(
    id_emergencia integer,
    nombre_emergencia character varying,
    id_tarea integer,
    nombre_tarea character varying,
    id_habilidad integer,
	nombre_habilidad character varying
) AS $$
BEGIN
    RETURN QUERY
    WITH voluntary_id AS (
        SELECT v.id id_voluntario
        FROM Voluntario v
        WHERE v.email = voluntary_email
    ),
        voluntary_skills AS (
            SELECT vs.id_voluntario id_voluntario,
                   vs.id_habilidad id_habilidad,
                   h.nombre nombre_habilidad
            FROM voluntary_id v
            LEFT JOIN Vol_habilidad vs
            ON v.id_voluntario = vs.id_voluntario
            INNER JOIN Habilidad h
            ON h.id = vs.id_habilidad
    ),
        tasks_with_skills AS (
            SELECT vs.*,
                   t.id id_tarea,
                   t.nombre nombre_tarea,
                   t.id_emergencia id_emergencia
            FROM 
            voluntary_skills vs
            INNER JOIN Tarea_Habilidad th 
            ON vs.id_habilidad = th.id_habilidad
            INNER JOIN Tarea t
            ON t.id = th.id_tarea
            
    ),
        tasks_with_emergency AS (
            SELECT ts.*,
                   e.nombre nombre_emergencia,
                   e.activa activa

            FROM tasks_with_skills ts
            INNER JOIN Emergencia e
            ON e.id = ts.id_emergencia
    )

    SELECT twe.id_emergencia,
           twe.nombre_emergencia,
           twe.id_tarea,
           twe.nombre_tarea,
           twe.id_habilidad,
           twe.nombre_habilidad

    FROM tasks_with_emergency twe
    WHERE twe.activa = TRUE
    ORDER BY twe.id_tarea DESC;

END;
$$ LANGUAGE plpgsql;

-- TRIGGER

-- Tabla que registra la actividad realizada en la base de datos. --
CREATE TABLE registro_actividad (
  id serial PRIMARY KEY,
  nombre_tabla varchar(255),
  operacion varchar(10),
  nombre_usuario varchar(255),
  timestamp timestamp,
  query text
);

-- Función que se utiliza para registrar cambios en la base de datos.--
CREATE OR REPLACE FUNCTION funcion_registro_trigger()
RETURNS TRIGGER AS $$
DECLARE
  nombre_usuario varchar(255);
BEGIN 
  -- Verificar si la tabla tiene una columna id_voluntario
  IF EXISTS(SELECT 1 FROM information_schema.columns WHERE table_name = TG_TABLE_NAME AND column_name = 'id_voluntario') THEN
    EXECUTE format('SELECT nombre FROM Voluntario WHERE id = $1', NEW.id_voluntario) INTO nombre_usuario;
  -- Verificar si la tabla tiene una columna id_institucion
  ELSIF EXISTS(SELECT 1 FROM information_schema.columns WHERE table_name = TG_TABLE_NAME AND column_name = 'id_institucion') THEN
    EXECUTE format('SELECT nombre FROM Institucion WHERE id = $1', NEW.id_institucion) INTO nombre_usuario;
  ELSE
    -- Definir el nombre del usuario como el nombre de usuario de la sesión actual
    nombre_usuario := current_user;
  END IF;

  -- Insertar en el registro de actividad
  INSERT INTO registro_actividad (nombre_tabla, operacion, nombre_usuario, timestamp, query)
  VALUES (TG_TABLE_NAME, TG_OP, nombre_usuario, current_timestamp, NEW::text);

  RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Triggers para las tablas a registrar. --

-- Trigger para tabla Institucion
CREATE TRIGGER trigger_registro_institucion
AFTER INSERT OR UPDATE OR DELETE ON Institucion
FOR EACH ROW
EXECUTE FUNCTION funcion_registro_trigger();

-- Trigger para tabla Voluntario
CREATE TRIGGER trigger_registro_voluntario
AFTER INSERT OR UPDATE OR DELETE ON Voluntario
FOR EACH ROW
EXECUTE FUNCTION funcion_registro_trigger();

-- Trigger para tabla Emergencia
CREATE TRIGGER trigger_registro_emergencia
AFTER INSERT OR UPDATE OR DELETE ON Emergencia
FOR EACH ROW
EXECUTE FUNCTION funcion_registro_trigger();

-- Trigger para tabla Habilidades
CREATE TRIGGER trigger_registro_habilidades
AFTER INSERT OR UPDATE OR DELETE ON Habilidad
FOR EACH ROW
EXECUTE FUNCTION funcion_registro_trigger();

-- Trigger para tabla Voluntarios y Habilidades
CREATE TRIGGER trigger_registro_volHabilidad
AFTER INSERT OR UPDATE OR DELETE ON Vol_Habilidad
FOR EACH ROW
EXECUTE FUNCTION funcion_registro_trigger();

-- Trigger para tabla Emergencias y Habilidades
CREATE TRIGGER trigger_registro_emeHabilidad
AFTER INSERT OR UPDATE OR DELETE ON Eme_Habilidad
FOR EACH ROW
EXECUTE FUNCTION funcion_registro_trigger();

-- Trigger para tabla tarea
CREATE TRIGGER trigger_registro_tarea
AFTER INSERT OR UPDATE OR DELETE ON Tarea
FOR EACH ROW
EXECUTE FUNCTION funcion_registro_trigger();

-- Trigger para tabla Tarea y Habilidades
CREATE TRIGGER trigger_registro_tareaHabilidad
AFTER INSERT OR UPDATE OR DELETE ON Tarea_Habilidad
FOR EACH ROW
EXECUTE FUNCTION funcion_registro_trigger();

-- Trigger para tabla disponible
CREATE TRIGGER trigger_registro_disponible
AFTER INSERT OR UPDATE OR DELETE ON Disponible
FOR EACH ROW
EXECUTE FUNCTION funcion_registro_trigger();

-- Trigger para tabla ranking
CREATE TRIGGER trigger_registro_ranking
AFTER INSERT OR UPDATE OR DELETE ON Ranking
FOR EACH ROW
EXECUTE FUNCTION funcion_registro_trigger();

-- Testeo: SELECT * FROM registro_actividad;

-- Procedimiento almacenado para generar el reporte de actividad por usuario --
CREATE OR REPLACE FUNCTION generate_user_query_report()
RETURNS TABLE (username character varying, query_count integer, last_query timestamp, queries text[]) AS $$
BEGIN
    RETURN QUERY
    SELECT
        ra.nombre_usuario,
        COUNT(ra.id)::integer AS query_count,
        MAX(ra.timestamp) AS last_query,
        ARRAY_AGG(ra.query) AS queries  -- Agregar las consultas al arreglo
    FROM
        registro_actividad ra
    WHERE
        ra.operacion IN ('INSERT', 'UPDATE', 'DELETE')
    GROUP BY
        ra.nombre_usuario
    ORDER BY
        COUNT(ra.id) DESC; -- Ordenar de mayor a menor el número de operaciones por usuario
END;
$$ LANGUAGE plpgsql;

-- TESTEO:
-- SELECT * FROM generate_user_query_report();