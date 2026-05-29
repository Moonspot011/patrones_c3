package hospital.decorator;

public abstract class TratamientoDecorator implements Tratamiento {
    private Tratamiento wrappee;

    public TratamientoDecorator(Tratamiento wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public void aplicarTratamiento() {
        wrappee.aplicarTratamiento();
    }
}
