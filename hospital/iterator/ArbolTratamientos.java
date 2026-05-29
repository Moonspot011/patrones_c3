package hospital.iterator;

import hospital.decorator.Tratamiento;
import java.util.ArrayList;
import java.util.List;

public class ArbolTratamientos {
    private Tratamiento raiz;
    private List<Tratamiento> tratamientos;

    public ArbolTratamientos() {
        this.tratamientos = new ArrayList<>();
    }

    public void agregar(Tratamiento tratamiento) {
        tratamientos.add(tratamiento);
    }

    public Tratamiento getRaiz() {
        return raiz;
    }

    public void setRaiz(Tratamiento raiz) {
        this.raiz = raiz;
    }

    public List<Tratamiento> getTratamientos() {
        return tratamientos;
    }

    public IteratorTratamientos crearIteratorPrioridad() {
        return new IteratorPrioridad(this);
    }

    public IteratorTratamientos crearIteratorCronologico() {
        return new IteratorCronologico(this);
    }

    public IteratorTratamientos crearIteratorUrgencias() {
        return new IteratorUrgencias(this);
    }
}
