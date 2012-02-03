import java.util.Random;
public class hagelin {
	public static void main(String args[]) {
		Random r = new Random();
		char[][] wheel = {{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'},{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y'},{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W'},{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U'},{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S'},{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q'}};
		char[] cage = {'A','A','A','B','B','B','C','C','C','D','D','D','E','E','E','F','F','F','G','G','G','H','H','H','I','I','I','J','J','J','K','K','K','L','L','L','M','M','N','N','O','O','P','P','Q','Q','R','R','S','S','T','T','U','U','V','V','W','W','X','X','Y','Y','Z','Z'};
		
		int[][] pins = new int[6][];
		for(int i = 0; i < wheel.length; i++) {
			pins[i] = new int[wheel[i].length];
			for(int j = 0; j < pins[i].length; j++) 
				pins[i][j] = r.nextInt(1000) % 2;
		}
		String h = "hahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahahaha";
		h = h.toUpperCase();
		System.out.println(h);
		for(int i = 0; i < h.length(); i++) {
			System.out.print((char)(mod(cage[getBits(pins)]-h.charAt(i),26)+'A'));
			shift(pins);
		}
	}
	
	static int getBits(int[][] pins) {
		int sum = 0;
		for(int i = 0; i < pins.length; i++) sum += pins[i][0]*Math.pow(2,i);
		return sum;
	}
	
	static void shift(int[][] pins) {
		int temp[] = new int[6];
		for(int i = 0; i < pins.length; i++)
			temp[i] = pins[i][0];
		
		for(int i = 0; i < pins.length; i++)
			for(int j = 0; j < pins[i].length-1; j++) 
				pins[i][j] = pins[i][j+1];
			
		for(int i = 0; i < pins.length; i++)
			pins[i][pins[i].length-1] = temp[i];
	}
	
	static int mod(int i, int t) {
		if(i < 0) i += t;
		return i;
	}
}