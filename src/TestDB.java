import java.sql.Connection;
//import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestDB {

    private static final String URL = "jdbc:mysql://localhost:3306/fooddeliveryDB"; // replace with your hostname and port if different
    private static final String USER = "root"; // replace with your MySQL username
    private static final String PASSWORD = "Um@ir@h7402"; // replace with your MySQL password

    public static List<Customer> customerList = new ArrayList<>();
    public static List<Restaurant> restaurantList = new ArrayList<>();
    
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the database.");
            //DatabaseMetaData dbMetaData = connection.getMetaData(); 
            Scanner scanner = new Scanner(System.in);
            boolean exit = false;

            populateCustomerList(connection);
            populateRestaurantList(connection);
            
            while (!exit) {
                System.out.println("\nMain Menu:");
                System.out.println("1. Register a Customer");
                System.out.println("2. Register a Restaurant");
                System.out.println("3. Display All Customers");
                System.out.println("4. Display All Restaurants");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        registerCustomer(connection, scanner);
                        break;
                    case 2:
                        registerRestaurant(connection, scanner);
                        break;
                    case 3:
                        readCustomer(connection);
                        break;
                    case 4:
                        readRestaurants(connection);
                        break;
                    case 5:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
            connection.close();
            scanner.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//main()
    
    public static void populateCustomerList(Connection connection) throws SQLException {
        String query = "SELECT * FROM customer";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            int id = resultSet.getInt("customerID");
            String name = resultSet.getString("customerName");
            String address = resultSet.getString("customerHomeAddress");
            String email = resultSet.getString("customerEmail");
            Customer cust = new Customer(id, name, address, email);
            customerList.add(cust);
        }
        resultSet.close();
        statement.close();
    }
    
    public static void populateRestaurantList(Connection connection) throws SQLException {
        String query = "SELECT * FROM restaurant";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            int id = resultSet.getInt("restaurantID");
            String name = resultSet.getString("restaurantName");
            String address = resultSet.getString("restaurantAddress");
            String email = resultSet.getString("restaurantEmail");
            String food1 = resultSet.getString("food1");
            double price1 = resultSet.getDouble("price1");
            String food2 = resultSet.getString("food2");
            double price2 = resultSet.getDouble("price2");
            String food3 = resultSet.getString("food3");
            double price3 = resultSet.getDouble("price3");
            Restaurant rest = new Restaurant(id, name, address, email, food1, price1, food2, price2, food3, price3);
            restaurantList.add(rest);
        }
        resultSet.close();
        statement.close();
    }
    
    public static void registerCustomer(Connection connection, Scanner scanner) throws SQLException {
        System.out.println("Enter Customer ID (6 digits): ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter Customer Name: ");
        String name = scanner.nextLine();

        System.out.println("Enter Customer Home Address: ");
        String address = scanner.nextLine();

        System.out.println("Enter Customer Email: ");
        String email = scanner.nextLine();

        Customer cust = new Customer(id, name, address, email);
        createCustomer(connection, cust);
        customerList.add(cust);
    }

    public static void registerRestaurant(Connection connection, Scanner scanner) throws SQLException {
        System.out.println("Enter Restaurant ID (6 digits): ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter Restaurant Name: ");
        String name = scanner.nextLine();

        System.out.println("Enter Restaurant Address: ");
        String address = scanner.nextLine();

        System.out.println("Enter Restaurant Email: ");
        String email = scanner.nextLine();

        System.out.println("Enter Food 1: ");
        String food1 = scanner.nextLine();
        System.out.println("Enter Price for Food 1: ");
        double price1 = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter Food 2: ");
        String food2 = scanner.nextLine();
        System.out.println("Enter Price for Food 2: ");
        double price2 = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        System.out.println("Enter Food 3: ");
        String food3 = scanner.nextLine();
        System.out.println("Enter Price for Food 3: ");
        double price3 = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Restaurant rest = new Restaurant(id, name, address, email, food1, price1, food2, price2, food3, price3);
        createRestaurant(connection, rest);
        restaurantList.add(rest);
    }
    
    public static void createCustomer(Connection connection, Customer cust) throws SQLException {
        
        System.out.println("Insert Section");
        // author -> table name
        // (authorid, firstname, lastname) - column names in the author table
        String query = "INSERT INTO customer (customerID, customerName, customerHomeAddress, customerEmail) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        // setInt->id is in int
        statement.setInt(1, cust.getId()); // 1-> refer to the first question mark
        statement.setString(2, cust.getName()); // 2-> refer to the second question mark
        statement.setString(3, cust.getAddress()); // 3-> refer to the third question mark
        statement.setString(4, cust.getEmail());
        int rowsInserted = statement.executeUpdate();
        System.out.println("No of rows inserted into DB = "+rowsInserted);
        if (rowsInserted > 0) {
            System.out.println("A new customer was inserted successfully!");
        }
        statement.close();
    }

    public static void createRestaurant(Connection connection, Restaurant rest) throws SQLException {
        String query = "INSERT INTO restaurant (restaurantID, restaurantName, restaurantAddress, restaurantEmail, food1, price1, food2, price2, food3, price3) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, rest.getId());
        statement.setString(2, rest.getName());
        statement.setString(3, rest.getAddress());
        statement.setString(4, rest.getEmail());
        statement.setString(5, rest.getFood1());
        statement.setDouble(6, rest.getPrice1());
        statement.setString(7, rest.getFood2());
        statement.setDouble(8, rest.getPrice2());
        statement.setString(9, rest.getFood3());
        statement.setDouble(10, rest.getPrice3());
        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new restaurant was inserted successfully!");
        }
        statement.close();
    }
    
    // Read
    public static void readCustomer(Connection connection) throws SQLException {
        System.out.println("\nDisplay all customer records:");
        int i = 0;
        for (Customer cust : customerList) {
            i++;
            System.out.println("Record " + i + ": " + cust.getId() + "\t" + cust.getName() + "\t" + cust.getAddress() + "\t" + cust.getEmail());
        }
    }
    
     public static void readRestaurants(Connection connection) throws SQLException {
        System.out.println("\nDisplay all restaurant records:");
        int i = 0;
        for (Restaurant rest : restaurantList) {
            i++;
            System.out.println("Record " + i + ": " + rest.getId() + "\t" + rest.getName() + "\t" + rest.getAddress() + "\t" + rest.getEmail());
            System.out.println("Foods: " + rest.getFood1() + " ($" + rest.getPrice1() + "), " + rest.getFood2() + " ($" + rest.getPrice2() + "), " + rest.getFood3() + " ($" + rest.getPrice3() + ")");
        }
    }
    
}// TestDB class