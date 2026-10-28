package trabajo3.ventas.modelo;

import java.util.Stack;
import java.util.function.Function;

public class Venta {

    private String producto;
    private double precio;
    private String cliente;
    private EnumVenta tipoVenta;
    private Categoria categoria;
    // El Stack conteo sirve para contar las unidades vendidas en cada transaccion
    private Stack<Integer> conteo = new Stack<>();

    public Venta() {
    }

    public Venta(String producto, double precio, String cliente, EnumVenta tipoVenta, Categoria categoria) {
        this.producto = producto;
        this.precio = precio;
        this.cliente = cliente;
        this.tipoVenta = tipoVenta;
        this.categoria = categoria;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setTipoVenta(EnumVenta tipoVenta) {
        this.tipoVenta = tipoVenta;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setConteo(Stack<Integer> conteo) {
        this.conteo = conteo;
    }

    public String getProducto() {
        return producto;
    }

    public double getPrecio() {
        return precio;
    }

    public String getCliente() {
        return cliente;
    }

    public EnumVenta getTipoVenta() {
        return tipoVenta;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Stack<Integer> getConteo() {
        return conteo;
    }

    // Metodo para agregar los datos al Stack de numeros llamado conteo
    public void agregarConteo(int dato) {
        conteo.push(dato);
    }

    // Metodo del PUNTO5 que recibe la funcion del PUNTO4 y muestra el total
    public String verTotales(Function<Venta, Integer> totalizar) {
        return "El total de unidades del producto " + producto + " es: " + totalizar.apply(this);
    }

    @Override
    public String toString() {
        return producto + ", $" + precio + ", " + cliente + ", " + tipoVenta + ", " + categoria + ", conteo=" + conteo;
    }

}
