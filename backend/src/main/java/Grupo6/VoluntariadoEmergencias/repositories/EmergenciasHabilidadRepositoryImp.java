package Grupo6.VoluntariadoEmergencias.repositories;

import Grupo6.VoluntariadoEmergencias.entities.EmergenciasHabilidadEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class EmergenciasHabilidadRepositoryImp implements EmergenciasHabilidadRepository {

    @Autowired
    private Sql2o sql2o;

    public List<EmergenciasHabilidadEntity> getEmergenciasHabilidad() {
        String sql = "SELECT E.id AS id_emergencia, E.nombre AS nombre_emergencia, H.nombre AS nombre_habilidad " +
                "FROM emergencia E " +
                "JOIN eme_Habilidad EH ON E.id = EH.id_emergencia " +
                "JOIN habilidad H ON EH.id_habilidad = H.id";

        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .executeAndFetch(EmergenciasHabilidadEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
