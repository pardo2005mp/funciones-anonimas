import java.util.List;

public class Validacion {
    public static void main(String[] args) {
        // Comprueba si hay precios mayores a $500 y si todos son positivos.
        List<Integer> precios = List.of(25, 15, 180, 750, 45, 80, 150, 65, 120, 95);
        boolean hayCaros = precios.stream().anyMatch(p -> p > 500);
        boolean todosPositivos = precios.stream().allMatch(p -> p > 0);
        System.out.println("Hay precios mayores a $500: " + hayCaros);
        System.out.println("Todos los precios son positivos: " + todosPositivos);
    }
}
