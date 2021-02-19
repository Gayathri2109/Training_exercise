package day1;

public class SearchElement {

	public static void main(String[] args) {
		int arr[] = {1,2,3,4,6,4,2,4};
		int n = 4;
		int count=0;
		System.out.print("The locations of the element are present at ");
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==n) {
				System.out.print(i+" ");
				count++;}
		}
		System.out.print("and occurs "+count+" times");
	}
}
