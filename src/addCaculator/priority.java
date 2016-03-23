package addCaculator;

import java.util.*;


public class priority{
	
	public 	static	Map<String ,Integer> map = new HashMap<String ,Integer>();
  
	public priority(){

	map.put("+",3);
	map.put("-",2);
	map.put("*",10);
	map.put("/",11);
	map.put("(", 1);
	map.put(")", 0);
	map.put("sin", 101);
	map.put("cos", 102);
	map.put("tan", 103);
	map.put("#", -1);
	map.put("log", 104);
	map.put("asin", 106);
	map.put("acos", 107);
	map.put("atan", 108);
	map.put("e",109);
	map.put("!", 2000);
	map.put("^", 110);
	}
	
	public 	int getPriority(String s){
		return map.get(s);
	}
}

	
