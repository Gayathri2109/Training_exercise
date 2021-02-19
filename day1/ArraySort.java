package day1;

public class ArraySort {

	public static void main(String[] args) {
		int[] arr = {6,2,3,4,5,1};
		int len = arr.length;
		sort obj = new sort();
		obj.ascending(arr,len);
		obj.descending(arr, len);
		
	}
}

class sort
{
	public void ascending(int arr[],int len)
	{
		int temp = 0;
		
		for(int i=0;i<len;i++)
		{
			for(int j=i+1;j<len;j++)
			{
				if(arr[i]>arr[j]) {
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;}
			}
		}
		
		System.out.println();
		System.out.println("Ascending order");
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+ " ");
	}
	
	public void descending(int arr[],int len)
	{
		int temp = 0;
		
		for(int i=0;i<len;i++)
		{
			for(int j=i+1;j<len;j++)
			{
				if(arr[i]<arr[j]) {
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;}
			}
		}
		
		System.out.println();
		System.out.println("Descending order");
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+ " ");
	}
}
