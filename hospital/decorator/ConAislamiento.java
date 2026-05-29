package hospital.decorator;

public class ConAislamiento extends TratamientoDecorator {
    private String fecha;
    private String prioridad;
    private String descripcion;

    public ConAislamiento(Tratamiento wrappee) {
        super(wrappee);
    }

    @Override
    public void aplicarTratamiento() {
        super.aplicarTratamiento();
        // Additional isolation treatment logic
    }
}
