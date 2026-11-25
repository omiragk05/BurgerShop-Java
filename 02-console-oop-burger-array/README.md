# Stage 2: Console App (OOP & Burger Array)

Refactors Stage 1 into an Object-Oriented design. Replaces the six parallel arrays with a `Burger` model class and stores all orders in a single `Burger[]` array.

## Concepts Demonstrated
- Encapsulation (`private` fields with getters and setters in `Burger`)
- Constructors and static constants (`BURGERPRICE`, `PREPARING`, `DELIVERED`, `CANCELED`)
- Storing custom objects in a dynamically resized `Burger[]` array
- String-based Order ID generation

## Files
- `BurgerShop.java` — Contains the `Burger` model class and the `BurgerShop` console application.

## How to Run
```bash
javac BurgerShop.java
java BurgerShop
