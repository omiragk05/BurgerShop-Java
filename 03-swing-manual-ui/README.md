
# Stage 3: Hand-Coded Java Swing GUI

Transitions the application from the console to a multi-window desktop GUI built entirely in Java Swing without a drag-and-drop form builder. Data is managed in memory via a `Burger[]` array in `Tools.java`.

## Concepts Demonstrated
- Java Swing components (`JFrame`, `JPanel`, `JButton`, `JLabel`, `JTextField`, `JComboBox`, `JTable`, `JOptionPane`)
- Layout managers (`BorderLayout`, `GridLayout`, `BoxLayout`)
- Event handling with `ActionListener`
- Separation of UI frames, data model (`Burger`), and data helper (`Tools`)

## Key Files
- `BurgerShop.java` — Application entry point (launches `MainUI`).
- `Burger.java` & `Tools.java` — Order model and in-memory array storage.
- `MainUI.java`, `PlaceOrder.java`, `UpdateOrder.java` — Core navigation and order management windows.
- `SearchOrdersUI.java`, `SearchOrderByOrderID.java`, `SearchOrderByCustomerID.java`, `BestCustomer.java` — Search and customer ranking windows.
- `ViewOrdersUI.java`, `ProcessingOrders.java`, `DeliveredOrders.java`, `CanceledOrders.java` — Status-filtered order tables.
- `1.png` — UI banner image asset.

## How to Run
```bash
javac *.java
java BurgerShop
