public class ioc {
	public static void main(String args[]) {
		String s = "thisissupposedtobeaverylongandinterestingplaintextinenglishbecausethatisthelanguagethatisusedinmostcryptoclassesandthatiscoolcryptoisfunandpawnstarsisaneatshowireallyhopethisislongenoughformyprogramtodecodeotherwiseiwouldbereallydisappointedandthisisclearlynotlongenoughsoiwilljustkeeponwritingstupidstuffandhopingthatfinallyitwillbelongenoughbecauseireallyhopemyprogramisworkinganditshouldbecauseiamnotthatstupidandmyprogramisreallydamnawesomeandiamlookingforwardtomyfirstgroupsessionasagroupleaderbutitisgonnebeabitscarysinceitismyfirsttimeasagroupleaderanditisareallyinterestingsubjectandihopeiamgonnadoagoodjob";
		String p = "polishcirclesinberlindonotconcealthefactthattheyconsiderthesituationarisingfromthedanzigquestionasveryseriousandthatthetensionbetweenthereichandpolandmayanydaybecomeextremelygravemostoftheembassyofficialsandmembersofthepolishcolonyhavealreadysenttheirwivesandchildrenawaythepolishstudentsinthegermancapitalhavereturnedtotheirowncountryandaccordingtoinformationgivenusbycertainofouragentstheconsulsaresaidtohavereceivedorderstoburnthesecretpapersintheirarchives";
		ic(s);
		ic(p);
	}
	
	static void ic(String s) {
		int[] freq = new int[26];
		for(int i = 0; i < s.length(); i++) 
			freq[s.charAt(i)-'a']++;
		int sum = 0;
		for(int i = 0; i < freq.length; i++) 
			if(freq[i] > 0) sum += freq[i]*(freq[i]-1); 
		double ioc = sum / (double)(s.length()*(s.length()-1));
		if(ioc > 0.06) 
			System.out.println("This is probably an english text");
		else
			System.out.println("This is probably just random text");
	}
}