import java.util.*;
class BurgerShop{
	
	public static int[] IntOrderId = new int[0];
	public static String[] StrOrderId = new String[0];
	public static String[] CusId = new String[0];
	public static String[] CusName = new String[0];
	public static int[] BurgerCount = new int[0];
	public final static double BURGERPRICE=500;
    public static int[] OrderSat = new int[0];
    public static final int PREPARING = 0;
    public static final int DELIVERED = 1;
    public static final int CANCEL = 2;	
	public static final String[] Sat = {"PREPARING","DELIVERED","CANCEL"};
	
	public static void BestCustomer(){
		Scanner input=new Scanner(System.in);
		L1:do{
			clearConsole();
			System.out.println("-------------------------------------------------------");
		    System.out.println("|                   BEST CUSTOMER                      |");
		    System.out.println("-------------------------------------------------------");
			System.out.println();
			System.out.println();
			BestCustomerProcess();	
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
	
	public static void BestCustomerProcess(){
		String[] cusidstring = new String[0];
		for (int i = 0; i < CusId.length; i++){
			boolean b=false;
			for (int j = 0; j < cusidstring.length; j++){
				if(CusId[i].equalsIgnoreCase(cusidstring[j])){
					b=true;
					break;
				}
			}
			
			if(!b){
				String[] temp = new String[cusidstring.length+1];
				for (int j = 0; j < cusidstring.length; j++){
					temp[j]=cusidstring[j];
				}
				temp[temp.length-1]=CusId[i];
				cusidstring=temp;
			}
		}
		int[] bcordercount=new int[cusidstring.length];
		
		for (int i = 0; i < CusId.length; i++){
			for (int j = 0; j < cusidstring.length; j++){
				if(CusId[i].equalsIgnoreCase(cusidstring[j])){
					bcordercount[j]+=BurgerCount[i];
				}
			}
			
		}
		
		
		for(int i=0; i<bcordercount.length-1; i++){
			for (int j = 0; j < bcordercount.length-1; j++){
				if(bcordercount[j]<bcordercount[j+1]){
					int t=bcordercount[j];
					bcordercount[j]=bcordercount[j+1];
					bcordercount[j+1]=t;

					String temp=cusidstring[j];
					cusidstring[j]=cusidstring[j+1];
					cusidstring[j+1]=temp;
				}
			}
		}
		
		String[] bcName=new String[cusidstring.length];
		
		for (int i = 0; i < CusName.length; i++){
			for (int j = 0; j < cusidstring.length; j++){
				if(CusId[i].equalsIgnoreCase(cusidstring[j])){
					bcName[j]=CusName[i];
				}
			}
			
		}
		
		System.out.println("----------------------------------------");
		System.out.println("CustomerID\tName\t\tTotal");
		System.out.println("----------------------------------------");
		for (int i = 0; i < cusidstring.length; i++)
		{
			
			System.out.println(cusidstring[i]+"\t"+bcName[i]+"\t\t"+(bcordercount[i]*BURGERPRICE));
			System.out.println("----------------------------------------");
		}
	}

	public static void SatUpdateOrderDetails(int a){
		Scanner input=new Scanner(System.in);
		int x=OrderSat[a];
		if (x==1)
		{
			System.out.println("This order is already delivered... You can not update this order...");
			System.out.println();
		}else if (x==2)
		{
			System.out.println("This order is already canceled... You can not update this order...");
			System.out.println();
		}else
		{
			System.out.println("OrderID    - "+StrOrderId[a]);
			System.out.println("CustomerID - "+CusId[a]);
			System.out.println("Name       - "+CusName[a]);
			System.out.println("Quantity   - "+BurgerCount[a]);
			System.out.println("OrderValue - "+(BurgerCount[a]*BURGERPRICE));
			System.out.println("OrderStatus- "+Sat[OrderSat[a]]);
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
					UpdateQuantity(a);
					break;
				}else if(op==2){
					UpdateStatus(a);
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
	
	public static void UpdateQuantity(int a){
		Scanner input=new Scanner(System.in);
		clearConsole();
		System.out.println("Quantity Update");
		System.out.println("=================");
		System.out.println();
		System.out.println("OrderID    - "+StrOrderId[a]);
		System.out.println("CustomerID - "+CusId[a]);
		System.out.println("Name       - "+CusName[a]);
		do{
			System.out.println();
			System.out.print("Enter your new quantity value - ");
			int newvalue=input.nextInt();
			
			if (newvalue<=0)
			{
				System.out.println("Burger Quantity must be greater than 0");
				continue;
			}else
			{
				BurgerCount[a]=newvalue;
				System.out.println();
				System.out.println("\tupdate order quantity successfull");
				System.out.println();
				break;
			}
		} while (true);
		
		System.out.println("new order quantity - "+BurgerCount[a]);
		System.out.println("new order value    - "+(BurgerCount[a]*BURGERPRICE));
		
	}
	
	
	public static void UpdateStatus(int a){
		Scanner input=new Scanner(System.in);
		clearConsole();
		System.out.println("Status Update");
		System.out.println("=================");
		System.out.println();
		System.out.println("OrderID    - "+StrOrderId[a]);
		System.out.println("CustomerID - "+CusId[a]);
		System.out.println("Name       - "+CusName[a]);
		
		System.out.println();
		System.out.println("\t[1] Delivered");
		System.out.println("\t[2] Cancel");
		do{
			System.out.println();
			System.out.print("Enter your new order status - ");
			int newsat=input.nextInt();
			
			if (newsat==1)
			{
				OrderSat[a]=1;
				System.out.println();
				System.out.println("\tupdate order status successfull");
				System.out.println();
				break;
			}else if (newsat==2)
			{
				OrderSat[a]=2;
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
		
		System.out.println("new order status - "+Sat[OrderSat[a]]);
		System.out.println();
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
				String searchorderid=input.next();
				searchorderid="B"+searchorderid;
				int result=OrderIdCheak(searchorderid);
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
					SatUpdateOrderDetails(result);
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
	
	
	public static void SearchOrder(){
		Scanner input=new Scanner(System.in);
		do{	clearConsole();
			System.out.println("-------------------------------------------------------");
		    System.out.println("|                 SEARCH ORDER DETAILS                 |");
		    System.out.println("-------------------------------------------------------");
			System.out.println();
			System.out.println();	
			System.out.print("Enter order ID - B");
			String searchorderid=input.next();
			searchorderid="B"+searchorderid;
			int result=OrderIdCheak(searchorderid);
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
				System.out.println(StrOrderId[result]+"\t"+CusId[result]+"\t"+CusName[result]+"\t"+BurgerCount[result]+"\t\t"+BurgerCount[result]*BURGERPRICE+"\t\t"+(OrderSat[result]==0?Sat[0]:OrderSat[result]==1?Sat[1]:Sat[2]));
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
	
	public static int OrderIdCheak(String searchorderid){
		for(int i=0; i<StrOrderId.length; i++){
			if(searchorderid.equalsIgnoreCase(StrOrderId[i])){
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
			String searchcusid=input.next();
			CusDataPrint(searchcusid);
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
	
	public static void CusDataPrint(String searchcusid){
		int[] x=new int[0];  //indexes array
		int[] tempx=new int[0];
		
		for(int i=0; i<CusId.length; i++){
			if(searchcusid.equalsIgnoreCase(CusId[i])){
				tempx=new int[x.length+1];
				for (int j = 0; j < x.length; j++) {
					tempx[j] = x[j];
			    }
				tempx[tempx.length-1]=i;
				x=tempx;
			}
		}
		
		if (x.length==0)
		{
			System.out.println();
			System.out.println();
			System.out.println("\tThis customer ID not added yet.....");
			System.out.println();
		}else
		{
			System.out.println();
			System.out.println();
			System.out.println("CustomerID - "+searchcusid);
			System.out.println("Name       - "+CusName[x[0]]);
			System.out.println();
			System.out.println("Customer Order Details");
			System.out.println("=======================");
			System.out.println();
			System.out.println("--------------------------------------------");
			System.out.println("Order ID\tOrder Quantity\tTotal Value");
			System.out.println("--------------------------------------------");
			for (int a : x) {
				System.out.println(StrOrderId[a]+"\t\t"+BurgerCount[a]+"\t\t"+BurgerCount[a]*BURGERPRICE);	
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
			System.out.println("[1] Delivered Order");
			System.out.println("[2] Preparing Order");
			System.out.println("[3] Canceled Order");
			System.out.println();
			System.out.print("Enter an option to continue > ");
			int op=input.nextInt();
			
			int[] x=new int[0];
			int[] tempx=new int[0];
			
			for(int i=0; i<OrderSat.length; i++){
				if(OrderSat[i]==0){
					tempx=new int[x.length+1];
					for (int j = 0; j < x.length; j++) {
			            tempx[j] = x[j];
			        }
					tempx[tempx.length-1]=i;
					x=tempx;
				}
			}
			int[] y=new int[0];
			int[] tempy=new int[0];
			
			for(int i=0; i<OrderSat.length; i++){
				if(OrderSat[i]==1){
					tempy=new int[y.length+1];
					for (int j = 0; j < y.length; j++) {
			            tempy[j] = y[j];
			        }
					tempy[tempy.length-1]=i;
					y=tempy;
				}
			}
			int[] z=new int[0];
			int[] tempz=new int[0];
			
			for(int i=0; i<OrderSat.length; i++){
				if(OrderSat[i]==2){
					tempz=new int[z.length+1];
					for (int j = 0; j < z.length; j++) {
			            tempz[j] = z[j];
			        }
					tempz[tempz.length-1]=i;
					z=tempz;
				}
			}
			switch (op)
			{
				case 1: DeliveredOrders(y);
					break;
				case 2: PreparingOrders(x);
					break;
				case 3: CanceledOrders(z);
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
	
	public static void DeliveredOrders(int[] y){
		clearConsole();
		System.out.println("-------------------------------------------------------");
		System.out.println("|                DELIVERED ORDERS                      |");
		System.out.println("-------------------------------------------------------");

		if (y.length==0)
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
			for (int a : y) {
				System.out.println(StrOrderId[a]+"\t"+CusId[a]+"\t"+CusName[a]+"\t"+BurgerCount[a]+"\t\t"+BurgerCount[a]*BURGERPRICE);	
				System.out.println("------------------------------------------------------");
			}
		}
		
	}
	public static void PreparingOrders(int[] x){
		clearConsole();
		System.out.println("-------------------------------------------------------");
		System.out.println("|                PREPARING ORDERS                      |");
		System.out.println("-------------------------------------------------------");

		if (x.length==0)
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
			for (int a : x) {
				System.out.println(StrOrderId[a]+"\t"+CusId[a]+"\t"+CusName[a]+"\t"+BurgerCount[a]+"\t\t"+BurgerCount[a]*BURGERPRICE);	
				System.out.println("------------------------------------------------------");
			}
		}
		
		
	}
	public static void CanceledOrders(int [] z){
		clearConsole();
		System.out.println("-------------------------------------------------------");
		System.out.println("|                CANCELED ORDERS                      |");
		System.out.println("-------------------------------------------------------");

		if (z.length==0)
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
			for (int a : z) {
				System.out.println(StrOrderId[a]+"\t"+CusId[a]+"\t"+CusName[a]+"\t"+BurgerCount[a]+"\t\t"+BurgerCount[a]*BURGERPRICE);	
				System.out.println("------------------------------------------------------");
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
			int newintorderid =NewIdCreate();
			String newstrorderid=NewSIdCreate(newintorderid);
			System.out.println("ORDER ID - "+newstrorderid);
			System.out.println("====================");
			System.out.println();
			String newcusid;
			L2:do
			{
				System.out.println();
				System.out.print("Enter Customer ID(phone no.) : ");
				newcusid = input.next();
				if (newcusid.length()==10&&newcusid.charAt(0)=='0')
				{
					break;
				}else
				{
					System.out.println("Wrong Customer ID. Enter The Correct One");
				}
			} while (true);
			
	
			int a=CusIdCheak(newcusid);
			String newcusname;
			if (a==-1)
			{
				System.out.print("Customer Name : ");
				newcusname=input.next();
			}else
			{
				newcusname=CusName[a];
				System.out.println("Customer Name : "+CusName[a]);
			}
			int newburgercount =0;
			L3:do
			{
				System.out.print("Enter Burger Quantity  - ");
				newburgercount = input.nextInt();
				if (newburgercount<=0)
				{
					System.out.println("Burger Quantity must be greater than 0");
					System.out.print("Enter correct Burger Quantity  - ");
					newburgercount = input.nextInt();
				}else
				{
					break;
				}
			} while (true);
	
			int newordersat=PREPARING;
			
			System.out.println("Total Value - "+(newburgercount*BURGERPRICE));
			
			L4:do{
				System.out.print("\n\tDo you confirm the order - ");
				char op=input.next().charAt(0);
				if(op=='Y'|op=='y'){
					
					IncreseIntOrderId(newintorderid);
					IncreseStrOrderId(newstrorderid);
					IncreseCusId(newcusid);
					IncreseCusName(newcusname);
					IncreseBurgerCount(newburgercount);
					IncreseOrderSat(newordersat);
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
	
	public static void IncreseIntOrderId(int a){
		int[] tempIntOrderId= new int[IntOrderId.length+1];
		for (int i = 0; i < IntOrderId.length; i++)
		{
			tempIntOrderId[i]=IntOrderId[i];	
		}
		tempIntOrderId[tempIntOrderId.length-1]=a;
		IntOrderId=tempIntOrderId;
	}
		
	public static void IncreseStrOrderId(String a){
		String[] tempStrOrderId= new String[StrOrderId.length+1];
		for (int i = 0; i < StrOrderId.length; i++)
		{
			tempStrOrderId[i]=StrOrderId[i];	
		}
		tempStrOrderId[tempStrOrderId.length-1]=a;
		StrOrderId=tempStrOrderId;
	}
	public static void IncreseCusId(String a){
		String[] tempCusId= new String[CusId.length+1];
		for (int i = 0; i < CusId.length; i++)
		{
			tempCusId[i]=CusId[i];	
		}
		tempCusId[tempCusId.length-1]=a;
		CusId=tempCusId;
	}
	public static void IncreseCusName(String a){
		String[] tempCusName= new String[CusName.length+1];
		for (int i = 0; i < CusName.length; i++)
		{
			tempCusName[i]=CusName[i];	
		}
		tempCusName[tempCusName.length-1]=a;
		CusName=tempCusName;
	}
	public static void IncreseBurgerCount(int a){
		int[] tempBurgerCount= new int[BurgerCount.length+1];
		for (int i = 0; i < BurgerCount.length; i++)
		{
			tempBurgerCount[i]=BurgerCount[i];	
		}
		tempBurgerCount[tempBurgerCount.length-1]=a;
		BurgerCount=tempBurgerCount;
	}
	public static void IncreseOrderSat(int a){
		int[] tempOrderSat= new int[OrderSat.length+1];
		for (int i = 0; i < OrderSat.length; i++)
		{
			tempOrderSat[i]=OrderSat[i];	
		}
		tempOrderSat[tempOrderSat.length-1]=a;
		OrderSat=tempOrderSat;
	}
	
	
	
	public static int NewIdCreate(){
		int newintorderid=0;
		if (IntOrderId.length==0)
		{
			newintorderid=1;
		}else
		{
			newintorderid=IntOrderId[IntOrderId.length-1]+1;							
		}
		return newintorderid;
		
		
	}  
	public static String NewSIdCreate(int newintorderid){
		String newstrorderid;
		if (newintorderid<=9)
		{
			newstrorderid ="B000"+newintorderid;
		}else if (newintorderid<=99)
		{
			newstrorderid="B00"+newintorderid;
		}else if (newintorderid<=999)
		{
			newstrorderid="B0"+newintorderid;
		}else
		{
			newstrorderid="B"+newintorderid;
		}
		return newstrorderid;
	}

	public static int CusIdCheak(String newcusid){
		for(int i=0; i<CusId.length; i++){
			if(newcusid.equalsIgnoreCase(CusId[i])){
				return i;
			}
		}
		return -1;
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
