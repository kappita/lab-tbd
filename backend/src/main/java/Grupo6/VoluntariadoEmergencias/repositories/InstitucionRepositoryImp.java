package Grupo6.VoluntariadoEmergencias.repositories;

import Grupo6.VoluntariadoEmergencias.entities.InstitucionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

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

    @Override
    public List<InstitucionEntity> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Institucion")
                    .executeAndFetch(InstitucionEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<InstitucionEntity> getById(Long id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Institucion where id= :id")
                    .addParameter("id",id)
                    .executeAndFetch(InstitucionEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public String update(InstitucionEntity institucion, Long id){
        try(Connection conn = sql2o.open()){
            String updateSql = "update Institucion set nombre=:nombre WHERE id=:id";
            conn.createQuery(updateSql)
                    .addParameter("id", id)
                    .addParameter("nombre", institucion.getNombre())
                    .executeUpdate();
            return "Se actualizó el nombre de la institucion";
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return "No se pudo actualizar el nombre de la institucion";
        }
    }

    @Override
    public void delete(Long id) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from Institucion where id = :id ")
                    .addParameter("id",id)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
