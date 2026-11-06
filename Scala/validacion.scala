object Validacion {
  def main(args: Array[String]): Unit = {
    // Comprueba si hay precios mayores a $500 y si todos son positivos.
    val precios = List(25, 15, 180, 750, 45, 80, 150, 65, 120, 95)
    val hayCaros = precios.exists(p => p > 500)
    val todosPositivos = precios.forall(p => p > 0)
    println("Hay precios mayores a $500: " + hayCaros)
    println("Todos los precios son positivos: " + todosPositivos)
  }
}
