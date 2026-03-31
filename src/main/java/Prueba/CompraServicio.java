package Prueba;

/**
 * Servicio de compras
 * Valida proveedores y ordenes de compra contra catalogo.
 */
public class CompraServicio {
    private Catalogo catalogo;

    public CompraServicio(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

    /**
     * Registrar una compra:
     * - Proveedor debe estar activo
     * - Orden debe ser valida contra catalogo
     */
    public void registrarCompra(Proveedor proveedor, OrdenCompra orden) {
        if (!proveedor.isActivo()) {
            throw new RuntimeException("Proveedor inactivo");
        }
        validarOrden(orden);
    }

    /**
     * Validar precios de productos contra catalogo
     */
    public void validarOrden(OrdenCompra orden) {
        for (Producto p : orden.getProductos()) {
            double precioCatalogo = catalogo.obtenerPrecio(p.getNombre());
            if (p.getPrecio() != precioCatalogo) {
                throw new RuntimeException("Precio inválido para producto: " + p.getNombre());
            }
        }
    }

}
