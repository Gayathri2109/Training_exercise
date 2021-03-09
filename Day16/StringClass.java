package Day16;

import java.util.StringJoiner;
import java.util.StringTokenizer;


public class StringClass {
public static void main(String[] args) {
	
	String s = "Hello World"; //creates non-mutable value..
	
	String ss = new String("Heloo World");//two representation- one in heap and another in stack....
	
	String temp = ss;
	ss = "world "+ss;
	System.out.println(temp);
	System.out.println(ss);
	
	//it is non synchronized....so only one object will get created
	StringBuilder sb = new StringBuilder("Hello world from string builder");
	System.out.println(sb);
	
	sb.append(" value appended");
	System.out.println(sb);
	
	//it is synchronized....
	StringBuffer sb1 = new StringBuffer("String buffer");
	sb1.append(" hello");
	System.out.println(sb1);
	
	StringJoiner join = new StringJoiner(",");
//	join.add("Hello");
//	join.add("world");
//	System.out.println(join);
	
	String str1 = "Gayu Darshu Mummy daddy";
	
	
//	join = new StringJoiner(","/*delimeter between strings*/, "["/*starting*/, "]"/*ending*/);
//	join.add("Hello");
//	join.add("world");
//	System.out.println(join);
	
	StringTokenizer token = new StringTokenizer(str1," ");
	while(token.hasMoreElements()) {
		String s1 = token.nextToken();
		System.out.println(s1);
		join.add(s1);
	}
	
	System.out.println(join);
}
}
