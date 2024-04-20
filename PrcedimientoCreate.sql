-- Procedimiento almacenado para generar el reporte de actividad por usuario y guardar los resultados en una tabla --
CREATE OR REPLACE FUNCTION generate_user_query_report_and_save()
RETURNS VOID AS $$
BEGIN
    -- Crear la tabla para almacenar los resultados si no existe
    CREATE TABLE IF NOT EXISTS user_query_report (
        id serial PRIMARY KEY,
        username character varying,
        query_count bigint,
        last_query timestamp,
        query text,
        operacion varchar(10)
    );

    -- Eliminar cualquier dato previo en la tabla
    TRUNCATE TABLE user_query_report;

    -- Insertar los resultados del reporte en la tabla
    INSERT INTO user_query_report (username, query_count, last_query, query, operacion)
    SELECT
        ra.nombre_usuario,
        COUNT(ra.id) AS query_count,
        MAX(ra.timestamp) AS last_query,
        ra.query,
        ra.operacion
    FROM
        registro_actividad ra
    WHERE
        ra.operacion IN ('INSERT', 'UPDATE', 'DELETE')
    GROUP BY
        ra.nombre_usuario, ra.query, ra.operacion
    ORDER BY
        query_count DESC; -- Ordenar por query_count de mayor a menor

END;
$$ LANGUAGE plpgsql;

-- PTesteo: SELECT * FROM user_query_report;