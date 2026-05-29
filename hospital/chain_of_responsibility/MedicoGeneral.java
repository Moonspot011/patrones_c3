package hospital.chain_of_responsibility;

import hospital.Paciente;

public class MedicoGeneral extends ManejadorPaciente{
    @Override
    public void atender(Paciente paciente) {

        if(paciente.getnivel()<=3){
            System.out.println("Paciente atendido por médico general");
        }
        else if(siguiente!=null){
            siguiente.atender(paciente);
        }
    }
}
