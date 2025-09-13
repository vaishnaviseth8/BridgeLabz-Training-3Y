package TypesofInheritance;

class Order {
    protected String orderId;
    protected String orderDate;

    public Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return "Order placed";
    }

    public void displayInfo() {
        System.out.println("Order ID    : " + orderId);
        System.out.println("Order Date  : " + orderDate);
        System.out.println("Status      : " + getOrderStatus());
        System.out.println("-----------------------------");
    }
}

class ShippedOrder extends Order {
    protected String trackingNumber;

    public ShippedOrder(String orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    public String getOrderStatus() {
        return "Order shipped (Tracking: " + trackingNumber + ")";
    }

    @Override
    public void displayInfo() {
        System.out.println("Order ID    : " + orderId);
        System.out.println("Order Date  : " + orderDate);
        System.out.println("Tracking No.: " + trackingNumber);
        System.out.println("Status      : " + getOrderStatus());
        System.out.println("-----------------------------");
    }
}

class DeliveredOrder extends ShippedOrder {
    private String deliveryDate;

    public DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String getOrderStatus() {
        return "Order delivered on " + deliveryDate;
    }

    @Override
    public void displayInfo() {
        System.out.println("Order ID    : " + orderId);
        System.out.println("Order Date  : " + orderDate);
        System.out.println("Tracking No.: " + trackingNumber);
        System.out.println("Delivery Date: " + deliveryDate);
        System.out.println("Status      : " + getOrderStatus());
        System.out.println("-----------------------------");
    }
}

public class RetailSystem {
    public static void main(String[] args) {
        Order o = new Order("ORD1001", "2025-09-01");
        ShippedOrder s = new ShippedOrder("ORD1002", "2025-09-02", "TRK123456");
        DeliveredOrder d = new DeliveredOrder("ORD1003", "2025-09-03", "TRK789101", "2025-09-05");

        o.displayInfo();
        s.displayInfo();
        d.displayInfo();
    }
}
