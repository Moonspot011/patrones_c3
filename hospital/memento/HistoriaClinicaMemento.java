package hospital.memento;

public class HistoriaClinicaMemento {
    private String estado;
    private String fecha;

    public HistoriaClinicaMemento(String estado) {
        this.estado = estado;
        this.fecha = java.time.LocalDateTime.now().toString();
    }

    public String getEstado() {
        return estado;
    }

    public String getFecha() {
        return fecha;
    }
}
