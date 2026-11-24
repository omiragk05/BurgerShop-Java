/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package burgershop;

/**
 *
 * @author omira
 */
public class Burger {
    private String orderId;
    private String customerId;
    private String customerName;
    private int qty;
    private int status;

    public Burger(String orderId, String customerId, String customerName, int qty, int status) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.qty = qty;
        this.status = status;
    }

    public String getOrderId() { return orderId; }
    public String getCustomerId() { return customerId; }
    public String getCustomerName() { return customerName; }
    public int getQty() { return qty; }
    public int getStatus() { return status; }

    public String getStatusString() {
       if(status==0){
           return "Preparing";
       }else if(status==1){
           return "Deliverded";
       }else{
           return "Canceled";
       }
    }
}
