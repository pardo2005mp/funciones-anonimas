# Comprueba si hay precios mayores a $500 y si todos son positivos.
precios = [25, 15, 180, 750, 45, 80, 150, 65, 120, 95]
hay_caros = any(map(lambda p: p > 500, precios))
todos_positivos = all(map(lambda p: p > 0, precios))
print("Hay precios mayores a $500:", hay_caros)
print("Todos los precios son positivos:", todos_positivos)
