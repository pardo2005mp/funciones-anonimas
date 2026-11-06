object SeleccionScala {
  def main(args: Array[String]): Unit = {
    // Muestra los precios de la tienda que superan los $100.
    val precios = List(25, 15, 180, 750, 45, 80, 150, 65, 120, 95)
    val resultado = precios.filter(p => p > 100)
    println(resultado)
  }
}
