package com.gc.ejemplos

case class ValidationException(msg: String, code: Int) extends RuntimeException(msg)

object Validador {

  @throws[ValidationException]
  def check(value: Any)(f:(Any) => Boolean): Any = {
    value match {
      case value: Int => if (f(value)) value else throw ValidationException("integer no valido",100)
      case value: String => if (f(value)) value else throw ValidationException("string no valido",200)
      case _ => throw ValidationException("tipo no soportado",500)
    }
  }

}
