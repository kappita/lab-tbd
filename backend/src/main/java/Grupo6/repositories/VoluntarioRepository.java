package grupo6.repositories;

import grupo6.entities.VoluntarioEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoluntarioRepository {

    List<VoluntarioEntity> findAll();
    VoluntarioEntity findById(Long id);
    VoluntarioEntity save(VoluntarioEntity voluntario);
    VoluntarioEntity update(VoluntarioEntity voluntario);
    void delete(Long id);
}
