package es.gimbernat;

import java.util.ArrayList;
import java.util.List;

/**
 * Representamos a  un empleado de la empresa.
 * Permite gestionar los  fichajes de entrada y salida.
 */
public class Empleado {
    private String nombre;
    private boolean dentroEmpresa;
    private List<Fichaje> historial;

    public Empleado(String nombre) {
        if (nombre == null || nombre.equals("")) {
            this.nombre = "Sin nombre";
        } else {
            this.nombre = nombre;
        }

        this.dentroEmpresa = false;
        this.historial = new ArrayList<>();
    }


    public String getNombre() {
        return nombre;
    }

    public boolean isDentroEmpresa() {
        return dentroEmpresa;
    }

    public List<Fichaje> getHistorial() {
        return historial;
    }

    /**
     * Registra la entrada del empleado.
     * @return true si se realiza correctamente, false si ya estaba dentro
     */

    /**
     * Representa un empleado de la empresa.
     * Permite gestionar fichajes de entrada y salida.
     */
    public boolean ficharEntrada(){
        if (dentroEmpresa) {
            return false;
        }

        dentroEmpresa = true;
        historial.add(new Fichaje(Fichaje.Tipo.ENTRADA));
        return true;
    }

    public boolean ficharSalida() {
        if (!dentroEmpresa) {
            return false;
        }

        dentroEmpresa = false;
        historial.add(new Fichaje(Fichaje.Tipo.SALIDA));
        return true;
    }
}