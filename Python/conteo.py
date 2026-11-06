# Cuenta cuántos productos tienen un precio mayor a $100.
precios = [25, 15, 180, 750, 45, 80, 150, 65, 120, 95]
resultado = len(list(filter(lambda p: p > 100, precios)))
print("Productos mayores a $100:", resultado)
