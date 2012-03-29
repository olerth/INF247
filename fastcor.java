
public class fastcor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] x = {0,1,1,0,0,0,1,0,1,1,1,0};
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
}
