object ConteoScala {
  def main(args: Array[String]): Unit = {
    // Cuenta cuántos productos tienen un precio mayor a $100.
    val precios = List(25, 15, 180, 750, 45, 80, 150, 65, 120, 95)
    val resultado = precios.count(p => p > 100)
    println("Productos mayores a $100: " + resultado)
  }
}
