package Grupo6.VoluntariadoEmergencias.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Repository
public class AgregarVoluntarioDisponibleRepositoryImp implements AgregarVoluntarioDisponibleRepository {

    @Autowired
    private Sql2o sql2o;

    public void postularComoDisponible(int idEmergencia, String emailVoluntario) {
        try (Connection conn = sql2o.open()) {
            // Obtener el ID del voluntario usando su correo electrónico
            String obtenerIdVoluntarioSql = "SELECT id FROM voluntario WHERE email = :emailVoluntario";
            Integer idVoluntario = conn.createQuery(obtenerIdVoluntarioSql)
                    .addParameter("emailVoluntario", emailVoluntario)
                    .executeScalar(Integer.class);

            if (idVoluntario != null) {
                // Insertar al voluntario en la tabla Disponible
                String insertarDisponibleSql = "INSERT INTO disponible (id_voluntario, id_emergencia) " +
                        "VALUES (:id_voluntario, :id_emergencia)";
                conn.createQuery(insertarDisponibleSql)
                        .addParameter("id_voluntario", idVoluntario)
                        .addParameter("id_emergencia", idEmergencia)
                        .executeUpdate();

                // Agregar las habilidades requeridas para esa emergencia a la tabla vol_habilidad
                String agregarHabilidadesSql = "INSERT INTO vol_habilidad (id_voluntario, id_habilidad) " +
                        "SELECT :id_voluntario, id_habilidad " +
                        "FROM eme_habilidad " +
                        "WHERE id_emergencia = :id_emergencia";
                conn.createQuery(agregarHabilidadesSql)
                        .addParameter("id_emergencia", idEmergencia)
                        .addParameter("id_voluntario", idVoluntario)
                        .executeUpdate();
            } else {
                System.out.println("No se encontro ningun voluntario con el correo electronico proporcionado.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
