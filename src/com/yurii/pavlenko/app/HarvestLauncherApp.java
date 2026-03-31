package com.yurii.pavlenko.app;

import com.yurii.pavlenko.basket.applebasket.AppleBasket;
import com.yurii.pavlenko.fruit.Fruit;
import com.yurii.pavlenko.fruit.apple.Apple;

/**
 * Entry point for demonstrating covariant returns and type checking.
 */
public class HarvestLauncherApp {

    public static void main(String[] args) {
        // Create the specialized basket
        AppleBasket appleBasket = new AppleBasket();

        // Retrieve an item. Even though the method returns Apple,
        // it is perfectly fine to store it in a Fruit variable.
        Fruit harvestedItem = appleBasket.getFruit();

        // Verify the actual type at runtime
        if (harvestedItem instanceof Apple) {
            System.out.println("Apple created");
        }
    }
}
