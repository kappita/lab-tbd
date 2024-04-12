package grupo6.services;

import grupo6.entities.VoluntarioEntity;
import grupo6.repositories.VoluntarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@Service
public class VoluntarioService {

    @Autowired
    private VoluntarioRepository voluntarioRepository;

    public List<VoluntarioEntity> getVoluntarios(){
        return (List<VoluntarioEntity>) voluntarioRepository.findAll();
    }

    public VoluntarioEntity saveVoluntario(VoluntarioEntity voluntario){
        return voluntarioRepository.save(voluntario);
    }

    public VoluntarioEntity getVoluntarioById(Long id){
        return voluntarioRepository.findById(id);
    }

    public VoluntarioEntity updateVoluntario(VoluntarioEntity voluntario) {
        return voluntarioRepository.update(voluntario);
    }

    public boolean deleteVoluntario(Long id) throws Exception {
        try{
            voluntarioRepository.delete(id);
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
