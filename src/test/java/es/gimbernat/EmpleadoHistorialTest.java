package es.gimbernat;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EmpleadoHistorialTest {

    // 1. Historial empieza vacío
    @Test
    public void historialEmpiezaVacio() {
        Empleado e = new Empleado("Juan");
        assertEquals(0, e.getHistorial().size());
    }

    // 2. Tras fichar entrada → 1 fichaje
    @Test
    public void historialTrasEntrada() {
        Empleado e = new Empleado("Juan");

        e.ficharEntrada();

        assertEquals(1, e.getHistorial().size());
    }

    // 3. Entrada + salida → 2 fichajes
    @Test
    public void historialEntradaSalida() {
        Empleado e = new Empleado("Juan");

        e.ficharEntrada();
        e.ficharSalida();

        assertEquals(2, e.getHistorial().size());
    }

    // 4. Primer fichaje tras entrada es ENTRADA
    @Test
    public void primerFichajeEsEntrada() {
        Empleado e = new Empleado("Juan");

        e.ficharEntrada();

        assertEquals(Fichaje.Tipo.ENTRADA, e.getHistorial().get(0).getTipo());
    }

    // 5. Primer fichaje tras salida es SALIDA
    @Test
    public  void fichajeSalidaEsSalida() {
        Empleado e = new Empleado("Juan");

        e.ficharEntrada();
        e.ficharSalida();

        assertEquals(Fichaje.Tipo.SALIDA, e.getHistorial().get(1).getTipo());
    }

    // 6. No añadir fichaje si operación incorrecta
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
}