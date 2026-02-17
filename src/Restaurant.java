public class Restaurant {
    private int id;
    private String name;
    private String address;
    private String email;
    private String food1;
    private double price1;
    private String food2;
    private double price2;
    private String food3;
    private double price3;

    public Restaurant(int id, String name, String address, String email, String food1, double price1, String food2, double price2, String food3, double price3) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.food1 = food1;
        this.price1 = price1;
        this.food2 = food2;
        this.price2 = price2;
        this.food3 = food3;
        this.price3 = price3;
    }

    public Restaurant(int id, String name, String address, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getEmail() { return email; }
    public String getFood1() { return food1; }
    public double getPrice1() { return price1; }
    public String getFood2() { return food2; }
    public double getPrice2() { return price2; }
    public String getFood3() { return food3; }
    public double getPrice3() { return price3; }
    
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setAddress(String address) { this.address = address; }
    public void setEmail(String email) { this.email = email; }
    public void setFood1(String food1) { this.food1 = food1; }
    public void setPrice1(double price1) { this.price1 = price1; }
    public void setFood2(String food2) { this.food2 = food2; }
    public void setPrice2(double price2) { this.price2 = price2; }
    public void setFood3(String food3) { this.food3 = food3; }
    public void setPrice3(double price3) { this.price3 = price3; }
}