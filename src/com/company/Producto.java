package com.company;

import java.util.UUID;

public class Producto {
    private UUID id = UUID.randomUUID();
    private double precio;
    private String nombre;
    private int categoria;

    public Producto(double precio, String nombre, int categoria){
        this.precio = precio;
        this.nombre = nombre;
        this.categoria = categoria;
    }

    public UUID getId() {
        return id;
    }

    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCategoria() {
        return categoria;
    }
}
