import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class SearchOrderByCustomerID extends JFrame{
    private String CustomerID="";
    private JLabel lblOrderId = new JLabel("");
    private JLabel lblCustomerName = new JLabel("");
    private JLabel lblBurgerQty = new JLabel("");
    private JLabel lblOrderStatus = new JLabel("");
    private JLabel lblTotalPrice = new JLabel("");
    private JButton btnGoHome;
    private JButton btnCheckOrder;

	SearchOrderByCustomerID(){
		setTitle("Burger Shop - Search Order");
		setSize(500, 400);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);

		JLabel lblTitle=new JLabel("Search Order By Customer ID");
		lblTitle.setFont(new Font("",1,30));
		lblTitle.setHorizontalAlignment(JLabel.CENTER);
		lblTitle.setOpaque(true);
		lblTitle.setBackground(Color.RED);
        lblTitle.setForeground(Color.WHITE);
		add("North",lblTitle);
		
		
		JPanel MidPanel = new JPanel();
		MidPanel.setLayout(new GridLayout(7, 2, 10, 10));

		JLabel l1 = new JLabel("Customer ID :");
        JLabel l2= new JLabel("");
		JLabel l3 = new JLabel("Order ID : ");
		JLabel l4 = new JLabel("Customer Name :");
		JLabel l5 = new JLabel("Burger Qty :");
		JLabel l6 = new JLabel("Order Status :");
        JLabel l7 = new JLabel("Total Price :");

        JTextField txtCustomerID = new JTextField(10);
        btnCheckOrder = new JButton("Check Order");
        btnCheckOrder.setBackground(Color.BLUE);
        btnCheckOrder.setForeground(Color.WHITE);
        btnCheckOrder.setFocusPainted(false);
        btnCheckOrder.setFont(new Font("Arial", Font.BOLD, 14));
        btnCheckOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CustomerID = txtCustomerID.getText();
                Burger[] burgerArray = Tools.getAllBurgers();
                boolean orderFound = false;
                for (Burger burger : burgerArray) {
                    if (burger.getCustomerId().equalsIgnoreCase(CustomerID)) {
                        lblOrderId.setText(burger.getOrderId());
                        lblCustomerName.setText(burger.getCustomerName());
                        lblBurgerQty.setText(String.valueOf(burger.getBurgerCount()));
                        lblOrderStatus.setText(burger.getOrderStatusString());
                        lblTotalPrice.setText(String.valueOf(burger.getOrderValue()));
                        orderFound = true;
                        break;
                    }
                }
                if (!orderFound) {
                    lblOrderId.setText("");
                    lblCustomerName.setText("");
                    lblBurgerQty.setText("");
                    lblOrderStatus.setText("");
                    lblTotalPrice.setText("");
                    JOptionPane.showMessageDialog(null, "Customer ID not found.", "Error", JOptionPane.ERROR_MESSAGE);
                    
                }
            }
        });

        MidPanel.add(l1);MidPanel.add(txtCustomerID);
        MidPanel.add(l2);MidPanel.add(btnCheckOrder);
        MidPanel.add(l3);MidPanel.add(lblOrderId);
        MidPanel.add(l4);MidPanel.add(lblCustomerName);
        MidPanel.add(l5);MidPanel.add(lblBurgerQty);
        MidPanel.add(l6);MidPanel.add(lblOrderStatus);
        MidPanel.add(l7);MidPanel.add(lblTotalPrice);
        add("Center",MidPanel);
        


        JPanel southPanel = new JPanel();
        btnGoHome = new JButton("Back");
        btnGoHome.setBackground(Color.RED);
        btnGoHome.setForeground(Color.WHITE);
        btnGoHome.setFocusPainted(false);
        btnGoHome.setFont(new Font("Arial", Font.BOLD, 14));
        btnGoHome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
            }
        });
        southPanel.add(btnGoHome);
        add("South", southPanel);
        setVisible(true);
    }
}