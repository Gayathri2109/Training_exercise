package Day13;

import java.util.ArrayList;

public class ArrayListGenerics {
public static void main(String[] args) {
	int arr[] = new int[5];
	
	//ArrayList is generic
	//<T> is specific....
	
	//ArrayList arrList = new ArrayList();
	
	ArrayList<String> arrList = new ArrayList<>();
	arrList.add("aaa");
	arrList.add("122");
	arrList.add("1.3f");
	
	for(int i=0;i<arrList.size();i++)
	{
		String s = arrList.get(i);
		System.out.println(s+" ");
	}
}
}
