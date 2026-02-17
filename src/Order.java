public class Order {
    private int orderID;
    private int customerID;
    private String restaurantName;
    private String foodOrdered;
    private String dateOrdered;
    private double totalAmount;

    public Order(int orderID, int customerID, String restaurantName, String foodOrdered, String dateOrdered, double totalAmount) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.restaurantName = restaurantName;
        this.foodOrdered = foodOrdered;
        this.dateOrdered = dateOrdered;
        this.totalAmount = totalAmount;
    }

    // Getters and Setters
    public int getOrderID() { return orderID; }
    public int getCustomerID() { return customerID; }
    public String getRestaurantName() { return restaurantName; }
    public String getFoodOrdered() { return foodOrdered; }
    public String getDateOrdered() { return dateOrdered; }
    public double getTotalAmount() { return totalAmount; }

    public void setOrderID(int orderID) { this.orderID = orderID; }
    public void setCustomerID(int customerID) { this.customerID = customerID; }
    public void setRestaurantName(String restaurantName) { this.restaurantName = restaurantName; }
    public void setFoodOrdered(String foodOrdered) { this.foodOrdered = foodOrdered; }
    public void setDateOrdered(String dateOrdered) { this.dateOrdered = dateOrdered; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
}