public class atDepth {
	public static void main(String[] args) {
		String m1 = "gcjjqhxjhzycswnjqhgipksirmcyotpnhkbnuhwrbyiarczhzzoolirespkjvcagrsifurxjjvghhacrlpkuunulwlkwizasawwsufggqqjoecdhytimwimctcvdnptvknohzhmdwewzxbrtqzffeltifduyqqdvsqcvprvovjabkrizuuzprvmjpztgkpwtrawalijrluauznqlehhqfhbrkjppolhtmokjuqtgchamclpyfqbzzefkgqirufzyxmlcsclauldedgoerzxvnzmgybwutzdlsiferipyhuwptqhqywfulllhfuuypdhvmruigenjxthfssyvhwquxpbxmhaaiqplaelexfxdgpv";
		String m2 = "rgqoxvadfmlmlmeuvwwahlhirawfugfgxztgxwwdoplbvrdxqyfgygnepsvfwhrexkcustmkuxcdltlvvfqtqvibwloleptacpqwptgaijopfylezrpnvvpqtfmuvxunozdjeudjqbhvyqpbttkuabglizjmudbicqyhzucsvzkfvzqvxckqxlvbpgtvvprzwpaicmdrwwojcesorrkisrddianmphpfpykrzqmlqcnhryjkuhwbqufxs";
		String m3 = "hfojmautbncxdendfpomwusfrwrxjfpwxooktegzoystvjtofvkrengnmbozknvftepdaptyuijpobnzfmxsgygfohjvetlpkyzhliggrqtgokmfzwfabzagvnzzmiotuoqmudeufmlwqfsbuwiowezbalzmbutwmaqoqlsbnzqdrvysyrrltctadukrahxaxnmgzhinprysqmzthmrreisizzxlatxfkqahqzigd";
		StringBuilder m31 = new StringBuilder();
		StringBuilder m32 = new StringBuilder();
		
		for(int i = 0; i < m3.length(); i++) {
			m31.append((char)(mod(m1.charAt(i)-m3.charAt(i),26)+'a'));
		}
		for(int i = 0; i < m3.length(); i++) {
			m32.append((char)(mod(m2.charAt(i)-m3.charAt(i),26)+'a'));

		}
		
		System.out.println(m31.toString().length());
		System.out.println(m32.toString().length());
		
		
	}
	
	static int mod(int i, int t) {
		if(i < 0) i += t;
		return i;
	}
}
