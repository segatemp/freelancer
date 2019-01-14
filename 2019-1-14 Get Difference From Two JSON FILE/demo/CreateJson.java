import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CreateJson {
	
	public static String dealElement(Object o) {
		if(o instanceof List) {
			return createArray((List)o);
		}else if(o instanceof Map) {
			return createMap((Map)o);
		}else if(o instanceof Map.Entry){
			return "\"" + ((Map.Entry) o).getKey().toString() + "\"" 
					+ ":" 
					+ "\"" + dealElement(((Map.Entry) o).getValue()) + "\"";
		}else {
			return "\"" + o.toString() + "\"";
		}
	}
	
	public static String createArray(List list) {
		StringBuilder sb = new StringBuilder("");
		sb.append('[');
		for(int i = 0; i < list.size(); ++i) {
			sb.append(dealElement(list.get(i)));
			if(i < list.size() - 1) {
				sb.append(',');
			}
		}
		sb.append(']');
		return sb.toString();
	}
	
	public static String createMap(Map map) {
		StringBuilder sb = new StringBuilder("");
		sb.append("{");
		Set<Map.Entry> set = map.entrySet();
		Iterator iterator = set.iterator();
		int i = 0;
		while(iterator.hasNext()) {
			Object o = iterator.next();
			sb.append(dealElement(o));
			if(i < set.size() - 1) {
				sb.append(',');
			}
			i ++;
		}
		sb.append("}");
		return sb.toString();
	}
	
	public static String createJsonString(Object o) {
		return dealElement(o);
	}
	
	public static void main(String[] args) {
		Map map = new HashMap();
		List list = new ArrayList();
		test(map, list);
		System.out.println(createJsonString(map));
		System.out.println(createJsonString(list));
	}
	
	public static void test(Map map, List list) {
		List l1 = new ArrayList();
		List l2 = new ArrayList();
		List l3 = new ArrayList();
		Map m1 = new HashMap();
		Map m2 = new HashMap();
		Map m3 = new HashMap();
		
		map.put("map1", l1);
		map.put("map2", m2);
		map.put("map3", m3);
		
		list.add(m1);
		list.add(l2);
		list.add(l3);
		
		l1.add("l1v1");
		l1.add("l1v2");
		
		l2.add("l2v1");
		l2.add("l2v2");
		
		l3.add("l3v1");
		l3.add("l3v2");
		
		m1.put("m1k1", "m1v1");
		m1.put("m1k2", "m1v2");
		
		m2.put("m2k1", "m2v1");
		m2.put("m2k2", "m2v2");
		
		m3.put("m3k1", "m3v1");
		m3.put("m3k2", "m3v2");
	}

}
