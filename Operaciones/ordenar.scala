object Ordenar {
  def main(args: Array[String]): Unit = {
    // Ordena los precios de menor a mayor con sortBy.
    val precios = List(25, 15, 180, 750, 45, 80, 150, 65, 120, 95)
    val resultado = precios.sortBy(p => p)
    println(resultado)
  }
}
