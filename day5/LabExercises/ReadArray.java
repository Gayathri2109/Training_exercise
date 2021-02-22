package LabExercises;

public class ReadArray {
public static void main(String[] args) {
//	int a[] = new int[5];
//	for(int x:a)
//		System.out.print(x+" ");
//	
//	int ab[][] = {
//			{2,3},
//			{4,5,6}};
//	System.out.println();
//	for(int x1[]:ab) {
//		for(int x2:x1) {
//		System.out.print(x2+" ");}
//		
//	System.out.println();}
	
	Command com[][] = new Command[2][3];
	com[0][0] = new Command("1st row 1st col");
	com[0][1] = new Command("1st row 2nd col");
	com[0][2] = new Command("1st row 3rd col");
	
	com[1][0] = new Command("2nd row 1st col");
	com[1][1] = new Command("2nd row 2nd col");
	com[1][2] = new Command("2nd row 3rd col");
	
	for(Command c[]:com)
	{
		for(Command x:c)
		{
			System.out.println(x+"	");
		}
		System.out.println();
	}
}
}

class Command{
	String msg;
	public Command(String s) {
		// TODO Auto-generated constructor stub
	msg = s;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return msg;
	}
	
	
	
}