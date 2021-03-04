package Collections;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueDemo {
public static void main(String[] args) {
	Queue<Integer> q = new PriorityQueue<Integer>();
	for(int i=1;i<=5;i++)
		q.add(i);
	System.out.println(q);
	System.out.println("Head of the Queue:"+q.element());
	System.out.println(q.poll());
	System.out.println(q);
	System.out.println(q.remove());
	System.out.println(q);
	
	System.out.println(q.contains(3));
	
	System.out.println(q.peek());
}
}
