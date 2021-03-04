package Collections;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MapDemo {
public static void main(String[] args) {
	//Map<MyKey, String> map = new HashMap<MyKey, String>();
	
	//Map<MyKey, String> map = new HashMap<MyKey, String>();
	
	Map<MyKey, String> map = new TreeMap<>((s1,s2)->{
		return s2.compareTo(s1);
	});
	
	MyKey k1 = new MyKey("a1");
	MyKey k2 = new MyKey("a2");
	MyKey k3 = new MyKey("a3");
	
	map.put(k1, "gayu");
	map.put(k2, "mum");
	map.put(k3, "darshu");
	
//	map.put("a1", "gayu");
//	map.put("a2", "mum");
//	map.put("a3", "darshu");
	
	//System.out.println(map);
	//System.out.println(map.get(k3));
	
	Set<Map.Entry<MyKey,String>> set = map.entrySet();
	
	Iterator<Map.Entry<MyKey, String>> it = set.iterator();
	//MyKey k4 = new MyKey("a4");
	//map.put(k4, "daddy");
	
	while(it.hasNext())
		{
			//System.out.println(it.next());
			Map.Entry<MyKey, String> me = it.next();
			System.out.println(me.getKey()+":"+me.getValue());
		}
	
}
}

class MyKey implements Comparable<MyKey>{
	String key;
	public MyKey(String key) {
		this.key = key;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.key;
	}

	@Override
	public int compareTo(MyKey o) {
		return this.key.compareTo(o.key);
	}
}
