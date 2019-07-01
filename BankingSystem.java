/*In this banking project, a person(the user) comes to the bank. They get a checking account and a savings account. Then a week passes and 
 * the person is depositing and withdrawing money from the bank and transfering money from their checking account to their savings account.
 * 
 * In my code, I included new concepts like inheritance-I used two extended classes and the super() line in the constructor of a subclass to 
 * call the super class's constructor.
 * 
 * NOTE: I tried making this project use object-orientated concepts properly but in that case, I had to move the arraylist changes
 * outside of the three methods. Since, you had given those requirements, I had to make most of my variables and methods static.*/

package banking;

//import java.util.Arrays;
import java.util.Scanner;

/*import myPackage.BankAccount;
import myPackage.BankMaintenance;
import myPackage.CheckingAccount;
import myPackage.Customer;
import myPackage.SavingsAccount;
*/

import java.util.ArrayList;

//create a class customer
class Customer {
	// instance variables

	// customer name
	String name = "";
	// ID used to access accounts
	int ID = 0;

	// non-static variable

	// use this static variable to create IDs in constructor
	static int lastAssignedID = 0;

	// constructor
	Customer(String name) {
		// assign customer name and ID
		this.name = name;
		ID = ++lastAssignedID;
	}
}

//the bank account class is the super class
class BankAccount {

	// int accountNum = 0;
	double balance = 0.00;
	String accountType = "";
	String transactionType = ""; // Deposit, Withdrawal
	int customerID = 0;

}

//the first subclass is the checking account
class CheckingAccount extends BankAccount {

	CheckingAccount(int customerID, double initialAmount) {
		this.customerID = customerID;
		this.balance = initialAmount;
		this.accountType = "checking";
	}

}

//the second subclass is the savings account
class SavingsAccount extends BankAccount {
	SavingsAccount(int customerID, double initialAmount) {
		this.customerID = customerID;
		this.balance = initialAmount;
		this.accountType = "savings";
	}
}

class BankMaintenance {

	static ArrayList<Customer> customerList = new ArrayList<Customer>();

	// This array list and array are being modified and printed in the following
	// three methods

	// this array list contains checking and savings accounts(the accounts are
	// instances of the checking and savings subclasses)
	static ArrayList<BankAccount> bankAccountList = new ArrayList<BankAccount>();
	// this array will help create and print the changes to accounts
	static double transaction[] = new double[3];

	// IN THE FOLLOWING METHODS:
	// the arraylist is being modified with the balance attribute and that attribute
	// is printed
	// the array helps display the overall change to the account from the point when
	// "a week has passed"

	// first method deposits money into the checking account
	static void deposit(int customerID, double amount) {
		// the program files through the accounts stored in bacnkAccountList
		for (int i = 0; i < bankAccountList.size(); i++) {
			// it uses the get built-in function to take the account object out of the array
			BankAccount tempBankAccount = bankAccountList.get(i);
			// the customerID has to match the user input and the account type has to be
			// checking not savings
			if (tempBankAccount.customerID == customerID && tempBankAccount.accountType == "checking") {
				if (amount >= 0) {
					// add the amount to the balance
					tempBankAccount.balance += amount;
					// print the balance
					System.out.println("Current balance in the checking account: $" + tempBankAccount.balance);
					// put the modified object back into the arraylist and thus save the changes
					bankAccountList.set(i, tempBankAccount);
					// the first array value saves the first change
					transaction[0] = amount;
					// and displays it
					System.out.println("Overall change in checking account: $" + transaction[0]);
				} else {
					transaction[0] = 0;
					System.out.println("Invalid amount. Transaction is not made.");
					System.out.println("Current balance in the checking account: $" + tempBankAccount.balance);
					System.out.println("Overall change in checking account: $" + transaction[0]);
				}
			}
		}
	}

	// the second method withdraws money from the checking account
	static void withdrawal(int customerID, double amount) {
		// the array list is being modified in the same way as in the deposit method
		for (int i = 0; i < bankAccountList.size(); i++) {
			BankAccount tempBankAccount = bankAccountList.get(i);
			if (tempBankAccount.customerID == customerID && tempBankAccount.accountType == "checking") {
				// check to make sure the customer is not trying to withdraw more money than
				// they have
				if (tempBankAccount.balance >= amount && amount >= 0) {
					tempBankAccount.balance -= amount;
					System.out.println("Current balance in the checking account: $" + tempBankAccount.balance);
					bankAccountList.set(i, tempBankAccount);
					transaction[1] = amount;
					System.out.println("Overall change in checking account: $" + (transaction[0] - transaction[1]));
					break;
				} else {
					transaction[1] = 0;
					if (amount < 0) {
						System.out.println("Invalid amount. Transaction is not made.");
						System.out.println("Current balance in the checking account: $" + tempBankAccount.balance);
						System.out.println("Overall change in checking account: $" + (transaction[0] - transaction[1]));
					} else {
						System.out.println(
								"You cannot withdraw that amount. Your balance is less than the amount you are trying to withdraw.");
						System.out.println("Current balance in the checking account: $" + tempBankAccount.balance);
						System.out.println("Overall change in checking account: $" + (transaction[0] - transaction[1]));
					}
					break;
				}
			}
		}
	}

