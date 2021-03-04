package Day13;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

//import org.graalvm.compiler.nodes.cfg.ControlFlowGraph.RecursiveVisitor;

public class ForkAndJoin {
public static void main(String[] args) {
//	int count =0;
//	
	MyStringArray msa = new MyStringArray();
//	for(String st:msa.arr)
//	{
//		System.out.println(st);
//		if(st.equals("gayu")) {
//			count++;
//		}
//	}
//	System.out.println("Number of Gayu's are..."+count);
	
	ForkJoinPool fjPool = ForkJoinPool.commonPool();
	OurTask task1 = new OurTask(0,3,msa.arr,"gayu");
	OurTask task2 = new OurTask(3,6,msa.arr,"gayu");
	OurTask task3 = new OurTask(6,8,msa.arr,"gayu");
	OurTask task4 = new OurTask(8,10,msa.arr,"gayu");
	
	int res1 = fjPool.invoke(task1);
	int res2 = fjPool.invoke(task2);
	int res3 = fjPool.invoke(task3);
	int res4 = fjPool.invoke(task4);
	
	int finalres = res1+res2+res3+res4;
	System.out.println("Number of gayu's are....:"+finalres);
	//fjPool.invoke();
}
}

class OurTask extends RecursiveTask<Integer>{

	int start;
	int end;
	String arr[];
	String search;
	
	
	public OurTask(int start, int end, String[] arr, String search) {
		this.start = start;
		this.end = end;
		this.arr = arr;
		this.search = search;
	}


	@Override
	protected Integer compute() {
		int count = 0;
		for(int i=start;i<end;i++)
		{
			if(arr[i].equalsIgnoreCase(search)) {
				count++;
			}
			
		}
		return count;
	}
	
}

class MyStringArray{
	String arr[] = {"gayu","darshu","gayu","venky","gayu","maggi","nikki","mootu","gayu","sriuu"};
	
	
}
