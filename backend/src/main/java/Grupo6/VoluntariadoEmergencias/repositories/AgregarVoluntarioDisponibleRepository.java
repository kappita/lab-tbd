package Grupo6.VoluntariadoEmergencias.repositories;

public interface AgregarVoluntarioDisponibleRepository {

    public void postularComoDisponible(Long idEmergencia, String emailVoluntario);
}
