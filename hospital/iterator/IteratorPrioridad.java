package hospital.iterator;

import hospital.decorator.Tratamiento;

public class IteratorPrioridad implements IteratorTratamientos {
    private ArbolTratamientos tratamientos;
    private int iteratorState;

    public IteratorPrioridad(ArbolTratamientos tratamientos) {
        this.tratamientos = tratamientos;
        this.iteratorState = 0;
    }

    @Override
    public Tratamiento getNext() {
        if (hasMore()) {
            return tratamientos.getTratamientos().get(iteratorState++);
        }
        return null;
    }

    @Override
    public boolean hasMore() {
        return iteratorState < tratamientos.getTratamientos().size();
    }
}
