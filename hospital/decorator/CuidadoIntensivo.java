package hospital.decorator;

public class CuidadoIntensivo extends TratamientoDecorator {
    private String fecha;
    private String prioridad;
    private String descripcion;

    public CuidadoIntensivo(Tratamiento wrappee) {
        super(wrappee);
    }

    @Override
    public void aplicarTratamiento() {
        super.aplicarTratamiento();
        // Additional ICU treatment logic
    }
}
