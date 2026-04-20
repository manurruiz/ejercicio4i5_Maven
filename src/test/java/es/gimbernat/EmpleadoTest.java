package es.gimbernat;

import org.junit.Test;

import static org.junit.Assert.*;


public class EmpleadoTest {


    //1. Crear un empleado con un nombre válido
    @Test
    public void EmpleadoNombreValido() {
        Empleado e = new Empleado("Manu");
        assertEquals("Manu", e.getNombre());
    }
   //2. Crear un empleado con un nombre vacío
   @Test
   public void EmpleadoNombreVacio() {
        Empleado e = new Empleado("");
        assertEquals("Sin nombre", e.getNombre());
    }
    //3. Crear un empleado con un nombre null
    @Test
    public void EmpleadoNombreNull() {
        Empleado e = new Empleado(null);
        assertEquals("Sin nombre", e.getNombre());
    }

    //4. Fichaje de entrada correcto cuando el empleado viene de fuera
    @Test
    public void FichajeCorrectoEmpleadoDeFuera() {
        Empleado e = new Empleado("Pepe");
        assertTrue(e.ficharEntrada());
    }

    //5. No permitir el fichaje de entrada dos veces seguidas
    @Test
    public void NoPermitirDobleEntrada() {
        Empleado e = new Empleado("Pepe");
        e.ficharEntrada();
        assertFalse(e.ficharEntrada());
    }

    //6. Fichaje de salida correcto cuando el empleado está en la empresa
    @Test
     public void ficharSalidaCorrecto() {
        Empleado e = new Empleado("Juan");
        e.ficharEntrada();
        assertTrue(e.ficharSalida());
    }

    //7. No permitir el fichaje de salida dos veces seguidas
    @Test
    public void noPermitirDobleSalida() {
        Empleado e = new Empleado("Juan");
        e.ficharEntrada();
        e.ficharSalida();
        assertFalse(e.ficharSalida());
    }
    //8. Comprobar que el boolean que indica si el empleado está dentro o fuera de la empresa
    //    cambia correctamente
    /**
     * Registra la entrada del empleado.
     */
    /**
     * Registra la salida del empleado.
     */
    @Test
    public void comprobarEstadoDentroFuera() {
        Empleado e = new Empleado("Juan");

        assertFalse(e.isDentroEmpresa()); // empieza fuera

        e.ficharEntrada();
        assertTrue(e.isDentroEmpresa()); // empieza dentro

        e.ficharSalida();
        assertFalse(e.isDentroEmpresa()); // vuelve a fuera
    }
    @Test
    public void testFichajeCompleto() {
        Fichaje f = new Fichaje(Fichaje.Tipo.ENTRADA);

        assertNotNull(f.getFechaHora());
        assertEquals(Fichaje.Tipo.ENTRADA, f.getTipo());
        assertTrue(f.toString().contains("ENTRADA"));
    }
}