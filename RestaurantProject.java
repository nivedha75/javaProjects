package RestaurantCentral;

import javax.swing.*;
import javax.swing.border.*;

import oracle.jdbc.pool.OracleDataSource;

import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.text.NumberFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Object.*;
//import javafx.scene.control.DatePicker;

public class RestaurantProject extends JFrame implements ActionListener {
	Order tempOrderObj;
	Customer tempCustomerObj;

	ArrayList<Order> orderList = new ArrayList<Order>();

	static int capacity = 0;
	// ArrayList<Customer> customerList = new ArrayList<Customer>();

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
	static JTextArea pizza1Description;
	static JTextArea pizza2Description;
	static JTextArea pizza3Description;
	static JTextArea pizza4Description;
	static JButton JavaDinerButtonPizza;
	static JLabel pizza1Price;
	static JLabel pizza2Price;
	static JLabel pizza3Price;
	static JLabel pizza4Price;

	// pasta page
	static JFrame framePasta;
	static JLayeredPane lpPasta;
	static JLabel pastaTitle;
	static JLabel pastaPicLabel;
	static JButton orderPastaButton1;
	static JButton orderPastaButton2;
	static JButton orderPastaButton3;
	static JButton orderPastaButton4;
	static JLabel pasta1;
	static JLabel pasta2;
	static JLabel pasta3;
	static JLabel pasta4;
	static JTextArea pasta1Description;
	static JTextArea pasta2Description;
	static JTextArea pasta3Description;
	static JTextArea pasta4Description;
	static JButton JavaDinerButtonPasta;
	static JLabel pasta1Price;
	static JLabel pasta2Price;
	static JLabel pasta3Price;
	static JLabel pasta4Price;

	// reservations page
	static JFrame reservationFrame;
	static JLayeredPane lpReservation;
	static JLabel reservationLabel;
	static JLabel reservationTitle;
	static JComboBox cbNumPeople;
	static JComboBox cbDay;
	static JComboBox cbTimeSlot;
	static JButton findButton;
	static JButton exit;
	static JLabel bookedLabel;

	// reservations page 2
	static JFrame reservationFrame2;
	static JTextField tfNameR;
	static JTextField tfTelephoneNumR;
	static JLabel reservationLabel2;
	static JLayeredPane lpReservation2;
	static JLabel labelNameR;
	static JLabel labelTelephoneNumR;
	static JButton confirmReservationButton;
	static JLabel resultOfConfirmR;
	static JLabel resultOfFindingTable;
	static JButton JavaDinerButtonR;
	static JLabel didNotFill;

	// Cart page
	static JFrame cartFrame;
	static JLayeredPane lpCart;
	static JLabel cartLabel;
	static JButton checkoutButton;
	// static JButton backToShoppingButton;
	static JTextArea taCart;
	static JTextArea totalCost;
	static JScrollPane spItems;

	// Delivery or Carry Out Page
	static JFrame choiceFrame;
	static JLayeredPane lpChoice;
	static JLabel choiceLabel;
	static JButton deliveryButton;
	static JButton carryoutButton;
	static JButton placeOrderButton;
	static JLabel name;
	static JLabel telephoneNum;
	static JLabel address;
	static JLabel city;
	static JLabel zip;
	static JTextField tfName;
	static JTextField tfTelephoneNum;
	static JTextField tfAddress;
	static JTextField tfCity;
	static JTextField tfZip;
	static JLabel result;
	static JButton goBackToCartButton;
	static JButton exitButtonChoice;

	// about us
	static JFrame frameAboutUs;
	static JLayeredPane layeredPaneAU;
	static JButton JavaDinerButtonAboutUs;
	static JTextArea taAboutUs;
	static JLabel aboutUsLabel;

	public static void main(String[] args) {
		new RestaurantProject();
	}

	public RestaurantProject() {

		tempCustomerObj = new Customer();

		mainPage();
		pizzaPage();
		pastaPage();
		reservationsPage();
		reservationsPage2();
		aboutUsPage();
		CartPage();
		DeliveryOrCarryoutPage();

	}

	void mainPage() {
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
		// saladMenuItem = new JMenuItem("Salad");
		// dessertMenuItem = new JMenuItem("Dessert");
		// beverageMenuItem = new JMenuItem("Beverage");
		pizzaMenuItem.addActionListener(this);
		pastaMenuItem.addActionListener(this);
		// saladMenuItem.addActionListener(this);
		// dessertMenuItem.addActionListener(this);
		// beverageMenuItem.addActionListener(this);

		menu.add(pizzaMenuItem);
		menu.add(pastaMenuItem);
		// menu.add(saladMenuItem);
		// menu.add(dessertMenuItem);
		// menu.add(beverageMenuItem);

		menu.setFont(new Font("Bittermilk", Font.PLAIN, 72));
		// menuBar.setFont(new Font("Bittermilk", Font.PLAIN, 72));
		pizzaMenuItem.setFont(new Font("Bittermilk", Font.PLAIN, 72));
		pastaMenuItem.setFont(new Font("Bittermilk", Font.PLAIN, 72));
		// saladMenuItem.setFont(new Font("Bittermilk", Font.PLAIN, 72));
		// dessertMenuItem.setFont(new Font("Bittermilk", Font.PLAIN, 72));
		// beverageMenuItem.setFont(new Font("Bittermilk", Font.PLAIN, 72));

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
	}

