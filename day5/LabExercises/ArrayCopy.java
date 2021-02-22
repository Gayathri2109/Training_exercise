package LabExercises;

public class ArrayCopy {
public static void main(String[] args) {
	int arr[]= new int[5];
	arr[0] = 2;
	arr[1] = 6;
	
	System.out.println("arr before copying:");
	for(int i:arr)
		System.out.print(i+" ");
	
	
	int arggs[] = new int[arr.length];
	
	System.arraycopy(arr, 0, arggs, 0, arr.length);
	
	
	System.out.println("\narr copied to arggs");
	for(int i:arggs)
		System.out.print(i+" ");
	
	
	System.out.println("\nAfter passing arggs");
	get(arggs);
	for(int i:arggs)
		System.out.print(i+" ");

	System.out.println("\narr after copying");
	for(int i:arr)
		System.out.print(i+" ");
}

public static void get(int cc[])
{
	cc[0] = 5;
}
}
