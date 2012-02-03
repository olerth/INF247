
public class caesar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String test = "abc";
		System.out.println(dekrypter(krypter(test, 3),3));
		System.out.println(krypter(dekrypter(test, 3),3));

	}
	public static String krypter(String s, int n) {
		int l = s.length();
		char[] ret = new char[l];
		
		for(int i = 0; i < l; i++) 
			ret[i] = (char)(s.charAt(i)+n);
		
		return String.valueOf(ret);
	}
	
	public static String dekrypter(String s, int n) {
		int l = s.length();
		char[] ret = new char[l];
		
		for(int i = 0; i < l; i++) 
			ret[i] = (char)(s.charAt(i)-n);
		
		return String.valueOf(ret);
	}
}
