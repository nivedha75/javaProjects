package myPackage;

//import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;


class BankAccount {
	String name = "";
	double balance = 0.0;
	String accountType = "";
	String transactionType = "";// Deposit, Withdrawal
	int accountNumber = 0;
	//int customerID=0;
	// use this static variable to create IDs in constructor
	static int lastAssignedID = 0;
	
	BankAccount(String name){
		accountNumber = ++lastAssignedID;
		this.name = name;
		System.out.println("This is the account # for the current account: " + accountNumber);
	}

}

class CheckingAccount extends BankAccount {

	CheckingAccount(String name, double initialAmount) {
		super(name);
		this.balance = initialAmount;
		this.accountType = "checking";
	}

}

class SavingsAccount extends BankAccount {
	SavingsAccount(String name, double initialAmount) {
		super(name);
		this.balance = initialAmount;
		this.accountType = "savings";
	}
}

class BankMaintenance {

	//static ArrayList<Customer> customerList = new ArrayList<Customer>();
	// this array list contains checking and savings accounts
	static ArrayList<BankAccount> bankAccountList = new ArrayList<BankAccount>();
	static double transaction[] = new double[3];

	static void deposit(int accountNumber, double amount) {
		for (int i = 0; i < bankAccountList.size(); i++) {
			BankAccount tempBankAccount = bankAccountList.get(i);
			if (tempBankAccount.accountNumber == accountNumber && tempBankAccount.accountType == "checking") {
				tempBankAccount.balance += amount;
				System.out.println("Current balance in the checking account: " + tempBankAccount.balance);
				// tempBankAccount.deposit(accountNumber, amount);
				bankAccountList.set(i, tempBankAccount);
				transaction[0] = amount;
				System.out.println("Overall change in checking account: " + transaction[0]);
			}
		}
	}

	static void withdrawal(int accountNumber, double amount) {
		for (int i = 0; i < bankAccountList.size(); i++) {
			BankAccount tempBankAccount = bankAccountList.get(i);
			if (tempBankAccount.accountNumber == accountNumber && tempBankAccount.accountType == "checking") {

				if (tempBankAccount.balance >= amount) {
					tempBankAccount.balance -= amount;
					System.out
							.println("Current balance in the checking account: " + tempBankAccount.balance);
					// tempBankAccount.deposit(accountNumber, amount);
					bankAccountList.set(i, tempBankAccount);
					transaction[1] = amount;
					System.out.println("Overall change in checking account: " + (transaction[0] - transaction[1]));
					break;
				} else {
					transaction[1] = 0;
					System.out.println(
							"You cannot withdraw that amount. Your balance is less than the amount you are trying to withdraw.");
					break;
				}
			}
		}
	}

	static void transfer(int accountNumber, double amount) {
		for (int i = 0; i < bankAccountList.size(); i++) {
			BankAccount tempBankAccount = bankAccountList.get(i);
			if (tempBankAccount.accountNumber == accountNumber && tempBankAccount.accountType == "checking") {

				if (tempBankAccount.balance >= amount) {
					tempBankAccount.balance -= amount;
					System.out
							.println("Current balance in the checking account: " + tempBankAccount.balance);
					// tempBankAccount.deposit(accountNumber, amount);
					bankAccountList.set(i, tempBankAccount);
					transaction[2] = amount;
					System.out.println("Overall change in checking account: "
							+ (transaction[0] - transaction[1] - transaction[2]));
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
				if (tempBankAccount.accountNumber == accountNumber && tempBankAccount.accountType == "savings") {
					tempBankAccount.balance += amount;
					System.out
							.println("Current balance in the savings account: " + tempBankAccount.balance);
					// tempBankAccount.deposit(accountNumber, amount);
					bankAccountList.set(i, tempBankAccount);
				}
			}
		}

	}

	static void checkOverallChange() {
		System.out.println("The overall change");
	}

	
	static void addAccount(String name, String accountType, double initialAmount) {

		if (accountType.equalsIgnoreCase("checking")) {
			CheckingAccount checkingObj = new CheckingAccount(name, initialAmount);
			bankAccountList.add(checkingObj);
		} else if (accountType.equalsIgnoreCase("savings")) {
			SavingsAccount savingsObj = new SavingsAccount(name, initialAmount);
			bankAccountList.add(savingsObj);
		} else {
			System.out.println("Invalid account. Try again.");
		}

	}

}

public class BankingSystem2 {

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

			Scanner accountType = new Scanner(System.in);
			System.out.println("Do you want to make a savings or checking account first?");
			String account = accountType.nextLine();

			Scanner amount = new Scanner(System.in);
			System.out.println("How much do you want to deposit in your account initially?");
			double initialAmount = amount.nextDouble();

			BankMaintenance.addAccount(name, account, initialAmount);

			String answer = "";
			if (account.equalsIgnoreCase("checking")) {
				answer = "savings";
			} else {
				answer = "checking";
			}

			Scanner amount2 = new Scanner(System.in);
			System.out.println("How much do you want to deposit in your " + answer + " account initially?");
			double initialAmount2 = amount2.nextDouble();

			BankMaintenance.addAccount(name, answer, initialAmount2);

			Thread.sleep(2000);
			System.out.println("A week has passed...");
			Thread.sleep(2000);
			
			Scanner questionID = new Scanner(System.in);
			System.out.println("Enter the ID for your checking account.");
			int ID = questionID.nextInt();
			
			// try to display balance here
			Scanner depositAmount = new Scanner(System.in);
			System.out.println("How much do you want to deposit in your checking account?");
			double deposit = depositAmount.nextDouble();

			// CheckingAccount tempObj = new CheckingAccount();
			// CheckingAccount.deposit(ID, deposit);
			BankMaintenance.deposit(ID, deposit);

			Scanner withdrawalAmount = new Scanner(System.in);
			System.out.println("How much do you want to withdraw from your checking account?");
			double withdrawal = withdrawalAmount.nextDouble();

			BankMaintenance.withdrawal(ID, withdrawal);

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
		 * tempBankAccount = bankAccountList.get(i); if (tempBankAccount.accountNumber ==
		 * accountNumber && tempBankAccount.accountType == "checking") {
		 * tempBankAccount.deposit(accountNumber, amount); bankAccountList.set(i,
		 * tempBankAccount); balance += amount; System.out.println(balance);
		 * 
		 * } }
		 */

	}

}

