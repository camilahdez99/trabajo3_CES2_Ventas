package trabajo3.ventas.repositories;

import trabajo3.ventas.modelo.Categoria;
import trabajo3.ventas.modelo.CarteraDeVentas;
import trabajo3.ventas.modelo.EnumVenta;
import trabajo3.ventas.modelo.Venta;

import java.util.Stack;

public class Ventas {

    // Los 5 objetos Venta, todos con los mismos tipos de enum
    public static final Venta venta1 = new Venta("Balon de futbol", 50000, "Carlos", EnumVenta.ONLINE, Categoria.DEPORTES);
    public static final Venta venta2 = new Venta("Camiseta deportiva", 80000, "Diana", EnumVenta.ONLINE, Categoria.DEPORTES);
    public static final Venta venta3 = new Venta("Tenis para correr", 220000, "Miguel", EnumVenta.ONLINE, Categoria.DEPORTES);
    public static final Venta venta4 = new Venta("Gorra", 40000, "Valentina", EnumVenta.ONLINE, Categoria.DEPORTES);
    public static final Venta venta5 = new Venta("Termo", 30000, "Camilo", EnumVenta.ONLINE, Categoria.DEPORTES);

    // Stack con los 5 objetos
    public static final Stack<Venta> ventas = new Stack<>();

    // Objeto de la clase de la columna F, con los mismos tipos de enum
    public static final CarteraDeVentas cartera =
            new CarteraDeVentas("Cartera deportiva", "Maria Camila", EnumVenta.ONLINE, Categoria.DEPORTES);

    static {
        // Se llena el Stack conteo de cada objeto con varios datos enteros
        venta1.agregarConteo(1);
        venta1.agregarConteo(2);
        venta1.agregarConteo(3);

        venta2.agregarConteo(5);
        venta2.agregarConteo(5);

        venta3.agregarConteo(10);

        venta4.agregarConteo(2);
        venta4.agregarConteo(4);
        venta4.agregarConteo(6);
        venta4.agregarConteo(8);

        // venta5 queda sin datos en el Stack conteo

        // Se crea el Stack con los 5 objetos
        ventas.push(venta1);
        ventas.push(venta2);
        ventas.push(venta3);
        ventas.push(venta4);
        ventas.push(venta5);

        // Se agregan los 5 objetos al Deque de la cartera
        cartera.agregarVenta(venta1);
        cartera.agregarVenta(venta2);
        cartera.agregarVenta(venta3);
        cartera.agregarVenta(venta4);
        cartera.agregarVenta(venta5);
    }

}
