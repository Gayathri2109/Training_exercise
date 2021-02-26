package Day9.FridayFun;

public class Q10 {
	
	//JVM searches for the main method and starts executing from it.
	//We can write the main method in our program with return type other than void,
	//the program gets compiled without any compilation errors
public static int main(String[] args) {
	System.out.println("Helooo");
	return 9;
}

	//Java main method doesn't return anything, 
	//that's why it's return type is void .
	//This has been done to keep things simple because once the main method is finished executing,
	//java program terminates. 
	//So there is no point in returning anything,
	//there is nothing that can be done for the returned object by JVM.
}
