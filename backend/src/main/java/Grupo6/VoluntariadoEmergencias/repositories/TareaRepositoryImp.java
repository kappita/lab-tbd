package Grupo6.VoluntariadoEmergencias.repositories;

import Grupo6.VoluntariadoEmergencias.entities.TareaEmergenciaEntity;
import Grupo6.VoluntariadoEmergencias.entities.TareaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class TareaRepositoryImp implements TareaRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public TareaEntity save(TareaEntity tarea) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO Tarea (id_emergencia,nombre,estado) " +
                    "VALUES (:id_emergencia,:nombre,:estado)";
            conn.createQuery(sql)
                    .addParameter("id_emergencia", tarea.getId_Emergencia())
                    .addParameter("nombre", tarea.getNombre())
                    .addParameter("estado", tarea.getEstado())
                    .executeUpdate();

            return tarea;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<TareaEntity> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from tarea")
                    .executeAndFetch(TareaEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<TareaEntity> getById(Long id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Tarea where id= :id")
                    .addParameter("id",id)
                    .executeAndFetch(TareaEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public String update(TareaEntity tarea, Long id){
        try(Connection conn = sql2o.open()){
            String updateSql = "update Tarea set nombre=:nombre WHERE id=:id";
            conn.createQuery(updateSql)
                    .addParameter("id", id)
                    .addParameter("nombre", tarea.getNombre())
                    .executeUpdate();
            return "Se actualizó el nombre de la tarea";
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return "No se pudo actualizar el nombre de la tarea";
        }
    }

    @Override
    public void delete(Long id) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from Tarea where id = :id ")
                    .addParameter("id",id)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<TareaEmergenciaEntity> findEligibleTareasByVoluntaryEmail(String email) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM get_voluntary_eligible_tasks_by_email(:email)")
                    .addParameter("email", email)
                    .executeAndFetch(TareaEmergenciaEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    };
}
