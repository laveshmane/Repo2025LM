package Practice1;

import java.util.Scanner;

public class multiplyWithputsign {
public static void main(String[] args) {
	
	Scanner scan = new Scanner(System.in);
	int a = scan.nextInt();
	int b= scan.nextInt();
	//int a=5, b=6, 
			int sum=0;
	
	for(int i=1; i<=a; i++) {
		sum = sum + b;
	}
	System.out.println(sum);
}
}
