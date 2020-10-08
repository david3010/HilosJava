package com.company;

import java.util.ArrayList;
import java.util.List;

public class ProductoServiceSeq {

    public void ejecutar() {
        long inicio = System.currentTimeMillis();
        double precioMin = 300D;
        double precioMax = 1500D;
        ProductosService ps = new ProductosService();
        List<Producto> productos = ps.getProductos();
        List<Producto> encontrados = new ArrayList<>();

        for (Producto p : productos) {
            if (p.getPrecio() >= precioMin && p.getPrecio() <= precioMax) {
                encontrados.add(p);
            }
        }

        long fin = System.currentTimeMillis();
        System.out.println("Productos encontrados : " + encontrados.size());
        System.out.println("Tiempo de ejecucion: " + (fin - inicio));
    }
}
