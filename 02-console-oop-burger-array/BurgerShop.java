import java.util.*;
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


}

class BurgerShop{

	public static Burger[] burgerArray = new Burger[0];

	public static void main(String args[]){
		Scanner input=new Scanner(System.in);
		clearConsole();
		while(true){
			System.out.println("-------------------------------------------------------");
		    System.out.println("|                     BurgerShop                      |");
		    System.out.println("-------------------------------------------------------");
		    System.out.println();
		    System.out.println("[1] Place Order               [2] Search Best Customer   ");
		    System.out.println("[3] Search Order              [4] Search Customer    ");
		    System.out.println("[5] View Order                [6] Update Order Details ");
		    System.out.println("[7] Exit                  ");
		    System.out.println();
		    int op=0;
		    
			System.out.print("Enter an option to continue > ");
			op = input.nextInt();

			switch (op)
			{
				case 1: PlaceOrder();
					break;
				case 2: BestCustomer();
					break;
				case 3: SearchOrder();
					break;
				case 4: SearchCustomer();
					break;
				case 5: ViewOrders();
					break;
				case 6: UpdateOrderDetails();
					break;
				case 7: exit();
					break;
				default:
					System.out.println("\nWrong Option. Try Again... ");
			}
		}
	}

	public static void PlaceOrder(){
		Scanner input=new Scanner(System.in);
		do{
			clearConsole();
			System.out.println("-------------------------------------------------------");
		    System.out.println("|                    PLACE ORDER                      |");
		    System.out.println("-------------------------------------------------------");
			System.out.println();
			System.out.println();
			String orderId=generateOrderId();
			System.out.println("ORDER ID - "+orderId);
			System.out.println("====================");
			System.out.println();
			String customerId;
			L2:do
			{
				System.out.println();
				System.out.print("Enter Customer ID(phone no.) : ");
				customerId = input.next();
				if (customerId.length()==10&&customerId.charAt(0)=='0')
				{
					break;
				}else
				{
					System.out.println("Wrong Customer ID. Enter The Correct One");
				}
			} while (true);


			int a=customerIdCheck(customerId);
			String customerName;
			if (a==-1)
			{
				System.out.print("Customer Name : ");
				customerName=input.next();
			}else
			{
				customerName=burgerArray[a].getCustomerName();
				System.out.println("Customer Name : "+customerName);
			}
			int burgerCount =0;
			L3:do
			{
				System.out.print("Enter Burger Quantity  - ");
				burgerCount = input.nextInt();
				if (burgerCount<=0)
				{
					System.out.println("Burger Quantity must be greater than 0");
					System.out.print("Enter correct Burger Quantity  - ");
					burgerCount = input.nextInt();
				}else
				{
					break;
				}
			} while (true);
	
			System.out.println("Total Value - "+(burgerCount*Burger.BURGERPRICE));

			L4:do{
				System.out.print("\n\tDo you confirm the order - ");
				char op=input.next().charAt(0);
				if(op=='Y'|op=='y'){

					extendsArray();
					Burger newburger=new Burger(orderId, customerId, customerName, burgerCount);
					burgerArray[burgerArray.length-1]=newburger;

					System.out.println("\n\tyour order has enterd to system succsesfully....");
					break;
					
				}else if(op=='N'|op=='n'){
					System.out.println("\n\tyour order cleared");
					break;
				}else{
					System.out.println("\tWrong option");
					continue L4;
				}
			}while(true);
			
			L5:do{
				System.out.print("\nDo you want to place another order(Y/N) : ");
				char op=input.next().charAt(0);
				if(op=='Y'|op=='y'){
					break;
				}else if(op=='N'|op=='n'){
					clearConsole();
					return;
				}else{
					System.out.println("Wrong option/try again...");
					continue L5;
				}
			}while(true);	
		}while(true);
	}

	public static int customerIdCheck(String customerId){
		for(int i=0; i<burgerArray.length; i++){
			if(customerId.equalsIgnoreCase(burgerArray[i].getCustomerId())){
				return i;
			}
		}
		return -1;
	}

		public static void extendsArray(){
		Burger[] tempBurgerArray=new Burger[burgerArray.length+1];
		for (int i = 0; i < burgerArray.length; i++){
			tempBurgerArray[i]=burgerArray[i];
		}
		burgerArray=tempBurgerArray;
	}

