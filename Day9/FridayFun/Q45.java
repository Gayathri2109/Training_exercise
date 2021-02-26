package Day9.FridayFun;

public class Q45 {
public static void main(String[] args) {
	Bank b = new Bank();
	b.Assign("Gayathri", 234517, "Debit Card", 8626);
	b.deposit(8626);
	b.displayDetails();
}
}

class Bank{
	String nameOfTheDepositer;
	double accountNo;
	String typeOfAccount;
	int balance;
	
	public void Assign(String s,double d,String str,int b)
	{
		accountNo = d;
		balance = b;
		nameOfTheDepositer = s;
		typeOfAccount = str;
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