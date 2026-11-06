object Buscar {
  def main(args: Array[String]): Unit = {
    // Busca el primer precio que supere los $500.
    val precios = List(25, 15, 180, 750, 45, 80, 150, 65, 120, 95)
    val resultado = precios.find(p => p > 500)
    println(resultado)
  }
}
