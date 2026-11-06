object Combinacion {
  def main(args: Array[String]): Unit = {
    // Busca precios entre $20 y $80 y los ordena de menor a mayor.
    val precios = List(25, 15, 180, 750, 45, 80, 150, 65, 120, 95)
    val resultado = precios
      .filter(p => p >= 20)      // Vista en clase: descarta precios menores a $20.
      .sortBy(p => p)           // Nueva: ordena los precios.
      .takeWhile(p => p <= 80)  // Nueva: toma precios hasta $80.
    println(resultado)
  }
}
