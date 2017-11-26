package com.gc.ejemplos

import org.scalatest.FunSuite

/**
  * https://www.scala-lang.org/api/2.10.5/#scala.Option
  */
class EjemplosOptionTest extends FunSuite {

  test("test crear option") {
    val nullOption = EjemplosOption.createOption(null)
    val okOption = EjemplosOption.createOption("cualquier valor")

    assert(nullOption == None)
    assert(okOption == Some("cualquier valor"))
  }

  test("test crear option con default") {
    val okOption =
      EjemplosOption.createOptionWithDefaultValue("valor ok",
                                                  "valor por defecto")
    val defaultOption =
      EjemplosOption.createOptionWithDefaultValue(null, "valor por defecto")

    assert(okOption == Some("valor ok"))
    assert(defaultOption == Some("valor por defecto"))
  }

  test("test uso isDefind") {
    val nullOption = EjemplosOption.createOption(null)
    val okOption = EjemplosOption.createOption("cualquier valor")

    assert(nullOption.isDefined == false)
    assert(okOption.isDefined == true)
  }

  test("test uso de getOrElse") {
    val nullOption = EjemplosOption.createOption(null)
    val okOption = EjemplosOption.createOption("cualquier valor")

    assert(nullOption.getOrElse("valor por defecto") == "valor por defecto")
    assert(okOption.get == "cualquier valor")
  }

}