	void pizzaPage() {
		// ***PIZZA***//

		JavaDinerButtonPizza = new JButton();
		JavaDinerButtonPizza.addActionListener(this);
		JavaDinerButtonPizza.setBounds(720, 30, 450, 110);
		JavaDinerButtonPizza.setBorderPainted(false);
		JavaDinerButtonPizza.setContentAreaFilled(false);
		JavaDinerButtonPizza.setToolTipText("Return to main page");

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
		orderPizzaButton4.setToolTipText("Add to Cart");
		pizza1 = new JLabel("Gourmet Veggie");
		pizza2 = new JLabel("Italian Supreme");
		pizza3 = new JLabel("Garden Party");
		pizza4 = new JLabel("Cheese Pizza");
		pizza1Description = new JTextArea(
				"TOMATOES, MUSHROOMS, \nGREEN PEPPERS, \nONIONS, BLACK OLIVES \nON ZESTY RED SAUCE");
		pizza2Description = new JTextArea(
				"ARTICHOKE HEARTS, ZUCCHINI, \nSPINACH, MUSHROOMS, \nTOMATOES, GARLIC, RED & \nGREEN ONIONS ON OUR CREAMY \nGARLIC SAUCE");
		pizza3Description = new JTextArea("MUSHROOMS, GREEN PEPPERS, \nONIONS, BLACK OLIVES ON \nZESTY RED SAUCE");
		pizza4Description = new JTextArea("CLASSIC CHEESE PIZZA \nPERFECTED, NEVER BEEN BETTER");
		pizza1Price = new JLabel("$12.00");
		pizza2Price = new JLabel("$11.50");
		pizza3Price = new JLabel("$10.00");
		pizza4Price = new JLabel("$6.00");

		// set location here
		pizzaTitle.setBounds(870, 120, 200, 100);
		orderPizzaButton1.setBounds(120, 500, 200, 40);
		orderPizzaButton2.setBounds(1100, 500, 200, 40);
		orderPizzaButton3.setBounds(120, 950, 200, 40);
		orderPizzaButton4.setBounds(1100, 950, 200, 40);

		pizza1.setBounds(80, 210, 400, 100);
		pizza2.setBounds(1030, 210, 400, 100);
		pizza3.setBounds(80, 650, 400, 100);
		pizza4.setBounds(1030, 650, 400, 100);

		pizza1Description.setBounds(80, 320, 350, 100);
		pizza2Description.setBounds(1030, 320, 350, 100);
		pizza3Description.setBounds(80, 760, 350, 100);
		pizza4Description.setBounds(1030, 760, 350, 100);

		pizza1Price.setBounds(80, 420, 200, 100);
		pizza2Price.setBounds(1030, 420, 200, 100);
		pizza3Price.setBounds(80, 860, 200, 100);
		pizza4Price.setBounds(1030, 860, 200, 100);

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
		pizza1Description.setFont(new Font("Arial", Font.PLAIN, 20));
		pizza2Description.setFont(new Font("Arial", Font.PLAIN, 20));
		pizza3Description.setFont(new Font("Arial", Font.PLAIN, 20));
		pizza4Description.setFont(new Font("Arial", Font.PLAIN, 20));
		pizza1Price.setFont(new Font("Bittermilk", Font.BOLD, 30));
		pizza2Price.setFont(new Font("Bittermilk", Font.BOLD, 30));
		pizza3Price.setFont(new Font("Bittermilk", Font.BOLD, 30));
		pizza4Price.setFont(new Font("Bittermilk", Font.BOLD, 30));

		pizzaPicLabel = new JLabel();
		pizzaPicLabel.setIcon(new ImageIcon("C:/SavedPictures/PizzaMain.jpg"));
		pizzaPicLabel.setBounds(0, 0, 1920, 1080);

		lpPizza = new JLayeredPane();
		lpPizza.setPreferredSize(new Dimension(1920, 1080));
		lpPizza.add(pizzaPicLabel, new Integer(50));
		lpPizza.add(JavaDinerButtonPizza, new Integer(100));
		lpPizza.add(pizzaTitle, new Integer(100));
		lpPizza.add(orderPizzaButton1, new Integer(100));
		lpPizza.add(orderPizzaButton2, new Integer(100));
		lpPizza.add(orderPizzaButton3, new Integer(100));
		lpPizza.add(orderPizzaButton4, new Integer(100));
		lpPizza.add(pizza1, new Integer(100));
		lpPizza.add(pizza2, new Integer(100));
		lpPizza.add(pizza3, new Integer(100));
		lpPizza.add(pizza4, new Integer(100));
		lpPizza.add(pizza1Description, new Integer(100));
		lpPizza.add(pizza2Description, new Integer(100));
		lpPizza.add(pizza3Description, new Integer(100));
		lpPizza.add(pizza4Description, new Integer(100));
		lpPizza.add(pizza1Price, new Integer(100));
		lpPizza.add(pizza2Price, new Integer(100));
		lpPizza.add(pizza3Price, new Integer(100));
		lpPizza.add(pizza4Price, new Integer(100));

		framePizza = new JFrame();
		framePizza.add(lpPizza);
		framePizza.setSize(1920, 1080);
		framePizza.setResizable(false);
		framePizza.setTitle("Pizza");
		framePizza.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePizza.setVisible(false);
		framePizza.setLocationRelativeTo(null);
	}

