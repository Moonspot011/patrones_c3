package hospital.chain_of_responsibility;

import hospital.Paciente;

public class UCI extends ManejadorPaciente{
    @Override
    public void atender(Paciente paciente) {
        System.out.println("Paciente enviado a UCI");
    }
}
