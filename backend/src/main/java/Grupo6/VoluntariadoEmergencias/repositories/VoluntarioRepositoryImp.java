package Grupo6.VoluntariadoEmergencias.repositories;

import Grupo6.VoluntariadoEmergencias.entities.VoluntarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class VoluntarioRepositoryImp implements VoluntarioRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public VoluntarioEntity save(VoluntarioEntity voluntario) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO Voluntario (nombre,email,password,rut) " +
                    "VALUES (:nombre,:email,:password,:rut)";
            conn.createQuery(sql)
                    .addParameter("nombre", voluntario.getNombre())
                    .addParameter("email", voluntario.getEmail())
                    .addParameter("password", voluntario.getPassword())
                    .addParameter("rut", voluntario.getRut())
                    .executeUpdate();

            return voluntario;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<VoluntarioEntity> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from voluntario")
                    .executeAndFetch(VoluntarioEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<VoluntarioEntity> getById(Long id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Voluntario where id= :id")
                    .addParameter("id",id)
                    .executeAndFetch(VoluntarioEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public String update(VoluntarioEntity voluntario, Long id){
        try(Connection conn = sql2o.open()){
            String updateSql = "update Voluntario set nombre=:nombre WHERE id=:id";
            conn.createQuery(updateSql)
                    .addParameter("id", id)
                    .addParameter("nombre", voluntario.getNombre())
                    .executeUpdate();
            return "Se actualizó el nombre del voluntario";
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return "No se pudo actualizar el nombre del voluntario";
        }
    }

    @Override
    public void delete(Long id) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from Voluntario where id = :id ")
                    .addParameter("id",id)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public VoluntarioEntity getByEmail(String email) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Voluntario where email = :email")
                    .addParameter("email", email)
                    .executeAndFetchFirst(VoluntarioEntity.class);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
