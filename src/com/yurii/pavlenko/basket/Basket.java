package com.yurii.pavlenko.basket;

import com.yurii.pavlenko.fruit.Fruit;

/**
 * Base class for a fruit container.
 */
public class Basket {
    /**
     * Retrieves a generic fruit from the basket.
     * @return a new Fruit object
     */
    public Fruit getFruit() {
        return new Fruit();
    }
}