	void pastaPage() {
		// ***PASTA***//

		JavaDinerButtonPasta = new JButton();
		JavaDinerButtonPasta.addActionListener(this);
		JavaDinerButtonPasta.setBounds(720, 30, 450, 110);
		JavaDinerButtonPasta.setBorderPainted(false);
		JavaDinerButtonPasta.setContentAreaFilled(false);
		JavaDinerButtonPasta.setToolTipText("Return to main page");

		pastaTitle = new JLabel("Pasta");
		orderPastaButton1 = new JButton("Add to Cart");
		orderPastaButton1.addActionListener(this);
		orderPastaButton1.setToolTipText("Add to Cart");
		orderPastaButton2 = new JButton("Add to Cart");
		orderPastaButton2.addActionListener(this);
		orderPastaButton2.setToolTipText("Add to Cart");
		orderPastaButton3 = new JButton("Add to Cart");
		orderPastaButton3.addActionListener(this);
		orderPastaButton3.setToolTipText("Add to Cart");
		orderPastaButton4 = new JButton("Add to Cart");
		orderPastaButton4.addActionListener(this);
		orderPastaButton4.setToolTipText("Customize");
		pasta1 = new JLabel("Fettuccini Alfredo");
		pasta2 = new JLabel("Creamy Tomato Basil Rigatoni");
		pasta3 = new JLabel("Fettuccini with Mariana Sauce");
		pasta4 = new JLabel("Four Cheese Penne");
		pasta1Description = new JTextArea("TRY OUR FETTUCCINE PASTA\nTOSSED IN A RICH AND\nCREAMY ALFREDO SAUCE");
		pasta2Description = new JTextArea("RIGATONI COATED IN A DELICIOUS,\nCREAMY TOMATO SAUCE WITH\nFRESH BASIL");
		pasta3Description = new JTextArea("FETTUCCINE SOAKED IN A RICH\nMARIANA SAUCE MADE WITH FRESH\nTOMATOES");
		pasta4Description = new JTextArea(
				"PENNE DIPPED IN A MIXTURE OF\nFOUR CHEESES AND BAKED:\nRICOTTA, MOZERELLA, COTTAGE,\nAND PARMESAN");
		pasta1Price = new JLabel("$12.00");
		pasta2Price = new JLabel("$11.50");
		pasta3Price = new JLabel("$10.00");
		pasta4Price = new JLabel("$10.00");

		// set location here
		pastaTitle.setBounds(870, 120, 200, 100);
		orderPastaButton1.setBounds(120, 500, 200, 40);
		orderPastaButton2.setBounds(1100, 500, 200, 40);
		orderPastaButton3.setBounds(120, 950, 200, 40);
		orderPastaButton4.setBounds(1100, 950, 200, 40);

		pasta1.setBounds(80, 210, 400, 100);
		pasta2.setBounds(1030, 210, 600, 100);
		pasta3.setBounds(80, 650, 600, 100);
		pasta4.setBounds(1030, 650, 400, 100);

		pasta1Description.setBounds(80, 320, 350, 100);
		pasta2Description.setBounds(1030, 320, 350, 100);
		pasta3Description.setBounds(80, 760, 350, 100);
		pasta4Description.setBounds(1030, 760, 350, 100);

		pasta1Price.setBounds(80, 420, 300, 100);
		pasta2Price.setBounds(1030, 420, 400, 100);
		pasta3Price.setBounds(80, 860, 300, 100);
		pasta4Price.setBounds(1030, 860, 300, 100);

		// set font here
		pastaTitle.setFont(new Font("Arial", Font.ITALIC, 45));
		orderPastaButton1.setFont(new Font("Bittermilk", Font.BOLD, 30));
		orderPastaButton2.setFont(new Font("Bittermilk", Font.BOLD, 30));
		orderPastaButton3.setFont(new Font("Bittermilk", Font.BOLD, 30));
		orderPastaButton4.setFont(new Font("Bittermilk", Font.BOLD, 30));
		pasta1.setFont(new Font("Bittermilk", Font.BOLD, 30));
		pasta2.setFont(new Font("Bittermilk", Font.BOLD, 30));
		pasta3.setFont(new Font("Bittermilk", Font.BOLD, 30));
		pasta4.setFont(new Font("Bittermilk", Font.BOLD, 30));
		pasta1Description.setFont(new Font("Arial", Font.PLAIN, 20));
		pasta2Description.setFont(new Font("Arial", Font.PLAIN, 20));
		pasta3Description.setFont(new Font("Arial", Font.PLAIN, 20));
		pasta4Description.setFont(new Font("Arial", Font.PLAIN, 20));
		pasta1Price.setFont(new Font("Bittermilk", Font.BOLD, 30));
		pasta2Price.setFont(new Font("Bittermilk", Font.BOLD, 30));
		pasta3Price.setFont(new Font("Bittermilk", Font.BOLD, 30));
		pasta4Price.setFont(new Font("Bittermilk", Font.BOLD, 30));

		pastaPicLabel = new JLabel();
		pastaPicLabel.setIcon(new ImageIcon("C:/SavedPictures/PastaMain.jpg"));
		pastaPicLabel.setBounds(0, 0, 1920, 1080);

		lpPasta = new JLayeredPane();
		lpPasta.setPreferredSize(new Dimension(1920, 1080));
		lpPasta.add(pastaPicLabel, new Integer(50));
		lpPasta.add(JavaDinerButtonPasta, new Integer(100));
		lpPasta.add(pastaTitle, new Integer(100));
		lpPasta.add(orderPastaButton1, new Integer(100));
		lpPasta.add(orderPastaButton2, new Integer(100));
		lpPasta.add(orderPastaButton3, new Integer(100));
		lpPasta.add(orderPastaButton4, new Integer(100));
		lpPasta.add(pasta1, new Integer(100));
		lpPasta.add(pasta2, new Integer(100));
		lpPasta.add(pasta3, new Integer(100));
		lpPasta.add(pasta4, new Integer(100));
		lpPasta.add(pasta1Description, new Integer(100));
		lpPasta.add(pasta2Description, new Integer(100));
		lpPasta.add(pasta3Description, new Integer(100));
		lpPasta.add(pasta4Description, new Integer(100));
		lpPasta.add(pasta1Price, new Integer(100));
		lpPasta.add(pasta2Price, new Integer(100));
		lpPasta.add(pasta3Price, new Integer(100));
		lpPasta.add(pasta4Price, new Integer(100));

		framePasta = new JFrame();
		framePasta.add(lpPasta);
		framePasta.setSize(1920, 1080);
		framePasta.setResizable(false);
		framePasta.setTitle("pasta");
		framePasta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePasta.setVisible(false);
		framePasta.setLocationRelativeTo(null);
	}

