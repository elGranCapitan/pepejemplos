package com.gc.ejemplos

import org.scalatest.FunSuite

class ValidadorTest extends FunSuite {

  test("test value int") {

    val ruleInt: Any => Boolean = i => i.asInstanceOf[Int] > 0
    val valueOk = -1

    intercept[ValidationException] {
      Validador.check(valueOk)(ruleInt)
    }

//    assert(valueOk > 0)

  }

}
