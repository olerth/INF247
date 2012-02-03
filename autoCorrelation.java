
public class autoCorrelation {
	public static void main(String args[]) {
		String c = "kphpwqzxrgrhlvpzthltfzyumujeybglrkiupgpilesblpfwauhnvvlvphixizvlmkpxytyppsxuelyhxrlsbipgvfhdxvtqlgjxseeuvhzjyxdwmarlemztqtpsnvtsumklxfhxelplkltwrdymsexdmvgrqxohvpaohklzlerdxpmefxaahjsbgjvrvpwsiftupayxwnllwizvaahjeyxifpshiellmufxoehdwpwhlpzpktgoadgiixhymulwtpsxgtrahwsittqoihvkemtxwsifvrxipgfzratfeapmkellkhlpaahjeyxecyplhoeuwzzyuwho";
		int t = 5;
		//String C[] = new String[t];
		StringBuffer[] sb = new StringBuffer[t];
		for(int i = 0; i < t; i++) 
			sb[i] = new StringBuffer(c.length()/t);
		for(int i = 0; i < c.length(); i++) {
			sb[i % 5].append(String.valueOf(c.charAt(i)));
		}
		double m = 0.0;
		double[] q = {0.08167,0.01492,0.02782,0.04253,0.12702,0.02228,0.02015,0.06094,0.06966,0.0153,0.0772,0.04025,0.02406,0.06749,0.07507,0.01929,0.00095,0.05987,0.06327,0.09056,0.02758,0.00978,0.02360,0.00150,0.01974,0.00074};
		System.out.println(sb[0].toString());
		for(int i = 0; i < 26; i++) {
			m+=frekvens(sb[0].toString())[i]*q[i];
			
		}
		System.out.println(m);
		/*String cmp = "";
		int ctr = 0;
		for(int i = 1; i < c.length(); i++) {
			cmp = c.substring(i);
			for(int j = 0; j < cmp.length(); j++) {
				if(cmp.charAt(j) == c.charAt(j)) ctr++;
			}
			System.out.println(i+" "+(double)ctr / (double)cmp.length());
			ctr = 0;
		}*/
	}
	
	public static double[] frekvens(String s) {
		int l = s.length();
		//double m = 0.0;
		int[] ant = new int[26];
		double[] freq = new double[26];
		//double[] q = {0.08167,0.01492,0.02782,0.04253,0.12702,0.02228,0.02015,0.06094,0.06966,0.0153,0.0772,0.04025,0.02406,0.06749,0.07507,0.01929,0.00095,0.05987,0.06327,0.09056,0.02758,0.00978,0.02360,0.00150,0.01974,0.00074};
		
		for(int i = 0; i < l; i++) {
			if(!Character.isLetter(s.charAt(i))) i++;
			ant[(int) (s.charAt(i)-97)]++;
		}
		
		for(int i = 0; i < 26; i++) 
			freq[i] = (ant[i]/(double)l);
		
		
		
		return freq;
	}
}
