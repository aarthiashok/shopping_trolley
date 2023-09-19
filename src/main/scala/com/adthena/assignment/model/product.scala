package com.adthena.assignment.model

class product (configValue: ujson.Value) {
  private var _id: Double = configValue("id").num
  private var _name: String = configValue("name").str
  private var _price: Double = configValue("price").num
  private var _count: Double = 0

  def name: String = _name
  def id: Double = _id
  def price: Double = _price
  def count: Double = _count

  def count_=(countValue: Double): Unit = {
    _count = countValue
  }
}