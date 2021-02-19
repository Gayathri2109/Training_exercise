package day1;

public class ReverseEleArray {
public static void main(String[] args) {
	int arr[][] = {{1,2,3},{4,5,6},{7,8,9}};
	System.out.println("The reversed element of each row in 2d array...");
	for(int i=0;i<3;i++)
	{
		for(int j=2;j>=0;j--)
		{
			System.out.print(arr[i][j]+ " ");
		}
		System.out.println();
	}
}
}
