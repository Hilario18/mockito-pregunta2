package Prueba;

public class Proveedor {
    private String nombre;
    private boolean activo;

    public Proveedor(String nombre, boolean activo) {
        this.nombre = nombre;
        this.activo = activo;
    }

    public boolean isActivo() {
        return activo;
    }

}
