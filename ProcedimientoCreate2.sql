-- Procedimiento almacenado para generar el reporte de actividad por usuario --
CREATE OR REPLACE FUNCTION generate_user_query_report()
RETURNS TABLE (username character varying, query_count integer, last_query timestamp) AS $$
BEGIN
    RETURN QUERY
    SELECT
        ra.nombre_usuario,
        COUNT(ra.id)::integer AS query_count,
        MAX(ra.timestamp) AS last_query
    FROM
        registro_actividad ra
    WHERE
        ra.operacion IN ('INSERT', 'UPDATE', 'DELETE')
    GROUP BY
        ra.nombre_usuario;
END;
$$ LANGUAGE plpgsql;

-- Test: SELECT * FROM generate_user_query_report();