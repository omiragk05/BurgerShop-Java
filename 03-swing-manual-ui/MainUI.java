import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MainUI extends JFrame{
	private JButton btnPlaceOrder;
	private	JButton btnSearchOrder;
	private	JButton btnViewOrder;
	private	JButton btnUpdateOrder;
	private	JButton btnExit;
	MainUI(){
		setTitle("Burger Shop");
		setSize(500, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
	
		JPanel westPanel = new JPanel();
		westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));
		JLabel lblTitle = new JLabel("Welcome to Burgers");
		lblTitle.setFont(new Font("", Font.BOLD, 25));
		lblTitle.setForeground(Color.ORANGE);
		lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
	   
		ImageIcon icon = new ImageIcon("1.png");
		Image img = icon.getImage();
		Image scaledImg = img.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImg);
		
		JLabel lblImage = new JLabel(scaledIcon);
		lblImage.setAlignmentX(Component.CENTER_ALIGNMENT);
	
		westPanel.add(lblTitle);
		westPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		westPanel.add(lblImage);
		
		add("West",westPanel);
	

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(5, 1, 0, 10));
	
		btnPlaceOrder = new JButton("Place Order");
		btnPlaceOrder.setBackground(Color.RED);
		btnPlaceOrder.setForeground(Color.WHITE);
		btnPlaceOrder.setFocusPainted(false);
		btnPlaceOrder.setFont(new Font("Arial", Font.BOLD, 14));
		btnPlaceOrder.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new PlaceOrder().setVisible(true);
			}
		});
		buttonPanel.add(btnPlaceOrder);		
		
		btnSearchOrder = new JButton("Search Orders");
		btnSearchOrder.setBackground(Color.RED);
		btnSearchOrder.setForeground(Color.WHITE);
		btnSearchOrder.setFocusPainted(false);
		btnSearchOrder.setFont(new Font("Arial", Font.BOLD, 14));
		btnSearchOrder.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new SearchOrdersUI().setVisible(true);
			}
		});
		buttonPanel.add(btnSearchOrder);
		
		btnViewOrder = new JButton("View Orders");
		btnViewOrder.setBackground(Color.RED);
		btnViewOrder.setForeground(Color.WHITE);
		btnViewOrder.setFocusPainted(false);
		btnViewOrder.setFont(new Font("Arial", Font.BOLD, 14));
		btnViewOrder.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new ViewOrdersUI().setVisible(true);
			}
		});
		buttonPanel.add(btnViewOrder);
		
		btnUpdateOrder = new JButton("Update Order Details");
		btnUpdateOrder.setBackground(Color.RED);
		btnUpdateOrder.setForeground(Color.WHITE);
		btnUpdateOrder.setFocusPainted(false);
		btnUpdateOrder.setFont(new Font("Arial", Font.BOLD, 14));
		btnUpdateOrder.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new UpdateOrder().setVisible(true);
			}
		});
		buttonPanel.add(btnUpdateOrder);
		
		btnExit = new JButton("Exit");
		btnExit.setBackground(Color.RED);
		btnExit.setForeground(Color.WHITE);
		btnExit.setFocusPainted(false);
		btnExit.setFont(new Font("Arial", Font.BOLD, 14));
		btnExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				System.out.println("\n\t\tYou left the program...\n"); 
				System.exit(0);
			}
		});
		buttonPanel.add(btnExit);

		add("East",buttonPanel);
		setVisible(true);
	}
}


