import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class DeliveredOrders extends JFrame {

    private DefaultTableModel dtm;
	private JTable tblStudentDetails;
    private int[] deliveredOrderIndexArray = new int[0];
    private JButton btnBack;
    public DeliveredOrders() {
        Burger[] burgerArray = Tools.getAllBurgers(); 
        for (int i = 0; i < burgerArray.length; i++) {
            if (burgerArray[i].getOrderStatus() == Burger.DELIVERED) {
                int[] tempArray = new int[deliveredOrderIndexArray.length + 1];
                System.arraycopy(deliveredOrderIndexArray, 0, tempArray, 0, deliveredOrderIndexArray.length);
                tempArray[tempArray.length - 1] = i;
                deliveredOrderIndexArray = tempArray;
            }
        }

        if (deliveredOrderIndexArray.length == 0) {
            JOptionPane.showMessageDialog(null, "No orders have been delivered at the moment.","Error",JOptionPane.ERROR_MESSAGE);
                    return;
        } else {
            setTitle("Burger Shop - Delivered Orders");
            setSize(500, 400);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setLayout(new BorderLayout());
            setLocationRelativeTo(null);

            JLabel lblTitle = new JLabel("Delivered Orders");
            lblTitle.setFont(new Font("", Font.BOLD, 30));
            lblTitle.setHorizontalAlignment(JLabel.CENTER);
            lblTitle.setOpaque(true);
            lblTitle.setBackground(Color.RED);
            lblTitle.setForeground(Color.WHITE);
            add(lblTitle, BorderLayout.NORTH);

            String[] columnsName={"Order ID","Customer ID","Customer Name","Burger Qty","Total Price"};
		    dtm = new DefaultTableModel(columnsName, 0);
            tblStudentDetails = new JTable(dtm);
            JScrollPane tablePane = new JScrollPane(tblStudentDetails);
            add("Center", tablePane);
            dtm.setRowCount(0);
            for (int i : deliveredOrderIndexArray) {
                Object[] rowData = {
                    burgerArray[i].getOrderId(),
                    burgerArray[i].getCustomerId(),
                    burgerArray[i].getCustomerName(),
                    burgerArray[i].getBurgerCount(),
                    burgerArray[i].getOrderValue()
                };
                dtm.addRow(rowData);
            }

            JPanel southPanel = new JPanel();
            btnBack = new JButton("Back");
            btnBack.setBackground(Color.RED);
            btnBack.setForeground(Color.WHITE);
            btnBack.setFocusPainted(false);
            btnBack.setFont(new Font("Arial", Font.BOLD, 14));
            btnBack.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    dispose();
                }
            });
            southPanel.add(btnBack);
            add("South",southPanel);

            setVisible(true);
        }
    
    }
}
