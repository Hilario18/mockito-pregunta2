package Prueba;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class CompraPbTest {
        @Test
        void testProveedorInactivoNoPermiteCompra() {
            Proveedor proveedorMock =mock(Proveedor.class);
            when(proveedorMock.isActivo()).thenReturn(false);

            Catalogo catalogoMock = mock(Catalogo.class);
            CompraService service = new CompraService(catalogoMock);

            Exception ex = assertThrows(RuntimeException.class, () -> {
                service.registrarCompra(proveedorMock, new OrdenCompra());
            });

            assertEquals("Proveedor inactivo", ex.getMessage());
        }

        @Test
        void testPrecioNoCoincideConCatalogo() {
            Catalogo catalogoMock = mock(Catalogo.class);
            when(catalogoMock.obtenerPrecio("Laptop")).thenReturn(1000.0);

            Producto producto = new Producto("Laptop", 1200.0);
            OrdenCompra orden = new OrdenCompra();
            orden.agregarProducto(producto);

            CompraService service = new CompraService(catalogoMock);

            Exception ex = assertThrows(RuntimeException.class, () -> {
                service.validarOrden(orden);
            });

            assertEquals("Precio inválido para producto: Laptop", ex.getMessage());
        }
    }
