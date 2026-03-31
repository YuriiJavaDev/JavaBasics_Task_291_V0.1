# Covariant Return Types: Fruit Harvest (JavaBasics_Task_291_V0.1)

## 📖 Description
In Java, **Covariant Return Types** allow an overriding method to return a subtype of the type returned by the original method in the superclass. This project illustrates this using a "Basket" hierarchy. While a generic `Basket` provides a generic `Fruit`, a specialized `AppleBasket` is guaranteed to provide an `Apple`. This feature reduces the need for explicit type casting and makes the API of specialized classes much more intuitive and type-safe.

## 📋 Requirements Compliance
- **Class Hierarchy**: Established `Fruit` -> `Apple` and `Basket` -> `AppleBasket` relationships.
- **Covariant Overriding**: Redefined `getFruit()` in `AppleBasket` to return `Apple` instead of `Fruit`.
- **Type Verification**: Used the `instanceof` operator to confirm the runtime type of the returned object.
- **Polymorphism**: Demonstrated that a specialized return still satisfies the superclass contract.
- **Clean Architecture**: Strictly separated the domain entities from the `HarvestLauncherApp`.

## 🚀 Architectural Stack
- Java 8+ (Inheritance, Covariant Returns, Type Checking)

## 🏗️ Implementation Details
- **Fruit / Apple**: The data models representing the items being harvested.
- **Basket / AppleBasket**: The factory-like classes demonstrating method specialization.
- **HarvestLauncherApp**: The bootstrap class for verifying the harvest results.

## 📋 Expected result
```text
Apple created
```

## 💻 Code Example

Project Structure:

    JavaBasics_Task_291/
    ├── src/
    │   └── com/yurii/pavlenko/
    │                 ├── app/
    │                 │   └── HarvestLauncherApp.java
    │                 ├── basket/
    │                 │   ├── applebasket/
    │                 │   │   └── AppleBasket.java
    │                 │   └── Basket.java
    │                 └── fruit/
    │                     ├── apple/
    │                     │   └── Apple.java
    │                     └── Fruit.java
    ├── .gitignore
    ├── JavaBasics_Task_291_V0.1.iml
    ├── LICENSE
    └── README.md

Code
```java
package com.yurii.pavlenko.app;

import com.yurii.pavlenko.basket.applebasket.AppleBasket;
import com.yurii.pavlenko.fruit.Fruit;
import com.yurii.pavlenko.fruit.apple.Apple;

public class HarvestLauncherApp {

    public static void main(String[] args) {

        AppleBasket appleBasket = new AppleBasket();
        Fruit harvestedItem = appleBasket.getFruit();

        if (harvestedItem instanceof Apple) {
            System.out.println("Apple created");
        }
    }
}
```
```java
package com.yurii.pavlenko.fruit.apple;

import com.yurii.pavlenko.fruit.Fruit;

public class Apple extends Fruit {
    // Specific apple properties
}
```
```java
package com.yurii.pavlenko.basket.applebasket;

import com.yurii.pavlenko.basket.Basket;
import com.yurii.pavlenko.fruit.apple.Apple;

public class AppleBasket extends Basket {
 
    @Override
    public Apple getFruit() {
        return new Apple();
    }
}
```

## ⚖️ License
This project is licensed under the **MIT License**.

Copyright (c) 2026 Yurii Pavlenko

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files...

License: [MIT](LICENSE)
