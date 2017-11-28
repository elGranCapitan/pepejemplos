package com.gc.ejemplos

class Persona(_nombre: String, _sexo: String) extends Serializable {

  val nombre =_nombre
  val sexo = _sexo

  override def equals(otro: Any): Boolean = {
    otro match {
      case instance: Persona => (instance canEqual this) &&
          nombre == instance.nombre && sexo == instance.sexo
      case _ => false
    }
  }

  def canEqual(other: Any): Boolean = {
    other.isInstanceOf[Persona]
  }

  override def hashCode(): Int = {
    val estado = Seq(nombre, sexo)
    estado.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }

  override def toString: String = {
    s"Persona($nombre,$sexo)"
  }

  def copy(nombre: String = nombre, sexo: String = sexo): Persona = {
    new Persona(nombre, sexo)
  }

}

object Persona {

  def apply(nombre: String, sexo: String): Persona = {
    new Persona(nombre, sexo)
  }

  def unapply(persona: Persona): Option[(String, String)] = {
    if (persona.eq(null)) None
    else Some((persona.nombre, persona.sexo))
  }

}
