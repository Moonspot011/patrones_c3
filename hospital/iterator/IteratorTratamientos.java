package hospital.iterator;

import hospital.decorator.Tratamiento;

public interface IteratorTratamientos {
    Tratamiento getNext();
    boolean hasMore();
}
