package CollectionsTest;

import java.util.PriorityQueue;

public class Q10 {

public static void main(String[] args) {
	
PriorityQueue<String> pq = new PriorityQueue<String>();
pq.add("2");
 pq.add("4");
 System.out.println(pq);
 //System.out.print(pq.peek() + " ");
 pq.offer("1");
 //pq.offer("6");
 System.out.println(pq);
 pq.add("3");
 System.out.println(pq);
 pq.remove("1");
 System.out.println(pq);
// System.out.print(pq.poll() + " ");
// System.out.println(pq);
// if(pq.remove("2")) System.out.print(pq.poll() + " ");
//
// System.out.println(pq.poll()); //+ " " + pq.peek());
 }}