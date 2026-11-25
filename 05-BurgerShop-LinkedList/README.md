# Stage 5: NetBeans GUI with Custom Linked List & Controller

The final and most structured version of the application. Replaces raw array handling with a custom `List` (Linked List) data structure and centralizes business logic and file I/O inside a dedicated `BurgerController` class.

## Concepts Demonstrated
- Custom Linked List implementation (`List.java`)
- Separation of concerns with a Controller layer (`BurgerController.java`)
- Persistent File I/O (`Burger.txt`) integrated with the Linked List
- Full NetBeans Swing desktop GUI

## Project Structure
- `Burger.txt` — Persistent text file storing order records.
- `src/burgershop/BurgerShop.java` — Entry point.
- `src/burgershop/Burger.java` — Order model class.
- `src/burgershop/List.java` — Custom Linked List data structure.
- `src/burgershop/BurgerController.java` — Handles CRUD operations, search, sorting, and file I/O.
- `src/burgershop/*.java` & `*.form` — NetBeans GUI forms (`MainUI`, `PlaceOrder`, `EditOrderDetails`, `FindTopCustomer`, `SearchOrderUI`, `ViewOrderUI`, `ViewAllOrders`, etc.).

## How to Run
1. Open **Apache NetBeans**.
2. Go to **File → Open Project** and select `05-BurgerShop-LinkedList`.
3. Right-click the project and click **Run** (or press `F6`).
