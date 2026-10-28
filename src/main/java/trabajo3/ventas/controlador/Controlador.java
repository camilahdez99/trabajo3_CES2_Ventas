package trabajo3.ventas.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Function;

import trabajo3.ventas.modelo.EnumVenta;
import trabajo3.ventas.modelo.Venta;
import trabajo3.ventas.repositories.Ventas;

@Controller
public class Controlador {

    private List<String> resultado = new ArrayList<>();

    // PUNTO1: mostrar los 5 objetos, el Stack y la cartera con su Deque
    @GetMapping("peticion1")
    public String peticion1(Model model) {

        resultado.clear();

        resultado.add("PUNTO1");

        resultado.add("Stack con los 5 objetos de tipo Venta:");
        resultado.add("Ventas.ventas: " + Ventas.ventas.toString());

        resultado.add("Objeto CarteraDeVentas (columna F): " + Ventas.cartera.getNombre());
        resultado.add("Deque de ventas de la cartera: " + Ventas.cartera.getVentas().toString());

        model.addAttribute("resultado", resultado);

        return "resultado";
    }

    // PUNTO2: ListIterator sobre el Stack e Iterator sobre el Deque
    @GetMapping("peticion2")
    public String peticion2(Model model) {

        resultado.clear();

        resultado.add("PUNTO2");

        resultado.add("ListIterator con el Stack de los 5 objetos:");

        ListIterator<Venta> listIterator = Ventas.ventas.listIterator();

        while (listIterator.hasNext()) {
            Venta venta = listIterator.next();
            resultado.add("Producto: " + venta.getProducto() + ", Precio: " + venta.getPrecio()
                    + ", Cliente: " + venta.getCliente() + ", TipoVenta: " + venta.getTipoVenta()
                    + ", Categoria: " + venta.getCategoria());
        }

        resultado.add("Iterator con el Deque de la cartera:");

        Iterator<Venta> iterator = Ventas.cartera.getVentas().iterator();

        while (iterator.hasNext()) {
            Venta venta = iterator.next();
            resultado.add("Producto: " + venta.getProducto() + ", Precio: " + venta.getPrecio()
                    + ", Cliente: " + venta.getCliente() + ", TipoVenta: " + venta.getTipoVenta()
                    + ", Categoria: " + venta.getCategoria());
        }

        model.addAttribute("resultado", resultado);

        return "resultado";
    }

    // PUNTO3: convertir el Stack en Deque y usar programacion funcional sobre el
    // Deque de la cartera para imprimir los objetos de un enum especifico
    @GetMapping("peticion3")
    public String peticion3(Model model) {

        resultado.clear();

        resultado.add("PUNTO3");

        Deque<Venta> deque = new ArrayDeque<>(Ventas.ventas);

        resultado.add("Deque<Venta> deque = new ArrayDeque<>(Ventas.ventas): " + deque.toString());

        resultado.add("Objetos del Deque de la cartera que son de tipo ONLINE:");

        List<Venta> ventasOnline = Ventas.cartera.getVentas().stream()
                .filter(venta -> EnumVenta.ONLINE.equals(venta.getTipoVenta()))
                .toList();

        for (Venta venta : ventasOnline) {
            resultado.add(venta.toString());
        }

        model.addAttribute("resultado", resultado);

        return "resultado";
    }

    // PUNTO4: funcion con Function<T,R> que suma los datos del Stack conteo
    static Function<Venta, Integer> sumarConteo = venta -> {
        int suma = 0;
        for (Integer dato : venta.getConteo()) {
            suma += dato;
        }
        return suma;
    };

    @GetMapping("peticion4")
    public String peticion4(Model model) {

        resultado.clear();

        resultado.add("PUNTO4");

        int total = sumarConteo.apply(Ventas.venta1);

        resultado.add("Suma de los datos del Stack conteo de venta1: " + total);

        model.addAttribute("resultado", resultado);

        return "resultado";
    }

    // PUNTO5: llamar al metodo verTotales pasandole la funcion del PUNTO4
    @GetMapping("peticion5")
    public String peticion5(Model model) {

        resultado.clear();

        resultado.add("PUNTO5");

        resultado.add(Ventas.venta1.verTotales(sumarConteo));

        model.addAttribute("resultado", resultado);

        return "resultado";
    }

}
