package burgershop;

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

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getQty() {
        return qty;
    }

    public int getStatus() {
        return status;
    }

    public String getStatusString() {
        return getStatusString(status);
    }

    public static String getStatusString(int status) {
        if (status == 0) {
            return "Preparing";
        } else if (status == 1) {
            return "Delivered";
        } else {
            return "Canceled";
        }
    }

    @Override
    public String toString() {
        return orderId + "-" + customerId + "-" + customerName + "-" + qty + "-" + status;
    }

    /**
     * @return the orderStatus
     */
    public int getOrderStatus() {
        return status;
    }

    /**
     * @param orderStatus the orderStatus to set
     */
    public void setOrderStatus(int orderStatus) {
        this.status = orderStatus;
    }

    public boolean equals(Burger burger) {
        return burger != null && orderId != null && orderId.equalsIgnoreCase(burger.orderId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Burger)) {
            return false;
        }
        return equals((Burger) obj);
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int compareByQty(Burger other) {
        return Integer.compare(this.qty, other.qty);
    }

    public boolean isSameCustomer(Burger other) {
        return this.customerId.equalsIgnoreCase(other.customerId);
    }
}
