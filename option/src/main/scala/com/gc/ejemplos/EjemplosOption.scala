package com.gc.ejemplos

object EjemplosOption {

  def createOption(value: String): Option[String] = {
    value match {
      case v: String => Some(v)
      case null      => None
    }
  }

  def createOptionWithDefaultValue(value: String, default: String): Option[String] = {
    createOption(value).orElse(Some(default))
  }

}
