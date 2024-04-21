package Grupo6.VoluntariadoEmergencias.repositories;

import Grupo6.VoluntariadoEmergencias.entities.HabilidadEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class HabilidadRepositoryImp implements HabilidadRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public HabilidadEntity save(HabilidadEntity habilidad) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO Habilidad (nombre,descripcion) " +
                    "VALUES ( :nombre, :descripcion)";
            conn.createQuery(sql)
                    .addParameter("nombre", habilidad.getNombre())
                    .addParameter("descripcion", habilidad.getDescripcion())
                    .executeUpdate();

            return habilidad;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<HabilidadEntity> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Habilidad")
                    .executeAndFetch(HabilidadEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<HabilidadEntity> getById(Long id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Habilidad where id= :id")
                    .addParameter("id",id)
                    .executeAndFetch(HabilidadEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public String updateNombreHabilidad(HabilidadEntity habilidad, Long id){
        try(Connection conn = sql2o.open()){
            String updateSql = "update Habilidad set nombre=:nombre WHERE id=:id";
            conn.createQuery(updateSql)
                    .addParameter("id", id)
                    .addParameter("nombre", habilidad.getNombre())
                    .executeUpdate();
            return "Se actualizó el nombre de la habilidad";
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return "No se pudo actualizar el nombre de la habilidad";
        }
    }

    @Override
    public void delete(Long id) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from Habilidad where id = :id ")
                    .addParameter("id",id)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
