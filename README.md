# Parte 1. Programación funcional en el mundo real

## Caso 1. Apache Spark

**¿Qué es?**

Apache Spark es un motor de procesamiento de datos que permite analizar grandes cantidades de información mediante operaciones distribuidas.

**¿Qué problema resuelve?**

Permite procesar grandes conjuntos de datos, como registros de transacciones, eventos o archivos, distribuyendo las tareas entre varias máquinas.

**Lenguaje y herramienta:**

Apache Spark permite utilizar Scala, Java y Python. En Scala se pueden emplear funciones anónimas con operaciones como `map`, `filter` y `reduceByKey`.

**Ventaja de la programación funcional:**

Permite expresar transformaciones y operaciones sobre datos de forma clara, sin necesidad de escribir ciclos manuales para cada elemento. Spark también puede distribuir estas operaciones entre diferentes máquinas.

**Fragmento de código de la documentación oficial:**

```scala
val lines = sc.textFile("data.txt")
val pairs = lines.map(s => (s, 1))
val counts = pairs.reduceByKey((a, b) => a + b)
```

**Explicación:**

El código lee un archivo de texto, transforma cada línea en un par formado por su contenido y el número 1, y después suma los valores asociados a las líneas iguales. Las expresiones `s => (s, 1)` y `(a, b) => a + b` son funciones anónimas.

**Fuente:**

Apache Software Foundation. *RDD Programming Guide*.

https://spark.apache.org/docs/latest/rdd-programming-guide.html

## Caso 2. pandas

**¿Qué es?**

pandas es una biblioteca de código abierto de Python utilizada para manipular y analizar datos organizados en tablas.

**¿Qué problema resuelve?**

Facilita la limpieza, transformación y análisis de conjuntos de datos. Por ejemplo, permite clasificar productos de una tienda según su precio.

**Lenguaje y herramienta:**

Python, mediante la biblioteca pandas y funciones anónimas escritas con `lambda`.

**Ventaja de la programación funcional:**

Permite aplicar reglas de transformación directamente sobre columnas de datos, sin crear una función nombrada para cada operación sencilla.

**Ejemplo propio basado en la documentación oficial:**

```python
import pandas as pd

productos = pd.DataFrame({
    "producto": ["Mouse", "Monitor", "Laptop"],
    "precio": [15, 180, 750]
})

productos["categoria"] = productos["precio"].apply(
    lambda precio: "Alto" if precio > 100 else "Bajo"
)

print(productos)
```

**Explicación:**

El programa crea una tabla de productos y utiliza `apply()` con una función anónima para clasificar sus precios. Si el precio es mayor a 100, asigna la categoría "Alto"; de lo contrario, asigna "Bajo".

**Fuente:**

pandas Development Team. *pandas.DataFrame.apply*.

https://pandas.pydata.org/docs/reference/api/pandas.DataFrame.apply.html

### Relación entre los casos

Ambos proyectos permiten utilizar funciones anónimas para procesar datos. Apache Spark está orientado especialmente al procesamiento distribuido, mientras que pandas facilita la manipulación y el análisis de datos tabulares. En ambos casos, las funciones anónimas permiten expresar operaciones de manera breve y reutilizar funciones existentes como `map` y `apply`.


# Parte 2. ¿Qué es una función anónima?

### 2.1. ¿Qué es una función anónima y de dónde viene el nombre lambda?

Una función anónima es una función que se define sin asignarle un nombre propio. Se utiliza para realizar operaciones específicas de manera sencilla, especialmente al trabajar con listas.

El término *lambda* proviene del cálculo lambda, un modelo matemático desarrollado por Alonzo Church para representar funciones.

**Ejemplo en Scala:**

```scala
val numeros = List(2, 4, 6, 8)
val resultado = numeros.map(n => n * 2)

println(resultado)
```

**Salida:**
```text
List(4, 8, 12, 16)
```

**Explicación:** La expresión `n => n * 2` es una función anónima que multiplica cada número por dos. `map` aplica esa función a todos los elementos de la lista.

### 2.2. ¿En qué se diferencia de una función nombrada?

Una función nombrada tiene un nombre definido y puede utilizarse en diferentes partes del programa. Una función anónima se escribe sin declarar un nombre para la función, lo que resulta útil en operaciones cortas.

**Función nombrada:**

```scala
def duplicar(n: Int): Int = n * 2

val numeros = List(2, 4, 6)
println(numeros.map(duplicar))
```

**Función anónima:**

```scala
val numeros = List(2, 4, 6)
println(numeros.map(n => n * 2))
```

**Salida de ambas:**
```text
List(4, 8, 12)
```

**Explicación:** Los dos ejemplos realizan la misma operación. La principal diferencia es que el primero declara una función llamada `duplicar`, mientras que el segundo escribe directamente la lógica dentro de `map`.

