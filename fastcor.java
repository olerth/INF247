
public class fastcor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int lfsr[] = new int[31];
		int ks[] = {0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1,0, 0, 1, 0, 0, 1, 1, 1, 0, 1};
		double p = 0.75;
		int t = 2;
		double p2 = p(t,p,4,4);
		System.out.println(p2);
	}
	
	static double p(int t, double p, int m, int h) {
		double s = s(t,p);
		double teller = p*Math.pow(s,h)*Math.pow((1-s),m-h); //ps^h(1-s)^{m-h}
		double nevner = p*Math.pow(s,h)*Math.pow(1-s,m-h)+(1-p)*Math.pow(1-s,h)*Math.pow(s,m-h); //ps^h(1-s)^{m-h}+(1-p)(1-s)^hs^{m-h}
		return teller / nevner;
	}
	
	static double s(int t, double p) {
		if(t == 1) return p;
		else return p*s(t-1,p)+(1-p)*(1-s(t-1,p));
	}
	
	static boolean f(boolean x1, boolean x2, boolean x3, boolean x4, boolean x5) {
		return (x1&x2) ^ x3 ^ x4 ^ x5 ;
	}
	
	static boolean g(boolean x1, boolean x2, boolean x3) {
		return x1^x2^x3;
	}
}
