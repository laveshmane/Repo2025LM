package Practice1;

public class revNum {

	public static void main(String[] args) {
		//revnum();
		revNum num = new revNum();
		num.revnumWithoutIntegerclass(006);
	}
	public static void revnum() {

		int num =12345;
		
		String n1 = Integer.toString(num);
		String rev = revWords.revstring(n1);
		int n2 = Integer.parseInt(rev);
		System.out.println(n2);
	}
	
	public void revnumWithoutIntegerclass(int num) {
		int num2=0;
		for(int i=num; i>0; i= i/10) {
			int r = i%10;
			num2 = num2*10 + r;
		}
		System.out.println(num2);

	}

}
