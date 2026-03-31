### You manage a warehouse where various fruit baskets are collected.

#### - You need to keep track of which fruits go into which baskets. First, define two classes: a general Fruit class and a more specific Apple class, with Apple inheriting from Fruit.

#### - Next, create a Basket class, which will represent a regular basket. Inside Basket, implement the Fruit getFruit() method, which simply returns a new, general Fruit object. This is as if you were taking any fruit from a regular basket.

#### - But you also have specialized baskets! Create an AppleBasket class, which inherits from Basket. This basket should be specialized for apples. So, override the getFruit() method in the AppleBasket class, but this time specify that it returns an Apple object, not just a Fruit. This is called a **covariant return type**—you're returning a more specific type than the parent class.

#### - In your main method, create an AppleBasket object and call its getFruit() method. Store the result in a variable, such as harvestedItem. Then use the instanceof operator to check whether harvestedItem is actually an Apple object. If so, print "Apple created," confirming that you actually got an apple from the specialized basket.
