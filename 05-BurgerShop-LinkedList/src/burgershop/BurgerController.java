/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package burgershop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BurgerController {

    private static final String DATA_FILE = "Burger.txt";

    public static String generateOrderId() {
        int maxOrderIdNum = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(DATA_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String trimmed = line.trim();
                if (trimmed.isEmpty()) {
                    continue;
                }
                String[] parts = trimmed.split(",");
                String id = parts[0].trim();
                if (id.length() >= 2 && (id.charAt(0) == 'B' || id.charAt(0) == 'b')) {
                    try {
                        int num = Integer.parseInt(id.substring(1));
                        if (num > maxOrderIdNum) {
                            maxOrderIdNum = num;
                        }
                    } catch (NumberFormatException ignored) {
                    }
                }
            }
        } catch (IOException ex) {}

        return String.format("B%04d", maxOrderIdNum + 1);
    }

    public static boolean isCustomerIdValid(String customerId) {
        if (customerId == null || customerId.length() != 10) {
            return false;
        }
        if (customerId.charAt(0) != '0') {
            return false;
        }
        for (int i = 0; i < customerId.length(); i++) {
            if (!Character.isDigit(customerId.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isOrderPlaced(String orderId, String customerId, String customerName, String qty) {
        if (orderId == null || customerId == null || customerName == null || qty == null) {
            return false;
        }
        String cleanName = customerName.trim();
        if (cleanName.isEmpty() || cleanName.contains(",")) {
            return false;
        }
        int parsedQty;
        try {
            parsedQty = Integer.parseInt(qty.trim());
            if (parsedQty < 1) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(DATA_FILE, true))) {
            bw.write(orderId.trim() + "," + customerId.trim() + "," + cleanName + "," + parsedQty + "," + 0);
            bw.newLine();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static List allBurgerOrdersList() {
        List allBurgerList = new List();
        try (BufferedReader br = new BufferedReader(new FileReader(DATA_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    try {
                        String orderId = parts[0].trim();
                        String customerId = parts[1].trim();
                        String customerName = parts[2].trim();
                        int qty = Integer.parseInt(parts[3].trim());
                        int status = Integer.parseInt(parts[4].trim());

                        Burger burger = new Burger(orderId, customerId, customerName, qty, status);
                        allBurgerList.addLast(burger);
                    } catch (NumberFormatException ignored) {
                    }
                }
            }
        } catch (IOException ex) {}
        return allBurgerList;
    }

    // 0=Preparing 1=Delivered 2=Canceled
    public static List allBurgerOrdersListByStatus(int status) {
        List allBurgerOrdersList = allBurgerOrdersList();
        List filteredBurgerList = new List();

        for (int i = 0; i < allBurgerOrdersList.size(); i++) {
            Burger b = allBurgerOrdersList.get(i);
            if (b.getStatus() == status) {
                filteredBurgerList.addLast(b);
            }
        }

        return filteredBurgerList;
    }

    public static List getAllOrdersTopToLow() {
        List allOrders = allBurgerOrdersList(); 
        List tempList = new List();
        List uniqueCustomerList = new List(); 
        List sortedOrders = new List();

        
        for (int i = 0; i < allOrders.size(); i++) {
            tempList.addLast(allOrders.get(i));
        }

        
        for (int i = 0; i < tempList.size(); i++) {
            Burger b = tempList.get(i);
            boolean exists = false;

            for (int j = 0; j < uniqueCustomerList.size(); j++) {
                Burger existing = uniqueCustomerList.get(j);
                if (existing.getCustomerId().equalsIgnoreCase(b.getCustomerId())) {
                    exists = true;
                    break;
                }
            }

            if (!exists) {
                uniqueCustomerList.addLast(new Burger("", b.getCustomerId(), b.getCustomerName(), 0, 0));
            }
        }

        
        for (int i = 0; i < uniqueCustomerList.size(); i++) {
            Burger unique = uniqueCustomerList.get(i);
            int totalQty = 0;

            for (int j = 0; j < tempList.size(); j++) {
                Burger order = tempList.get(j);
                if (order.getCustomerId().equalsIgnoreCase(unique.getCustomerId())) {
                    totalQty += order.getQty();
                }
            }

            unique.setQty(totalQty); 
        }

        
        for (int i = 0; i < uniqueCustomerList.size() - 1; i++) {
            for (int j = i + 1; j < uniqueCustomerList.size(); j++) {
                Burger a = uniqueCustomerList.get(i);
                Burger b = uniqueCustomerList.get(j);

                if (b.getQty() > a.getQty()) {
                    
                    Burger temp = a;
                    uniqueCustomerList.set(i, b);
                    uniqueCustomerList.set(j, temp);
                }
            }
        }

        
        for (int i = 0; i < uniqueCustomerList.size(); i++) {
            Burger topCustomer = uniqueCustomerList.get(i);
            for (int j = 0; j < tempList.size(); j++) {
                Burger b = tempList.get(j);
                if (b.getCustomerId().equalsIgnoreCase(topCustomer.getCustomerId())) {
                    sortedOrders.addLast(b);
                }
            }
        }

        return sortedOrders;
    }

    public static Burger getBurgerByOrderId(String orderId) {
        if (orderId == null || orderId.trim().isEmpty()) {
            return null;
        }
        String target = orderId.trim();
        List allOrders = allBurgerOrdersList();
        for (int i = 0; i < allOrders.size(); i++) {
            Burger b = allOrders.get(i);
            if (b.getOrderId().equalsIgnoreCase(target)) {
                return b;
            }
        }
        return null;
    }

    public static List getOrdersByCustomerId(String customerId) {
        List matchingOrders = new List();
        if (customerId == null || customerId.trim().isEmpty()) {
            return matchingOrders;
        }
        String target = customerId.trim();
        List allOrders = allBurgerOrdersList();
        for (int i = 0; i < allOrders.size(); i++) {
            Burger b = allOrders.get(i);
            if (b.getCustomerId().equalsIgnoreCase(target)) {
                matchingOrders.addLast(b);
            }
        }
        return matchingOrders;
    }

    public static boolean updateOrderDetails(String orderId, int newQty, int newStatus) {
        if (orderId == null || orderId.trim().isEmpty() || newQty < 1 || newStatus < 0 || newStatus > 2) {
            return false;
        }
        String target = orderId.trim();
        List allOrders = allBurgerOrdersList();
        boolean updated = false;

        for (int i = 0; i < allOrders.size(); i++) {
            Burger b = allOrders.get(i);
            if (b.getOrderId().equalsIgnoreCase(target)) {
                if (b.getStatus() != 0) {
                    return false;
                }
                b.setQty(newQty);
                b.setStatus(newStatus);
                updated = true;
                break;
            }
        }

        if (!updated) {
            return false;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(DATA_FILE, false))) {
            for (int i = 0; i < allOrders.size(); i++) {
                Burger b = allOrders.get(i);
                bw.write(b.getOrderId() + "," + b.getCustomerId() + "," + b.getCustomerName() + "," + b.getQty() + "," + b.getStatus());
                bw.newLine();
            }
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

}
