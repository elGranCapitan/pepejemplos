# [Parser Lambda](https://trello.com/c/Yecpvihr)

Este ejemplo ofrece un parser de un log en el que se encuentra una posible lista de etiquetas, que pueden encontrarse o no, y ademas conocemos un marca de fin del paseo.

Ejemplo de traza de log:

```
esto seria [tag1] un ejemplo de traza[tag4]a ser analizada ## por nuestro parser
```

Función a implementar:

```
def parser(traza: String, etiquetas: Seq[String], marcaFin: String): Option[String]
```

El resultado esperado sera la subtraza contenida entre la ultima etiqueta de la lista y la marca de fin, según la traza de ejemplo, sería:

```
Some("a ser analizada")
```

Ejecución:

```
sbt test
```
