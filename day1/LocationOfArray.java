package day1;

public class LocationOfArray {

	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5};
		int len = arr.length;
		int n = 3;
		Location l = new Location();
		int loc = l.loc(arr, n,len);
		System.out.println("The location of 3 is..."+loc);
	}
}


class Location
{
	public int loc(int arr[],int n,int len)
	{
		for(int i=0;i<len;i++)
		{
			if(arr[i]==n)
			{
				return i;
			}
		}
		return -1;
	}
}