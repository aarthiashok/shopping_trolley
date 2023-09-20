import com.adthena.assignment.ShopBasketProcessor

object Main {
  def main(args: Array[String]): Unit = {
    var basket = new ShopBasketProcessor()
    basket.getInputFromUser()
    basket.calculateTotal()
  }
}
