package hospital.facade;

import hospital.builder.BuilderHistoriaClinica;

public class HospitalFacade {
    private BuilderHistoriaClinica builder;

    public HospitalFacade(BuilderHistoriaClinica builder) {
        this.builder = builder;
    }

    public void registrarNuevoPaciente() {
        builder.reset();
        builder.agregarDatos();
        builder.agregarDiagnostico();
    }
}
