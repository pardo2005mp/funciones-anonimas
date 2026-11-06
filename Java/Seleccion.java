import java.util.List;

public class Seleccion {
    public static void main(String[] args) {
        // Muestra los precios de la tienda que superan los $100.
        List<Integer> precios = List.of(25, 15, 180, 750, 45, 80, 150, 65, 120, 95);
        List<Integer> resultado = precios.stream()
                .filter(p -> p > 100)
                .toList();
        System.out.println(resultado);
    }
}
