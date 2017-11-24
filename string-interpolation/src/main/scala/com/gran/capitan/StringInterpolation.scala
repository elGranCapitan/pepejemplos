package com.gran.capitan

/**
  * Ejemplos de uso de la interpolacion de cadenas ofrecida por Scala
  */
object StringInterpolation extends App {

  def standardInterpolation(values: Seq[String]): Seq[String] = {
    values.map(value => s"value: $value")
  }

  def rawInterpolation(value: String): String = {
    raw"esto es una interpolacion raw para \n${value}"
  }

  def formatInterpolation(value: Float) = {
    f"Patri mide $value%2.2f de altura"
  }

}
