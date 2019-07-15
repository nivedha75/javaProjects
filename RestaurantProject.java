package RestaurantCentral;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.Toolkit;
import java.awt.Dimension;

import java.util.ArrayList;
import java.util.Arrays;

//class order represents order details 
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

	void placeOrder() {
		// insert
	}

	void addToCart(String telephoneNum, String foodOrdered, int quantity, double price) {
		this.telephoneNum = telephoneNum;
		this.foodOrdered = foodOrdered;
		this.quantity = quantity;
		this.price = price;
	}
}

class Customer {

	String name;
	String phoneNumber;
	String streetAddress;
	String city;
	String state;
	String zip;
	// String username;
	// String password;
	int customerID;
	static int lastAssignedNum;

	public Customer() {
		customerID = ++lastAssignedNum;
	}

	void placeOrder() {

	}

	void Pay() {

	}
}

class Food {
	String category;
	String name;
	double price;

}

class Beverage extends Food {
	String size;

	public Beverage() {
		category = "beverage";
	}

}

class Pizza extends Food {
	String pizzaType;// create your own or premade
	String size;
	String crust;
	String[][] toppings = new String[11][2];
	// red bellpeppers
	// green bellpeppers
	// mushrooms
	// pineapple
	// spinach
	// onion
	// olives
	// jalepeno
	// zuchinni
	// artichoke
	// black olives

	public Pizza() {
		category = "Pizza";
	}

}

class Salad extends Food {

	public Salad() {
		category = "Salad";

	}
}

class Pasta extends Food {
	String pastaType;
	String sauce;
	String type;
	String cheese;
	String[][] vegetables = new String[7][2];

	public Pasta() {
		category = "Pasta";
	}

}

class Dessert extends Food {

	public Dessert() {
		category = "Dessert";
	}
}

class Paying {
	double overallPrice;
	double tip;

	void calculateOverallPrice(double pizzaCost, double pastaCost) {
		// overallPrice =
	}
}

class Seating {

}

public class RestaurantProject extends JFrame implements ActionListener {
	Order tempOrderObj;
	Customer customerObj;

	// main page
	static JFrame frame;
	static JLayeredPane layeredPane;
	static JPanel mainPicPanel;
	static JLabel mainPicLabel;
	static JMenu menu;
	static JMenuBar menuBar;
	static JMenuItem pizzaMenuItem;
	static JMenuItem pastaMenuItem;
	static JMenuItem saladMenuItem;
	static JMenuItem dessertMenuItem;
	static JMenuItem beverageMenuItem;
	// static String foodCategoryChosen;
	static JButton titleButton;
	static JButton reservationButton;
	static JButton aboutUsButton;
	static JButton orderingPageButton;

	// pizza page
	static JFrame framePizza;
	static JLayeredPane lpPizza;
	static JLabel pizzaTitle;
	static JLabel pizzaPicLabel;
	static JButton orderPizzaButton1;
	static JButton orderPizzaButton2;
	static JButton orderPizzaButton3;
	static JButton orderPizzaButton4;
	static JLabel pizza1;
	static JLabel pizza2;
	static JLabel pizza3;
	static JLabel pizza4;

	// reservations page
	static JFrame reservationFrame;
	static JLayeredPane lpReservation;
	static JLabel reservationLabel;
	static JLabel reservationTitle;
	static JComboBox cbNumPeople;
	static JComboBox cbDay;
	static JComboBox cbTimeSlot;
	static JButton findButton;

	public static void main(String[] args) {
		new RestaurantProject();
	}

