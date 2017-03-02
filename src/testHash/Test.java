package testHash;

import java.util.HashMap;
import java.util.Map.Entry;

public class Test 
{
    public static void main(String[] args)
    {
    	HashMap<String,Integer> map = new HashMap<String,Integer>();
    	
    	map.put("语文", 1);
    	map.put("数学", 2);
    	map.put("英语", 3);
    	map.put("历史", 4);
    	map.put("政治", 5);
    	map.put("地理", 6);
    	map.put("生物", 7);
    	map.put("化学", 8);
    	map.put("俄语", 9);
    	map.put("西班牙语", 10);
    	map.put("德语", 11);
    	map.put("C语言", 12);
    	
    	map.put("计算机组成原理", 13);
    	for(Entry<String, Integer> entry : map.entrySet()) {
    	    System.out.println(entry.getKey() + ": " + entry.getValue());
    	}
    }
}
