package hospital.observer;

import hospital.Paciente;

public abstract class EnfermeriaObserver implements Observer {

    @Override
    public void actualizar(Paciente paciente) {
        System.out.println("Enfermería recibió actualización del paciente: "+paciente.getField());
    }
}
