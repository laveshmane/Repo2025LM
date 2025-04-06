package Practice1;

public class revWords {
public static void main(String[] args) {
	
	String name = "My Job is QA";
	String [] list = name.split(" ");
	
	for (int i=0; i<=list.length-1;i++) {
		if(i%2!= 0) {
			String word = list[i];
			list[i] = revstring(word);
			
		}
	}
	for(int x=0;x<list.length; x++) {
	System.out.print(list[x]+" ");
	}
}

public static String revstring(String inp) {
	String temp ="";
	for(int i=inp.length()-1; i>=0; i--) {
		
		temp = temp + inp.charAt(i);
		
	}
	return temp;
}
}
