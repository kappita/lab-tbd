-- Crear la tabla para almacenar los resultados del reporte de actividad por usuario --
CREATE TABLE IF NOT EXISTS usuario_contador_operaciones (
    id serial PRIMARY KEY,
    username character varying UNIQUE,
    total_operations bigint,
    last_query timestamp,  -- Agregar una columna para almacenar la fecha de la última consulta
    queries text[]  -- Agregar una columna para almacenar las consultas realizadas por el usuario
);

-- Procedimiento almacenado para generar el reporte de actividad por usuario y guardar los resultados en una tabla --
CREATE OR REPLACE FUNCTION generar_reporte_operaciones()
RETURNS VOID AS $$
BEGIN
    -- Insertar los resultados del reporte en la tabla
    INSERT INTO usuario_contador_operaciones (username, total_operations, last_query, queries)
    SELECT
        ra.nombre_usuario,
        COUNT(*) AS total_operations,
        MAX(ra.timestamp) AS last_query,
        ARRAY_AGG(ra.query) AS queries  -- Agregar las consultas al arreglo
    FROM
        registro_actividad ra
    WHERE
        ra.operacion IN ('INSERT', 'UPDATE', 'DELETE')
    GROUP BY
        ra.nombre_usuario
    ON CONFLICT (username) DO UPDATE
    SET total_operations = EXCLUDED.total_operations,
        last_query = EXCLUDED.last_query,
        queries = ARRAY_CAT(usuario_contador_operaciones.queries, EXCLUDED.queries);  -- Concatenar los arreglos de consultas
END;
$$ LANGUAGE plpgsql;

--Ejecutar ambas para testeo:
--SELECT generar_reporte_operaciones();
--SELECT * FROM usuario_contador_operaciones ORDER BY total_operations DESC;