	public static String generateOrderId() {
		if (burgerArray.length==0){
			return "B0001";
		}
        String lastOrderId = burgerArray[burgerArray.length - 1].getOrderId();
        int x = Integer.parseInt(lastOrderId.substring(1)); 
        int temp = ++x; 
        int count = 0; 
        while (temp != 0) {
            count++;
            temp /= 10; 
        }
        switch (count) {
            case 1:
                return "B000" + x;
            case 2:
                return "B00" + x;
            case 3:
                return "B0" + x;
            default:
                return "B" + x;
        }
	}

	public static void BestCustomer(){
		Scanner input=new Scanner(System.in);
		L1:do{
			clearConsole();
			System.out.println("-------------------------------------------------------");
		    System.out.println("|                   BEST CUSTOMER                      |");
		    System.out.println("-------------------------------------------------------");
			System.out.println();
			System.out.println();
			displayBestCustomer();	
			System.out.println();
			L2:do{
				System.out.print("\tDo you want to go back to main menu(Y/N)? " );
				char op=input.next().charAt(0);
				System.out.println();
				System.out.println();
				if(op=='Y'|op=='y'){
					clearConsole();
					return;
					
				}else if(op=='N'|op=='n'){
					clearConsole();
					continue L1;
				}else{
					System.out.println("Wrong option/try again...");
					System.out.println();
					continue L2;
				}
			}while(true);
		}while(true);
	}

	public static void displayBestCustomer(){
		String[] dublicateRemovedCustomerId = new String[0];
		for (int i = 0; i < burgerArray.length; i++){
			boolean b=false;
			for (int j = 0; j < dublicateRemovedCustomerId.length; j++){
				if(burgerArray[i].getCustomerId().equalsIgnoreCase(dublicateRemovedCustomerId[j])){
					b=true;
					break;
				}
			}
			
			if(!b){
				String[] temp = new String[dublicateRemovedCustomerId.length+1];
				for (int j = 0; j < dublicateRemovedCustomerId.length; j++){
					temp[j]=dublicateRemovedCustomerId[j];
				}
				temp[temp.length-1]=burgerArray[i].getCustomerId();
				dublicateRemovedCustomerId=temp;
			}
		}
		int[] totalOrderCountOfCustomer=new int[dublicateRemovedCustomerId.length];

		for (int i = 0; i < burgerArray.length; i++){
			for (int j = 0; j < dublicateRemovedCustomerId.length; j++){
				if(burgerArray[i].getCustomerId().equalsIgnoreCase(dublicateRemovedCustomerId[j])){
					totalOrderCountOfCustomer[j]+=burgerArray[i].getBurgerCount();
				}
			}
			
		}
		
		
		for(int i=0; i<totalOrderCountOfCustomer.length-1; i++){
			for (int j = 0; j < totalOrderCountOfCustomer.length-1; j++){
				if(totalOrderCountOfCustomer[j]<totalOrderCountOfCustomer[j+1]){
					int t=totalOrderCountOfCustomer[j];
					totalOrderCountOfCustomer[j]=totalOrderCountOfCustomer[j+1];
					totalOrderCountOfCustomer[j+1]=t;

					String temp=dublicateRemovedCustomerId[j];
					dublicateRemovedCustomerId[j]=dublicateRemovedCustomerId[j+1];
					dublicateRemovedCustomerId[j+1]=temp;
				}
			}
		}

		String[] dublicateRemovedCustomerName=new String[dublicateRemovedCustomerId.length];

		for (int i = 0; i < burgerArray.length; i++){
			for (int j = 0; j < dublicateRemovedCustomerId.length; j++){
				if(burgerArray[i].getCustomerId().equalsIgnoreCase(dublicateRemovedCustomerId[j])){
					dublicateRemovedCustomerName[j]=burgerArray[i].getCustomerName();
				}
			}
			
		}
		
		System.out.println("----------------------------------------");
		System.out.println("CustomerID\tName\t\tTotal");
		System.out.println("----------------------------------------");
		for (int i = 0; i < dublicateRemovedCustomerId.length; i++)
		{
			System.out.println(dublicateRemovedCustomerId[i]+"\t"+dublicateRemovedCustomerName[i]+"\t\t"+(totalOrderCountOfCustomer[i]*Burger.BURGERPRICE));
			System.out.println("----------------------------------------");
		}
	}

