import org.scalatest.funsuite.AnyFunSuite
import com.adthena.assignment.ShopBasketProcessor
import com.adthena.assignment.model.Product

val mockJson1: String =
  """
    |{
    |   "id": 4,
    |   "name": "Apple",
    |   "price": 100,
    |   "discount": {
    |     "type": "PERCENTAGE_DISCOUNT",
    |     "value": 10,
    |     "description": "Apples 10% off"
    |   }
    | }
    """.stripMargin


class ShopBasketProcessorTest extends AnyFunSuite:
test("ShopBasketProcessor.PercentageDiscount") {
  var item = new Product(ujson.read(mockJson1))
  item.item_count = (4)
  var basket = new ShopBasketProcessor()
  assert(basket.calculatePercentageDiscount(item) === 40)
}