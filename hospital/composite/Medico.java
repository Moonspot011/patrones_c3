package hospital.composite;

public interface Medico extends ComponenteHospitalario {
    @Override
    void atender();

    @Override
    void actualizar(String contexto);
}
