package hospital.decorator;

public class TratamientoUrgente extends TratamientoDecorator {
    private String fecha;
    private String prioridad;
    private String descripcion;

    public TratamientoUrgente(Tratamiento wrappee) {
        super(wrappee);
    }

    @Override
    public void aplicarTratamiento() {
        super.aplicarTratamiento();
        // Additional urgent treatment logic
    }
}
