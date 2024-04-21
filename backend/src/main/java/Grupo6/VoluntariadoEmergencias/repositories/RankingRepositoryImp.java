package Grupo6.VoluntariadoEmergencias.repositories;

import Grupo6.VoluntariadoEmergencias.entities.RankingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class RankingRepositoryImp implements RankingRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public RankingEntity save(RankingEntity ranking) {
        try (Connection conn = sql2o.open()) {
            String sql = "INSERT INTO Ranking (id_voluntario,id_tarea,ranking) " +
                    "VALUES (:id_voluntario, :id_tarea, :ranking)";
            conn.createQuery(sql)
                    .addParameter("id_voluntario", ranking.getId_Voluntario())
                    .addParameter("id_tarea", ranking.getId_Tarea())
                    .addParameter("ranking", ranking.getRanking())
                    .executeUpdate();

            return ranking;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<RankingEntity> getAll() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Ranking")
                    .executeAndFetch(RankingEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<RankingEntity> getById(Long id) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Ranking where id= :id")
                    .addParameter("id",id)
                    .executeAndFetch(RankingEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<RankingEntity> getByIdTarea(Long id_tarea) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Ranking where id_tarea= :id_tarea")
                    .addParameter("id_tarea",id_tarea)
                    .executeAndFetch(RankingEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public List<RankingEntity> getByIdVoluntario(Long id_voluntario) {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Ranking where id_voluntario= :id_voluntario")
                    .addParameter("id_voluntario",id_voluntario)
                    .executeAndFetch(RankingEntity.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public String updatePosicionRanking(RankingEntity ranking, Long id){
        try(Connection conn = sql2o.open()){
            String updateSql = "update Ranking set ranking =:puntaje WHERE id=:id";
            conn.createQuery(updateSql)
                    .addParameter("id", id)
                    .addParameter("puntaje", ranking.getRanking())
                    .executeUpdate();
            return "Se actualizó la posicion en el ranking";
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return "No se pudo actualizar la posicion en el ranking";
        }
    }

    @Override
    public void delete(Long id) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("DELETE from Ranking where id = :id ")
                    .addParameter("id",id)
                    .executeUpdate();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
