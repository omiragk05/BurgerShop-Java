import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UpdateOrder extends JFrame {
    private Burger currentBurger = null;

    private JTextField txtOrderId;
    private JLabel lblCustomerId;
    private JLabel lblCustomerName;
    private JTextField txtBurgerQty;
    private JComboBox<String> cmbStatus;
    private JLabel lblTotalPrice;

    private JButton btnSearch;
    private JButton btnUpdate;
    private JButton btnBack;

    public UpdateOrder() {
        setTitle("Burger Shop - Update Order");
        setSize(500, 420);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        JLabel lblTitle = new JLabel("Update Order Details");
        lblTitle.setFont(new Font("", Font.BOLD, 30));
        lblTitle.setHorizontalAlignment(JLabel.CENTER);
        lblTitle.setOpaque(true);
        lblTitle.setBackground(Color.RED);
        lblTitle.setForeground(Color.WHITE);
        add("North", lblTitle);

        JPanel midPanel = new JPanel();
        midPanel.setLayout(new GridLayout(7, 2, 10, 10));
        midPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        txtOrderId = new JTextField(10);
        btnSearch = new JButton("Search Order");
        btnSearch.setBackground(Color.BLUE);
        btnSearch.setForeground(Color.WHITE);
        btnSearch.setFocusPainted(false);
        btnSearch.setFont(new Font("Arial", Font.BOLD, 14));

        lblCustomerId = new JLabel("");
        lblCustomerName = new JLabel("");
        txtBurgerQty = new JTextField(10);
        txtBurgerQty.setEnabled(false);

        String[] statuses = {"Preparing", "Delivered", "Canceled"};
        cmbStatus = new JComboBox<>(statuses);
        cmbStatus.setEnabled(false);

        lblTotalPrice = new JLabel("");

        midPanel.add(new JLabel("Order ID :"));        midPanel.add(txtOrderId);
        midPanel.add(new JLabel(""));                  midPanel.add(btnSearch);
        midPanel.add(new JLabel("Customer ID :"));     midPanel.add(lblCustomerId);
        midPanel.add(new JLabel("Customer Name :"));   midPanel.add(lblCustomerName);
        midPanel.add(new JLabel("Burger Qty :"));      midPanel.add(txtBurgerQty);
        midPanel.add(new JLabel("Order Status :"));    midPanel.add(cmbStatus);
        midPanel.add(new JLabel("Total Price :"));     midPanel.add(lblTotalPrice);

        add("Center", midPanel);

        JPanel southPanel = new JPanel();
        btnUpdate = new JButton("Update Order");
        btnUpdate.setBackground(Color.GREEN);
        btnUpdate.setForeground(Color.WHITE);
        btnUpdate.setFocusPainted(false);
        btnUpdate.setFont(new Font("Arial", Font.BOLD, 14));
        btnUpdate.setEnabled(false);

        btnBack = new JButton("Back");
        btnBack.setBackground(Color.RED);
        btnBack.setForeground(Color.WHITE);
        btnBack.setFocusPainted(false);
        btnBack.setFont(new Font("Arial", Font.BOLD, 14));

        southPanel.add(btnUpdate);
        southPanel.add(btnBack);
        add("South", southPanel);

        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String orderId = txtOrderId.getText().trim();
                currentBurger = Tools.searchBurger(orderId);

                if (currentBurger == null) {
                    clearFields();
                    JOptionPane.showMessageDialog(null, "Order ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                lblCustomerId.setText(currentBurger.getCustomerId());
                lblCustomerName.setText(currentBurger.getCustomerName());
                txtBurgerQty.setText(String.valueOf(currentBurger.getBurgerCount()));
                cmbStatus.setSelectedIndex(currentBurger.getOrderStatus());
                lblTotalPrice.setText(String.valueOf(currentBurger.getOrderValue()));

                if (currentBurger.getOrderStatus() == Burger.PREPARING) {
                    txtBurgerQty.setEnabled(true);
                    cmbStatus.setEnabled(true);
                    btnUpdate.setEnabled(true);
                } else {
                    txtBurgerQty.setEnabled(false);
                    cmbStatus.setEnabled(false);
                    btnUpdate.setEnabled(false);
                    JOptionPane.showMessageDialog(
                        null,
                        "This order is already " + currentBurger.getOrderStatusString() + " and cannot be updated.",
                        "Info",
                        JOptionPane.INFORMATION_MESSAGE
                    );
                }
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (currentBurger == null) return;

                try {
                    int newQty = Integer.parseInt(txtBurgerQty.getText().trim());
                    if (newQty <= 0) {
                        JOptionPane.showMessageDialog(null, "Burger quantity must be greater than 0.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    currentBurger.setBurgerCount(newQty);
                    currentBurger.setOrderStatus(cmbStatus.getSelectedIndex());

                    if (Tools.updateBurger(currentBurger)) {
                        lblTotalPrice.setText(String.valueOf(currentBurger.getOrderValue()));
                        JOptionPane.showMessageDialog(null, "Order updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number for quantity.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
            }
        });

        setVisible(true);
    }

    private void clearFields() {
        lblCustomerId.setText("");
        lblCustomerName.setText("");
        txtBurgerQty.setText("");
        lblTotalPrice.setText("");
        txtBurgerQty.setEnabled(false);
        cmbStatus.setEnabled(false);
        btnUpdate.setEnabled(false);
    }
}