package grupo6.repositories;

import grupo6.entities.TareaEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TareaRepository {

    List<TareaEntity> findAll();
    TareaEntity findByIdTarea(Long id);
    TareaEntity save(TareaEntity t);
    TareaEntity update(TareaEntity t);
    void delete(Long id);

}
