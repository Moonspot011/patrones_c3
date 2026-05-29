package hospital.chain_of_responsibility;

import hospital.Paciente;

public class Especialista extends ManejadorPaciente{
    @Override
    public void atender(Paciente paciente) {

        if(paciente.getnivel()<=7){
            System.out.println("Paciente atendido por especialista");
        }
        else if(siguiente!=null){
            siguiente.atender(paciente);
        }
    }
}