### 2.3. ¿Qué significa que las funciones sean ciudadanos de primera clase?

Significa que las funciones pueden tratarse como valores: guardarse en variables, enviarse como argumentos a otras funciones y devolverse como resultados.

Esto permite utilizar lambdas en operaciones como `map` y `filter`, porque estas reciben funciones que indican qué hacer con cada elemento.

**Ejemplo en Scala:**

```scala
val numeros = List(5, 15, 20, 8)

val esMayor: Int => Boolean = n => n > 10

val resultado = numeros.filter(esMayor)

println(resultado)
```

**Salida:**
```text
List(15, 20)
```

**Explicación:** La función anónima se guarda en `esMayor` y luego se pasa a `filter`. Esta operación conserva únicamente los números mayores que 10.

### 2.4. ¿Qué es un closure?

Un *closure* o clausura es una función que puede utilizar variables definidas fuera de ella, conservando acceso a su entorno incluso cuando se ejecuta en otro lugar.

**Ejemplo en Scala:**

```scala
val limite = 50

val precios = List(20, 60, 80, 30)

val resultado = precios.filter(p => p > limite)

println(resultado)
```

**Salida:**
```text
List(60, 80)
```

**Explicación:** La función anónima `p => p > limite` utiliza la variable `limite`, que fue declarada fuera de ella. Esto demuestra cómo una función puede capturar valores de su entorno.

### Resumen

Las funciones anónimas permiten escribir operaciones de manera breve y clara. Son especialmente útiles para transformar, filtrar y procesar listas sin declarar una función nombrada para cada operación.

# Parte 3. Aplicación práctica de funciones anónimas

Para facilitar las comparaciones, se usa **la misma lista de diez precios** en
Scala, Java y Python: `25, 15, 180, 750, 45, 80, 150, 65, 120, 95`.
Los precios representan productos de una tienda de tecnología. Cada programa
utiliza una lambda y una operación sobre listas; las salidas deben representar
el mismo resultado en los tres lenguajes.

### 3.1 Selección — `filter`

**Situación real:** una tienda quiere mostrar los productos que cuestan más de $100.

- [Scala](scala/seleccion.scala): `precios.filter(p => p > 100)`.
- [Java](java/Seleccion.java): `precios.stream().filter(p -> p > 100).toList()`.
- [Python](python/seleccion.py): `list(filter(lambda p: p > 100, precios))`.

**Salida comprobable:** `180, 750, 150, 120` (en ese orden).

**Explicación:** la función anónima comprueba si cada precio supera $100.
`filter` conserva únicamente los precios que cumplen esa condición.

### 3.2 Transformación — `map`

**Situación real:** una tienda añade $10 por envío al precio de cada producto.

- [Scala](scala/transformacion.scala): `precios.map(p => p + 10)`.
- [Java](java/Transformacion.java): `precios.stream().map(p -> p + 10).toList()`.
- [Python](python/transformacion.py): `list(map(lambda p: p + 10, precios))`.

**Salida comprobable:** `35, 25, 190, 760, 55, 90, 160, 75, 130, 105`.

**Explicación:** la lambda suma 10 a cada precio; `map` genera una lista
con los nuevos valores sin cambiar la lista original.

### 3.3 Validación — `exists` y `forall`

**Situación real:** una tienda necesita verificar si tiene algún producto de
más de $500 y comprobar que ningún precio sea cero o negativo.

- [Scala](scala/validacion.scala): `exists(p => p > 500)` y `forall(p => p > 0)`.
- [Java](java/Validacion.java): `anyMatch(p -> p > 500)` y `allMatch(p -> p > 0)`.
- [Python](python/validacion.py): `any(map(lambda p: p > 500, precios))` y `all(map(lambda p: p > 0, precios))`.

**Salida comprobable:** ambas validaciones son verdaderas: hay un precio de
más de $500 y todos los precios son positivos.

**Explicación:** una lambda verifica si existe al menos un elemento que cumple
la condición y otra comprueba si todos la cumplen.

### 3.4 Conteo — `count`

**Situación real:** la tienda necesita saber cuántos productos cuestan más de $100.

- [Scala](scala/conteo.scala): `precios.count(p => p > 100)`.
- [Java](java/Conteo.java): `precios.stream().filter(p -> p > 100).count()`.
- [Python](python/conteo.py): `len(list(filter(lambda p: p > 100, precios)))`.

**Salida comprobable:** `Productos mayores a $100: 4`.

**Explicación:** la lambda comprueba qué precios son mayores a $100 y la
operación correspondiente permite contar los que cumplen la condición.

**Comparación de salidas:** Scala imprime listas como `List(...)`; Java y Python
como `[...]`. En las validaciones Python usa `True` y Scala/Java `true`.
Aunque la escritura cambia, **los resultados son equivalentes**.

---

