package hospital.memento;

import java.util.ArrayList;
import java.util.List;

public class HistorialCambios {
    private List<HistoriaClinicaMemento> listaMementos;

    public HistorialCambios() {
        this.listaMementos = new ArrayList<>();
    }

    public void agregarMemento(HistoriaClinicaMemento memento) {
        listaMementos.add(memento);
    }

    public HistoriaClinicaMemento getEstado(int index) {
        if (index >= 0 && index < listaMementos.size()) {
            return listaMementos.get(index);
        }
        return null;
    }

    public HistoriaClinicaMemento getUltimoEstado() {
        if (listaMementos.isEmpty()) {
            return null;
        }
        return listaMementos.get(listaMementos.size() - 1);
    }

    public List<HistoriaClinicaMemento> getListaMementos() {
        return listaMementos;
    }
}
