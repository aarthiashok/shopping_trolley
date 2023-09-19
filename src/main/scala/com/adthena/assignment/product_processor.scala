package com.adthena.assignment
import java.io.FileNotFoundException
import java.io.IOException

class product_processor {

  try {

    val productConfig = ujson.read(os.read(os.pwd / "product_details.json"))
    productConfig("product").arr.foreach {
      case (product) => println(s"$product")
    }
  }
  catch {
    case ex: FileNotFoundException => {
      println("Missing product config file exception")
    }
    case ex: IOException => {
      println("IO Exception on reading product file")
    }
  }

  //println("product processor")
  }

