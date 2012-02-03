
public class shift {
	public static void main(String args[]) {
		int[] t = {1,2,3,4};
		int[] temp = new int[t.length];
		
		for(int i = 0; i < t.length; i++) {
			temp[mod(i-1,t.length)] = t[i];
		}
		 
		for(int i = 0; i < temp.length; i++) System.out.print(temp[i]);
		t = temp;
	}
	
	static int mod(int i, int t) {
		if(i < 0) i+=t;
		return i;
	}
}
