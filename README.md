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