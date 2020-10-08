package com.company;

public class Main {

    public static void main(String[] args) {

        ProductosService p = new ProductosService();
        p.ejecutar();


        ProductoServiceSeq p2 = new ProductoServiceSeq();
        p2.ejecutar();

    }
}
