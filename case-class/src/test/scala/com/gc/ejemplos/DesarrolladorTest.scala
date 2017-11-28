package com.gc.ejemplos

import org.scalatest._

class DesarrolladorTest extends FunSuite {

  test("crear sin operador new") {
    val developer = Desarrollador("Pepe", "Bluetab", List("java", "scala"), 0)

    assert(developer != null)
  }

  test("crear con operador new aunque no es buen de buen estilo") {
    val developer = new Desarrollador("Pepe", "Bluetab", List("java", "scala"), 0)

    assert(developer != null)
  }

  test("propiedades accesibles") {
    val developer = Desarrollador("Pepe", "Bluetab", List("java", "scala"), 0)

    assert(developer.nombre == "Pepe")
    assert(developer.experiencia == 0)
  }

  test("hashcode, equals y toString generados por Scala") {
    val developer1 = Desarrollador("Pepe", "Bluetab", List("java", "scala"), 0)
    val developer2 = Desarrollador("Patricia", "Everis", List("java", "scala"), 5)
    val developer3 = Desarrollador("Patricia", "Everis", List("java", "scala"), 5)

    assert(developer1.hashCode != developer2.hashCode)
    assert(developer1.equals(developer2) == false)
    assert(developer2.equals(developer3) == true)
    assert(developer2.toString == "Desarrollador(Patricia,Everis,List(java, scala),5)")
  }

  test("uso de copy") {
    val developer = Desarrollador("Pepe", "Bluetab", List("java", "scala"), 0)
    val newDeveloper = developer.copy(tecnologias = List("docker", "ansible"), experiencia = 2)

    assert(newDeveloper.nombre == "Pepe")
    assert(newDeveloper.tecnologias == List("docker", "ansible"))
    assert(newDeveloper.experiencia == 2)
  }

}
