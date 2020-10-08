package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProductosService {

    List<Producto> productos;

    Producto e1 = new Producto(12.50D, "Labial", CategoriaProducto.MODA_BELLEZA.getTipo());
    Producto e2 = new Producto(1500.00D, "Planca para el cabello", CategoriaProducto.MODA_BELLEZA.getTipo());
    Producto e3 = new Producto(600.00D, "Maquillaje", CategoriaProducto.MODA_BELLEZA.getTipo());
    Producto e4 = new Producto(30.00D, "Brocha para la cara", CategoriaProducto.MODA_BELLEZA.getTipo());
    Producto e5 = new Producto(120.00D, "Rimel", CategoriaProducto.MODA_BELLEZA.getTipo());

    Producto e6 = new Producto(345.00D, "Balón", CategoriaProducto.DEPORTES.getTipo());
    Producto e7 = new Producto(600.00D, "Short", CategoriaProducto.DEPORTES.getTipo());
    Producto e8 = new Producto(450.00D, "Camisa", CategoriaProducto.DEPORTES.getTipo());
    Producto e9 = new Producto(1450.50D, "Jersey", CategoriaProducto.DEPORTES.getTipo());
    Producto e10 = new Producto(120.00D, "Espinillera", CategoriaProducto.DEPORTES.getTipo());

    Producto e11 = new Producto(1680.50D, "COD ColdWar", CategoriaProducto.VIDEOJUEGOS.getTipo());
    Producto e12 = new Producto(1500.00D, "Halo 9", CategoriaProducto.VIDEOJUEGOS.getTipo());
    Producto e13 = new Producto(1800.00D, "Fifa 21", CategoriaProducto.VIDEOJUEGOS.getTipo());
    Producto e14 = new Producto(1450.00D, "God of War", CategoriaProducto.VIDEOJUEGOS.getTipo());
    Producto e15 = new Producto(2000.00D, "CyberPunk", CategoriaProducto.VIDEOJUEGOS.getTipo());

    Producto e16 = new Producto(5000.00D, "Redmi note 8", CategoriaProducto.ELECTRONICA.getTipo());
    Producto e17 = new Producto(20000.00D, "Samsung Galaxy S20", CategoriaProducto.ELECTRONICA.getTipo());
    Producto e18 = new Producto(22000.50D, "Iphone 11", CategoriaProducto.ELECTRONICA.getTipo());
    Producto e19 = new Producto(30000.00D, "Samsung Galaxy Note 20", CategoriaProducto.ELECTRONICA.getTipo());
    Producto e20 = new Producto(23000.00D, "Huawei p40", CategoriaProducto.ELECTRONICA.getTipo());

    Producto e316 = new Producto(16000.00D, "Refrigerador", CategoriaProducto.ELECTRODOMESTICOS.getTipo());
    Producto e5417 = new Producto(8500.00D, "Estufa", CategoriaProducto.ELECTRODOMESTICOS.getTipo());
    Producto e518 = new Producto(3500.00D, "Television 21''", CategoriaProducto.ELECTRODOMESTICOS.getTipo());
    Producto e619 = new Producto(1500D, "Mini componente", CategoriaProducto.ELECTRODOMESTICOS.getTipo());
    Producto e720 = new Producto(1800D, "Teátro en casa", CategoriaProducto.ELECTRODOMESTICOS.getTipo());
    Producto[] elementos = new Producto[]{e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11,
            e12, e13, e14, e15, e16, e17, e18, e19, e20, e316, e5417, e518, e619, e720};

    public List<Producto> getProductos() {
        productos = Arrays.asList(elementos);
        return productos;
    }

    public void ejecutar(double precioMin, double precioMax) {
        ProductosService p = new ProductosService();
        List<Producto> productos = p.getProductos();
        List<Producto> encontrados = new ArrayList<>();

        List<Producto> ELECTRONICA = productos
                .stream().filter(producto ->
                        producto.getCategoria() == CategoriaProducto.ELECTRONICA.getTipo()).collect(
                        Collectors.toList());

        List<Producto> MODA_BELLEZA = productos
                .stream().filter(producto ->
                        producto.getCategoria() == CategoriaProducto.MODA_BELLEZA.getTipo()).collect(
                        Collectors.toList());

        List<Producto> DEPORTES = productos
                .stream().filter(producto ->
                        producto.getCategoria() == CategoriaProducto.DEPORTES.getTipo()).collect(
                        Collectors.toList());

        List<Producto> ELECTRODOMESTICOS = productos
                .stream().filter(producto ->
                        producto.getCategoria() == CategoriaProducto.ELECTRODOMESTICOS.getTipo()).collect(
                        Collectors.toList());

        List<Producto> VIDEOJUEGOS = productos
                .stream().filter(producto ->
                        producto.getCategoria() == CategoriaProducto.VIDEOJUEGOS.getTipo()).collect(
                        Collectors.toList());

        Busqueda r5 = new Busqueda(precioMin, precioMax, ELECTRONICA);
        Busqueda r1 = new Busqueda(precioMin, precioMax, MODA_BELLEZA);
        Busqueda r2 = new Busqueda(precioMin, precioMax, DEPORTES);
        Busqueda r3 = new Busqueda(precioMin, precioMax, ELECTRODOMESTICOS);
        Busqueda r4 = new Busqueda(precioMin, precioMax, VIDEOJUEGOS);
        long inicio = System.currentTimeMillis();
        Thread t1 = new Thread(r1);
        t1.start();
        Thread t2 = new Thread(r2);
        t2.start();
        Thread t3 = new Thread(r3);
        t3.start();
        Thread t4 = new Thread(r4);
        t4.start();
        Thread t5 = new Thread(r5);
        t5.start();

        do {
            System.out.println("Buscando...");
        } while (r1.enEjecucion || r2.enEjecucion || r3.enEjecucion || r4.enEjecucion || r5.enEjecucion);

        encontrados.addAll(r1.getBusqueda());
        encontrados.addAll(r2.getBusqueda());
        encontrados.addAll(r3.getBusqueda());
        encontrados.addAll(r4.getBusqueda());
        encontrados.addAll(r5.getBusqueda());

        long fin = System.currentTimeMillis();
        System.out.println("Productos encontrados: " + encontrados.size());
        System.out.println("Tiempo de ejecucion : " + (fin - inicio));
    }

}
