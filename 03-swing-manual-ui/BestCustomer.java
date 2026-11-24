import java.awt.*;
import javax.swing.*;

public class BestCustomer {
    BestCustomer() {
        Burger[] burgerArray = Tools.getAllBurgers();
        String[] dublicateRemovedCustomerId = new String[0];
        for (int i = 0; i < burgerArray.length; i++) {
            boolean b = false;
            for (int j = 0; j < dublicateRemovedCustomerId.length; j++) {
                if (burgerArray[i].getCustomerId().equalsIgnoreCase(dublicateRemovedCustomerId[j])) {
                    b = true;
                    break;
                }
            }

            if (!b) {
                String[] temp = new String[dublicateRemovedCustomerId.length + 1];
                for (int j = 0; j < dublicateRemovedCustomerId.length; j++) {
                    temp[j] = dublicateRemovedCustomerId[j];
                }
                temp[temp.length - 1] = burgerArray[i].getCustomerId();
                dublicateRemovedCustomerId = temp;
            }
        }

        int[] totalOrderCountOfCustomer = new int[dublicateRemovedCustomerId.length];
        for (int i = 0; i < burgerArray.length; i++) {
            for (int j = 0; j < dublicateRemovedCustomerId.length; j++) {
                if (burgerArray[i].getCustomerId().equalsIgnoreCase(dublicateRemovedCustomerId[j])) {
                    totalOrderCountOfCustomer[j] += burgerArray[i].getBurgerCount();
                }
            }
        }

        for (int i = 0; i < totalOrderCountOfCustomer.length - 1; i++) {
            for (int j = 0; j < totalOrderCountOfCustomer.length - 1; j++) {
                if (totalOrderCountOfCustomer[j] < totalOrderCountOfCustomer[j + 1]) {
                    int t = totalOrderCountOfCustomer[j];
                    totalOrderCountOfCustomer[j] = totalOrderCountOfCustomer[j + 1];
                    totalOrderCountOfCustomer[j + 1] = t;

                    String temp = dublicateRemovedCustomerId[j];
                    dublicateRemovedCustomerId[j] = dublicateRemovedCustomerId[j + 1];
                    dublicateRemovedCustomerId[j + 1] = temp;
                }
            }
        }

        String[] dublicateRemovedCustomerName = new String[dublicateRemovedCustomerId.length];
        for (int i = 0; i < burgerArray.length; i++) {
            for (int j = 0; j < dublicateRemovedCustomerId.length; j++) {
                if (burgerArray[i].getCustomerId().equalsIgnoreCase(dublicateRemovedCustomerId[j])) {
                    dublicateRemovedCustomerName[j] = burgerArray[i].getCustomerName();
                }
            }
        }

        String[] columnNames = {"CustomerID", "Name", "Total"};
        Object[][] data = new Object[dublicateRemovedCustomerId.length][3];

        for (int i = 0; i < dublicateRemovedCustomerId.length; i++) {
            data[i][0] = dublicateRemovedCustomerId[i];
            data[i][1] = dublicateRemovedCustomerName[i];
            data[i][2] = totalOrderCountOfCustomer[i] * Burger.BURGERPRICE;
        }

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        JFrame frame = new JFrame("Best Customers");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
