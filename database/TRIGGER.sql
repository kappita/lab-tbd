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