	public static void SearchOrder(){
		Scanner input=new Scanner(System.in);
		do{	clearConsole();
			System.out.println("-------------------------------------------------------");
		    System.out.println("|                 SEARCH ORDER DETAILS                 |");
		    System.out.println("-------------------------------------------------------");
			System.out.println();
			System.out.println();	
			System.out.print("Enter order ID - B");
			String searchOrderId=input.next();
			searchOrderId="B"+searchOrderId;
			int result=OrderIdCheck(searchOrderId);
			System.out.println();
			System.out.println();
			if (result==-1)
			{
				System.out.print("Invalid Order ID.\tDo you want to enter again(Y/N)? " );
				
			}else
			{
				System.out.println("-----------------------------------------------------------------------------");
				System.out.println("OrderID\tCustomerID\tName\tQuantity\tOrderValue\tOrderStatus ");
				System.out.println("-----------------------------------------------------------------------------");
				System.out.println(burgerArray[result].getOrderId()+"\t"+burgerArray[result].getCustomerId()+"\t"+burgerArray[result].getCustomerName()+"\t"+burgerArray[result].getBurgerCount()+"\t\t"+(burgerArray[result].getBurgerCount()*Burger.BURGERPRICE)+"\t\t"+burgerArray[result].getOrderStatusString());
				System.out.println("-----------------------------------------------------------------------------");
				System.out.println();
				System.out.print("Do you want to search another order details (Y/N)? ");	
			}

			do{
				char op=input.next().charAt(0);
				System.out.println();
				if(op=='Y'|op=='y'){
					break;
				}else if(op=='N'|op=='n'){
					clearConsole();
					return;
				}else{
					System.out.println("Wrong option/try again...");
					System.out.print("Do you want to search another order details (Y/N)?");
					continue;
				}
			}while(true);	
			
			
		}while(true);
	}
	
	public static int OrderIdCheck(String searchOrderId){
		for(int i=0; i<burgerArray.length; i++){
			if(searchOrderId.equalsIgnoreCase(burgerArray[i].getOrderId())){
				return i;
			}
		}
		return -1;
	}


		public static void SearchCustomer(){
		Scanner input=new Scanner(System.in);
		do{	clearConsole();
			System.out.println("-------------------------------------------------------");
		    System.out.println("|               SEARCH CUSTOMER ORDER                  |");
		    System.out.println("-------------------------------------------------------");
			System.out.println();	
			System.out.print("Enter customer Id - ");
			String searchCustomerId=input.next();
			CustomerDataPrint(searchCustomerId);
			System.out.println();
			System.out.println();
			
			do{
				System.out.print("Do you want to search another customer details (Y/N)?");
				char op=input.next().charAt(0);
				System.out.println();
				if(op=='Y'|op=='y'){
					break;
				}else if(op=='N'|op=='n'){
					clearConsole();
					return;
				}else{
					System.out.println("Wrong option/try again...");
					continue;
				}
			}while(true);	
	
		}while(true);
	}

	public static void CustomerDataPrint(String searchCustomerId){
		int[] indexArray=new int[0];
		int[] tempIndexArray=new int[0];

		for(int i=0; i<burgerArray.length; i++){
			if(searchCustomerId.equalsIgnoreCase(burgerArray[i].getCustomerId())){
				tempIndexArray=new int[indexArray.length+1];
				for (int j = 0; j < indexArray.length; j++) {
					tempIndexArray[j] = indexArray[j];
			    }
				tempIndexArray[tempIndexArray.length-1]=i;
				indexArray=tempIndexArray;
			}
		}

		if (indexArray.length==0)
		{
			System.out.println();
			System.out.println();
			System.out.println("\tThis customer ID not added yet.....");
			System.out.println();
		}else
		{
			System.out.println();
			System.out.println();
			System.out.println("CustomerID - "+searchCustomerId);
			System.out.println("Name       - "+burgerArray[indexArray[0]].getCustomerName());
			System.out.println();
			System.out.println("Customer Order Details");
			System.out.println("=======================");
			System.out.println();
			System.out.println("--------------------------------------------");
			System.out.println("Order ID\tOrder Quantity\tTotal Value");
			System.out.println("--------------------------------------------");
			for (int a : indexArray) {
				System.out.println(burgerArray[a].getOrderId()+"\t\t"+burgerArray[a].getBurgerCount()+"\t\t"+burgerArray[a].getBurgerCount()*Burger.BURGERPRICE);	
			}
			System.out.println("--------------------------------------------");
		}
	}
	
