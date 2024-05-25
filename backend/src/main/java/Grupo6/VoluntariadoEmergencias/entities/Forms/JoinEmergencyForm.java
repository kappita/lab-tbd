package Grupo6.VoluntariadoEmergencias.entities.Forms;

public class JoinEmergencyForm {
    private String token;
    private Long id_emergencia;

    public JoinEmergencyForm(String token, Long id_emergencia) {
        this.token = token;
        this.id_emergencia = id_emergencia;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getId_emergencia() {
        return id_emergencia;
    }

    public void setId_emergencia(Long id_emergencia) {
        this.id_emergencia = id_emergencia;
    }
}
