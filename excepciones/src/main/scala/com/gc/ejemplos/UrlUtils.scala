package com.gc.ejemplos

import java.io.InputStream
import java.net.URL

import scala.io.Source
import scala.util.Try

object UrlUtils {

  def createURL(url: String): Try[URL] = Try(new URL(url))

  def createInputStreamFromURL(url: String): Try[Try[Try[InputStream]]] = {
    createURL(url).map(u => Try(u.openConnection()).map(conn => Try(conn.getInputStream)))
  }

  def createInputStreamFromURL2(url: String): Try[InputStream] = {
    createURL(url).flatMap(u => Try(u.openConnection()).flatMap(conn => Try(conn.getInputStream)))
  }

  def getURLContent(url: String): Try[Iterator[String]] = {
    for {
      url <- createURL(url)
      connection <- Try(url.openConnection())
      is <- Try(connection.getInputStream)
      source = Source.fromInputStream(is)
    } yield source.getLines()
  }

}
