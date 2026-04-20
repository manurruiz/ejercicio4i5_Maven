package es.gimbernat;


import org.junit.Test;

import static org.junit.Assert.*;

public class EmpleadoHistorialTest {

    // 1. Al crear un empleado, el historial está vacío
    @Test
    public void historialEmpiezaVacio() {
        Empleado e = new Empleado("Juan");
        assertEquals(0, e.getHistorial().size());
    }

    // 2. Después de un fichaje de entrada correcto, el historial tiene un fichaje
    @Test
    public void historialTrasEntrada() {
        Empleado e = new Empleado("Juan");

        e.ficharEntrada();

        assertEquals(1, e.getHistorial().size());
    }

    // 3. Después de un fichaje de entrada y un fichaje de salida correctos, el historial tiene dos
    //fichajes.
    @Test
    public void historialEntradaSalida() {
        Empleado e = new Empleado("Juan");

        e.ficharEntrada();
        e.ficharSalida();

        assertEquals(2, e.getHistorial().size());
    }

    // 4.El primer fichaje registrado después de ficharEntrada() es de tipo ENTRADA
    @Test
    public void primerFichajeEsEntrada() {
        Empleado e = new Empleado("Juan");

        e.ficharEntrada();

        assertEquals(Fichaje.Tipo.ENTRADA, e.getHistorial().get(0).getTipo());
    }

    // 5. El primer fichaje registrado después de ficharSalida() es de tipo SALIDA.
    @Test
    public  void fichajeSalida() {
        Empleado e = new Empleado("Juan");

        e.ficharEntrada();
        e.ficharSalida();

        assertEquals(Fichaje.Tipo.SALIDA, e.getHistorial().get(1).getTipo());
    }

    // 6.Después de un fichaje de entrada o un fichaje de salida incorrectos, no se añaden fichajes al
    //historial.
    @Test
    public void noAñadeFichajeSiIncorrecto() {
        Empleado e = new Empleado("Juan");

        // Intentar salida sin haber entrado
        e.ficharSalida();
        assertEquals(0, e.getHistorial().size());

        // Entrada correcta
        e.ficharEntrada();
        assertEquals(1, e.getHistorial().size());

        // Intentar otra entrada (incorrecta)
        e.ficharEntrada();
        assertEquals(1, e.getHistorial().size());
    }
    @Test
    public void testFichajeToStringYFecha() {
        Fichaje f = new Fichaje(Fichaje.Tipo.ENTRADA);

        assertNotNull(f.getFechaHora());
        assertTrue(f.toString().contains("ENTRADA"));
    }
}