package trabajo3.ventas.modelo;

import java.util.ArrayDeque;
import java.util.Deque;

public class CarteraDeVentas {

    private String nombre;
    private String responsable;
    private EnumVenta tipoVenta;
    private Categoria categoria;
    // Deque para guardar los objetos de la clase Venta
    private Deque<Venta> ventas = new ArrayDeque<>();

    public CarteraDeVentas() {
    }

    public CarteraDeVentas(String nombre, String responsable, EnumVenta tipoVenta, Categoria categoria) {
        this.nombre = nombre;
        this.responsable = responsable;
        this.tipoVenta = tipoVenta;
        this.categoria = categoria;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public void setTipoVenta(EnumVenta tipoVenta) {
        this.tipoVenta = tipoVenta;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setVentas(Deque<Venta> ventas) {
        this.ventas = ventas;
    }

    public String getNombre() {
        return nombre;
    }

    public String getResponsable() {
        return responsable;
    }

    public EnumVenta getTipoVenta() {
        return tipoVenta;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Deque<Venta> getVentas() {
        return ventas;
    }

    // Metodo para agregar los datos al Deque de objetos Venta
    public void agregarVenta(Venta venta) {
        ventas.add(venta);
    }

}
