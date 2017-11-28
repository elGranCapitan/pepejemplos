package com.gc.ejemplos

import scala.annotation.tailrec

object Parseador {

  type TipoDeCorte = (String,String) => String

  val haciaDelante: TipoDeCorte = (traza, etiqueta) => traza.substring(traza.indexOf(etiqueta) + etiqueta.length)
  val haciaAtras: TipoDeCorte = (traza, marcaFinal) => traza.split(marcaFinal).head.trim

  @tailrec
  def parserDeTraza(traza: String, etiquetas: Seq[String]): Option[String] = {
    etiquetas.length match {
      case 0 => Some(traza)
      case 1 =>
        cortarTraza(traza, etiquetas.head)(haciaAtras) match {
          case Some(subTraza) => parserDeTraza(subTraza, etiquetas.tail)
          case None => parserDeTraza(traza, etiquetas.tail)
        }
      case _ =>
        cortarTraza(traza, etiquetas.head)(haciaDelante) match {
          case Some(subTraza) => parserDeTraza(subTraza, etiquetas.tail)
          case None => parserDeTraza(traza, etiquetas.tail)
        }
    }
  }

  @tailrec
  def parserDeTraza(traza: String, etiquetas: Seq[String], marcaFinal: String): Option[String] = {
     if (etiquetas.nonEmpty) {
      cortarTraza(traza, etiquetas.head)(haciaDelante) match {
        case Some(subTraza) => parserDeTraza(subTraza, etiquetas.tail, marcaFinal)
        case None => parserDeTraza(traza, etiquetas.tail, marcaFinal)
      }
    } else {
      cortarTraza(traza, marcaFinal)(haciaAtras)
    }
  }

  private def cortarTraza(traza: String, etiqueta: String)(tipoDeCorte: TipoDeCorte): Option[String] = {
    traza.indexOf(etiqueta) match {
      case position if position >= 0 => Some(tipoDeCorte(traza,etiqueta))
      case -1 => None
    }
  }

}
