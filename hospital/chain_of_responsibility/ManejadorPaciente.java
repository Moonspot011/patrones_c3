package hospital.chain_of_responsibility;

import hospital.Paciente;

public abstract class ManejadorPaciente {
    protected ManejadorPaciente siguiente;

    public void setSiguiente(ManejadorPaciente siguiente){
        this.siguiente=siguiente;
    }
    public abstract void atender(Paciente paciente);
}
