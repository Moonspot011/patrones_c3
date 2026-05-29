package hospital.observer;

import hospital.Paciente;

public class LaboratorioObserver implements Observer{

    @Override
    public void actualizar(Paciente paciente) {
        System.out.println("Laboratorio preparado para atender a "+paciente.getField());
    }
}
