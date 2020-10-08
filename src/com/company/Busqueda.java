package com.company;

import java.util.ArrayList;
import java.util.List;

public class Busqueda implements Runnable {

    public boolean enEjecucion = false;
    public List<Producto> productos;
    public List<Producto> encontrados = new ArrayList<>();
    int categoria;
    double precioMin;
    double precioMax;

    public Busqueda(double precioMin, double precioMax, List<Producto> productos) {
        super();
        this.productos = productos;
        this.precioMin = precioMin;
        this.precioMax = precioMax;
    }
    @Override
    public void run(){
        enEjecucion = true;
        for (final Producto producto : productos)  {
            if(producto.getPrecio() >= precioMin && producto.getPrecio() <= precioMax){
                encontrados.add(producto);
            }
        }
        enEjecucion = false;
    }

    public List<Producto> getBusqueda() {
        if(encontrados.size() > 0){
            return encontrados;
        }
        return new ArrayList<Producto>();
    }
}
