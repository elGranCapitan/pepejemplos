package com.gc.ejemplos

import java.io.{FileNotFoundException, InputStream}
import java.net.{MalformedURLException, URL}

import org.scalatest.FunSuite

import scala.util.{Success, Try}

class UrlUtilsTest extends FunSuite {

  test("test sobre metodo createURL con URL correcta") {
    val urlOk=UrlUtils.createURL("http://www.google.es")

    assert(urlOk.isSuccess==true)
  }

  test("test sobre metodo createURL configurando una URL ante el fallo") {
    val urlOk=UrlUtils.createURL("pepep-lopez").getOrElse(new URL("http://www.google.es"))

    assert(urlOk.isInstanceOf[URL]==true)
  }

  test("test sobre metodo createURL usando map") {
    val urlOk=UrlUtils.createURL("http://www.google.es")
    val urlKo=UrlUtils.createURL("pepep-lopez")

    assert(urlOk.map(_.getProtocol)==Success("http"))
    assert(urlKo.map(_.getProtocol).isFailure==true)
  }

  test("test sobre metodo createInputStreamFromURL con map") {
    val urlOk=UrlUtils.createInputStreamFromURL("http://www.google.es")

    assert(urlOk.isSuccess==true)
    assert(urlOk.get.get.get.isInstanceOf[InputStream]==true)
  }

  test("test sobre metodo createInputStreamFromURL con flatMap") {
    val urlOk=UrlUtils.createInputStreamFromURL2("http://www.google.es")

    assert(urlOk.isSuccess==true)
    assert(urlOk.get.isInstanceOf[InputStream]==true)
  }

  test("test sobre metodo getURLContent") {
    val urlOk=UrlUtils.getURLContent("http://www.marca.es")

    assert(urlOk.isSuccess==true)
  }

  test("test sobre metodo getURLContent configurando excepciones ") {
    val url = UrlUtils.getURLContent("garbage") recover {
      case e: FileNotFoundException => Iterator("Requested page does not exist")
      case e: MalformedURLException => Iterator("Please make sure to enter a valid URL")
      case _ => Iterator("An unexpected error has occurred. We are so sorry!")
    }
  }


}
