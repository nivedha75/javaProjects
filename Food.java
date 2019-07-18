package RestaurantCentral;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

import oracle.jdbc.pool.OracleDataSource;

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

