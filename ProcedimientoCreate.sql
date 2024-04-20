-- Crear la tabla para almacenar los resultados del reporte de actividad por usuario --
CREATE TABLE IF NOT EXISTS usuario_contador_operaciones (
    id serial PRIMARY KEY,
    username character varying UNIQUE,
    total_operations bigint,
    last_query timestamp  -- Agregar una columna para almacenar la fecha de la última consulta
);

-- Procedimiento almacenado para generar el reporte de actividad por usuario y guardar los resultados en una tabla --
CREATE OR REPLACE FUNCTION generar_reporte_operaciones()
RETURNS VOID AS $$
BEGIN
    -- Insertar los resultados del reporte en la tabla
    INSERT INTO usuario_contador_operaciones (username, total_operations, last_query)
    SELECT
        ra.nombre_usuario,
        COUNT(*) AS total_operations,
        MAX(ra.timestamp) AS last_query
    FROM
        registro_actividad ra
    WHERE
        ra.operacion IN ('INSERT', 'UPDATE', 'DELETE')
    GROUP BY
        ra.nombre_usuario
    ON CONFLICT (username) DO UPDATE
    SET total_operations = EXCLUDED.total_operations,
        last_query = EXCLUDED.last_query;
END;
$$ LANGUAGE plpgsql;


-- Cada vez que se realiza una operación
-- primero se ejecuta esto
--SELECT generar_reporte_operaciones();


-- y luego se consulta el reporte
-- SELECT * FROM usuario_contador_operaciones ORDER BY total_operations DESC;
