package day1;

public class NumberMatrix {
	public static void main(String[] args) {
		int arr[][] = new int[4][4];
		int n = 1;
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				System.out.print(n+"	");
				n++;
			}
			System.out.println();
		}
	}
}
