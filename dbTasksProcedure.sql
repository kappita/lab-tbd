

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
                   e.nombre nombre_emergencia

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
    -- WHERE twe.is_active = TRUE
    ORDER BY twe.id_tarea DESC;

END;
$$ LANGUAGE plpgsql;


-- FUNCION PARA MOSTRAR TAREAS DISPONIBLES PARA USUARIOS CON TODAS LAS HABILIDADES NECESARIAS

-- CREATE OR REPLACE FUNCTION get_voluntary_eligible_tasks_by_email(voluntary_email TEXT)
-- RETURNS TABLE(
--     id_emergencia integer,
--     nombre_emergencia character varying,
--     id_tarea integer,
--     nombre_tarea character varying,
--     id_habilidad integer,
-- 	nombre_habilidad character varying
-- ) AS $$
-- BEGIN
--     RETURN QUERY
--     WITH voluntary_id AS (
--         SELECT v.id id_voluntario
--         FROM Voluntario v
--         WHERE v.email = voluntary_email
--     ),
--         voluntary_skills AS (
--             SELECT vs.id_voluntario id_voluntario,
--                    vs.id_habilidad id_habilidad,
--                    h.nombre nombre_habilidad
--             FROM voluntary_id v
--             LEFT JOIN Vol_habilidad vs
--             ON v.id_voluntario = vs.id_voluntario
--             INNER JOIN Habilidad h
--             ON h.id = vs.id_habilidad
--     ),
--         tasks_with_skills AS (
--             SELECT vs.*,
--                    t.id id_tarea,
--                    t.nombre nombre_tarea,
--                    t.id_emergencia id_emergencia
--             FROM 
--             voluntary_skills vs
--             INNER JOIN Tarea_Habilidad th 
--             ON vs.id_habilidad = th.id_habilidad
--             INNER JOIN Tarea t
--             ON t.id = th.id_tarea
            
--     ),
--         tasks_with_emergency AS (
--             SELECT ts.*,
--                    e.nombre nombre_emergencia

--             FROM tasks_with_skills ts
--             INNER JOIN Emergencia e
--             ON e.id = ts.id_emergencia
--     ),

--         total_skills_per_task AS (
--             SELECT th.id_tarea,
--                    count(*) cantidad_habilidades
--             FROM Tarea_habilidad th
--             GROUP BY th.id_tarea
--     ),
--         total_skills_per_eligible_task AS (
--             SELECT twe.id_tarea,
--                    count(*) cantidad_habilidades
--             FROM tasks_with_emergency twe
--             GROUP BY twe.id_tarea
--         ),
--         fulfilled_skills_tasks AS (
--             SELECT ts1.id_tarea
--             FROM total_skills_per_task ts1
--             INNER JOIN total_skills_per_eligible_task ts2
--             ON ts1.id_tarea = ts2.id_tarea
--             WHERE ts1.cantidad_habilidades = ts2.cantidad_habilidades
--         )

--     SELECT twe.id_emergencia,
--            twe.nombre_emergencia,
--            twe.id_tarea,
--            twe.nombre_tarea,
--            twe.id_habilidad,
--            twe.nombre_habilidad

--     FROM tasks_with_emergency twe
--     INNER JOIN fulfilled_skills_tasks fst
--     ON fst.id_tarea = twe.id_tarea;
--     -- WHERE twe.is_active = TRUE

-- END;
-- $$ LANGUAGE plpgsql;