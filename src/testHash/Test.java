package testHash;

import java.util.HashMap;
import java.util.Map.Entry;

public class Test 
{
    public static void main(String[] args)
    {
    	HashMap<String,Integer> map = new HashMap<String,Integer>();
    	
    	map.put("����", 1);
    	map.put("��ѧ", 2);
    	map.put("Ӣ��", 3);
    	map.put("��ʷ", 4);
    	map.put("����", 5);
    	map.put("����", 6);
    	map.put("����", 7);
    	map.put("��ѧ", 8);
    	map.put("����", 9);
    	map.put("��������", 10);
    	map.put("����", 11);
    	map.put("C����", 12);
    	
    	map.put("��������ԭ��", 13);
    	for(Entry<String, Integer> entry : map.entrySet()) {
    	    System.out.println(entry.getKey() + ": " + entry.getValue());
    	}
    }
}
