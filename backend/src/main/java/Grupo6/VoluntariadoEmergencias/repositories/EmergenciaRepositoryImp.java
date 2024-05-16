package Grupo6.VoluntariadoEmergencias.repositories;

import Grupo6.VoluntariadoEmergencias.entities.EmergenciaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class EmergenciaRepositoryImp implements EmergenciaRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public EmergenciaEntity save(EmergenciaEntity emergencia) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO Emergencia (id_institucion, nombre, longitud_emergencia, latitud_emergencia, ubicacion_emergencia) " +
                    "VALUES ( :id_institucion, :nombre, :longitud_emergencia, :latitud_emergencia, ST_SetSRID(ST_MakePoint(:longitud_emergencia, :latitud_emergencia), 4326))";
            conn.createQuery(sql)
                    .addParameter("id_institucion", emergencia.getId_Institucion())
                    .addParameter("nombre", emergencia.getNombre())
                    .addParameter("longitud_emergencia", emergencia.getLongitud_emergencia())
                    .addParameter("latitud_emergencia", emergencia.getLatitud_emergencia())
                    .executeUpdate();

            return emergencia;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<EmergenciaEntity> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select e.id, e.id_institucion, e.nombre, e.activa, e.latitud_emergencia, e.longitud_emergencia from Emergencia e")
                    .executeAndFetch(EmergenciaEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<EmergenciaEntity> getById(Long id) {

        try(Connection conn = sql2o.open()){
            return conn.createQuery("select e.id, e.id_institucion, e.nombre, e.activa, e.latitud_emergencia, e.longitud_emergencia from Emergencia e where id= :id")
                    .addParameter("id",id)
                    .executeAndFetch(EmergenciaEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public String updateNombreEmergencia(EmergenciaEntity emergencia, Long id){
        try(Connection conn = sql2o.open()){
            String updateSql = "update Emergencia set nombre=:nombre WHERE id=:id";
            conn.createQuery(updateSql)
                    .addParameter("id", id)
                    .addParameter("nombre", emergencia.getNombre())
                    .executeUpdate();
            return "Se actualizó el nombre de la emergencia";
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return "No se pudo actualizar el nombre de la emergencia";
        }
    }

    @Override
    public void delete(Long id) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from Emergencia where id = :id ")
                    .addParameter("id",id)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
