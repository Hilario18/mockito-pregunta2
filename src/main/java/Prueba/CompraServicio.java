package Prueba;

public class CompraServicio {
    private Catalogo catalogo;

    public CompraServicio(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

    public void registrarCompra(Proveedor proveedor, OrdenCompra orden) {
        if (!proveedor.isActivo()) {
            throw new RuntimeException("Proveedor inactivo");
        }
        validarOrden(orden);
    }

    public void validarOrden(OrdenCompra orden) {
        for (Producto p : orden.getProductos()) {
            double precioCatalogo = catalogo.obtenerPrecio(p.getNombre());
            if (p.getPrecio() != precioCatalogo) {
                throw new RuntimeException("Precio inválido para producto: " + p.getNombre());
            }
        }
    }

}
