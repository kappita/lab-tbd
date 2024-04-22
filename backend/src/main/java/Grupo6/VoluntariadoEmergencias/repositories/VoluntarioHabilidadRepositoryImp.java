package Grupo6.VoluntariadoEmergencias.repositories;

import Grupo6.VoluntariadoEmergencias.entities.VoluntarioHabilidadEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class VoluntarioHabilidadRepositoryImp implements VoluntarioHabilidadRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public VoluntarioHabilidadEntity save(VoluntarioHabilidadEntity voluntarioHabilidad) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO vol_habilidad (id_voluntario,id_habilidad) " +
                    "VALUES (:id_voluntario,:id_habilidad)";
            conn.createQuery(sql)
                    .addParameter("id_voluntario", voluntarioHabilidad.getId_Voluntario())
                    .addParameter("id_habilidad", voluntarioHabilidad.getId_Habilidad())
                    .executeUpdate();
            return voluntarioHabilidad;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<VoluntarioHabilidadEntity> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from vol_habilidad")
                    .executeAndFetch(VoluntarioHabilidadEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<VoluntarioHabilidadEntity> getById(Long id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from vol_habilidad where id= :id")
                    .addParameter("id",id)
                    .executeAndFetch(VoluntarioHabilidadEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public String updateVoluntarioAsignado(VoluntarioHabilidadEntity voluntarioHabilidad, Long id){
        try(Connection conn = sql2o.open()){
            String updateSql = "update vol_habilidad set id_voluntario=:id_voluntario WHERE id=:id";
            conn.createQuery(updateSql)
                    .addParameter("id", id)
                    .addParameter("id_voluntario", voluntarioHabilidad.getId_Voluntario())
                    .executeUpdate();
            return "Se actualizó el id del voluntario asignado";
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return "No se pudo actualizar el id del voluntario asignado";
        }
    }

    @Override
    public void delete(Long id) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from vol_habilidad where id = :id ")
                    .addParameter("id",id)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
