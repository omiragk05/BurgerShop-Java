import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class SearchOrdersUI extends JFrame{
	private JButton btnBestCustomer;
	private	JButton btnSearchByOrderID;
	private	JButton btnSearchByCustomerID;
	private	JButton btnGoHome;
	SearchOrdersUI(){
		setTitle("Burger Shop - Search Orders");
		setSize(500, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
	
		JPanel westPanel = new JPanel();
		westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));
		JLabel lblTitle = new JLabel("Search Orders");
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
		buttonPanel.setLayout(new GridLayout(4, 1, 0, 10));

		btnBestCustomer = new JButton("Best Customer");
		btnBestCustomer.setBackground(Color.RED);
		btnBestCustomer.setForeground(Color.WHITE);
		btnBestCustomer.setFocusPainted(false);
		btnBestCustomer.setFont(new Font("Arial", Font.BOLD, 14));
            btnBestCustomer.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
					Burger[] burgerArray = Tools.getAllBurgers(); 
                    if (burgerArray.length == 0) {
                        JOptionPane.showMessageDialog(null, "No orders have been Added at the moment.", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        new BestCustomer();
                    }
                }
            });

            buttonPanel.add(btnBestCustomer);

		btnSearchByOrderID = new JButton("Search By Order ID");
		btnSearchByOrderID.setBackground(Color.RED);
		btnSearchByOrderID.setForeground(Color.WHITE);
		btnSearchByOrderID.setFocusPainted(false);
		btnSearchByOrderID.setFont(new Font("Arial", Font.BOLD, 14));
		btnSearchByOrderID.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new SearchOrderByOrderID();
			}
		});
		buttonPanel.add(btnSearchByOrderID);

		btnSearchByCustomerID = new JButton("Search By Customer ID");
		btnSearchByCustomerID.setBackground(Color.RED);
		btnSearchByCustomerID.setForeground(Color.WHITE);
		btnSearchByCustomerID.setFocusPainted(false);
		btnSearchByCustomerID.setFont(new Font("Arial", Font.BOLD, 14));
		btnSearchByCustomerID.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new SearchOrderByCustomerID();
			}
		});
		buttonPanel.add(btnSearchByCustomerID);

		btnGoHome = new JButton("Go To Home");
		btnGoHome.setBackground(Color.RED);
		btnGoHome.setForeground(Color.WHITE);
		btnGoHome.setFocusPainted(false);
		btnGoHome.setFont(new Font("Arial", Font.BOLD, 14));
		btnGoHome.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
                dispose();
			}
		});
		buttonPanel.add(btnGoHome);

		add("East",buttonPanel);
		setVisible(true);
	}
}


