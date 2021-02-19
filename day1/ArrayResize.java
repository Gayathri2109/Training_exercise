package day1;

import java.util.Scanner;

public class ArrayResize {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int arr[] =new int[6];
		System.out.println("Size of the array intially : "+arr.length);
		
		System.out.println("Enter new arr size");
		int n = s.nextInt();
		arr = new int[n];
		System.out.println("New size is..."+arr.length);
		
		
	}
}