	public static void ViewOrders(){
		Scanner input=new Scanner(System.in);
		do{
			clearConsole();
			System.out.println("-------------------------------------------------------");
		    System.out.println("|                VIEW ORDER LIST                       |");
		    System.out.println("-------------------------------------------------------");
			System.out.println();
			System.out.println("[1] Preparing Order");
			System.out.println("[2] Delivered Order");
			System.out.println("[3] Canceled Order");
			System.out.println();
			System.out.print("Enter an option to continue > ");
			int op=input.nextInt();

			int[] PreparingOrderIndexArray=new int[0];

			for(int i=0; i<burgerArray.length; i++){
				if(burgerArray[i].getOrderStatus()==Burger.PREPARING){
					int[] tempArray=new int[PreparingOrderIndexArray.length+1];
					for (int j = 0; j < PreparingOrderIndexArray.length; j++) {
			            tempArray[j] = PreparingOrderIndexArray[j];
			        }
					tempArray[tempArray.length-1]=i;
					PreparingOrderIndexArray=tempArray;
				}
			}
			int[] DeliveredOrderIndexArray=new int[0];

			for(int i=0; i<burgerArray.length; i++){
				if(burgerArray[i].getOrderStatus()==Burger.DELIVERED){
					int[] tempArray=new int[DeliveredOrderIndexArray.length+1];
					for (int j = 0; j < DeliveredOrderIndexArray.length; j++) {
			            tempArray[j] = DeliveredOrderIndexArray[j];
			        }
					tempArray[tempArray.length-1]=i;
					DeliveredOrderIndexArray=tempArray;
				}
			}
			int[] CanceledOrderIndexArray=new int[0];

			for(int i=0; i<burgerArray.length; i++){
				if(burgerArray[i].getOrderStatus()==Burger.CANCELED){
					int[] tempArray=new int[CanceledOrderIndexArray.length+1];
					for (int j = 0; j < CanceledOrderIndexArray.length; j++) {
			            tempArray[j] = CanceledOrderIndexArray[j];
			        }
					tempArray[tempArray.length-1]=i;
					CanceledOrderIndexArray=tempArray;
				}
			}
			switch (op)
			{
				case 1: PreparingOrders(PreparingOrderIndexArray);
					break;
				case 2: DeliveredOrders(DeliveredOrderIndexArray);
					break;
				case 3: CanceledOrders(CanceledOrderIndexArray);
					break;
				default:
					System.out.println("\nWrong Option. Try Again... ");
			}
			
			do{
				System.out.print("Do you want to view another order list (Y/N)? ");
				char op1=input.next().charAt(0);
				System.out.println();
				if(op1=='Y'|op1=='y'){
					break;
				}else if(op1=='N'|op1=='n'){
					clearConsole();
					return;
				}else{
					System.out.println("Wrong option/try again...");
					continue;
				}
			}while(true);
		
		}while(true);
		
	}
	
		public static void PreparingOrders(int[] PreparingOrderIndexArray){
		clearConsole();
		System.out.println("-------------------------------------------------------");
		System.out.println("|                PREPARING ORDERS                      |");
		System.out.println("-------------------------------------------------------");

		if (PreparingOrderIndexArray.length==0)
		{
			System.out.println();
			System.out.println();
			System.out.println("\tNo Orders Preparing Yet.....");
			System.out.println();
		}else
		{
			System.out.println();
			System.out.println();
			System.out.println("------------------------------------------------------");
			System.out.println("OrderID\tCustomerID\tName\tQuantity\tOrderValue");
			System.out.println("------------------------------------------------------");
			for (int a : PreparingOrderIndexArray) {
				System.out.println(burgerArray[a].getOrderId()+"\t"+burgerArray[a].getCustomerId()+"\t"+burgerArray[a].getCustomerName()+"\t"+burgerArray[a].getBurgerCount()+"\t\t"+burgerArray[a].getBurgerCount()*Burger.BURGERPRICE);	
				System.out.println("------------------------------------------------------");
			}
		}
		
		
	}

