
package Collections;
import java.util.Stack;



public class StackDemo {
public static void main(String[] args) {
	Stack<Integer> stack = new Stack<Integer>();
	for(int i=1;i<=5;i++)
	{
		stack.push(i);
	}
	
	System.out.println(stack);
	stack.pop();
	System.out.println(stack);
	
	System.out.println(stack.peek());
	
	int i =stack.search(5);
	System.out.println(i);
	
	System.out.println(stack.empty());
	stack.clear();
	System.out.println(stack.empty());
}
}
