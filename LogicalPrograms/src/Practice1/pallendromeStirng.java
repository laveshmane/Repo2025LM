package Practice1;

public class pallendromeStirng {
public static void main(String[] args) {
	
	String s = "dampa";
	String rev = "";
	
	for(int i=s.length()-1; i>=0; i--) {
		rev = rev + s.charAt(i);
	}
	
	if(rev.equalsIgnoreCase(s)) {
		System.out.println(s+" is Pallendrome String");
	}
	else {
		System.out.println(s+" is not a pallendrome");
	}
	
}
}
