package Grupo6.VoluntariadoEmergencias.entities;

public class DisponibleEntity {


    private Long idDisponible;
    private Long id_voluntario;
    private Long id_emergencia;

    public DisponibleEntity(Long id, Long id_voluntario, Long id_emergencia) {
        this.idDisponible = id;
        this.id_voluntario = id_voluntario;
        this.id_emergencia = id_emergencia;
    }

    public Long getId() {
        return idDisponible;
    }

    public void setId(Long id) {
        this.idDisponible = id;
    }

    public Long getId_voluntario() {
        return id_voluntario;
    }

    public void setId_voluntario(Long id_voluntario) {
        this.id_voluntario = id_voluntario;
    }

    public Long getId_emergencia() {
        return id_emergencia;
    }

    public void setId_emergencia(Long id_emergencia) {
        this.id_emergencia = id_emergencia;
    }




}
