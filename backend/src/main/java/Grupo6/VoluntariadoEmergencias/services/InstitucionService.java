package Grupo6.VoluntariadoEmergencias.services;

import Grupo6.VoluntariadoEmergencias.entities.Forms.LoginForm;
import Grupo6.VoluntariadoEmergencias.Responses.Login;
import Grupo6.VoluntariadoEmergencias.entities.InstitucionEntity;
import Grupo6.VoluntariadoEmergencias.entities.VoluntarioEntity;
import Grupo6.VoluntariadoEmergencias.repositories.InstitucionRepository;
import Grupo6.VoluntariadoEmergencias.repositories.JWTMiddlewareRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstitucionService {
    private final InstitucionRepository institucionRepository;

    @Autowired
    private JWTMiddlewareRepositoryImp JWT;

    InstitucionService(InstitucionRepository institucionRepository){
        this.institucionRepository = institucionRepository;
    }

    public InstitucionEntity crearInstitucion( InstitucionEntity institucion){
        InstitucionEntity inst = institucionRepository.save(institucion);
        return inst;
    }
    // get R

    public List<InstitucionEntity> getAllInstituciones(){
        return institucionRepository.getAll();
    }
    //get by

    public List<InstitucionEntity> getInstitucionById( Long id){
        return institucionRepository.getById(id);
    }


    // actualizar U

    public String updateInstitucion( InstitucionEntity institucion, Long id){
        String retorno = institucionRepository.update(institucion,id);
        return retorno;
    }

    // borrar D

    public void deleteInstitucion(Long id){
        institucionRepository.delete(id);
    }

    public Login login(LoginForm form) {
        VoluntarioEntity vol = institucionRepository.getByEmail(form.getEmail());
        if (vol == null) {
            return new Login(false, null);
        }
        if (!form.getPassword().equals(vol.getPassword())) {
            return new Login(false, null);
        }

        String jwt = JWT.generateToken(form);
        return new Login(true, jwt);
    }

}
