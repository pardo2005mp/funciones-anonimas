object Transformacion {
  def main(args: Array[String]): Unit = {
    // Suma $10 por envío al precio de cada producto.
    val precios = List(25, 15, 180, 750, 45, 80, 150, 65, 120, 95)
    val resultado = precios.map(p => p + 10)
    println(resultado)
  }
}
