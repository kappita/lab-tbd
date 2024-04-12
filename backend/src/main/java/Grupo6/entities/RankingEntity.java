package Grupo6.entities;

public class RankingEntity {


    private Long idRanking;
    private Long idVoluntario;
    private Long idTarea;
    private int puntaje;

    public RankingEntity(Long idRanking, Long idVoluntario, Long idTarea, int puntaje) {
        this.idRanking = idRanking;
        this.idVoluntario = idVoluntario;
        this.idTarea = idTarea;
        this.puntaje = puntaje;
    }

    public Long getIdRanking() {
        return idRanking;
    }

    public void setIdRanking(Long idRanking) {
        this.idRanking = idRanking;
    }

    public Long getIdVoluntario() {
        return idVoluntario;
    }

    public void setIdVoluntario(Long idVoluntario) {
        this.idVoluntario = idVoluntario;
    }

    public Long getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(Long idTarea) {
        this.idTarea = idTarea;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

}
