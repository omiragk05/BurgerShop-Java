# BurgerShop Java 

<p align="center">
  <img src="https://raw.githubusercontent.com/omiragk05/BurgerShop-Java/refs/heads/main/03-swing-manual-ui/1.png" alt="BurgerShop Logo" width="250" />
</p>

A simple BurgerShop POS system developed using Java. This repository documents the full progression of the application—starting from a console program using parallel arrays and evolving into a NetBeans Swing desktop application backed by file I/O, a custom Linked List, and a controller layer.

## Tech Stack
- **Language:** Java (JDK 11 & JDK 17)
- **GUI Framework:** Java Swing (`javax.swing`, `java.awt`)
- **Editors & IDE:** Geany (Stages 1–3), Apache NetBeans with Ant (Stages 4–5)
- **Storage:** Parallel Arrays → Object Arrays → Text File I/O (`Burger.txt`) → Custom Linked List + File I/O

## Project Progression

| Stage | Folder | Architecture & Concepts Covered |
| :--- | :--- | :--- |
| **Stage 1** | [`01-console-parallel-arrays/`](./01-console-parallel-arrays) | Procedural console app using 6 parallel arrays with manual array resizing. |
| **Stage 2** | [`02-console-oop-burger-array/`](./02-console-oop-burger-array) | Object-Oriented console app introducing the `Burger` model class and a `Burger[]` array. |
| **Stage 3** | [`03-swing-manual-ui/`](./03-swing-manual-ui) | Hand-coded Java Swing multi-window GUI (`JFrame`, `JTable`, layouts) backed by a `Burger[]` array. |
| **Stage 4** | [`04-BurgerShop-GUI-FileIO/`](./04-BurgerShop-GUI-FileIO) | NetBeans GUI Builder desktop app with persistent text file storage (`Burger.txt`). |
| **Stage 5** | [`05-BurgerShop-LinkedList/`](./05-BurgerShop-LinkedList) | Refactored NetBeans GUI using a custom `List` (Linked List), `BurgerController`, and file I/O. |

## Core Features
- **Place Order:** Auto-generated Order IDs, quantity validation, and automatic price calculation (500.00 per burger).
- **Search Orders:** Look up orders by Order ID or Customer ID.
- **Best / Top Customer:** Aggregates total spend per customer and ranks them in descending order.
- **View Orders:** Filter orders by status (*Preparing*, *Delivered*, *Canceled*) or view all orders.
- **Update Order Details:** Modify burger quantity or update order status for active (*Preparing*) orders.

## How to Run
- **Stages 1–3 (Command Line):** Navigate into the stage folder, compile with `javac *.java`, and run `java BurgerShop`.
- **Stages 4–5 (NetBeans):** Open Apache NetBeans → **File** → **Open Project** → select the stage folder → click **Run**.

## License
This project is licensed under the terms of the [LICENSE](./LICENSE) file.
