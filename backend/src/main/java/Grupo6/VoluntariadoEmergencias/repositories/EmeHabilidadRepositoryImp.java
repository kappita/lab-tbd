package Grupo6.VoluntariadoEmergencias.repositories;

import Grupo6.VoluntariadoEmergencias.entities.EmeHabilidadEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class EmeHabilidadRepositoryImp implements EmeHabilidadRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public EmeHabilidadEntity save(EmeHabilidadEntity emeHabilidad) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO eme_habilidad (id_emergencia,id_habilidad) " +
                    "VALUES (:id_emergencia,:id_habilidad)";
            conn.createQuery(sql)
                    .addParameter("id_emergencia", emeHabilidad.getId_Emergencia())
                    .addParameter("id_habilidad", emeHabilidad.getId_Habilidad())
                    .executeUpdate();
            return emeHabilidad;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<EmeHabilidadEntity> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from eme_habilidad")
                    .executeAndFetch(EmeHabilidadEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<EmeHabilidadEntity> getById(Long id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from eme_habilidad where id= :id")
                    .addParameter("id",id)
                    .executeAndFetch(EmeHabilidadEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public String updateHabilidadAsignada(EmeHabilidadEntity emeHabilidad, Long id){
        try(Connection conn = sql2o.open()){
            String updateSql = "update eme_habilidad set id_habilidad=:id_habilidad WHERE id=:id";
            conn.createQuery(updateSql)
                    .addParameter("id", id)
                    .addParameter("id_habilidad", emeHabilidad.getId_Habilidad())
                    .executeUpdate();
            return "Se actualizó la habilidad asignada a la emergencia";
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return "No se pudo actualizar la habilidad asignada a la emergencia";
        }
    }

    @Override
    public void delete(Long id) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from eme_habilidad where id = :id ")
                    .addParameter("id",id)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
