object TomarMientras {
  def main(args: Array[String]): Unit = {
    // Toma precios desde el inicio mientras sean menores a $100.
    val precios = List(25, 15, 180, 750, 45, 80, 150, 65, 120, 95)
    val resultado = precios.takeWhile(p => p < 100)
    println(resultado)
  }
}
