import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class PlaceOrder extends JFrame{
    private String OrderId=Tools.generateBurgerId();
    private String CustomerID=Tools.generateCustomerId();
    private double Price=0.0;

	PlaceOrder(){
		setTitle("Burger Shop - Place Order");
		setSize(500, 400);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		
		JLabel lblTitle=new JLabel("Place Order");
		lblTitle.setFont(new Font("",1,30));
		lblTitle.setHorizontalAlignment(JLabel.CENTER);
		lblTitle.setOpaque(true);
		lblTitle.setBackground(Color.RED);
        lblTitle.setForeground(Color.WHITE);
		add("North",lblTitle);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(4, 1, 0, 10));
	
		JButton btnPlaceOrder = new JButton("Place Order");
		btnPlaceOrder.setBackground(Color.GREEN);
		btnPlaceOrder.setForeground(Color.WHITE);
		btnPlaceOrder.setFocusPainted(false);
		btnPlaceOrder.setFont(new Font("Arial", Font.BOLD, 14));
		buttonPanel.add(btnPlaceOrder);		
		
		JButton btnMainui = new JButton("Go To Home");
		btnMainui.setBackground(Color.RED);
		btnMainui.setForeground(Color.WHITE);
		btnMainui.setFocusPainted(false);
		btnMainui.setFont(new Font("Arial", Font.BOLD, 14));
		buttonPanel.add(btnMainui);
		
		JLabel lblEmpty1 = new JLabel("");
		buttonPanel.add(lblEmpty1);

		JButton btnShowPrice = new JButton("Calculate Price");
        btnShowPrice.setBackground(Color.BLUE);
		btnShowPrice.setForeground(Color.WHITE);
		btnShowPrice.setFocusPainted(false);
		btnShowPrice.setFont(new Font("", Font.BOLD, 14));
		buttonPanel.add(btnShowPrice);
		add("East",buttonPanel);
		
		JPanel WestPanel = new JPanel();
		WestPanel.setLayout(new GridLayout(6, 2, 10, 10));
		
		JLabel l1 = new JLabel("Order ID :");
		JLabel l2 = new JLabel("CustomerID : ");
		JLabel l3 = new JLabel("Customer Name :");
		JLabel l4 = new JLabel("Burger Qty :");
		JLabel l5 = new JLabel("Order Status :");
        JLabel l6 = new JLabel("Total Price :");
		
        JLabel t1 = new JLabel(OrderId);
		JLabel t2 = new JLabel(CustomerID);
        JTextField t3= new JTextField(10);
        JTextField t4 = new JTextField(10);
        JLabel t5 = new JLabel("Preparing");
        JLabel t6 = new JLabel(String.valueOf(Price));

        WestPanel.add(l1);WestPanel.add(t1);
        WestPanel.add(l2);WestPanel.add(t2);
        WestPanel.add(l3);WestPanel.add(t3);
        WestPanel.add(l4);WestPanel.add(t4);
        WestPanel.add(l5);WestPanel.add(t5);
        WestPanel.add(l6);WestPanel.add(t6);


        btnShowPrice.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(t4.getText().isEmpty()||Integer.parseInt(t4.getText())<1){
                    JOptionPane.showMessageDialog(null, "Please enter correct burger quantity","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }else{
                int qty=Integer.parseInt(t4.getText());
                Price=qty*Burger.BURGERPRICE;
                t6.setText(String.valueOf(Price));
                }
            }
        });
        btnMainui.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                dispose();
                
            }
        });

        btnPlaceOrder.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(t3.getText().isEmpty()||t4.getText().isEmpty()||Integer.parseInt(t4.getText())<1){
                    JOptionPane.showMessageDialog(null, "Please enter all the fields correctly","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }else{
                String name=t3.getText();
                int qty=Integer.parseInt(t4.getText());
                Burger burger=new Burger(OrderId,CustomerID,name,qty);
                if(Tools.addBurger(burger)){
                    JOptionPane.showMessageDialog(null, "Order placed successfully!\nYour Order ID is "+OrderId,"Success",JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    new PlaceOrder().setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Order not placed!","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                }
            }
        });
        
		add("West",WestPanel);
        setVisible(true);
	}
}

