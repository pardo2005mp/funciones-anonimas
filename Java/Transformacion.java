import java.util.List;

public class Transformacion {
    public static void main(String[] args) {
        // Suma $10 por envío al precio de cada producto.
        List<Integer> precios = List.of(25, 15, 180, 750, 45, 80, 150, 65, 120, 95);
        List<Integer> resultado = precios.stream()
                .map(p -> p + 10)
                .toList();
        System.out.println(resultado);
    }
}
