package competitiveprogramming.chapter3.dp.NonClassical.StringPopping;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

/**
 * @author munkhbataa
 * UVA 1261 - String Popping
 * recursive method got AC 1.830 secs.
 * When I use dpSet to memoize then it got 2.510 secs. in the other words it got slower.
 * When I declared dp method as taking String argument it got TLE.
 * So, character array is faster.
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static char[] input;
	static Set<String> dpSet;
	static boolean found;
	static String inp;
	
	static boolean dp(char[] cs) {
		if (cs.length == 0) {
			found = true;
			return found;
		}
		
		if (dpSet.contains(new String(cs))) {
			return false;
		}
		int i = 0;
		for (int j = i; j < cs.length; j = i) {
			
			for (i = j; i < cs.length && cs[j] == cs[i]; i++)
				;
			if (j + 1 >= i) {
				continue;
			}
			char[] newcs = new char[cs.length - i + j];
			for (int k = 0; k < j; k++) {
				newcs[k] = cs[k];
			}
			for (int k = j; k < cs.length - i + j; k++) {
				newcs[k] = cs[k + (i - j)];
			}
			if (!dp(newcs)) {
				dpSet.add(new String(newcs));
			}
		}
		return found;
	}
	
	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		dpSet = new HashSet<>();
		while (t > 0) {
			input = br.readLine().toCharArray();
//			inp = br.readLine();
			found = false;
			if (dp(input)) {
				pw.println(1);
			} else {
				pw.println(0);
			}
			t--;
		}
		br.close();
		pw.flush();
		pw.close();
	}
}

//static boolean dp1(String str) {
//	if (str.length() == 0) {
//		found = true;
//		return found;
//	}
//	
//	if (dpSet.contains(str)) {
//		return false;
//	}
//	int i = 0;
//	for (int j = i; j < str.length(); j = i) {
//		
//		for (i = j; i < str.length() && str.charAt(j) == str.charAt(i); i++)
//			;
//		if (j + 1 >= i) {
//			continue;
//		}
//		StringBuilder sb = new StringBuilder();
//		sb.append(str.substring(0, j));
//		sb.append(str.substring(i, str.length()));
//		
//		if (!dp1(sb.toString())) {
//			dpSet.add(sb.toString());
//		}
//	}
//	return found;
//}
