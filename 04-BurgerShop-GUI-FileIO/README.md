
# Stage 4: NetBeans GUI with File I/O

Rebuilds the desktop interface using the Apache NetBeans GUI Builder (`.form` files) and introduces persistent storage so orders are saved to and loaded from `Burger.txt`.

## Concepts Demonstrated
- NetBeans Swing GUI Designer (`.form` layouts and generated UI code)
- File I/O persistence (`Burger.txt`) for reading, writing, and updating order records
- Expanded views including `ViewAllOrders`, `EditOrderDetails`, and `FindTopCustomer`
- Package organization (`burgershop`)

## Project Structure
- `Burger.txt` — Persistent text file storing order records.
- `src/burgershop/BurgerShop.java` — Entry point.
- `src/burgershop/Burger.java` — Order model class.
- `src/burgershop/*.java` & `*.form` — NetBeans GUI forms (`MainUI`, `PlaceOrder`, `EditOrderDetails`, `FindTopCustomer`, `SearchOrderUI`, `ViewOrderUI`, `ViewAllOrders`, etc.).

## How to Run
1. Open **Apache NetBeans**.
2. Go to **File → Open Project** and select `04-BurgerShop-GUI-FileIO`.
3. Right-click the project and click **Run** (or press `F6`).