	public RestaurantProject() {

		customerObj = new Customer();

		// ***MAIN PAGE***//

		// title button
		titleButton = new JButton();
		titleButton.addActionListener(this);
		titleButton.setBounds(75, 50, 600, 150);
		titleButton.setBorderPainted(false);
		titleButton.setContentAreaFilled(false);
		titleButton.setToolTipText("Return to main page");

		// menu bar
		menuBar = new JMenuBar();
		menu = new JMenu("Menu");
		menuBar.setBounds(700, 60, 350, 100);
		menuBar.add(menu);
		pizzaMenuItem = new JMenuItem("Pizza");
		pastaMenuItem = new JMenuItem("Pasta");
		saladMenuItem = new JMenuItem("Salad");
		dessertMenuItem = new JMenuItem("Dessert");
		beverageMenuItem = new JMenuItem("Beverage");
		pizzaMenuItem.addActionListener(this);
		pastaMenuItem.addActionListener(this);
		saladMenuItem.addActionListener(this);
		dessertMenuItem.addActionListener(this);
		beverageMenuItem.addActionListener(this);

		menu.add(pizzaMenuItem);
		menu.add(pastaMenuItem);
		menu.add(saladMenuItem);
		menu.add(dessertMenuItem);
		menu.add(beverageMenuItem);

		menu.setFont(new Font("Bittermilk", Font.PLAIN, 72));
		// menuBar.setFont(new Font("Bittermilk", Font.PLAIN, 72));
		pizzaMenuItem.setFont(new Font("Bittermilk", Font.PLAIN, 72));
		pastaMenuItem.setFont(new Font("Bittermilk", Font.PLAIN, 72));
		saladMenuItem.setFont(new Font("Bittermilk", Font.PLAIN, 72));
		dessertMenuItem.setFont(new Font("Bittermilk", Font.PLAIN, 72));
		beverageMenuItem.setFont(new Font("Bittermilk", Font.PLAIN, 72));

		// reservation button
		reservationButton = new JButton();
		reservationButton.addActionListener(this);
		reservationButton.setBounds(1100, 60, 370, 100);
		reservationButton.setBorderPainted(false);
		reservationButton.setContentAreaFilled(false);
		reservationButton.setToolTipText("Go to Reservations Page");

		// about us button
		aboutUsButton = new JButton();
		aboutUsButton.addActionListener(this);
		aboutUsButton.setBounds(1490, 60, 290, 100);
		aboutUsButton.setBorderPainted(false);
		aboutUsButton.setContentAreaFilled(false);
		aboutUsButton.setToolTipText("Learn About Us");

		// ordering page button
		orderingPageButton = new JButton();
		orderingPageButton.addActionListener(this);
		orderingPageButton.setBounds(1790, 50, 100, 120);
		orderingPageButton.setBorderPainted(false);
		orderingPageButton.setContentAreaFilled(false);
		orderingPageButton.setToolTipText("Order Food Now");

		// background pic for main page
		mainPicLabel = new JLabel();
		mainPicLabel.setIcon(new ImageIcon("C:/SavedPictures/mainPic.jpg"));
		mainPicLabel.setBounds(0, 0, 1920, 1080);

		// layered pane for main page
		layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(new Dimension(1920, 1080));
		layeredPane.add(mainPicLabel, new Integer(50));
		layeredPane.add(titleButton, new Integer(100));
		layeredPane.add(menuBar, new Integer(100));
		layeredPane.add(reservationButton, new Integer(100));
		layeredPane.add(aboutUsButton, new Integer(100));
		layeredPane.add(orderingPageButton, new Integer(100));

		// frame for main page
		frame = new JFrame();
		// frame.setLayout();
		// frame.setState(Frame.NORMAL);
		// Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		// frame.setSize(screenSize.width, screenSize.height);
		frame.setSize(1920, 1080);
		frame.setResizable(false);
		frame.setTitle("Restaurant");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.add(layeredPane);

		// ***PIZZA***//
		pizzaTitle = new JLabel("Pizza");
		orderPizzaButton1 = new JButton("Add to Cart");
		orderPizzaButton1.addActionListener(this);
		orderPizzaButton1.setToolTipText("Add to Cart");
		orderPizzaButton2 = new JButton("Add to Cart");
		orderPizzaButton2.addActionListener(this);
		orderPizzaButton2.setToolTipText("Add to Cart");
		orderPizzaButton3 = new JButton("Add to Cart");
		orderPizzaButton3.addActionListener(this);
		orderPizzaButton3.setToolTipText("Add to Cart");
		orderPizzaButton4 = new JButton("Add to Cart");
		orderPizzaButton4.addActionListener(this);
		orderPizzaButton4.setToolTipText("Customize");
		pizza1 = new JLabel("Gourmet Veggie");
		pizza2 = new JLabel("Italian Supreme");
		pizza3 = new JLabel("Garden Party");
		pizza4 = new JLabel("Create Your Own");

		// set location here
		pizzaTitle.setBounds(870, 120, 200, 100);
		orderPizzaButton1.setBounds(120, 450, 200, 40);
		orderPizzaButton2.setBounds(1100, 450, 200, 40);
		orderPizzaButton3.setBounds(120, 900, 200, 40);
		orderPizzaButton4.setBounds(1100, 900, 200, 40);

		pizza1.setBounds(80, 210, 400, 100);
		pizza2.setBounds(1030, 210, 400, 100);
		pizza3.setBounds(80, 650, 400, 100);
		pizza4.setBounds(1030, 650, 400, 100);

		// set font here
		pizzaTitle.setFont(new Font("Arial", Font.ITALIC, 45));
		orderPizzaButton1.setFont(new Font("Bittermilk", Font.BOLD, 30));
		orderPizzaButton2.setFont(new Font("Bittermilk", Font.BOLD, 30));
		orderPizzaButton3.setFont(new Font("Bittermilk", Font.BOLD, 30));
		orderPizzaButton4.setFont(new Font("Bittermilk", Font.BOLD, 30));
		pizza1.setFont(new Font("Bittermilk", Font.BOLD, 50));
		pizza2.setFont(new Font("Bittermilk", Font.BOLD, 50));
		pizza3.setFont(new Font("Bittermilk", Font.BOLD, 50));
		pizza4.setFont(new Font("Bittermilk", Font.BOLD, 50));

		pizzaPicLabel = new JLabel();
		pizzaPicLabel.setIcon(new ImageIcon("C:/SavedPictures/PizzaMain.jpg"));
		pizzaPicLabel.setBounds(0, 0, 1920, 1080);

		lpPizza = new JLayeredPane();
		lpPizza.setPreferredSize(new Dimension(1920, 1080));
		lpPizza.add(pizzaPicLabel, new Integer(50));
		lpPizza.add(pizzaTitle, new Integer(100));
		lpPizza.add(orderPizzaButton1, new Integer(100));
		lpPizza.add(orderPizzaButton2, new Integer(100));
		lpPizza.add(orderPizzaButton3, new Integer(100));
		lpPizza.add(orderPizzaButton4, new Integer(100));
		lpPizza.add(pizza1, new Integer(100));
		lpPizza.add(pizza2, new Integer(100));
		lpPizza.add(pizza3, new Integer(100));
		lpPizza.add(pizza4, new Integer(100));

		framePizza = new JFrame();
		framePizza.add(lpPizza);
		framePizza.setSize(1920, 1080);
		framePizza.setResizable(false);
		framePizza.setTitle("Pizza");
		framePizza.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePizza.setVisible(false);
		framePizza.setLocationRelativeTo(null);

		// ***RESERVATIONS PAGE***//

		// create components
		cbNumPeople = new JComboBox();
		cbDay = new JComboBox();
		cbTimeSlot = new JComboBox();
		reservationTitle = new JLabel("Reservations");
		findButton = new JButton();
		findButton.addActionListener(this);
		findButton.setBorderPainted(false);
		findButton.setContentAreaFilled(false);
		findButton.setToolTipText("Find a Table");

		// set location here
		cbNumPeople.setBounds(550, 450, 800, 50);
		// reservationPanel.addBorder( new EmptyBorder(10, 10, 10, 10) );
		// reservationPanel.add(cbNumPeople, constraints);
		cbDay.setBounds(550, 550, 800, 50);
		cbTimeSlot.setBounds(550, 650, 800, 50);
		// cbNumPeople.setSize(200, 200);
		reservationTitle.setBounds(570, 250, 800, 200);
		findButton.setBounds(730, 820, 400, 100);

		// set font here
		cbNumPeople.setFont(new Font("Times New Roman", Font.BOLD, 15));
		cbDay.setFont(new Font("Times New Roman", Font.BOLD, 15));
		cbTimeSlot.setFont(new Font("Times New Roman", Font.BOLD, 15));
		reservationTitle.setFont(new Font("Bittermilk", Font.PLAIN, 50));

		// add to combo box
		cbNumPeople.addItem("Number Of People");
		cbDay.addItem("Date");
		cbTimeSlot.addItem("Time");

		cbNumPeople.addItem("1 Person");
		cbNumPeople.addItem("2 People");
		cbNumPeople.addItem("3 People");
		cbNumPeople.addItem("4 People");
		cbNumPeople.addItem("5 People");
		cbNumPeople.addItem("6 People");
		cbNumPeople.addItem("7 People");
		cbNumPeople.addItem("8+ People");
		cbDay.addItem("Calendar");
		cbTimeSlot.addItem("12:00");
		cbTimeSlot.addItem("12:30");
		cbTimeSlot.addItem("1:00");
		cbTimeSlot.addItem("1:30");
		cbTimeSlot.addItem("2:00");
		cbTimeSlot.addItem("2:30");
		cbTimeSlot.addItem("3:00");
		cbTimeSlot.addItem("3:30");
		cbTimeSlot.addItem("4:00");
		cbTimeSlot.addItem("4:30");
		cbTimeSlot.addItem("5:00");
		cbTimeSlot.addItem("5:30");
		cbTimeSlot.addItem("6:00");
		cbTimeSlot.addItem("6:30");
		cbTimeSlot.addItem("7:00");
		cbTimeSlot.addItem("7:30");
		cbTimeSlot.addItem("8:00");
		cbTimeSlot.addItem("8:30");
		cbTimeSlot.addItem("9:00");
		cbTimeSlot.addItem("9:30");
		cbTimeSlot.addItem("10:00");
		cbTimeSlot.addItem("10:30");
		cbTimeSlot.addItem("11:00");
		cbTimeSlot.addItem("11:30");

		// reservationPanel.setLayout(new GridLayout(3, 1));
		// reservationPanel.setBounds(700, 25, 400, 500);
		// reservationPanel.setLayout(null);

		// background pic
		reservationLabel = new JLabel();
		reservationLabel.setIcon(new ImageIcon("C:/SavedPictures/reservationsPage.jpg"));
		reservationLabel.setBounds(0, 0, 1920, 1080);

		// layered pane for main page
		lpReservation = new JLayeredPane();
		lpReservation.setPreferredSize(new Dimension(1920, 1080));
		lpReservation.add(reservationLabel, new Integer(50));
		lpReservation.add(findButton, new Integer(100));
		// lpReservation.add(reservationTitle, new Integer(100));
		lpReservation.add(cbNumPeople, new Integer(100));
		lpReservation.add(cbDay, new Integer(100));
		lpReservation.add(cbTimeSlot, new Integer(100));

		// reservation frame
		reservationFrame = new JFrame();
		reservationFrame.add(lpReservation);
		// reservationFrame.add(reservationPanel);
		reservationFrame.setVisible(false);
		reservationFrame.setSize(1920, 1080);
		reservationFrame.setTitle("Reservations");
		/// reservationLabel.setSize(1920, 1080);
		reservationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		reservationFrame.setResizable(false);

	}