	public static void DeliveredOrders(int[] DeliveredOrderIndexArray){
		clearConsole();
		System.out.println("-------------------------------------------------------");
		System.out.println("|                DELIVERED ORDERS                      |");
		System.out.println("-------------------------------------------------------");

		if (DeliveredOrderIndexArray.length==0)
		{
			System.out.println();
			System.out.println();
			System.out.println("\tNo Orders Delivered Yet.....");
			System.out.println();
		}else
		{
			System.out.println();
			System.out.println();
			System.out.println("------------------------------------------------------");
			System.out.println("OrderID\tCustomerID\tName\tQuantity\tOrderValue");
			System.out.println("------------------------------------------------------");
			for (int a : DeliveredOrderIndexArray) {
				System.out.println(burgerArray[a].getOrderId()+"\t"+burgerArray[a].getCustomerId()+"\t"+burgerArray[a].getCustomerName()+"\t"+burgerArray[a].getBurgerCount()+"\t\t"+burgerArray[a].getBurgerCount()*Burger.BURGERPRICE);	
				System.out.println("------------------------------------------------------");
			}
		}
		
	}

	public static void CanceledOrders(int [] CanceledOrderIndexArray){
		clearConsole();
		System.out.println("-------------------------------------------------------");
		System.out.println("|                CANCELED ORDERS                      |");
		System.out.println("-------------------------------------------------------");

		if (CanceledOrderIndexArray.length==0)
		{
			System.out.println();
			System.out.println();
			System.out.println("\tNo Orders Canceled Yet.....");
			System.out.println();
		}else
		{
			System.out.println();
			System.out.println();
			System.out.println("------------------------------------------------------");
			System.out.println("OrderID\tCustomerID\tName\tQuantity\tOrderValue");
			System.out.println("------------------------------------------------------");
			for (int a : CanceledOrderIndexArray) {
				System.out.println(burgerArray[a].getOrderId()+"\t"+burgerArray[a].getCustomerId()+"\t"+burgerArray[a].getCustomerName()+"\t"+burgerArray[a].getBurgerCount()+"\t\t"+burgerArray[a].getBurgerCount()*Burger.BURGERPRICE);	
				System.out.println("------------------------------------------------------");
			}
		}
	}

	public static void UpdateOrderDetails(){
		Scanner input=new Scanner(System.in);
		L1:do{
			clearConsole();
			System.out.println("-------------------------------------------------------");
		    System.out.println("|               UPDATE ORDER DETAILS                   |");
		    System.out.println("-------------------------------------------------------");
			System.out.println();
			do{
				System.out.print("Enter order Id - B");
				String searchOrderId=input.next();
				searchOrderId="B"+searchOrderId;
				int result=OrderIdCheck(searchOrderId);
				System.out.println();
				if (result==-1)
				{
					System.out.print("Invalid Order ID.\tDo you want to enter again(Y/N)? " );
					char op=input.next().charAt(0);
					System.out.println();
					System.out.println();
					if(op=='Y'|op=='y'){
						clearConsole();
						continue L1;
					}else if(op=='N'|op=='n'){
						clearConsole();
						return;
					}else{
						System.out.println("Wrong option/try again...");
						System.out.print("Do you want to update another order details (Y/N)?");
						continue;
					}
				}else{
					UpdateOrderDetailsDisplay(result);
					break;
				}
			
			}while(true);
			
			do{
				char op=input.next().charAt(0);
				System.out.println();
				if(op=='Y'|op=='y'){
					break;
				}else if(op=='N'|op=='n'){
					clearConsole();
					return;
				}else{
					System.out.println("Wrong option/try again...");
					System.out.print("Do you want to update another order details (Y/N)?");
					continue;
				}
			}while(true);

		}while(true);
	}


