package Grupo6.VoluntariadoEmergencias.repositories;

import Grupo6.VoluntariadoEmergencias.entities.InstitucionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Repository
public class InstitucionRepositoryImp implements InstitucionRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public InstitucionEntity save(InstitucionEntity institucion) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO Institucion (id,nombre) " +
                    "VALUES (:id_institucion, :nombre)";
            conn.createQuery(sql)
                    .addParameter("id_institucion", institucion.getId())
                    .addParameter("nombre", institucion.getNombre())
                    .executeUpdate();

            return institucion;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
