Coding assignment for Shopping Trolley

Problem Statement:

To write a scala program and the corresponding unit tests for the shopping items which are chosen to purchase.

Given Trolley items:

Soup – 65p per tin
Bread – 80p per loaf
Milk – £1.30 per bottle
Apples – £1.00 per bag

Discounts need to be applied :

Apples have 10% off their normal price this week
Buy 2 tins of soup and get a loaf of bread for half price

The program should accept a list of items in the basket and output the subtotal, the special offer discounts and the final price. 

Input should be via the command line in the form PriceBasket item1 item2 item3 

Solution:

This application was developed using scala 3. The products are input from the user.
According to the selection of items discounts and combo offers are applied.
Finally, total price is calculated from the actual price and the discounted price.
Test cases are written using scala test.

How to Run:

1. Clone the repo to local. 
2. Open the repository dir from InteliJ Idea IDE
3. Right click the src/main/scala/com.adthena.assignment/main file
4. And select "Run"

------------------------------------------------

Provide count for the item Milk

2

Provide count for the item Soup

2

Provide count for the item Bread

0

Provide count for the item Apple

0

Sub Total £ 3.9

(No offers available)

Total Price After discount £ 3.9

--------------------------------------------------

Provide count for the item Milk

1

Provide count for the item Soup

4

Provide count for the item Bread

3

Provide count for the item Apple

2

Buy 2 tins of soup and get a loaf of bread for half price : 80.0 p

Apples 10% off : 20.0 p

Sub Total £ 8.3

Total Price After discount £ 7.3
