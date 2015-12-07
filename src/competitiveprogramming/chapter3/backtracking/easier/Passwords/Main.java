package competitiveprogramming.chapter3.backtracking.easier.Passwords;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * @author munkhbat
 * UVA 628 - Passwords
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int n;
	static int m;
	static String[] dictionary;
	static String[] rules;
	static String[] digits = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
	static String rule;
	
	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}
	
	static void printSolution(String[] sol) {
		for (String s : sol) {
			pw.print(s);
		}
		pw.println();
	}
	
	static void solve(int len, String[] sol) {
		if (len == rule.length()) {
			printSolution(sol);
			return;
		}
		
		if (rule.charAt(len) == '0') {
			for (int i = 0; i < digits.length; i++) {
				sol[len] = digits[i];
				solve(len + 1, sol);
			}
		} else {
			for (String word : dictionary) {
				sol[len] = word;
				solve(len + 1, sol);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		while(true) {
			String str = br.readLine();
			if (str == null || str.equals("")) {
				break;
			}
			n = Integer.parseInt(str);
			dictionary = new String[n];
			for (int i = 0; i < n; i++) {
				dictionary[i] = br.readLine();
			}
			m = Integer.parseInt(br.readLine());
			rules = new String[m];
			for (int i = 0; i < m; i++) {
				rules[i] = br.readLine();
			}
			
			pw.println("--");
			
			for (String r : rules) {
				rule = r;
				solve(0, new String[r.length()]);
			}
		}
		br.close();
		pw.flush();
		pw.close();
	}
}
