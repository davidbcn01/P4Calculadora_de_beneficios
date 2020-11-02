package com.example.calculador_de_beneficios;

public class SimuladorCalculadora {
    public static class Solicitud {
        public double compra;
        public double venta;
        public int interes;

        public Solicitud(double compra, double venta, int interes) {
            this.compra = compra;
            this.venta = venta;
            this.interes = interes;
        }
    }

    public double calcular(Solicitud solicitud) {
        double interes = 0;
        try {
            Thread.sleep(6000);   // simular operacion de larga duracion (10s)

        } catch (InterruptedException e) {}

        return (solicitud.venta-(solicitud.venta*(solicitud.interes/100)))-solicitud.compra;
    }
}

