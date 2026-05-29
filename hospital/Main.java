package hospital;

import hospital.builder.BuilderHCCita;
import hospital.facade.HospitalFacade;
import hospital.composite.Departamento;
import hospital.composite.Cardiologo;
import hospital.composite.Neurologo;
import hospital.adapter.SistemaLaboratorioExterno;
import hospital.adapter.LaboratorioAdapter;
import hospital.decorator.Tratamiento;
import hospital.decorator.ServicioBasico;
import hospital.decorator.TratamientoUrgente;
import hospital.decorator.CuidadoIntensivo;
import hospital.decorator.ConAislamiento;
import hospital.iterator.ArbolTratamientos;
import hospital.iterator.IteratorTratamientos;
import hospital.memento.HistoriaClinicaMemento;
import hospital.memento.HistorialCambios;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== INICIANDO PRUEBAS DEL SISTEMA HOSPITALARIO ===\n");

        // 1. Prueba del Patrón Facade y Builder (sin Director)
        System.out.println("--- Prueba de Patrones Facade y Builder ---");
        Persona paciente = new Persona("Juan Pérez");
        BuilderHCCita builderCita = new BuilderHCCita(paciente);
        HospitalFacade facade = new HospitalFacade(builderCita);
        
        System.out.println("Ejecutando registrarNuevoPaciente() desde el Facade...");
        facade.registrarNuevoPaciente();
        HistoriaClinica hc = builderCita.getResultado();
        System.out.println("Historia Clínica construida en memoria para: " + paciente.getName() + ".\n");

        // 2. Prueba del Patrón Composite + Observer
        System.out.println("--- Prueba del Patrón Composite + Observer ---");
        Hospital hospital = new Hospital();
        Departamento deptoCardiologia = new Departamento();
        Cardiologo c1 = new Cardiologo();
        Neurologo n1 = new Neurologo();
        
        deptoCardiologia.addHijo(c1);
        deptoCardiologia.addHijo(n1);
        
        // Observer: suscribir componentes al hospital
        hospital.suscribirse(c1);
        hospital.suscribirse(n1);
        
        System.out.println("Llamando a atender() en el Departamento (Composite)...");
        deptoCardiologia.atender();
        
        System.out.println("Notificando a suscriptores (Observer)...");
        hospital.logicaPrincipalNotificacion();
        System.out.println("Atención y notificación completadas.\n");

        // 3. Prueba del Patrón Adapter
        System.out.println("--- Prueba del Patrón Adapter ---");
        SistemaLaboratorioExterno sistemaExterno = new SistemaLaboratorioExterno();
        LaboratorioAdapter adapter = new LaboratorioAdapter(sistemaExterno);
        
        System.out.println("Llamando a obtenerResultados() en el Adapter...");
        Data dataAdapter = adapter.obtenerResultados();
        System.out.println("Datos obtenidos a través del adaptador (JSON convertido a Data): " + dataAdapter.getContent() + "\n");

        // 4. Prueba del Patrón Decorator (Tratamiento en vez de Cita)
        System.out.println("--- Prueba del Patrón Decorator ---");
        Tratamiento tratamientoBase = new ServicioBasico();
        Tratamiento tratamientoUrgente = new TratamientoUrgente(tratamientoBase);
        Tratamiento tratamientoCompleto = new CuidadoIntensivo(tratamientoUrgente);
        Tratamiento tratamientoAislado = new ConAislamiento(tratamientoBase);
        
        System.out.println("Aplicando tratamiento decorado (ServicioBasico -> TratamientoUrgente -> CuidadoIntensivo)...");
        tratamientoCompleto.aplicarTratamiento();
        System.out.println("Aplicando tratamiento con aislamiento (ServicioBasico -> ConAislamiento)...");
        tratamientoAislado.aplicarTratamiento();
        System.out.println("Lógica de decoración ejecutada.\n");

        // 5. Prueba del Patrón Iterator
        System.out.println("--- Prueba del Patrón Iterator ---");
        ArbolTratamientos arbol = new ArbolTratamientos();
        arbol.agregar(tratamientoBase);
        arbol.agregar(tratamientoUrgente);
        arbol.agregar(tratamientoCompleto);
        
        System.out.println("Iterando tratamientos por prioridad...");
        IteratorTratamientos iterPrioridad = arbol.crearIteratorPrioridad();
        while (iterPrioridad.hasMore()) {
            Tratamiento t = iterPrioridad.getNext();
            System.out.println("  Tratamiento: " + t.getClass().getSimpleName());
        }
        
        System.out.println("Iterando tratamientos cronológicamente...");
        IteratorTratamientos iterCrono = arbol.crearIteratorCronologico();
        while (iterCrono.hasMore()) {
            Tratamiento t = iterCrono.getNext();
            System.out.println("  Tratamiento: " + t.getClass().getSimpleName());
        }
        System.out.println();

        // 6. Prueba del Patrón Memento
        System.out.println("--- Prueba del Patrón Memento ---");
        hc.setEstado("Estado inicial - Diagnóstico pendiente");
        System.out.println("Estado actual: " + hc.getEstado());
        
        HistorialCambios historial = new HistorialCambios();
        historial.agregarMemento(hc.crearMemento());
        
        hc.setEstado("Estado actualizado - Diagnóstico: Hipertensión");
        System.out.println("Estado modificado: " + hc.getEstado());
        historial.agregarMemento(hc.crearMemento());
        
        hc.setEstado("Estado final - Tratamiento asignado");
        System.out.println("Estado modificado: " + hc.getEstado());
        
        // Restaurar al estado anterior
        HistoriaClinicaMemento mementoAnterior = historial.getUltimoEstado();
        hc.restaurarMemento(mementoAnterior);
        System.out.println("Estado restaurado (Memento): " + hc.getEstado() + "\n");

        System.out.println("=== PRUEBAS COMPLETADAS ===");
    }
}
