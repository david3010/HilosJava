package com.company;

public class Main {

    public static void main(String[] args) {

        double precioMin = 0D;
        double precioMax = 150D;

        ProductosService p = new ProductosService();
        p.ejecutar(precioMin, precioMax);

        ProductoServiceSeq p2 = new ProductoServiceSeq();
        p2.ejecutar(precioMin, precioMax);

    }
}
