package com.yurii.pavlenko.basket.applebasket;

import com.yurii.pavlenko.basket.Basket;
import com.yurii.pavlenko.fruit.apple.Apple;

/**
 * Specialized container for apples.
 */
public class AppleBasket extends Basket {
    /**
     * Overrides the method to return a more specific type (Apple).
     * This is a "Covariant Return Type".
     */
    @Override
    public Apple getFruit() {
        return new Apple();
    }
}
