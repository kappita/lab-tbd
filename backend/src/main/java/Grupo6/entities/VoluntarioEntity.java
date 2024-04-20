package Grupo6.entities;

public class VoluntarioEntity {

    private Long idVoluntario;
    private String nombre;
    private String email;
    private String password;
    private String rut;

    public VoluntarioEntity(Long idVoluntario, String nombre, String email, String password, String rut) {
        this.idVoluntario = idVoluntario;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.rut = rut;
    }

    public Long getIdVoluntario() {
        return idVoluntario;
    }

    public void setIdVoluntario(Long idVoluntario) {
        this.idVoluntario = idVoluntario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }
}
