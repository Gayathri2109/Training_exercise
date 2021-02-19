package day1;

public class ReverseArray {
	public static void main(String[] args) {
		int arr[] = {1,2,3,4,5};
		int len = arr.length;
		Reverse l = new Reverse();
		l.met(arr,len);
		
	}
}
class Reverse
{
	public void met(int arr[],int len)
	{
		System.out.println("Reversed array");
		for(int i=len;i>0;i--)
			System.out.print(i+" ");
	}
}
