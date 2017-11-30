package com.gc.ejemplos

case class Comprador(edad: Int, dinero: Long)
case class Coche(marca: String, precio: Long)
case class Operacion(estado: String)

case class CompradorIlegalExcepcion(msg: String) extends Exception(msg)
case class PagoInsuficienteException(msg: String) extends Exception(msg)

object Excepciones {

  def javaStyle(comprador: Comprador, coche: Coche): Operacion = {
    if (comprador.edad < 18) {
      throw CompradorIlegalExcepcion("el comprador no tiene la edad legal minima")
    }
    if (comprador.dinero < coche.precio) {
      throw PagoInsuficienteException("el importe del cliente es insuficiente")
    }
    Operacion("finalizada")
  }

}
