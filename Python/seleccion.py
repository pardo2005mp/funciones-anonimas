# Muestra los precios de la tienda que superan los $100.
precios = [25, 15, 180, 750, 45, 80, 150, 65, 120, 95]
resultado = list(filter(lambda p: p > 100, precios))
print(resultado)
