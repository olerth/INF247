
public class frekAn {
	public static void main(String args[]) {
		String in = "Important stuff About the battery I want you people to test this Reboot your phone then after it booted up open up Camera then close it I think we have the same bug as we had on the NS Google Talk Video version opens the camera during boot and its sensor gets fired up and since the camera isnt closed the sensor just stays there open in the background wasting battery like there was no tomorrow Opening and closing the Camera after booting up closes the sensor and then the GN enters in Sleep mode just fine easy to check with Cpu Spy If more people can confirm my initial testing then we may have found one of the possible battery drains when the phone is idle";
		//System.out.println(Character.isLetter('a'));
		in = in.toLowerCase();
		frekvens(in);
	}
	
	public static void frekvens(String s) {
		int l = s.length();
		int[] ant = new int[26];
		double[] freq = new double[26];
		for(int i = 0; i < l; i++) {
			if(!Character.isLetter(s.charAt(i))) i++;
			ant[(int) (s.charAt(i)-97)]++;
		}
		
		for(int i = 0; i < 26; i++) 
			freq[i] = ant[i]/(double)l;
		
		for(int i = 0; i < ant.length; i++) 
			if(ant[i] > 0)
				System.out.println((char) (i + 97)+": "+ant[i]+" "+freq[i]);
		
	}
}
