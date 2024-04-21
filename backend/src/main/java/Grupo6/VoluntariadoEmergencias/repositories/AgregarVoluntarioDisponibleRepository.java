package Grupo6.VoluntariadoEmergencias.repositories;

public interface AgregarVoluntarioDisponibleRepository {

    public void postularComoDisponible(int idEmergencia, String emailVoluntario);
}
