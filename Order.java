package RestaurantCentral;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import oracle.jdbc.pool.OracleDataSource;


//class that represents order details 
class Order {
	int orderNumber;
	String telephoneNum;
	String foodOrdered;
	int quantity;
	double price;
	static int lastAssignedNum;

	public Order() {
		orderNumber = ++lastAssignedNum;
	}

	static void placeOrder(ArrayList<Order> orderList, Customer customerObj) throws SQLException {
	
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@//localhost:1521/XE");
		// jdbc:oracle:thin@//[hostname]:[port]/[DB service name]
		ods.setUser("SYSTEM"); // [username]
		ods.setPassword("javajuice"); // [password]
		Connection conn = ods.getConnection();

		//String insertcustsql = "insert into CUSTOMER (ID, NAME,PHONENUMBER,ADDRESS,CITY,ZIP) " + "VALUES (SEQ_ID.nextval,?,?,?,?,?)";
		String insertcustsql = "insert into CUSTOMER (ID, NAME,PHONENUMBER,ADDRESS,CITY,ZIP) " + "VALUES (?,?,?,?,?,?)";
				
		PreparedStatement pstmt1 = conn.prepareStatement(insertcustsql);
		//pstmt1.execute(insertcustsql);
		boolean flag1;
		System.out.println("DEBUG : insert into customer ");
		System.out.println(customerObj.customerID);
		System.out.println(customerObj.name);
		System.out.println(customerObj.phoneNumber);
		System.out.println(customerObj.streetAddress);
		System.out.println(customerObj.city);
		System.out.println(customerObj.zip);
		    pstmt1.setInt(1,customerObj.customerID);
			pstmt1.setString(2, customerObj.name);
			pstmt1.setString(3, customerObj.phoneNumber);
			pstmt1.setString(4, customerObj.streetAddress);
			pstmt1.setString(5, customerObj.city);
			pstmt1.setString(6, customerObj.zip);
			flag1 = pstmt1.execute();

		String sql = "insert into ORDERHISTORY (orderNumber,TELEPHONENUM,foodOrdered,Quantity,PRICE) values (?, ?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		boolean flag;
		for (Order i : orderList) {
			pstmt.setInt(1, i.orderNumber);
			pstmt.setString(2, customerObj.phoneNumber);
			// pstmt.setString(2, "1111111111");
			pstmt.setString(3, i.foodOrdered);
			pstmt.setInt(4, i.quantity);
			pstmt.setDouble(5, i.price);
			flag = pstmt.execute();
		}
	}

	void addToCart(String foodOrdered, int quantity, double price) {
		this.foodOrdered = foodOrdered;
		this.quantity = quantity;
		this.price = price;
	}

	static void displayOrder(ArrayList<Order> orderList) {

		System.out.println("DEBUG :Inside displayOrder method :");
		RestaurantProject.taCart = new JTextArea();
		RestaurantProject.taCart.setEditable(false);
		RestaurantProject.taCart.setFont(new Font("Consolas", Font.BOLD, 30));

		RestaurantProject.totalCost = new JTextArea();
		RestaurantProject.totalCost.setEditable(false);
		RestaurantProject.totalCost.setBounds(1450, 750, 370, 180);
		RestaurantProject.totalCost.setFont(new Font("Consolas", Font.BOLD, 25));
		// static JLabel headings = new JLabel("Food & Beverages \t \t Quantity \t
		// Price");
		//28 max

		RestaurantProject.spItems = new JScrollPane(RestaurantProject.taCart);
		RestaurantProject.spItems.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		RestaurantProject.spItems.setBounds(50, 350, 1770, 400);

		double subtotal = 0.0;
		double total = 0.0;
		String space = " ";
		int x;

		for (Order i : orderList) {
			subtotal += i.price;
		}

		total = subtotal * 1.09;

		for (Order i : orderList) {
			
			if(i.foodOrdered.length() < 28) {
				for(x = 0; x < (28-i.foodOrdered.length()); x++) {
				space += " ";
				}
			}
			
			System.out.println("displayOrder method :" + i.foodOrdered);
			RestaurantProject.taCart
					.append("\n " + i.foodOrdered + space + "\t\t\t\t\t \t       " + i.quantity + " \t       \t$" + i.price);
			RestaurantProject.taCart
					.append("\n_______________________________________________________________________________________________________\n");
			space = " ";
		}

		RestaurantProject.totalCost.append("\n        Subtotal: $" + subtotal + "\n\n");
		RestaurantProject.totalCost.append(" Total(with Tax): $" + total);
		RestaurantProject.lpCart.add(RestaurantProject.spItems, new Integer(100));
		RestaurantProject.lpCart.add(RestaurantProject.totalCost, new Integer(100));
	}
}

class Customer {

	String name;
	String phoneNumber;
	String streetAddress;
	String city;
	String zip;
	int customerID;
	static int lastAssignedNum;

	public Customer() {
		customerID = ++lastAssignedNum;
	}

	void Pay() {

	}
}

