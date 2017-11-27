package com.gc.ejemplos

import org.scalatest.FunSuite

class ParseadorTest extends FunSuite {

  val logTrace: String = "esto es un log TAG1 que contienes varios etiquetas TAG2 y una TAG3 marca final ## de lo que quiero parsear"

  test("logParser con todas las tags en la traza") {
    val logTrace =
      """esto es un log TAG1 que contiene varias etiquetas TAG2 y
        |una TAG3 una marca final ## de hasta donde quiero parsear""".stripMargin

    val result = Parseador.parserDeTraza(logTrace,Seq("TAG1","TAG2","TAG3"),"##")

    assert(result==Some("una marca final"))
  }

  test("logParser con tags que no existen al principio de la listaen la traza") {
    val logTrace =
      """esto es un log TAG1 que contiene varias etiquetas TAG2 y
        |una TAG3 una marca final ## de hasta donde quiero parsear""".stripMargin

    val result = Parseador.parserDeTraza(logTrace,Seq("TAG5", "TAG1","TAG2","TAG3"),"##")

    assert(result==Some("una marca final"))
  }

  test("logParser con tags que no existen al final de la lista en la traza") {
    val logTrace =
      """esto es un log TAG1 que contiene varias etiquetas TAG2 y
        |una TAG3 una marca final ## de hasta donde quiero parsear""".stripMargin

    val result = Parseador.parserDeTraza(logTrace,Seq("TAG1","TAG2","TAG3","TAG5"),"##")

    assert(result==Some("una marca final"))
  }

  test("logParser con tags que no existen al principio y al final de la lista en la traza") {
    val logTrace =
      """esto es un log TAG1 que contiene varias etiquetas TAG2 y
        |una TAG3 una marca final ## de hasta donde quiero parsear""".stripMargin

    val result = Parseador.parserDeTraza(logTrace,Seq("TAG9","TAG1","TAG2","TAG3","TAG5"),"##")

    assert(result==Some("una marca final"))
  }

  test("logParser con tags que no existen en cual quier posicion de la lista en la traza") {
    val logTrace =
      """esto es un log TAG1 que contiene varias etiquetas TAG2 y
        |una TAG3 una marca final ## de hasta donde quiero parsear""".stripMargin

    val result = Parseador.parserDeTraza(logTrace,Seq("TAG9","TAG1","TAG2","ALF4","TAG3","TAG5"),"##")

    assert(result==Some("una marca final"))
  }

  test("logParser sin tags en la traza") {
    val logTrace =
      """esto es un log que contiene varias etiquetas y una marca final ## de hasta donde quiero parsear"""

    val result = Parseador.parserDeTraza(logTrace,Seq("TAG9","TAG1","TAG2","ALF4","TAG3","TAG5"),"##")

    assert(result==Some("esto es un log que contiene varias etiquetas y una marca final"))
  }

}
