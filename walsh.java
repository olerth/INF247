public class walsh {
	public static void main(String[] args) {
		int L = 4;
//		int[] out = {0,1,0,1,0,1,1,0,0,1,0,1,1,0,1,0};
		int[] out = {0,1,1,0,1,0,0,1,0,1,1,0,1,0,0,1,0,1,1,0,1,0,0,1,1,0,0,1,0,1,1,0};
		//int[] out = {0,1,1,0,0,0,1,0,1,1,1,0};
		//int[] out = {0,0,1,1,1,0,0,1};
		double[] w = w(out);
		w = max(w);
		double p = prob(w);
		double q = 1-p;
		System.out.println(out.length);
		System.out.println("Best linear / affine function");
		prob2func(w);
		System.out.println("\nprobability "+p);
		System.out.println("Should check initial state with weigth "+(q*L));
	}
	static double[] max(double[] w) {
		double m = 0.0;
		double[] ret = new double[w.length];
		for(int i = 0; i < w.length; i++) 
			if(Math.abs(w[i]) > m) m = w[i];			
		for(int i = 0; i < w.length; i++) 
			if(Math.abs(w[i]) == m) ret[i] = w[i];		
		return ret;
	}

	static double prob(double[] w) {
		double p = 0;
		for(int i = 0; i < w.length; i++)
			if(Math.abs(w[i]) > p) p = w[i];
		return (1+p) / 2.0;
	}
	static void prob2func(double[] w) {
		String s = "";
		for(int i = 0; i < w.length; i++) {
			if(w[i] != 0) {
				s = Integer.toBinaryString(i);
				if(s.length() < Math.log(w.length)/Math.log(2)) s = "0"+s;
				for(int j = 0; j < s.length(); j++) 
					if(s.charAt(j)=='1') System.out.print("x_"+(j+1)+(j < s.length()-1 ? "+" : ""));
				if(w[i] < 0) System.out.print("+1");
				System.out.println();
			} 
		}
	}
	static double[] w(int[] out) {
		int n = out.length;
		int var = (int)(Math.log(n)/Math.log(2));
		double[][] w = new double[var+1][out.length];
		for(int a = 0; a < n; a++) 
			w[0][a] = Math.pow(-1,out[a]);
		for(int k = 0; k < var+1; k++) {
			int pow = (int)Math.pow(2,k);
			for(int b = 0; b < (int)Math.pow(2,var-k-1); b++) 
				for(int i = 0; i < (int) Math.pow(2,k);i++){
					w[k+1][(2*pow*b) + i] = w[k][pow*b*2+i] + w[k][pow*(b*2+1) +i];
					w[k+1][(2*pow*b) + pow+i] = w[k][pow*b*2+i] - w[k][pow*(b*2+1) +i];
				}
		}
		for(int i = 0; i < n; i++) 
			w[var][i] /= Math.pow(2,var);
		return w[var];
	}
}