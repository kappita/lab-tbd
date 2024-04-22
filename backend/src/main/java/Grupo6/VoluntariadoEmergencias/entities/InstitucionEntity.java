package Grupo6.VoluntariadoEmergencias.entities;

public class InstitucionEntity {
    private Long idInstitucion;
    private String nombre;
    private String email;
    private String password;

    public InstitucionEntity(Long idInstitucion, String nombre, String email, String password) {
        this.idInstitucion = idInstitucion;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return idInstitucion;
    }

    public void setId(Long id) {
        this.idInstitucion = id;
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
}
