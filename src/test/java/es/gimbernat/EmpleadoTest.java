package es.gimbernat;

import org.junit.Test;

import static org.junit.Assert.*;


public class EmpleadoTest {

    //1
    @Test
    public void EmpleadoNombreValido() {
        Empleado e = new Empleado("Manu");
        assertEquals("Manu", e.getNombre());
    }
   //2
    @Test
    public void EmpleadoNombreVacio() {
        Empleado e = new Empleado("");
        assertEquals("Sin nombre", e.getNombre());
    }
    //3
    @Test
    public void EmpleadoNombreNull() {
        Empleado e = new Empleado(null);
        assertEquals("Sin nombre", e.getNombre());
    }

    //4
    @Test
    public void FichajeCorrectoEmpleadoDeFuera() {
        Empleado e = new Empleado("Pepe");
        assertTrue(e.ficharEntrada());
    }

    //5
    @Test
    public void NoPermitirDobleEntrada() {
        Empleado e = new Empleado("Pepe");
        e.ficharEntrada();
        assertFalse(e.ficharEntrada());
    }

    //6
    @Test
     public void ficharSalidaCorrecto() {
        Empleado e = new Empleado("Juan");
        e.ficharEntrada();
        assertTrue(e.ficharSalida());
    }

    //7
    @Test
    public void noPermitirDobleSalida() {
        Empleado e = new Empleado("Juan");
        e.ficharEntrada();
        e.ficharSalida();
        assertFalse(e.ficharSalida());
    }
    //8
    @Test
    public void comprobarEstadoDentroFuera() {
        Empleado e = new Empleado("Juan");

        assertFalse(e.isDentroEmpresa()); // empieza fuera

        e.ficharEntrada();
        assertTrue(e.isDentroEmpresa()); // empieza dentro

        e.ficharSalida();
        assertFalse(e.isDentroEmpresa()); // vuelve a fuera
    }
}