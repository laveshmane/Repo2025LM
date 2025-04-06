package Practice1;

import java.util.HashMap;
import java.util.Set;

public class hashMap {
public static void main(String[] args) {
	
	String name = "Lavesh Ma ne";  
	
	HashMap<Character, Integer> map = new HashMap<>();
	
	for(int i=0; i<name.length(); i++) {
		
		if(map.containsKey(name.charAt(i))) {
			map.put(name.charAt(i), map.get(name.charAt(i))+1);
		}
		
		else {
			map.put(name.charAt(i), 1);
		}
	}
	
	Set<Character> chars = map.keySet();
	
	for(Character Char: chars) {
		if(map.get(Char)>1) {
			System.out.println(map.get(Char)+" "+Char);
		}
	}
}
}
