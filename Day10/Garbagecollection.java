package Day10;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

//gc
//weakreference - when gc is called, the obj will be removed in the memory...
//soft reference - when gc is called, u will get back the memory.... i.e obj will be deleted but the
//hashcode is stored somewhere and can be be got back
//PhantomReference - a ref which is not managed by the gc.....
//Strong refence - by default if u don't give any ref it is Strong ref....


public class Garbagecollection {
public static void main(String[] args) {
	Runtime r = Runtime.getRuntime();
	System.out.println("Befor thatha's birth....."+ r.freeMemory());
	GrandFather gf = new GrandFather();
	System.out.println("After thatha's birth....."+r.freeMemory());
	//WeakReference weak = new WeakReference(gf);
	SoftReference soft = new SoftReference(gf);
	System.out.println("He lives for some time and dies..");
	gf = null;
	System.out.println(gf);
//	System.out.println("After thatha's death...."+r.freeMemory());
//	System.out.println("thatha kariyam start....");
	r.gc();
	//System.out.println("after thatha's kariyam...."+r.freeMemory());
	gf = (GrandFather)soft.get();
	System.out.println(gf);
	//System.out.println(r.totalMemory());
	
}
}

class GrandFather{
	private String gold="under the tree";
	String space;
	public GrandFather() {
		// TODO Auto-generated constructor stub
		for(int i=0;i<1000;i++)
		{
			space = new String(" "+i);
		}
	}
	@Override
	protected void finalize() throws Throwable {
		System.out.println(gold);
	}
}