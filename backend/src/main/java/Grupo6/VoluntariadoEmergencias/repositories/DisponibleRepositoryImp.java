package Grupo6.VoluntariadoEmergencias.repositories;

import Grupo6.VoluntariadoEmergencias.entities.DisponibleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class DisponibleRepositoryImp implements DisponibleRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public DisponibleEntity save(DisponibleEntity disponible) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO disponible (id_voluntario,id_emergencia) " +
                    "VALUES (:id_voluntario, :id_emergencia)";
            conn.createQuery(sql)
                    .addParameter("id_voluntario", disponible.getId_voluntario())
                    .addParameter("id_emergencia", disponible.getId_emergencia())
                    .executeUpdate();

            return disponible;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<DisponibleEntity> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Disponible")
                    .executeAndFetch(DisponibleEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<DisponibleEntity> getById(Long id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Disponible where id= :id")
                    .addParameter("id",id)
                    .executeAndFetch(DisponibleEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public String updateIdEmergenciaAsignada(DisponibleEntity disponible, Long id){
        try(Connection conn = sql2o.open()){
            String updateSql = "update Disponible set id_emergencia=:id_emergencia WHERE id=:id";
            conn.createQuery(updateSql)
                    .addParameter("id", id)
                    .addParameter("id_emergencia", disponible.getId_emergencia())
                    .executeUpdate();
            return "Se actualizó la id de la emergencia asignada ";
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return "No se pudo actualizar la id de la emergencia asignada";
        }
    }

    @Override
    public void delete(Long id) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from Disponible where id = :id ")
                    .addParameter("id",id)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
