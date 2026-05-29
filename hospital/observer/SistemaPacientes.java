package hospital.observer;

import hospital.Paciente;

import java.util.ArrayList;

public class SistemaPacientes {

    private ArrayList<Observer> observadores = new ArrayList<>();

    public void agregarObserver(Observer o){
        observadores.add(o);
    }

    public void eliminarObserver(Observer o){
        observadores.remove(o);
    }

    public void notificar(Paciente p){
        for(Observer o : observadores){
            o.actualizar(p);
        }
    }

    public void registrarPaciente(Paciente p){
        System.out.println("Paciente registrado: " + p.getField());
        notificar(p);
    }
}