## Parte 4. Cuatro operaciones nuevas sobre colecciones

Estas operaciones no son las mismas que `map`, `filter`, `exists`, `forall`,
`count`, `maxBy`, `minBy`, `flatMap`, `foldLeft` o `scanLeft`, vistas en clase.
Se usa la lista de precios de la Parte 3.

### 4.1 `sortBy` — ordenar

- **Qué hace:** ordena los precios usando el valor que devuelve la lambda.
- **Qué recibe:** una función `p => p` que devuelve un número como criterio de orden.
- **Problema real:** mostrar los precios de menor a mayor. Es un tipo de problema de **ordenamiento**.
- **Código:** [ordenar.scala](operaciones/ordenar.scala).
- **Salida:** `List(15, 25, 45, 65, 80, 95, 120, 150, 180, 750)`.

### 4.2 `partition` — dividir una lista

- **Qué hace:** separa una lista en dos grupos según una condición.
- **Qué recibe:** una lambda `p => p <= 100`, que devuelve `Boolean` (`true` o `false`).
- **Problema real:** dividir productos económicos de los de mayor precio. Se parece a la **selección**, pero conserva ambos grupos.
- **Código:** [dividir.scala](operaciones/dividir.scala).
- **Salidas:**
  - Hasta $100: `List(25, 15, 45, 80, 65, 95)`.
  - Mayores a $100: `List(180, 750, 150, 120)`.

### 4.3 `find` — buscar

- **Qué hace:** encuentra el primer elemento que cumple la condición.
- **Qué recibe:** una lambda `p => p > 500`, que devuelve `Boolean`.
- **Problema real:** localizar un producto de precio superior a $500. Se parece a la **selección**, pero devuelve solo la primera coincidencia.
- **Código:** [buscar.scala](operaciones/buscar.scala).
- **Salida:** `Some(750)`, que significa que encontró el precio 750. Si no encontrara nada, devolvería `None`.

### 4.4 `takeWhile` — tomar elementos mientras se cumpla una condición

- **Qué hace:** toma elementos **desde el principio** de la lista y se detiene cuando uno no cumple la condición.
- **Qué recibe:** una lambda `p => p < 100`, que devuelve `Boolean`.
- **Problema real:** consultar el bloque inicial de precios menores a $100 en una lista recibida en cierto orden. Es un tipo de **selección por prefijo**.
- **Código:** [tomar_mientras.scala](operaciones/tomar_mientras.scala).
- **Salida:** `List(25, 15)`.
- **Importante:** `takeWhile` no es lo mismo que `filter`; se detiene al encontrar 180.

### 4.5 Combinación de operaciones

**Pregunta:** ¿qué precios de la tienda están entre $20 y $80, ordenados de menor a mayor?

**Código:** [combinacion.scala](operaciones/combinacion.scala).

```scala
val resultado = precios
  .filter(p => p >= 20)
  .sortBy(p => p)
  .takeWhile(p => p <= 80)
```

1. `filter` (vista en clase) elimina los precios menores a $20.
2. `sortBy` (nueva) ordena de menor a mayor.
3. `takeWhile` (nueva) toma los precios desde el inicio hasta superar $80.

**Salida:** `List(25, 45, 65, 80)`.   

## Parte 3. Aplicación práctica de funciones anónimas

Para facilitar las comparaciones, se usa **la misma lista de diez precios** en
Scala, Java y Python: `25, 15, 180, 750, 45, 80, 150, 65, 120, 95`.
Los precios representan productos de una tienda de tecnología. Cada programa
utiliza una lambda y una operación sobre listas; las salidas deben representar
el mismo resultado en los tres lenguajes.

### 3.1 Selección — `filter`

**Situación real:** una tienda quiere mostrar los productos que cuestan más de $100.

- [Scala](scala/seleccion.scala): `precios.filter(p => p > 100)`.
- [Java](java/Seleccion.java): `precios.stream().filter(p -> p > 100).toList()`.
- [Python](python/seleccion.py): `list(filter(lambda p: p > 100, precios))`.

**Salida comprobable:** `180, 750, 150, 120` (en ese orden).

**Explicación:** la función anónima comprueba si cada precio supera $100.
`filter` conserva únicamente los precios que cumplen esa condición.

### 3.2 Transformación — `map`

**Situación real:** una tienda añade $10 por envío al precio de cada producto.

- [Scala](scala/transformacion.scala): `precios.map(p => p + 10)`.
- [Java](java/Transformacion.java): `precios.stream().map(p -> p + 10).toList()`.
- [Python](python/transformacion.py): `list(map(lambda p: p + 10, precios))`.

**Salida comprobable:** `35, 25, 190, 760, 55, 90, 160, 75, 130, 105`.

**Explicación:** la lambda suma 10 a cada precio; `map` genera una lista
con los nuevos valores sin cambiar la lista original.

