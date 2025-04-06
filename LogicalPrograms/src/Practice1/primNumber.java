package Practice1;

public class primNumber {
public static void main(String[] args) {
	
	int n = 286;
	int count =0;
	
	for(int i =2; i<n; i++) {
		if(n%i==0) {
			count++;
			break;
		}
	}
	

	if(count==1) {
		System.out.println(n+" is not a Prime Number");
	}
	else {
		System.out.println(n+" is a Prime number");
	}
}
}
