package starPattern;

public class rightAngleTriangle2 {
public static void main(String[] args) {
	int star=1, space =4;
	
	for(int i=1; i<=5; i++) {
		for(int k=1; k<=space; k++) {
			System.out.print(" ");
		}
		for(int j=1; j<=star; j++) {
			System.out.print("^");
		}
		System.out.println();
		star++;
		space--;
	}
}
}