	static void transfer(int customerID, double amount) {
		// takes money out of checking
		for (int i = 0; i < bankAccountList.size(); i++) {
			BankAccount tempBankAccount = bankAccountList.get(i);
			if (tempBankAccount.customerID == customerID && tempBankAccount.accountType == "checking") {

				if (tempBankAccount.balance >= amount && amount >= 0) {
					tempBankAccount.balance -= amount;
					System.out.println("Current balance in the checking account: $" + tempBankAccount.balance);
					bankAccountList.set(i, tempBankAccount);
					transaction[2] = amount;
					System.out.println("Overall change in checking account: $"
							+ (transaction[0] - transaction[1] - transaction[2]));
					break;
				} else {
					transaction[2] = 0;
					if(amount < 0) {
						System.out.println("Invalid amount. Transaction is not made.");
						System.out.println("Current balance in the checking account: $" + tempBankAccount.balance);
						System.out.println("Overall change in checking account: $" + (transaction[0] - transaction[1] - transaction[2]));
					}else {
					System.out.println(
							"You cannot withdraw that amount. Your balance is less than the amount you are trying to withdraw.");
					System.out.println("Current balance in the checking account: $" + tempBankAccount.balance);
					System.out.println("Overall change in checking account: $" + (transaction[0] - transaction[1] - transaction[2]));
					}
					break;
				}
			}
		}

		// puts that money into savings
		for (int i = 0; i < bankAccountList.size(); i++) {
			if (transaction[2] == amount) {
				BankAccount tempBankAccount = bankAccountList.get(i);
				if (tempBankAccount.customerID == customerID && tempBankAccount.accountType == "savings") {
					tempBankAccount.balance += amount;
					System.out.println("Current balance in the savings account: $" + tempBankAccount.balance);
					// tempBankAccount.deposit(customerID, amount);
					bankAccountList.set(i, tempBankAccount);
				}
			}
		}

	}

	// create customer objects

	static void addCustomer(String name) {

		Customer customer = new Customer(name);
		customerList.add(customer);
		System.out.println("Your customer ID is " + customer.ID);

	}

	// create account objects and are used the methods

	static void addAccount(int customerID, String accountType, double initialAmount) {

		if (accountType.equalsIgnoreCase("checking")) {
			CheckingAccount checkingObj = new CheckingAccount(customerID, initialAmount);
			bankAccountList.add(checkingObj);
		} else if (accountType.equalsIgnoreCase("savings")) {
			SavingsAccount savingsObj = new SavingsAccount(customerID, initialAmount);
			bankAccountList.add(savingsObj);
		} else {
			System.out.println("Invalid account type. Try again.");
		}

	}

}

public class BankingSystem {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Hello! Welcome to the World's Most Awesome Bank!");

		Scanner customerType = new Scanner(System.in);
		System.out.println("Are you a new customer? Enter yes or no.");
		String type = customerType.nextLine();

		if (type.equalsIgnoreCase("yes")) {
			// create customer
			Scanner customerName = new Scanner(System.in);
			System.out.println("What is your name?");
			String name = customerName.nextLine();
			BankMaintenance.addCustomer(name);

			// create one account for the customer
			Scanner accountType = new Scanner(System.in);
			System.out.println("Do you want to make a savings or checking account first?");
			String account = accountType.nextLine();

			Scanner customerID = new Scanner(System.in);
			System.out.println("Enter your ID.");
			int ID = customerID.nextInt();

			Scanner amount = new Scanner(System.in);
			System.out.println("How much do you want to deposit in your account initially?");
			double initialAmount = amount.nextDouble();

			BankMaintenance.addAccount(ID, account, initialAmount);

			// create a second account for the customer
			String answer = "";
			if (account.equalsIgnoreCase("checking")) {
				answer = "savings";
			} else {
				answer = "checking";
			}

			Scanner amount2 = new Scanner(System.in);
			System.out.println("How much do you want to deposit in your " + answer + " account initially?");
			double initialAmount2 = amount2.nextDouble();

			BankMaintenance.addAccount(ID, answer, initialAmount2);

			Thread.sleep(1000);
			System.out.println("A week has passed...");
			Thread.sleep(1000);
			// starts calling the three methods here:

			// first method:

			// try to display balance here
			Scanner depositAmount = new Scanner(System.in);
			System.out.println("How much do you want to deposit in your checking account?");
			double deposit = depositAmount.nextDouble();

			// CheckingAccount tempObj = new CheckingAccount();
			// CheckingAccount.deposit(ID, deposit);
			BankMaintenance.deposit(ID, deposit);

			// second method:

			Scanner withdrawalAmount = new Scanner(System.in);
			System.out.println("How much do you want to withdraw from your checking account?");
			double withdrawal = withdrawalAmount.nextDouble();

			BankMaintenance.withdrawal(ID, withdrawal);

			// third method:

			Scanner transferScanner = new Scanner(System.in);
			System.out.println("How much do you want to transfer from your checking account to your savings account?");
			double transferAmount = transferScanner.nextDouble();

			BankMaintenance.transfer(ID, transferAmount);
			
			System.out.println("Your transactions in the bank have been made! I hope you enjoyed our service!");

		} else {
			System.out.println("Sorry I do not recognize you");
		}
		// deposit money
		// get user input: enter customer id, deposit amount , accounttype

		/*
		 * for (int i = 0; i < bankAccountList.size(); i++) { BankAccount
		 * tempBankAccount = bankAccountList.get(i); if (tempBankAccount.customerID ==
		 * customerID && tempBankAccount.accountType == "checking") {
		 * tempBankAccount.deposit(customerID, amount); bankAccountList.set(i,
		 * tempBankAccount); balance += amount; System.out.println(balance);
		 * 
		 * } }
		 */

	}

}