### 3.3 Validación — `exists` y `forall`

**Situación real:** una tienda necesita verificar si tiene algún producto de
más de $500 y comprobar que ningún precio sea cero o negativo.

- [Scala](scala/validacion.scala): `exists(p => p > 500)` y `forall(p => p > 0)`.
- [Java](java/Validacion.java): `anyMatch(p -> p > 500)` y `allMatch(p -> p > 0)`.
- [Python](python/validacion.py): `any(map(lambda p: p > 500, precios))` y `all(map(lambda p: p > 0, precios))`.

**Salida comprobable:** ambas validaciones son verdaderas: hay un precio de
más de $500 y todos los precios son positivos.

**Explicación:** una lambda verifica si existe al menos un elemento que cumple
la condición y otra comprueba si todos la cumplen.

### 3.4 Conteo — `count`

**Situación real:** la tienda necesita saber cuántos productos cuestan más de $100.

- [Scala](scala/conteo.scala): `precios.count(p => p > 100)`.
- [Java](java/Conteo.java): `precios.stream().filter(p -> p > 100).count()`.
- [Python](python/conteo.py): `len(list(filter(lambda p: p > 100, precios)))`.

**Salida comprobable:** `Productos mayores a $100: 4`.

**Explicación:** la lambda comprueba qué precios son mayores a $100 y la
operación correspondiente permite contar los que cumplen la condición.

**Comparación de salidas:** Scala imprime listas como `List(...)`; Java y Python
como `[...]`. En las validaciones Python usa `True` y Scala/Java `true`.
Aunque la escritura cambia, **los resultados son equivalentes**.

---

## Parte 4. Cuatro operaciones nuevas sobre colecciones

Estas operaciones no son las mismas que `map`, `filter`, `exists`, `forall`,
`count`, `maxBy`, `minBy`, `flatMap`, `foldLeft` o `scanLeft`, vistas en clase.
Se usa la lista de precios de la Parte 3.

### 4.1 `sortBy` — ordenar

- **Qué hace:** ordena los precios usando el valor que devuelve la lambda.
- **Qué recibe:** una función `p => p` que devuelve un número como criterio de orden.
- **Problema real:** mostrar los precios de menor a mayor. Es un tipo de problema de **ordenamiento**.
- **Código:** [ordenar.scala](operaciones/ordenar.scala).
- **Salida:** `List(15, 25, 45, 65, 80, 95, 120, 150, 180, 750)`.

### 4.2 `partition` — dividir una lista

- **Qué hace:** separa una lista en dos grupos según una condición.
- **Qué recibe:** una lambda `p => p <= 100`, que devuelve `Boolean` (`true` o `false`).
- **Problema real:** dividir productos económicos de los de mayor precio. Se parece a la **selección**, pero conserva ambos grupos.
- **Código:** [dividir.scala](operaciones/dividir.scala).
- **Salidas:**
  - Hasta $100: `List(25, 15, 45, 80, 65, 95)`.
  - Mayores a $100: `List(180, 750, 150, 120)`.

### 4.3 `find` — buscar

- **Qué hace:** encuentra el primer elemento que cumple la condición.
- **Qué recibe:** una lambda `p => p > 500`, que devuelve `Boolean`.
- **Problema real:** localizar un producto de precio superior a $500. Se parece a la **selección**, pero devuelve solo la primera coincidencia.
- **Código:** [buscar.scala](operaciones/buscar.scala).
- **Salida:** `Some(750)`, que significa que encontró el precio 750. Si no encontrara nada, devolvería `None`.

### 4.4 `takeWhile` — tomar elementos mientras se cumpla una condición

- **Qué hace:** toma elementos **desde el principio** de la lista y se detiene cuando uno no cumple la condición.
- **Qué recibe:** una lambda `p => p < 100`, que devuelve `Boolean`.
- **Problema real:** consultar el bloque inicial de precios menores a $100 en una lista recibida en cierto orden. Es un tipo de **selección por prefijo**.
- **Código:** [tomar_mientras.scala](operaciones/tomar_mientras.scala).
- **Salida:** `List(25, 15)`.
- **Importante:** `takeWhile` no es lo mismo que `filter`; se detiene al encontrar 180.

### 4.5 Combinación de operaciones

**Pregunta:** ¿qué precios de la tienda están entre $20 y $80, ordenados de menor a mayor?

**Código:** [combinacion.scala](operaciones/combinacion.scala).

```scala
val resultado = precios
  .filter(p => p >= 20)
  .sortBy(p => p)
  .takeWhile(p => p <= 80)
```

1. `filter` (vista en clase) elimina los precios menores a $20.
2. `sortBy` (nueva) ordena de menor a mayor.
3. `takeWhile` (nueva) toma los precios desde el inicio hasta superar $80.

**Salida:** `List(25, 45, 65, 80)`.