	void reservationsPage() {
		// ***RESERVATIONS PAGE***//

		/*
		 * UtilDateModel model = new UtilDateModel(); JDatePanelImpl datePanel = new
		 * JDatePanelImpl(model); JDatePickerImpl datePicker = new
		 * JDatePickerImpl(datePanel);
		 */

		// create components
		bookedLabel = new JLabel("Sorry, that spot is fully booked for the # of people you entered");//for the # of people they entered
		bookedLabel.setVisible(false);
		exit = new JButton("X");
		exit.setFont(new Font("Arial", Font.PLAIN, 40));
		exit.setBorderPainted(false);
		exit.addActionListener(this);
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
		bookedLabel.setBounds(750, 850, 1100, 100);
		exit.setBounds(1820, 0, 100, 100);
		cbNumPeople.setBounds(550, 450, 800, 50);
		// reservationPanel.addBorder( new EmptyBorder(10, 10, 10, 10) );
		// reservationPanel.add(cbNumPeople, constraints);
		cbDay.setBounds(550, 550, 800, 50);
		// 9999
		cbTimeSlot.setBounds(550, 650, 800, 50);
		// cbNumPeople.setSize(200, 200);
		reservationTitle.setBounds(570, 250, 800, 200);
		findButton.setBounds(730, 780, 400, 100);

		// set font here
		bookedLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		cbNumPeople.setFont(new Font("Times New Roman", Font.BOLD, 15));
		cbDay.setFont(new Font("Times New Roman", Font.BOLD, 15));
		cbTimeSlot.setFont(new Font("Times New Roman", Font.BOLD, 15));
		reservationTitle.setFont(new Font("Bittermilk", Font.PLAIN, 50));

		// add to combo box
		cbNumPeople.addItem("Number Of People");
		cbDay.addItem("Day");
		cbTimeSlot.addItem("Time");

		cbNumPeople.addItem("1");
		cbNumPeople.addItem("2");
		cbNumPeople.addItem("3");
		cbNumPeople.addItem("4");
		cbNumPeople.addItem("5");
		cbNumPeople.addItem("6");
		cbNumPeople.addItem("7");
		cbNumPeople.addItem("8");
		cbDay.addItem("7/19");
		cbDay.addItem("7/20");
		cbDay.addItem("7/21");
		cbDay.addItem("7/22");
		cbDay.addItem("7/23");
		cbDay.addItem("7/24");
		cbDay.addItem("7/25");

		cbTimeSlot.addItem("6:00 PM");
		// cbTimeSlot.addItem("6:30 PM");
		cbTimeSlot.addItem("7:00 PM");
		// cbTimeSlot.addItem("7:30 PM");
		cbTimeSlot.addItem("8:00 PM");
		// cbTimeSlot.addItem("8:30 PM");
		cbTimeSlot.addItem("9:00 PM");

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
		lpReservation.add(exit, new Integer(100));
		lpReservation.add(bookedLabel, new Integer(100));


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

	public void reservationsPage2() {

		JavaDinerButtonR = new JButton();
		JavaDinerButtonR.addActionListener(this);
		JavaDinerButtonR.setBounds(720, 30, 450, 110);
		JavaDinerButtonR.setBorderPainted(false);
		JavaDinerButtonR.setContentAreaFilled(false);
		JavaDinerButtonR.setToolTipText("Return to main page");

		didNotFill = new JLabel("Please enter information in all the fields");
		didNotFill.setBounds(120, 650, 1000, 50);
		didNotFill.setFont(new Font("Bittermilk", Font.PLAIN, 35));
		didNotFill.setVisible(false);

		resultOfFindingTable = new JLabel("Reservation at that time is available");
		resultOfFindingTable.setBounds(670, 120, 600, 200);
		resultOfFindingTable.setFont(new Font("Bittermilk", Font.PLAIN, 40));

		resultOfConfirmR = new JLabel("We have reserved your seats!");
		resultOfConfirmR.setBounds(870, 390, 600, 200);
		resultOfConfirmR.setFont(new Font("Bittermilk", Font.PLAIN, 50));
		resultOfConfirmR.setVisible(false);

		confirmReservationButton = new JButton();
		confirmReservationButton.setBounds(600, 790, 650, 120);
		confirmReservationButton.setBorderPainted(false);
		confirmReservationButton.setContentAreaFilled(false);
		confirmReservationButton.addActionListener(this);

		labelNameR = new JLabel("Name");
		labelNameR.setBounds(120, 400, 200, 50);
		labelNameR.setFont(new Font("Bittermilk", Font.PLAIN, 30));

		tfNameR = new JTextField();
		tfNameR.setBounds(120, 450, 400, 50);
		tfNameR.setFont(new Font("Bittermilk", Font.PLAIN, 30));

		labelTelephoneNumR = new JLabel("Telephone #");
		labelTelephoneNumR.setBounds(120, 500, 200, 50);
		labelTelephoneNumR.setFont(new Font("Bittermilk", Font.PLAIN, 30));

		tfTelephoneNumR = new JTextField();
		tfTelephoneNumR.setBounds(120, 550, 400, 50);
		tfTelephoneNumR.setFont(new Font("Bittermilk", Font.PLAIN, 30));

		reservationLabel2 = new JLabel();
		reservationLabel2.setIcon(new ImageIcon("C:/SavedPictures/reservationPage2.jpg"));
		reservationLabel2.setBounds(0, 0, 1920, 1080);

		lpReservation2 = new JLayeredPane();
		lpReservation2.setPreferredSize(new Dimension(1920, 1080));
		lpReservation2.add(reservationLabel2, new Integer(50));
		lpReservation2.add(tfNameR, new Integer(100));
		lpReservation2.add(tfTelephoneNumR, new Integer(100));
		lpReservation2.add(labelNameR, new Integer(100));
		lpReservation2.add(labelTelephoneNumR, new Integer(100));
		lpReservation2.add(confirmReservationButton, new Integer(100));
		lpReservation2.add(resultOfFindingTable, new Integer(100));
		lpReservation2.add(resultOfConfirmR, new Integer(100));
		lpReservation2.add(JavaDinerButtonR, new Integer(100));
		lpReservation2.add(didNotFill, new Integer(100));


		reservationFrame2 = new JFrame();
		reservationFrame2.add(lpReservation2);
		// reservationFrame.add(reservationPanel);
		reservationFrame2.setVisible(false);
		reservationFrame2.setSize(1920, 1080);
		reservationFrame2.setTitle("Reservations");
		/// reservationLabel.setSize(1920, 1080);
		reservationFrame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		reservationFrame2.setResizable(false);
	}

	public void CartPage() {
		/*
		 * RestaurantProject.taCart = new JTextArea();
		 * RestaurantProject.taCart.setEditable(false);
		 * RestaurantProject.taCart.setFont(new Font("Bittermilk", Font.BOLD, 30));
		 * 
		 * RestaurantProject.totalCost = new JTextArea();
		 * RestaurantProject.totalCost.setEditable(false);
		 * RestaurantProject.totalCost.setBounds(1450, 750, 370, 180);
		 * RestaurantProject.totalCost.setFont(new Font("Bittermilk", Font.BOLD, 30));
		 * // static JLabel headings = new JLabel("Food & Beverages \t \t Quantity \t //
		 * Price");
		 * 
		 * RestaurantProject.spItems = new JScrollPane(RestaurantProject.taCart);
		 * RestaurantProject.spItems.setVerticalScrollBarPolicy(ScrollPaneConstants.
		 * VERTICAL_SCROLLBAR_ALWAYS); RestaurantProject.spItems.setBounds(50, 350,
		 * 1770, 400);
		 * 
		 */

		checkoutButton = new JButton();
		checkoutButton.addActionListener(this);
		checkoutButton.setBounds(1565, 930, 350, 120);
		checkoutButton.setBorderPainted(false);
		checkoutButton.setContentAreaFilled(false);
		checkoutButton.setToolTipText("Continue With Order");

		/*
		 * backToShoppingButton = new JButton();
		 * backToShoppingButton.addActionListener(this);
		 * backToShoppingButton.setBounds(65, 930, 700, 120);
		 * backToShoppingButton.setBorderPainted(false);
		 * backToShoppingButton.setContentAreaFilled(false);
		 * backToShoppingButton.setToolTipText("Continue Shopping");
		 */

		cartLabel = new JLabel();
		cartLabel.setIcon(new ImageIcon("C:/SavedPictures/MyOrder.jpg"));
		cartLabel.setBounds(0, 0, 1920, 1080);

		lpCart = new JLayeredPane();
		lpCart.setPreferredSize(new Dimension(1920, 1080));
		lpCart.add(cartLabel, new Integer(50));
		lpCart.add(checkoutButton, new Integer(100));
		// lpCart.add(backToShoppingButton, new Integer(100));

		cartFrame = new JFrame();
		cartFrame.add(lpCart);
		cartFrame.setVisible(false);
		cartFrame.setSize(1920, 1080);
		cartFrame.setTitle("My Order");
		cartFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cartFrame.setResizable(false);
	}

	public void DeliveryOrCarryoutPage() {

		deliveryButton = new JButton();
		deliveryButton.addActionListener(this);
		deliveryButton.setBounds(600, 175, 300, 285);
		deliveryButton.setBorderPainted(false);
		deliveryButton.setContentAreaFilled(false);
		deliveryButton.setToolTipText("Choose Delivery Option");
		// deliveryButton.ToolTip.font(new Font("Arial", Font.BOLD, 30));

		name = new JLabel("Name");
		address = new JLabel("Address");
		city = new JLabel("City");
		zip = new JLabel("Zip");
		telephoneNum = new JLabel("Telephone #");

		name.setFont(new Font("Bittermilk", Font.PLAIN, 25));
		address.setFont(new Font("Bittermilk", Font.PLAIN, 25));
		city.setFont(new Font("Bittermilk", Font.PLAIN, 25));
		zip.setFont(new Font("Bittermilk", Font.PLAIN, 25));
		telephoneNum.setFont(new Font("Bittermilk", Font.PLAIN, 25));

		name.setBounds(600, 450, 600, 100);
		telephoneNum.setBounds(600, 575, 600, 100);
		address.setBounds(600, 700, 600, 100);
		city.setBounds(600, 825, 400, 100);
		zip.setBounds(1050, 825, 100, 100);

		tfName = new JTextField();
		tfAddress = new JTextField();
		tfCity = new JTextField();
		tfZip = new JTextField();
		tfTelephoneNum = new JTextField();

		tfName.setFont(new Font("Bittermilk", Font.PLAIN, 25));
		tfAddress.setFont(new Font("Bittermilk", Font.PLAIN, 25));
		tfCity.setFont(new Font("Bittermilk", Font.PLAIN, 25));
		tfZip.setFont(new Font("Bittermilk", Font.PLAIN, 25));
		tfTelephoneNum.setFont(new Font("Bittermilk", Font.PLAIN, 25));

		tfName.setBounds(600, 515, 600, 50);
		tfTelephoneNum.setBounds(600, 640, 600, 50);
		tfAddress.setBounds(600, 765, 600, 50);
		tfCity.setBounds(600, 890, 400, 50);
		tfZip.setBounds(1050, 890, 150, 50);

		carryoutButton = new JButton();
		carryoutButton.addActionListener(this);
		carryoutButton.setBounds(950, 175, 260, 285);
		carryoutButton.setBorderPainted(false);
		carryoutButton.setContentAreaFilled(false);
		carryoutButton.setToolTipText("Choose Carryout Option");

		placeOrderButton = new JButton();
		placeOrderButton.addActionListener(this);
		placeOrderButton.setBounds(1405, 510, 420, 130);
		placeOrderButton.setBorderPainted(false);
		placeOrderButton.setContentAreaFilled(false);
		placeOrderButton.setToolTipText("Place Order");

		goBackToCartButton = new JButton();
		goBackToCartButton.addActionListener(this);
		goBackToCartButton.setBounds(50, 490, 420, 130);
		goBackToCartButton.setBorderPainted(false);
		goBackToCartButton.setContentAreaFilled(false);
		goBackToCartButton.setToolTipText("Go Back to Cart");

		exitButtonChoice = new JButton("EXIT");
		exitButtonChoice.addActionListener(this);
		exitButtonChoice.setBounds(1770, 0, 150, 150);
		exitButtonChoice.setFont(new Font("Arial", Font.PLAIN, 40));
		exitButtonChoice.setBorderPainted(false);
		exitButtonChoice.setToolTipText("Exit the website");

		choiceLabel = new JLabel();
		choiceLabel.setIcon(new ImageIcon("C:/SavedPictures/DeliveryOrCarryout.jpg"));
		choiceLabel.setBounds(0, 0, 1920, 1080);

		result = new JLabel("\nYour order has been placed!");
		result.setFont(new Font("Arial", Font.PLAIN, 30));
		result.setBounds(1415, 610, 420, 130);
		result.setVisible(false);

		lpChoice = new JLayeredPane();
		lpChoice.setPreferredSize(new Dimension(1920, 1080));
		lpChoice.add(choiceLabel, new Integer(50));
		lpChoice.add(deliveryButton, new Integer(100));
		lpChoice.add(carryoutButton, new Integer(100));
		lpChoice.add(placeOrderButton, new Integer(100));
		lpChoice.add(goBackToCartButton, new Integer(100));
		lpChoice.add(name, new Integer(100));
		lpChoice.add(telephoneNum, new Integer(100));
		lpChoice.add(city, new Integer(100));
		lpChoice.add(address, new Integer(100));
		lpChoice.add(zip, new Integer(100));
		lpChoice.add(tfName, new Integer(100));
		lpChoice.add(tfTelephoneNum, new Integer(100));
		lpChoice.add(tfCity, new Integer(100));
		lpChoice.add(tfAddress, new Integer(100));
		lpChoice.add(tfZip, new Integer(100));
		lpChoice.add(result, new Integer(100));
		lpChoice.add(exitButtonChoice, new Integer(100));

		name.setVisible(false);
		telephoneNum.setVisible(false);
		city.setVisible(false);
		address.setVisible(false);
		zip.setVisible(false);
		tfName.setVisible(false);
		tfAddress.setVisible(false);
		tfCity.setVisible(false);
		tfZip.setVisible(false);
		tfTelephoneNum.setVisible(false);

		choiceFrame = new JFrame();
		choiceFrame.add(lpChoice);
		choiceFrame.setVisible(false);
		choiceFrame.setSize(1920, 1080);
		choiceFrame.setTitle("My Order");
		choiceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		choiceFrame.setResizable(false);

	}

	public void aboutUsPage() {

		JavaDinerButtonAboutUs = new JButton();
		JavaDinerButtonAboutUs.addActionListener(this);
		JavaDinerButtonAboutUs.setBounds(720, 30, 450, 110);
		JavaDinerButtonAboutUs.setBorderPainted(false);
		JavaDinerButtonAboutUs.setContentAreaFilled(false);
		JavaDinerButtonAboutUs.setToolTipText("Return to main page");

		taAboutUs = new JTextArea();
		taAboutUs.setEditable(false);
		taAboutUs.setBounds(20, 170, 780, 850);
		taAboutUs.setFont(new Font("Bittermilk", Font.PLAIN, 40));
		taAboutUs.append(
				"\nIn 1952, Java Diner was opened and became an \nimmediate success. It was opened first by a man \nnicknamed Java Virtual Machine. "
						+ "He created the \nbest pizza and pasta recipes and used the finest \ningredients. He taught his chefs first-rate \ncooking techniques. \n\n"
						+ "Today, we use only his superior ingredients, \nalong with his original recipes to bake \nextraordinary pizzas and cook outstanding \npastas that are worth sharing.\n\n");
		taAboutUs.append("Phone #: (123) 123-1010 \n");
		taAboutUs.append("Location: 101 Java Road, San Francisco CA\n");
		taAboutUs.append("Hours: 6pm - 9pm Monday-Sunday");
		aboutUsLabel = new JLabel();
		aboutUsLabel.setIcon(new ImageIcon("C:/SavedPictures/AboutUs.jpg"));
		aboutUsLabel.setBounds(0, 0, 1920, 1080);

		layeredPaneAU = new JLayeredPane();
		layeredPaneAU.setPreferredSize(new Dimension(1920, 1080));
		layeredPaneAU.add(aboutUsLabel, new Integer(50));
		layeredPaneAU.add(JavaDinerButtonAboutUs, new Integer(100));
		layeredPaneAU.add(taAboutUs, new Integer(100));

		frameAboutUs = new JFrame();
		frameAboutUs.setSize(1920, 1080);
		frameAboutUs.setResizable(false);
		frameAboutUs.setTitle("Restaurant");
		frameAboutUs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameAboutUs.setVisible(false);
		frameAboutUs.setLocationRelativeTo(null);
		frameAboutUs.add(layeredPaneAU);
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
			framePasta.setVisible(true);
			frame.setVisible(false);
		} else if (s == "Dessert") {
			frame.setVisible(false);
		} else if (s == "Beverage") {
			frame.setVisible(false);
		}

		if (e.getSource() == reservationButton) {
			reservationFrame.setVisible(true);
			frame.setVisible(false);
		} else if (e.getSource() == aboutUsButton) {
			frameAboutUs.setVisible(true);
			frame.setVisible(false);
		}

		System.out.println("Arraylist size : before addto cart" + orderList.size());
		// Add order to Arraylist to store info in memory
		// try {

		// to add to cart
		if (e.getSource() == orderPizzaButton1) {
			tempOrderObj = new Order();
			// tempOrderObj.addToCart(customerObj.phoneNumber, pizza1.getText(), 1, 15.00);
			tempOrderObj.addToCart(pizza1.getText(), 1, 12.00);
			orderList.add(tempOrderObj);
			System.out.println("added to Cart");

		} else if (e.getSource() == orderPizzaButton2) {
			tempOrderObj = new Order();
			tempOrderObj.addToCart(pizza2.getText(), 1, 11.50);
			orderList.add(tempOrderObj);
			System.out.println("added to Cart");

		} else if (e.getSource() == orderPizzaButton3) {
			tempOrderObj = new Order();
			tempOrderObj.addToCart(pizza3.getText(), 1, 10.00);
			orderList.add(tempOrderObj);
			System.out.println("added to Cart");

		} else if (e.getSource() == orderPizzaButton4) {
			tempOrderObj = new Order();
			tempOrderObj.addToCart(pizza4.getText(), 1, 6.00);
			orderList.add(tempOrderObj);
			System.out.println("added to Cart");
		}

		if (e.getSource() == orderPastaButton1) {
			tempOrderObj = new Order();
			tempOrderObj.addToCart(pasta1.getText(), 1, 12.00);
			orderList.add(tempOrderObj);
			System.out.println("added to Cart");

		} else if (e.getSource() == orderPastaButton2) {
			tempOrderObj = new Order();
			tempOrderObj.addToCart(pasta2.getText(), 1, 11.50);
			orderList.add(tempOrderObj);
			System.out.println("added to Cart");

		} else if (e.getSource() == orderPastaButton3) {
			tempOrderObj = new Order();
			tempOrderObj.addToCart(pasta3.getText(), 1, 10.00);
			orderList.add(tempOrderObj);
			System.out.println("added to Cart");

		} else if (e.getSource() == orderPastaButton4) {
			tempOrderObj = new Order();
			tempOrderObj.addToCart(pasta4.getText(), 1, 10.00);
			orderList.add(tempOrderObj);
			System.out.println("added to Cart");

		}

		if (e.getSource() == JavaDinerButtonPizza) {
			frame.setVisible(true);
			framePizza.setVisible(false);
		} else if (e.getSource() == JavaDinerButtonPasta) {
			frame.setVisible(true);
			framePasta.setVisible(false);
		} else if (e.getSource() == JavaDinerButtonAboutUs) {
			frame.setVisible(true);
			frameAboutUs.setVisible(false);
		}

		if (e.getSource() == exit) {
			frame.setVisible(true);
			reservationFrame.setVisible(false);
		}

		String numOfPeople = (String) cbNumPeople.getSelectedItem();
		String dateOfReservation = (String) cbDay.getSelectedItem();
		String timeSlot = (String) cbTimeSlot.getSelectedItem();

		if (e.getSource() == findButton) {
			try {
				// static void findTable(String dateOfReservation, String timeSlot ) throws
				// SQLException {
				capacity = Reservation.findTable(dateOfReservation, timeSlot);
				System.out.println("DEBUG :capacity inside main program :" + capacity);
				if (capacity == 0 || (Integer.parseInt(numOfPeople) > capacity)) {
					System.out.println("please select a different date / timeslot as it is fully booked ");
					bookedLabel.setVisible(true);
				} else {
					reservationFrame2.setVisible(true);
					reservationFrame.setVisible(false);
				}
			} catch (Exception e1) {
				System.out.println("Debug findtable :" + e1.getMessage());
				e1.printStackTrace(System.out);
			}

		}

		if (e.getSource() == confirmReservationButton) {
			
			if (tfNameR.getText().length() < 1 || tfTelephoneNumR.getText().length() < 1) {
				didNotFill.setVisible(true);
				
			} else {
				String name = (String) tfNameR.getText();
				String telephoneNum = (String) tfTelephoneNumR.getText();
				try {
					// static void placeReservation(String name, String phoneNum, String
					// numOfPeople, String dateOfReservation, String timeSlot) throws SQLException {
					System.out.println("capacity used in place reservation method:" + capacity);
					Reservation.placeReservation(name, telephoneNum, numOfPeople, dateOfReservation, timeSlot,
							capacity);
				} catch (Exception e1) {
					System.out.println("Debug Reservation :" + e1.getMessage());
					e1.printStackTrace(System.out);
				}

				resultOfConfirmR.setVisible(true);
				confirmReservationButton.setEnabled(false);
				bookedLabel.setVisible(false);
			}

		}

		if (e.getSource() == JavaDinerButtonR) {
			frame.setVisible(true);
			resultOfConfirmR.setVisible(false);
			confirmReservationButton.setEnabled(true);
			reservationFrame2.setVisible(false);
			didNotFill.setVisible(false);

		}

		// to see cart
		if (e.getSource() == orderingPageButton) {
			cartFrame.setVisible(true);
			Order.displayOrder(orderList);
			frame.setVisible(false);
			System.out.println("Arraylist size : place order page: " + orderList.size());
		}

		/*
		 * if (e.getSource() == backToShoppingButton) { frame.setVisible(true);
		 * cartFrame.setVisible(false); }
		 */

		if (e.getSource() == checkoutButton) {
			choiceFrame.setVisible(true);
			cartFrame.setVisible(false);
		}

		if (e.getSource() == deliveryButton) {

			name.setVisible(true);
			telephoneNum.setVisible(true);
			city.setVisible(true);
			address.setVisible(true);
			zip.setVisible(true);
			tfName.setVisible(true);
			tfAddress.setVisible(true);
			tfCity.setVisible(true);
			tfZip.setVisible(true);
			tfTelephoneNum.setVisible(true);

		} else if (e.getSource() == carryoutButton) {

			name.setVisible(true);
			telephoneNum.setVisible(true);
			city.setVisible(false);
			address.setVisible(false);
			zip.setVisible(false);
			tfName.setVisible(true);
			tfAddress.setVisible(false);
			tfCity.setVisible(false);
			tfZip.setVisible(false);
			tfTelephoneNum.setVisible(true);

		}

		if (e.getSource() == goBackToCartButton) {
			cartFrame.setVisible(true);
			choiceFrame.setVisible(false);

			deliveryButton.setEnabled(true);
			carryoutButton.setEnabled(true);

			name.setVisible(false);
			telephoneNum.setVisible(false);
			city.setVisible(false);
			address.setVisible(false);
			zip.setVisible(false);
			tfName.setVisible(false);
			tfAddress.setVisible(false);
			tfCity.setVisible(false);
			tfZip.setVisible(false);
			tfTelephoneNum.setVisible(false);

			tfName.setText("");
			tfAddress.setText("");
			tfCity.setText("");
			tfZip.setText("");
			tfTelephoneNum.setText("");
		}

		try {

			if (e.getSource() == placeOrderButton) {
				result.setVisible(true);
				tempCustomerObj.name = tfName.getText();
				tempCustomerObj.streetAddress = tfAddress.getText();
				tempCustomerObj.zip = tfZip.getText();
				tempCustomerObj.city = tfCity.getText();
				tempCustomerObj.phoneNumber = tfTelephoneNum.getText();

				// customerList.add(tempCustomerObj);
				System.out.println("Name :" + tempCustomerObj.name);
				System.out.println("phone :" + tempCustomerObj.phoneNumber);
				Order.placeOrder(orderList, tempCustomerObj);
				System.out.println("Order has been placed ");

				placeOrderButton.setEnabled(false);
				goBackToCartButton.setEnabled(false);

				exitButtonChoice.setEnabled(true);
				// main(null);

				name.setVisible(false);
				telephoneNum.setVisible(false);
				city.setVisible(false);
				address.setVisible(false);
				zip.setVisible(false);
				tfName.setVisible(false);
				tfAddress.setVisible(false);
				tfCity.setVisible(false);
				tfZip.setVisible(false);
				tfTelephoneNum.setVisible(false);

				tfName.setText("");
				tfAddress.setText("");
				tfCity.setText("");
				tfZip.setText("");
				tfTelephoneNum.setText("");

			}

		} catch (Exception e1) {
			System.out.println("Debug :" + e1.getMessage());
			e1.printStackTrace(System.out);
		}

		// DEBUG
		// ArrayList<Order> orderList = new ArrayList<Order>();

		if (e.getSource() == exitButtonChoice) {
			System.exit(0);
		}

	}

}
