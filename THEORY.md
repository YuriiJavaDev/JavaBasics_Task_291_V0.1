## Method override, @Override annotation

### 1. Method Overriding

In life, situations often arise where a "child" class behaves in a unique way. For example, all animals can make sounds, but a cat's is "meow," a dog's is "woof," and a programmer's is "oops, another bug!" In programming, this is accomplished through method overriding.

Method overriding is when a subclass provides its own implementation of a method already declared in the parent class. In other words, it "replaces" the standard behavior with its own, more specific behavior.

Analogy: If you imagine a parent class as a signature borscht recipe, then method overriding is like grandma adding her secret ingredient. Borscht is still borscht, but everyone has their own unique taste.

To override a method, you need to declare a method in the child class with the exact same signature (name, parameters, return type) as the parent class.

#### Example: Animals and Their Sounds

```java
class Animal {
void makeSound() {
System.out.println("Some generic animal sound");
}
}

class Dog extends Animal {
// Override the makeSound() method
void makeSound() {
System.out.println("Woof!");
}
}

class Cat extends Animal {
// Override the makeSound() method
void makeSound() {
System.out.println("Meow!");
}
}
```

Now, if you create a **Dog** object and call **makeSound()**, you'll hear "**Woof!**" instead of "**Some generic animal sound**".

#### Code Demonstration

```java
public class Main {
public static void main(String[] args) {
Animal generic = new Animal();
Dog dog = new Dog();
Cat cat = new Cat();

generic.makeSound(); // Some generic animal sound
dog.makeSound(); // Woof!
cat.makeSound(); // Meow!
}
}
```

**Important:** If the subclass doesn't have a method with the same signature, the parent method will be used.

### 2. The @Override Annotation: What It's For and How to Use It

In Java, it's common to mark overridden methods with the special **@Override** annotation. This isn't just a code decoration, but a useful tool:

- **The compiler checks** whether you're actually overriding the parent method. If you misspell a parameter name, type, or return type, the compiler will generate an error.
- **Improves code readability.** Another programmer immediately sees, "Oh, this method overrides its parent."

#### Example with @Override

```java
class Dog extends Animal {
@Override
void makeSound() {
System.out.println("Woof!");
}
}
```

If you accidentally write **void makeSond()** (a typo!) in a method marked as **@Override**, the compiler will complain: **"Method does not override or implement a method from a supertype"**.

**Modern Standards.** Using **@Override** is good practice and an industry standard. Even if the compiler doesn't require it, always use this annotation—it will make life easier for both you and your colleagues.

### 3. How Calling an Overridden Method Works

When you call a method on a subclass object, the subclass's implementation will be used, even if the variable is declared as the parent type.

**Example: Polymorphism in Action**

```java
Animal animal = new Dog();
animal.makeSound(); // "Woof!", not "Some generic animal sound"
```

Here, the variable is of type **Animal**, but it actually contains a **Dog** object. Java "understands" that it needs to call the overridden method from **Dog**. This is **polymorphism** (more details in the following lectures).

### 4. Overriding Restrictions and Rules

**Method Signature**

- The name, type, and order of the parameters must match the method in the parent. - The return type must be the same as or a *covariant* (subtype of the parent's return type). For example, if the parent returns **Animal** and the child returns **Dog**, this is permitted.

**Access Modifiers**

- Access cannot be more restrictive than the parent's.
- If the parent method is **public**, then the overridden method must also be public.
- If the parent is **protected**, then the overridden method can be **protected** or **public**.

If you try to do the opposite, the compiler will say: "**Cannot reduce the visibility of the inherited method**".

**Exceptions**

- An overridden method cannot throw a new checked exception that is not in the parent's declaration.
- It is allowed to throw fewer exceptions than the parent, or their subtypes.

**static, final, private**

- You cannot override methods declared as **static** or **final**, nor can you override private methods.
- **static** is hiding, not overriding.
- **final** cannot be overridden at all; Java protects such methods.
- **private** is not visible in the inheritor and cannot be overridden (you can only declare a new method with the same name).

**Constructors**

Constructors cannot be inherited or overridden. Each class has its own constructors.

### 5. Developing the Zoo Tutorial

It's time to put theory into practice! Let's continue developing our zoo app.

#### Step 1. The Animal Base Class

```java
public class Animal {
public void makeSound() {
System.out.println("Some generic animal sound");
}

public void sleep() {
System.out.println("Zzz...");
}
}
```

#### Step 2. The Dog and Cat Subclasses

```java
public class Dog extends Animal {
@Override
public void makeSound() {
System.out.println("Woof!");
}

// Additional method just for Dog
public void fetch() {
System.out.println("Dog brings the stick!");
}
}

public class Cat extends Animal {
@Override
public void makeSound() {
System.out.println("Meow!");
}

// Additional method just for Cat
public void scratch() {
System.out.println("Cat scratches the sofa!");
}
}
```

#### Step 3. Using override

```java
public class ZooTest {
public static void main(String[] args) {
Animal generic = new Animal();
Animal dog = new Dog();
Animal cat = new Cat();

generic.makeSound(); // Some generic animal sound
dog.makeSound(); // Woof!
cat.makeSound(); // Meow!

// dog.fetch(); // Error! Animal variable doesn't know about fetch()
// cat.scratch(); // Similar

// But if you explicitly specify the type:
if (dog instanceof Dog) {
((Dog) dog).fetch(); // Dog brings the stick!
}
if (cat instanceof Cat) {
((Cat) cat).scratch(); // Cat scratches the sofa!
}
}
}
```

**Comment:**

The **makeSound()** method works polymorphically—the version from the object's actual class is called. However, specific methods (**fetch**, **scratch**) are only accessible through explicit type casting—this is important for understanding how inheritance and overriding work.

### 6. Example with a return type (covariance)

Sometimes you want an overridden method to return a narrower type. For example:

```java
class Animal {
Animal getFriend() {
return new Animal();
}
}

class Dog extends Animal {
@Override
Dog getFriend() { // Return type is Dog, a subtype of Animal
return new Dog();
}
}
```

This is called return type covariance and is allowed in Java (since Java 5).

### 7. What happens if you don't use @Override?

If you accidentally misspell a method name or parameters, Java won't complain unless the @Override annotation is present. As a result, you'll create a new method rather than override it, and the expected behavior won't change.

**Error example**

```java
class Dog extends Animal {
// Typo: makeSoud instead of makeSound
void makeSoud() {
System.out.println("Woof!");
}
}

public class Main {
public static void main(String[] args) {
Animal dog = new Dog();
dog.makeSound(); // Outputs "Some generic animal sound"
}
}
```

If **@Override** were present, the compiler would generate an error: **"Method does not override or implement a method from a supertype"**.

### 8. Common Errors in Method Overriding

**Error #1: Missing @Override Annotation.**

Without it, it's easy to mistype a method name or parameters. As a result, the method won't be overridden, and the program won't behave as expected.

**Error #2: Attempting to narrow the access modifier.**

If the parent method is **public**, and you write **protected** or **private**, you'll get a compilation error.

**Error #3: Signature mismatch.**

If the parameters differ even by type, it's not overriding, but overloading.

**Error #4: Attempting to override a final or static method.**

Java won't allow this: final protects against overriding, and static methods aren't overridden at all (they're just hidden).

**Error #5: Changing the return type to an incompatible one.**

You can only return a subtype of the parent's return type (covariance), not a completely different type.
