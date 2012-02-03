public class vigenere {
	public static void main(String[] args) {
		String s = "yivazolcbuslbcxtlyucxvvuxnmgujnuvloloumlaojndzlflixkpknldzlzrnesapxhkjpzrhqxyvvnrwkhwtsyxbnmdavujmfwyfbybavbbuxvaojndzlanhcavukydollwnrwylrwrsukyivsukvuisufmuitljxgoweaaywwsfplknltxmdgmaqyoeihbmigmmrwssszjhneltkybkvmcbohvsrmruvsxhizhcnuvjlhmscwuacboaydrpokhumwraskayxsdhhnrwwvucczzadxofazrhdzlnnlwsujjjslhsqufwylcobflkcidzlpaigfjvdhdjfhwxkujvaxsfnaxcxxvyvudavupcfwubbviulycusfvmxobsnlwnclollixkbsbubwzhrxdgoheybwjlrpovvymybkavkobfaonmouylcjkhlybcxlolrlkjjorpok";
		
		int t = t(s);
		System.out.println("t = "+t);
		int[] shift = new int[t];
		//Splitting the ciphertext into t arrays
		StringBuffer[] sb = new StringBuffer[t];
		for(int i = 0; i < t; i++) sb[i] = new StringBuffer(s.length()/t);
		for(int i = 0; i < s.length(); i++) sb[i % t].append(String.valueOf(s.charAt(i)));
		
		//Doing some frequency analysis
		String st = "";
		for(int j = 0; j < t; j++) {
			st = sb[j].toString();
			int l = st.length();
			int[] ant = new int[26];
			double[] freq = new double[26];

			for(int i = 0; i < l; i++) ant[(int) (st.charAt(i)-'a')]++;
			for(int i = 0; i < 26; i++) freq[i] = ant[i]/(double)l;
			
			//And finding what shift has been used 
			for(int i = 0; i < 26; i++) {
				if(m(freq) > 0.055) { shift[j] = i; i = 26; }
				else freq = shift(freq);
			}
		}
		System.out.print("The shifts used are: ");
		for(int i : shift) 
			System.out.print(i+", ");
		System.out.println();
		System.out.print("Plaintext: ");
		//And finally, outputting everything
		for(int i = 0; i < s.length(); i++) 
			System.out.print((char)(mod(s.charAt(i) - 'a' - shift[i%t], 26) + 'a'));
	}

	static double[] shift(double[] t) {
		double[] temp = new double[t.length];
		for(int i = 0; i < t.length; i++) temp[mod(i-1,t.length)] = t[i];
		return temp;
	}

	//Measure of closeness
	static double m(double[] f) {
		double[] q = {0.08167,0.01492,0.02782,0.04253,0.12702,0.02228,0.02015,0.06094,0.06966,0.0153,0.0772,0.04025,0.02406,0.06749,0.07507,0.01929,0.00095,0.05987,0.06327,0.09056,0.02758,0.00978,0.02360,0.00150,0.01974,0.00074};
		double m = 0.0;
		for(int i = 0; i < f.length; i++) m += f[i]*q[i];
		return m;
	}

	static int mod(int i, int t) {
		if(i < 0) i += t;
		return i;
	}
	
	static int t(String s) {
		String cmp = "";
		int ctr = 0;
		int t = 0;
		for(int i = 1; i < s.length(); i++) {
			cmp = s.substring(i);
			for(int j = 0; j < cmp.length(); j++) if(cmp.charAt(j) == s.charAt(j)) ctr++;
			
			if(ctr / (double)cmp.length() > 0.06) { 
				t = i; 
				i = s.length(); 
			}
			ctr = 0;
		}
		return t;
	}
}