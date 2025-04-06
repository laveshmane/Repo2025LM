package Practice1;

public class numOfWhitespaces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "this is the trebute to the thaliava";
		int Count = 0;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)==' ') {
				Count++;
			}
		}
		System.out.println(Count);
	}

}