	public static void UpdateOrderDetailsDisplay(int index){
		Scanner input=new Scanner(System.in);
		int OrderStatus=burgerArray[index].getOrderStatus();
		if (OrderStatus==Burger.DELIVERED)
		{
			System.out.println("This order is already delivered... You can not update this order...");
			System.out.println();
		}else if (OrderStatus==Burger.CANCELED)
		{
			System.out.println("This order is already canceled... You can not update this order...");
			System.out.println();
		}else
		{
			System.out.println("OrderID    - "+burgerArray[index].getOrderId());
			System.out.println("CustomerID - "+burgerArray[index].getCustomerId());
			System.out.println("Name       - "+burgerArray[index].getCustomerName());
			System.out.println("Quantity   - "+burgerArray[index].getBurgerCount());
			System.out.println("OrderValue - "+(burgerArray[index].getBurgerCount()*Burger.BURGERPRICE));
			System.out.println("OrderStatus- "+(burgerArray[index].getOrderStatusString()));
			do
			{
				System.out.println();
				System.out.println("What do you want to update ?");
				System.out.println("\t[1] Quantity");
				System.out.println("\t[2] Status");
				System.out.println();
				System.out.print("Enter your option - ");
				int op=input.nextInt();
				if(op==1){
					UpdateQuantity(index);
					break;
				}else if(op==2){
					UpdateStatus(index);
					break;
				}else{
					System.out.println("\nWrong option/try again...");
					continue;
				}
			} while (true);
			System.out.println("");
		}
		System.out.println();
		System.out.print("Do you want to update another order details (Y/N)? ");
		
		
		
	}

	public static void UpdateQuantity(int index){
		Scanner input=new Scanner(System.in);
		clearConsole();
		System.out.println("Quantity Update");
		System.out.println("=================");
		System.out.println();
		System.out.println("OrderID    - "+burgerArray[index].getOrderId());
		System.out.println("CustomerID - "+burgerArray[index].getCustomerId());
		System.out.println("Name       - "+burgerArray[index].getCustomerName());
		do{
			System.out.println();
			System.out.print("Enter your new quantity value - ");
			int newQty=input.nextInt();

			if (newQty<=0)
			{
				System.out.println("Burger Quantity must be greater than 0");
				continue;
			}else
			{
				burgerArray[index].setBurgerCount(newQty);
				System.out.println();
				System.out.println("\tupdate order quantity successfull");
				System.out.println();
				break;
			}
		} while (true);

		System.out.println("new order quantity - "+burgerArray[index].getBurgerCount());
		System.out.println("new order value    - "+(burgerArray[index].getBurgerCount()*Burger.BURGERPRICE));

	}


	public static void UpdateStatus(int index){
		Scanner input=new Scanner(System.in);
		clearConsole();
		System.out.println("Status Update");
		System.out.println("=================");
		System.out.println();
		System.out.println("OrderID    - "+burgerArray[index].getOrderId());
		System.out.println("CustomerID - "+burgerArray[index].getCustomerId());
		System.out.println("Name       - "+burgerArray[index].getCustomerName());

		System.out.println();
		System.out.println("\t[1] Delivered");
		System.out.println("\t[2] Cancel");
		do{
			System.out.println();
			System.out.print("Enter your new order status - ");
			int newStatus=input.nextInt();

			if (newStatus==Burger.DELIVERED)
			{
				burgerArray[index].setOrderStatus(Burger.DELIVERED);
				System.out.println();
				System.out.println("\tupdate order status successfull");
				System.out.println();
				break;
			}else if (newStatus==Burger.CANCELED)
			{
				burgerArray[index].setOrderStatus(Burger.CANCELED);
				System.out.println();
				System.out.println("\tupdate order status successfull");
				System.out.println();
				break;
				
			}else
			{
				System.out.println("Wrong option/try again...");
				continue;
			}
		} while (true);

		System.out.println("new order status - "+burgerArray[index].getOrderStatusString());
		System.out.println();
	}
	
	
	
	

	public static void exit(){ 
		clearConsole(); 
		System.out.println("\n\t\tYou left the program...\n"); 
		System.exit(0); 
	}
	
	public final static void clearConsole(){
    	try{
        	final String os = System.getProperty("os.name");

        if(os.contains("Windows")) {
            new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
        }else{
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    	}catch(final Exception e){
        e.printStackTrace();
   	 	}
	}
}
