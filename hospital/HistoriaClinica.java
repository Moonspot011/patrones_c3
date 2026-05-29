package hospital;

import hospital.memento.HistoriaClinicaMemento;

public class HistoriaClinica {
    private String estado;

    public HistoriaClinica() {
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public HistoriaClinicaMemento crearMemento() {
        return new HistoriaClinicaMemento(this.estado);
    }

    public void restaurarMemento(HistoriaClinicaMemento memento) {
        this.estado = memento.getEstado();
    }
}
