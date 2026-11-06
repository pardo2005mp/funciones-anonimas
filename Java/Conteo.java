import java.util.List;

public class Conteo {
    public static void main(String[] args) {
        // Cuenta cuántos productos tienen un precio mayor a $100.
        List<Integer> precios = List.of(25, 15, 180, 750, 45, 80, 150, 65, 120, 95);
        long resultado = precios.stream()
                .filter(p -> p > 100)
                .count();
        System.out.println("Productos mayores a $100: " + resultado);
    }
}
