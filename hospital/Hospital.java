package hospital;

import hospital.composite.ComponenteHospitalario;
import hospital.decorator.Tratamiento;
import hospital.iterator.ArbolTratamientos;
import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private List<ComponenteHospitalario> medicos;
    private ArbolTratamientos tratamientos;

    public Hospital() {
        this.medicos = new ArrayList<>();
        this.tratamientos = new ArbolTratamientos();
    }

    public Data obtenerResultados() {
        return new Data("Resultados internos del hospital");
    }

    public void suscribirse(ComponenteHospitalario componente) {
        medicos.add(componente);
    }

    public void desuscribirse(ComponenteHospitalario componente) {
        medicos.remove(componente);
    }

    public void notificarSuscriptores(String contexto) {
        for (ComponenteHospitalario medico : medicos) {
            medico.actualizar(contexto);
        }
    }

    public void logicaPrincipalNotificacion() {
        // Lógica principal que dispara notificaciones
        notificarSuscriptores("Notificación del hospital");
    }

    public List<ComponenteHospitalario> getMedicos() {
        return medicos;
    }

    public ArbolTratamientos getTratamientos() {
        return tratamientos;
    }
}