	public void disableMain() {
		titleButton.setEnabled(false);
		titleButton.setToolTipText(null);
		reservationButton.setEnabled(false);
		reservationButton.setToolTipText(null);
		aboutUsButton.setEnabled(false);
		aboutUsButton.setToolTipText(null);
		orderingPageButton.setEnabled(false);
		orderingPageButton.setToolTipText(null);
		menuBar.setEnabled(false);
		menuBar.setToolTipText(null);

	}

	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if (s == "Pizza") {
			// String foodCategoryChosen = (String)cbMenu.getSelectedItem();
			framePizza.setVisible(true);
			frame.setVisible(false);
		} else if (s == "Salad") {
			frame.setVisible(false);
		} else if (s == "Pasta") {
			frame.setVisible(false);
		} else if (s == "Dessert") {
			frame.setVisible(false);
		} else if (s == "Beverage") {
			frame.setVisible(false);
		}

		ArrayList<Order> orderList = new ArrayList<Order>();
		// Add order to Arraylist to store info in memory
		if (e.getSource() == orderPizzaButton1) {
			tempOrderObj = new Order();
			tempOrderObj.addToCart(customerObj.phoneNumber, pizza1.getText(), 1, 15.00);
			orderList.add(tempOrderObj);
		} else if (e.getSource() == orderPizzaButton2) {
			tempOrderObj = new Order();
			tempOrderObj.addToCart(customerObj.phoneNumber, pizza2.getText(), 1, 14.00);
			orderList.add(tempOrderObj);
		} else if (e.getSource() == orderPizzaButton3) {
			tempOrderObj = new Order();
			tempOrderObj.addToCart(customerObj.phoneNumber, pizza3.getText(), 1, 16.00);
			orderList.add(tempOrderObj);
		} else if (e.getSource() == orderPizzaButton4) {

		}

//		//add this where I display shopping cart
//		double sum = 0.0;
//		for (Order i : orderList) {
//			sum += i.price;
//		}
//		sum *= 1.09;

		if (e.getSource() == reservationButton) {
			reservationFrame.setVisible(true);
			frame.setVisible(false);
		} else if (e.getSource() == aboutUsButton) {
			frame.setVisible(false);
		} else if (e.getSource() == orderingPageButton) {
			frame.setVisible(false);
		}

		if (e.getSource() == findButton) {
			reservationFrame.setVisible(false);
		}
	}

}
