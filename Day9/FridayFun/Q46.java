package Day9.FridayFun;

public class Q46 {

	public static void main(String[] args) {
		Bank1 b = new Bank1("Gayathri", 234517, "Debit Card", 8626);
		b.deposit(8626);
		b.displayDetails();
	}
	}

	class Bank1{
		String nameOfTheDepositer;
		double accountNo;
		String typeOfAccount;
		int balance;
		
		public Bank1(String nameOfTheDepositer, double accountNo, String typeOfAccount, int balance) {
			//super();
			this.nameOfTheDepositer = nameOfTheDepositer;
			this.accountNo = accountNo;
			this.typeOfAccount = typeOfAccount;
			this.balance = balance;
		}

		public void deposit(int deposit)
		{
			CheckBalance();
			balance = balance + deposit;
		}
		
		public int CheckBalance()
		{
			return balance;
		}
		
		public void displayDetails()
		{
			System.out.println("Name: "+nameOfTheDepositer);
			System.out.println("Balance: "+balance);
		}
	}
