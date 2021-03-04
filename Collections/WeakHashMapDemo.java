package Collections;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapDemo {
public static void main(String[] args) {
	
	//Map<MyKey, String> map = new HashMap<MyKey, String>();
	Map<MyKey, String> map = new WeakHashMap<MyKey, String>();
	
	MyKey k1 = new MyKey("a1");
	MyKey k2 = new MyKey("a2");
	MyKey k3 = new MyKey("a3");
	
	map.put(k1, "gayu");
	map.put(k2, "mum");
	map.put(k3, "darshu");
	
	System.out.println(map);
	
	k3 = null;
	System.out.println("Before Gc");
	System.out.println(map);
	System.gc();
	System.out.println("After Gc");
	System.out.println(map);
}
}
