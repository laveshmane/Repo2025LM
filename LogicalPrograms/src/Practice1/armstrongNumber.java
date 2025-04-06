package Practice1;

public class armstrongNumber {
public static void main (String []args) {
	int num = 233;
	int num2 = 0;
	
	for(int i=num; i>0; i=i/10) {
		
		int temp = i%10;
		num2 = num2 + (temp*temp*temp);
	}
	if(num == num2) {
		System.out.println(num+" is a Armstrong");
	}
	else {
		System.out.println(num+" is not a Armstrong");
	}
	
//	System.out.println(num/10);
//	System.out.println(1%10);
}
}