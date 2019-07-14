package GUIExamples;

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

class Customer {
	String name;
	String phoneNumber;
	String streetAddress;
	String city;
	String state;
	String zip;
	String username;
	String password;
	int ID;
	static int lastAssignedNum;

	public Customer(String name) {
		ID = ++lastAssignedNum;
	}
	void Order() {
	
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
	String pizzaType;//create your own or premade
	String size;
	String crust;
	String [] [] toppings = new String [11] [2];
	//red bellpeppers
	//green bellpeppers
	//mushrooms
	//pineapple
	//spinach
	//onion
	//olives
	//jalepeno
	//zuchinni
	//artichoke
	//black olives
	
	public Pizza() {
		category = "Pizza";
	}

}

class Salad extends Food {

	public Salad() {
		category = "Salad";

}

class Pasta extends Food {
	String pastaType;
	String sauce;
	String type;
	String cheese;
	String [] [] vegetables = new String [7] [2];
	
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
	static JFrame frame;
	static JFrame frameMenu;
	static JMenu menu;
	static JMenuBar menuBar;
	static JMenuItem pizzaMenuItem;
	static JMenuItem pastaMenuItem;
	static JMenuItem saladMenuItem;
	static JMenuItem dessertMenuItem;
	static JMenuItem beverageMenuItem;
	static String foodCategoryChosen;
	static JButton titleButton;
	static JButton reservationButton;
	static JButton aboutUsButton;
	static JButton orderingPageButton;

	static JComboBox cbNumPeople;
	static JComboBox cbDay;
	static JComboBox cbTimeSlot;
	static JPanel reservationPanel;
	static JFrame reservationFrame;

	// static ImageIcon icon;
	static JLabel mainPicLabel;
	static JPanel mainPicPanel;
	static JLayeredPane layeredPane;

	public static void main(String[] args) {
		new RestaurantProject();
	}

	public RestaurantProject() {
		// main page

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
		
		
		//background pic for main page
		mainPicLabel = new JLabel();
		mainPicLabel.setIcon(new ImageIcon("C:/SavedPictures/mainPic.jpg"));
		mainPicLabel.setBounds(0, 0, 1920, 1080);

		//layered pane for main page
		layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(new Dimension(1920, 1080));
		layeredPane.add(mainPicLabel, new Integer(50));
		layeredPane.add(titleButton, new Integer(100));
		layeredPane.add(menuBar, new Integer(100));
		layeredPane.add(reservationButton, new Integer(100));
		layeredPane.add(aboutUsButton, new Integer(100));
		layeredPane.add(orderingPageButton, new Integer(100));

		//frame for main page
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

		frameMenu = new JFrame();
		frameMenu.setVisible(true);
		frameMenu.setSize(1925, 1025);
		frameMenu.setResizable(false);
		frameMenu.setTitle("Pizza");
		frameMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameMenu.setVisible(true);
		frameMenu.setLocationRelativeTo(null);

		// paying component here

		// reservation component here
		// int seats;

		cbNumPeople = new JComboBox();
		cbDay = new JComboBox();
		cbTimeSlot = new JComboBox();
		reservationPanel = new JPanel();
		reservationFrame = new JFrame();

		cbNumPeople.setBounds(550, 250, 800, 50);
		// reservationPanel.addBorder( new EmptyBorder(10, 10, 10, 10) );
		// reservationPanel.add(cbNumPeople, constraints);
		cbDay.setBounds(550, 450, 800, 50);
		cbTimeSlot.setBounds(550, 650, 800, 50);
		// cbNumPeople.setSize(200, 200);

		cbNumPeople.setFont(new Font("Times New Roman", Font.BOLD, 15));
		cbDay.setFont(new Font("Times New Roman", Font.BOLD, 15));
		cbTimeSlot.setFont(new Font("Times New Roman", Font.BOLD, 15));

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
		reservationPanel.setLayout(null);
		reservationPanel.add(cbNumPeople);
		reservationPanel.add(cbDay);
		reservationPanel.add(cbTimeSlot);
		reservationFrame.add(reservationPanel);
		reservationFrame.setVisible(true);
		reservationFrame.setSize(1925, 1025);
		reservationFrame.setTitle("Reservations");

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

	/*
	 * public void actionPerformed(ActionEvent e) { if (e.getSource()== ) { String
	 * foodCategoryChosen = (String)cbMenu.getSelectedItem(); }else if (e.getSource)
	 * }
	 */

}
