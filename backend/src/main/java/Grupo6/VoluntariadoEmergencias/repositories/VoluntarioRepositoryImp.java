package Grupo6.VoluntariadoEmergencias.repositories;

import Grupo6.VoluntariadoEmergencias.Utils.Encrypter;
import Grupo6.VoluntariadoEmergencias.entities.VoluntarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VoluntarioRepositoryImp implements VoluntarioRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public VoluntarioEntity save(VoluntarioEntity voluntario) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO Voluntario (nombre,email, password, rut, longitud_voluntario, latitud_voluntario, ubicacion_voluntario) " +
                    "VALUES (:nombre, :email, :password, :rut, :longitud_voluntario, :latitud_voluntario, ST_SetSRID(ST_MakePoint(:longitud_voluntario, :latitud_voluntario), 4326))";
            conn.createQuery(sql)
                    .addParameter("nombre", voluntario.getNombre())
                    .addParameter("email", voluntario.getEmail())
                    .addParameter("password", Encrypter.encrypt(voluntario.getPassword(),voluntario.getEmail()))
                    .addParameter("rut", voluntario.getRut())
                    .addParameter("longitud_voluntario", voluntario.getLongitud_voluntario())
                    .addParameter("latitud_voluntario", voluntario.getLatitud_voluntario())
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
            return conn.createQuery("select v.id, v.nombre, v.email, v.password, v.rut, v.latitud_voluntario, v.longitud_voluntario from voluntario v")
                    .executeAndFetch(VoluntarioEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<VoluntarioEntity> getById(Long id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select v.id, v.nombre, v.email, v.password, v.rut, v.latitud_voluntario, v.longitud_voluntario from Voluntario v where id= :id")
                    .addParameter("id",id)
                    .executeAndFetch(VoluntarioEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<VoluntarioEntity> getByUbicacionCercana(Long idEmergencia, int cantidad) {
        String sql = "SELECT v.id, v.nombre, v.email, v.password, v.rut, v.latitud_voluntario, v.longitud_voluntario " +
                "FROM voluntario v " +
                "JOIN emergencia e ON e.id = :idEmergencia " +
                "ORDER BY ST_Distance(e.ubicacion_emergencia, v.ubicacion_voluntario) ASC " +
                "LIMIT :cantidad";

        List<VoluntarioEntity> voluntarios = new ArrayList<>();

        try (Connection conn = sql2o.open()) {
            Query query = conn.createQuery(sql)
                    .addParameter("idEmergencia", idEmergencia)
                    .addParameter("cantidad", cantidad);

            List<VoluntarioEntity> result = query.executeAndFetch(VoluntarioEntity.class);

            voluntarios.addAll(result);
        } catch (Exception e) {
            System.out.println("Error al obtener voluntarios cercanos: " + e.getMessage());
        }

        return voluntarios;
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
