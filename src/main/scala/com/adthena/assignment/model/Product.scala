package com.adthena.exercise.model

import scala.util.Try

class Product (configValue: ujson.Value) {
  private var _id: Int = configValue("id").num.toInt
  private var _name: String = configValue("name").str
  private var _price: Int = configValue("price").num.toInt
  private var _item_count: Int = 0
  val discountConfig : ujson.Value = configValue("discount").obj
  private var _discount_type: String = Try(discountConfig("type").str).getOrElse("NO_DISCOUNT")
  private var _discount_value: Int = Try(discountConfig("value").num.toInt).getOrElse(0)
  private var _discount_description: String = Try(discountConfig("description").str).getOrElse("")
  private var _combo_product_count: Int =  Try(discountConfig("combo-product-count").num.toInt).getOrElse(0)
  private var _combo_product_id: Int =Try(discountConfig("combo-product-id").num.toInt).getOrElse(0)

  def name: String = _name
  def id: Int = _id
  def price: Int = _price
  def item_count: Int = _item_count

  def discount_type: String = _discount_type
  def discount_value: Int = _discount_value
  def discount_description: String = _discount_description
  def combo_product_count: Int = _combo_product_count
  def combo_product_id: Int = _combo_product_id

  def item_count_=(countValue: Int): Unit = {
    _item_count = countValue
  }
}