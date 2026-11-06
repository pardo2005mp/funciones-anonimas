object Dividir {
  def main(args: Array[String]): Unit = {
    // Separa los precios de hasta $100 y los que superan $100.
    val precios = List(25, 15, 180, 750, 45, 80, 150, 65, 120, 95)
    val (economicos, caros) = precios.partition(p => p <= 100)
    println("Hasta $100: " + economicos)
    println("Mayores a $100: " + caros)
  }
}
