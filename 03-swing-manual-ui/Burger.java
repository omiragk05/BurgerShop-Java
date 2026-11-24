class Burger{

	public final static double BURGERPRICE=500.00;
    
    public static final int PREPARING = 0;
    public static final int DELIVERED = 1;
    public static final int CANCELED = 2;	

	private String orderId;
	private String customerId;
	private String customerName;
	private int burgerCount;
	private int orderStatus;

	public Burger(String orderId, String customerId, String customerName, int burgerCount){
		this.orderId=orderId;
		this.customerId=customerId;
		this.customerName=customerName;
		this.burgerCount=burgerCount;
		this.orderStatus=PREPARING;
	}
	public Burger(){}

	public String getOrderId(){
		return orderId;
	}
	public String getCustomerId(){
		return customerId;
	}
	public String getCustomerName(){
		return customerName;	
	}
	public int getBurgerCount(){
		return burgerCount;
	}
	public double getOrderValue(){
		return burgerCount*BURGERPRICE;
	}
	public int getOrderStatus(){
		return orderStatus;
	}

	public String getOrderStatusString(){
		if (orderStatus == PREPARING) {
			return "Preparing";
		} else if (orderStatus == DELIVERED) {
			return "Delivered";
		} else {
			return "Canceled";
		}
	}

	public void setBurgerCount(int burgerCount){
		this.burgerCount=burgerCount;
	}
	public void setOrderStatus(int orderStatus){
		this.orderStatus=orderStatus;
	}
	public String getId(){
		return orderId;
	}

}