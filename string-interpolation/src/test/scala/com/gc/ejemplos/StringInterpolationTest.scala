package com.gc.ejemplos

import org.scalatest.FunSuite

class StringInterpolationTest extends FunSuite {

  test("interpolacion de cadenas standard") {
    val listaInterpolada = StringInterpolation.standardInterpolation(Seq("Pepe","Patri","Lucia-Natalia"))

    assert(listaInterpolada(0)=="value: Pepe")
    assert(listaInterpolada(1)=="value: Patri")
    assert(listaInterpolada(2)=="value: Lucia-Natalia")
  }

  test("interpolacion de cadenas raw") {
    val stringRaw = StringInterpolation.rawInterpolation("Pepe")

    assert(stringRaw==raw"esto es una interpolacion raw para \nPepe")
  }

  test("interpolacion de cadenas con formato") {
    val stringRaw = StringInterpolation.formatInterpolation(1.7f)

    assert(stringRaw=="Patri mide 1,70 de altura")
  }

}
