package es.gimbernat;

import java.time.LocalDateTime;

public class Fichaje {
    private Tipo tipo;
    private LocalDateTime fechaHora;

    public enum Tipo {
        ENTRADA, SALIDA
    }

    public Fichaje(Tipo tipo) {
        this.tipo = tipo;
        this.fechaHora = LocalDateTime.now();
    }

   public Tipo getTipo() {
        return tipo;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    @Override
    public String toString() {
        return "Fichaje: " + "tipo=" + tipo +
                ", fechaHora=" + fechaHora;
    }
}