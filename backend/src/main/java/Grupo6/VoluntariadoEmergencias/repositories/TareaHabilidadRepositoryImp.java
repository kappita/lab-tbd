package Grupo6.VoluntariadoEmergencias.repositories;

import Grupo6.VoluntariadoEmergencias.entities.TareaHabilidadEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class TareaHabilidadRepositoryImp implements TareaHabilidadRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public TareaHabilidadEntity save(TareaHabilidadEntity tareaHabilidad) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO tarea_habilidad (id_tarea,id_habilidad) " +
                    "VALUES (:id_tarea,:id_habilidad)";
            conn.createQuery(sql)
                    .addParameter("id_tarea", tareaHabilidad.getId_Tarea())
                    .addParameter("id_habilidad", tareaHabilidad.getId_Habilidad())
                    .executeUpdate();

            return tareaHabilidad;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<TareaHabilidadEntity> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from tarea_habilidad")
                    .executeAndFetch(TareaHabilidadEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<TareaHabilidadEntity> getById(Long id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from tarea_habilidad where id= :id")
                    .addParameter("id",id)
                    .executeAndFetch(TareaHabilidadEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public String updateTareaAsignada(TareaHabilidadEntity tareaHabilidad, Long id){
        try(Connection conn = sql2o.open()){
            String updateSql = "update TareaHabilidad set id_tarea=:nombre WHERE id=:id";
            conn.createQuery(updateSql)
                    .addParameter("id", id)
                    .addParameter("id_tarea", tareaHabilidad.getId_Tarea())
                    .executeUpdate();
            return "Se actualizó la tarea asignada a una habilidad";
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return "No se pudo actualizar la tarea asignada a una habilidad";
        }
    }

    @Override
    public void delete(Long id) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from tarea_habilidad where id = :id ")
                    .addParameter("id",id)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
