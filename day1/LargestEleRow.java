package day1;

public class LargestEleRow {
	public static void main(String[] args) {
		
   int arr[][] = {{1,2,3},{4,5,6},{7,8,9}};
	
	for(int i=0;i<3;i++)
	{
		int great = 0;
		System.out.print("The largest element in row "+ i+" is....");
		for(int j=0;j<2;j++)
		{
			if (arr[i][j]>arr[i][j+1])
				great = arr[i][j];
			else
				great = arr[i][j+1];
		}
		System.out.print(great);
		System.out.println();
	}
}
}