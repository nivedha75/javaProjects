/*This is the second version of the banking system code. The comments from the original program applies here
 * In this code, I am able to call the withdraw method first and then call the deposit
 * I modified the array data and the scanners in order to make this change
 * 
 * NOTE 1: I tried to make some big changes in the setup in the program, but the changes only decreased the efficacy of the code
 * so I decided to just change the flow by switching the methods but achieve the same results! 
 * 
 * NOTE 2: I made some edits to the original banking system after creating this banking system version. Thus, I made sure
 * that the user can enter negative values and the computer can handle it in the original banking system. Thus, please test out
 * that feature in the other version, instead of this one. Thanks!*/

package buddy;

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
	String name = "";
	int ID = 0;
	// use this static variable to create IDs in constructor
	static int lastAssignedID = 0;

	Customer(String name) {
		// assign customer name and ID
		this.name = name;
		ID = ++lastAssignedID;
	}
}

class BankAccount {

	//int accountNum = 0;
	double balance = 0.0;
	String accountType = "";
	String transactionType = "";// Deposit, Withdrawal
	int customerID = 0;

}

class CheckingAccount extends BankAccount {

	CheckingAccount(int customerID, double initialAmount) {
		this.customerID = customerID;
		this.balance = initialAmount;
		this.accountType = "checking";
	}

}

class SavingsAccount extends BankAccount {
	SavingsAccount(int customerID, double initialAmount) {
		this.customerID = customerID;
		this.balance = initialAmount;
		this.accountType = "savings";
	}
}

class BankMaintenance {

	static ArrayList<Customer> customerList = new ArrayList<Customer>();
	// this array list contains checking and savings accounts
	static ArrayList<BankAccount> bankAccountList = new ArrayList<BankAccount>();
	static double transaction[] = new double[3];

	static void deposit(int customerID, double amount) {
		for (int i = 0; i < bankAccountList.size(); i++) {
			BankAccount tempBankAccount = bankAccountList.get(i);
			if (tempBankAccount.customerID == customerID && tempBankAccount.accountType == "checking") {
				tempBankAccount.balance += amount;
				System.out.println("Current balance in the checking account: $" + tempBankAccount.balance);
				// tempBankAccount.deposit(customerID, amount);
				bankAccountList.set(i, tempBankAccount);
				transaction[1] = amount;
				System.out.println("Overall change in checking account: $" + (transaction[1] - transaction[0]));
			}
		}
	}

	static void withdrawal(int customerID, double amount) {
		for (int i = 0; i < bankAccountList.size(); i++) {
			BankAccount tempBankAccount = bankAccountList.get(i);
			if (tempBankAccount.customerID == customerID && tempBankAccount.accountType == "checking") {

				if (tempBankAccount.balance >= amount) {
					tempBankAccount.balance -= amount;
					System.out
							.println("Current balance in the checking account: $" + tempBankAccount.balance);
					// tempBankAccount.deposit(customerID, amount);
					bankAccountList.set(i, tempBankAccount);
					transaction[0] = amount;
					System.out.println("Overall change in checking account: $" + (-transaction[0]));
					break;
				} else {
					transaction[0] = 0;
					System.out.println(
							"You cannot withdraw that amount. Your balance is less than the amount you are trying to withdraw.");
					break;
				}
			}
		}
	}

	static void transfer(int customerID, double amount) {
		for (int i = 0; i < bankAccountList.size(); i++) {
			BankAccount tempBankAccount = bankAccountList.get(i);
			if (tempBankAccount.customerID == customerID && tempBankAccount.accountType == "checking") {

				if (tempBankAccount.balance >= amount) {
					tempBankAccount.balance -= amount;
					System.out
							.println("Current balance in the checking account: $" + tempBankAccount.balance);
					// tempBankAccount.deposit(customerID, amount);
					bankAccountList.set(i, tempBankAccount);
					transaction[2] = amount;
					System.out.println("Overall change in checking account: $"
							+ (transaction[1] - transaction[0] - transaction[2]));
					break;
				} else {
					transaction[2] = 0;
					System.out.println(
							"You cannot withdraw that amount. Your balance is less than the amount you are trying to withdraw.");
					break;
				}
			}
		}

		for (int i = 0; i < bankAccountList.size(); i++) {
			if (transaction[2] == amount) {
				BankAccount tempBankAccount = bankAccountList.get(i);
				if (tempBankAccount.customerID == customerID && tempBankAccount.accountType == "savings") {
					tempBankAccount.balance += amount;
					System.out
							.println("Current balance in the savings account: $" + tempBankAccount.balance);
					// tempBankAccount.deposit(customerID, amount);
					bankAccountList.set(i, tempBankAccount);
				}
			}
		}

	}

	static void addCustomer(String name) {

		Customer customer = new Customer(name);
		customerList.add(customer);
		System.out.println("Your customer ID is " + customer.ID);

	}

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

public class BankingSystem_Version2 {

	static void displayBalance() {
		// System.out.println(this.balance);
	}

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Hello! Welcome to the World's Most Awesome Bank!");

		Scanner customerType = new Scanner(System.in);
		System.out.println("Are you a new customer? Enter yes or no.");
		String type = customerType.nextLine();

		if (type.equalsIgnoreCase("yes")) {
			Scanner customerName = new Scanner(System.in);
			System.out.println("What is your name?");
			String name = customerName.nextLine();
			BankMaintenance.addCustomer(name);

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
			
			Scanner withdrawalAmount = new Scanner(System.in);
			System.out.println("How much do you want to withdraw from your checking account?");
			double withdrawal = withdrawalAmount.nextDouble();

			BankMaintenance.withdrawal(ID, withdrawal);

			// try to display balance here
			Scanner depositAmount = new Scanner(System.in);
			System.out.println("How much do you want to deposit in your checking account?");
			double deposit = depositAmount.nextDouble();

			// CheckingAccount tempObj = new CheckingAccount();
			// CheckingAccount.deposit(ID, deposit);
			BankMaintenance.deposit(ID, deposit);


			Scanner transferScanner = new Scanner(System.in);
			System.out.println("How much do you want to transfer from your checking account to your savings account?");
			double transferAmount = transferScanner.nextDouble();

			BankMaintenance.transfer(ID, transferAmount);

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

