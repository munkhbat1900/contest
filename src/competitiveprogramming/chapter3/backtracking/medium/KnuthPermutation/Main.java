package competitiveprogramming.chapter3.backtracking.medium.KnuthPermutation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * @author Munkhbat
 * UVA 10063 Knuth's Permutation
 * 
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static String str;
	
	static void solve(int index, char[] ans) {
		if (str.length() == index) {
			for (char c : ans) {
				pw.print(c);
			}
			pw.println();
			return;
		}
		
		// new element will be placed as 0th element. So, move every element to the right by one.
		for (int i = index; i >= 1; i--) {
			ans[i] = ans[i - 1];
		}
		
		// permutate index times. So, for example the first element will never be permutated.
		for (int i = 0; i <= index; i++) {
			ans[i] = str.charAt(index);
			solve(index + 1, ans);
			// next we will place this element at next possible position.
			// So, move an element at next possible position to this position.
			if (i < str.length() - 1) {
				ans[i] = ans[i + 1];
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		boolean b = false;
		while (true) {
			str = br.readLine();
			if (str == null || "".equals(str)) {
				break;
			}
			if (b) {
				pw.println();
			}
			b = true;
			solve(0, new char[str.length()]);
		}
		br.close();
		pw.flush();
		pw.close();
	}
}
