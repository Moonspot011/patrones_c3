package hospital.observer;

import hospital.Paciente;

public class FacturacionObserver implements Observer{
    @Override
    public void actualizar(Paciente paciente) {
        System.out.println("Facturación inició proceso para: "+paciente.getField());
    }
}
