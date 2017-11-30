package com.gc.ejemplos

import scala.util.{Failure, Success, Try}

object ValidatorProgram extends App {

  val ruleInt: Any => Boolean = i => i.asInstanceOf[Int] > 0
  val ruleString: Any => Boolean = s => s.asInstanceOf[String].contains("fe")

  // Estilo Java
  try {
    val value = Validador.check(-1)(ruleInt)
    print(s"valor validado: $value")
  } catch {
    case ValidationException(msg, code) => print(s"error: $msg - codigo: $code")
  }

  // Estilo Scala
  val valueOk = Try(Validador.check("gran capitan")(ruleString)) match {
    case Success(value) => print(s"valor validado: $value")
    case Failure(_) => print("se ha producido un error")
  }

}

