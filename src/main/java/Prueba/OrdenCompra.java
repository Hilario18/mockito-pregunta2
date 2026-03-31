package Prueba;

import java.util.ArrayList;
import java.util.List;

public class OrdenCompra {
    private List<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public List<Producto> getProductos() {
        return productos;
    }

}
