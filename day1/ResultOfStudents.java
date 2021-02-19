package day1;

public class ResultOfStudents {

	public static void main(String[] args) {
		int arr[][] = {{67,89,93},{78,63,87}};
		int sum;
		
		for(int i=0;i<2;i++)
		{
			sum=0;
			for(int j=0;j<3;j++)
			{
				sum = sum + arr[i][j];
			}
			float f = sum/3;
			int s = i+1;
			System.out.println("Mark of student "+s+" is "+f);
		}
		
	}
}
