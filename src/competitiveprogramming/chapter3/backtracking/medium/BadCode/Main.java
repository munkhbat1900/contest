package competitiveprogramming.chapter3.backtracking.medium.BadCode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.Map.Entry;

/**
 * @author munkhbat
 * UVA 10950 - Bad Code
 * it is accepted in 1.125 secs. it is slow.
 * it would be more faster, 
 * if I check remaining string and checks it needs 0 or not. Then I won't need 2 recursive call.
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int n;
	static Map<Character, String> mapping;
	static String encrypted;
	static int count = 0;
	
	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}
	
	static boolean isMatch(String[] ans, int len) {
		int l = 0;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < ans[i].length(); j++) {
				if (ans[i].charAt(j) != encrypted.charAt(l)) {
					return false;
				}
				l++;
			}
		}
		return true;
	}
	
	static int ansLength(String[] ans, int len) {
		int l = 0;
		for (int i = 0; i < len; i++) {
			l += ans[i].length();
		}
		return l;
	}
	
	static void solve(String[] ans, int len, char[] orig) {
		if (count >= 100) {
			return;
		}
		
		int l = ansLength(ans, len);
		
		if (encrypted.length() < l) {
			return;
		}
		
		if (!isMatch(ans, len)) {
			return;
		}
		
		if (l == encrypted.length() && isMatch(ans, len)) {
			for (int i = 0; i < len; i++) {
				pw.print(orig[i]);
			}
			pw.println();
			count++;
			return;
		}
		
		for (Entry<Character, String> e : mapping.entrySet()) {
			if (count >= 100) {
				return;
			}
			ans[len] = e.getValue();
			orig[len] = e.getKey().charValue();
			solve(ans, len + 1, orig);
			ans[len] = "0" + e.getValue();
			solve(ans, len + 1, orig);
		}
	}
	
	public static void main(String[] args) throws IOException {
		int counter = 0;
		while (true) {
			if (counter > 0) {
				pw.println();
			}
			n = Integer.parseInt(br.readLine());
			if (n == 0) {
				break;
			}
			counter++;
			mapping = new TreeMap<>();
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				mapping.put(Character.valueOf(st.nextToken().charAt(0)), st.nextToken());
			}
			encrypted = br.readLine();
			
			pw.printf("Case #%d\n", valueOf(counter));
			count = 0;
			solve(new String[100], 0, new char[100]);
		}
		br.close();
		pw.flush();
		pw.close();
	}
}
