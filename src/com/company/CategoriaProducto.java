package com.company;

public enum CategoriaProducto {
    ELECTRODOMESTICOS(1),
    ELECTRONICA(2),
    VIDEOJUEGOS(3),
    DEPORTES(4),
    MODA_BELLEZA(5);

    private int tipo;

    CategoriaProducto(int tipo) {
        this.tipo = tipo;
    }

    public int getTipo(){
        return this.tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
