package com.adthena.assignment
import java.io.FileNotFoundException
import java.io.IOException
import model.Product
import scala.util.Try
import java.lang.Math.abs

class ShopBasketProcessor {
  private val itemsInBasket: scala.collection.mutable.Map[Int, Product] = scala.collection.mutable.Map[Int, Product]()

  try {
    val productConfig = ujson.read(os.read(os.pwd / "product_details.json"))
    productConfig("product").arr.foreach {
      case (productJson) =>
        val prodObj = new Product(productJson)
        itemsInBasket(prodObj.id) = prodObj
    }
  } catch {
    case ex: FileNotFoundException => {
      println("Missing product config file")
    }
    case ex: IOException => {
      println("IO Exception on reading config")
    }
  }

  private def getItemCount(prodId : Int): Int =
    val item : Option[Product] =  itemsInBasket.get(prodId)
    return item match {
      case Some(item) => return item.item_count.toInt
      case None => return 0
    }

  def getInputFromUser(): Unit =
    try {
      itemsInBasket.foreach { case (key, value) =>
        println(s"Provide count for the item ${value.name}")
        val item_count = scala.io.StdIn.readLine()
        value.item_count = item_count.toInt
      }
    } catch {
      case ex: NumberFormatException => {
        println("Please provide only number as input")
      }
    }

  def calculateTotal(): Unit =
    var totalPrice: Double = 0
    var totalDiscountPrice : Double = 0
    itemsInBasket.foreach { case (key, item) =>
      var itemPrice = item.price * item.item_count
      totalPrice += itemPrice
      val discount = applyDiscount (item)
      if (discount > 0) {
        println(s"${item.discount_description} : ${discount} p")
        //println(discount)
        totalDiscountPrice = discount + totalDiscountPrice
      }
    }
    println(s"Sub Total £ ${roundToPound(totalPrice)}")
    if(totalDiscountPrice == 0) {
      println("(No offers available)")
    }
    //println(s"Total discount £ ${totalDiscountPrice}")
    println(s"Total Price After discount £ ${roundToPound(totalPrice-totalDiscountPrice)}")


  def applyDiscount(item: Product) : Double =
    item.discount_type match
      case "PERCENTAGE_DISCOUNT" => calculatePercentageDiscount(item)
      case "NO_DISCOUNT" => 0
      case "COMBO_DISCOUNT" => applyBuy2GetHalfDiscount(item)

  def calculatePercentageDiscount(item : Product):Double =
    return ((item.discount_value.toFloat / 100) * item.price * item.item_count).toInt

  def applyBuy2GetHalfDiscount(item: Product):Double =
    val comboItemCount : Int = getItemCount(item.combo_product_id)
    if(comboItemCount < item.combo_product_count) {
      return 0 // not eligible for discount
    } else {
      val eligibleForDiscount = (Math.floor(comboItemCount/item.combo_product_count))
      if(item.item_count >= eligibleForDiscount) {
        return (eligibleForDiscount * item.price) / 2
      } else {
        return (item.item_count * item.price) / 2
      }
    }


  private def roundToPound(num : Double) : Double =
    BigDecimal(num.toFloat/100).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble
}
