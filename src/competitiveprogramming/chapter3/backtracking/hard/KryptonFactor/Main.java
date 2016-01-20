package competitiveprogramming.chapter3.backtracking.hard.KryptonFactor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author munkhbat
 * UVa 00129 - Krypton Factor
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int n, l;
	static char[] chars;
	static boolean found = false;
	static int count;
	
	static boolean isHard(char[] seq, int len, char c) {
		char[] tmp= new char[len + 1];
		for (int i = 0; i < len; i++) {
			tmp[i] = seq[i];
		}
		tmp[len] = c;
		len++;
		// it will be enough to check last 2 sequence of length length.
		// because we check every time when add one character.
		for (int length = 1; length <= len / 2; length++) {
			boolean b = true;
			for (int i = 0; i < length; i++) {
				if (tmp[len - i - 1] != tmp[len - i - 1 - length]) {
					b = false;
					break;
				}
			}
			if (b) return false;
		}
		return true;
	}
	
	static void solve(int len, char[] seq) {
//		for (int i = 0; i < len; i++) {
//			pw.print(seq[i]);
//		}
//		pw.println();
		if (count == n && !found) {
			found = true;
			int c = 1;
			pw.print(seq[0]);
			for (int i = 1; i < len; i++) {
				if (i % 4 == 0 && c < 16) {
					pw.print(" " + seq[i]);
					c++;
				} else if (i % 4 == 0 && c >= 16) {
					pw.println();
					pw.print(seq[i]);
					c = 0;
				} else {
					pw.print(seq[i]);
				}
			}
			pw.println();
			pw.println(len);
			return;
		}
		for (int i = 0; i < l; i++) {
			if (found) {
				return;
			}
			if (isHard(seq, len, chars[i])) {
				seq[len] = chars[i];
				count++;
				solve(len + 1, seq);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			if (n == 0 && l == 0) {
				break;
			}
			
			chars = new char[l];
			for (int i = 0; i < l; i++) {
				chars[i] = alphabet.charAt(i);
			}
			
			found = false;
			count = 0;
			// assumed maximum length is 80
			solve(0, new char[80]);
		}
		br.close();
		pw.flush();
		pw.close();
	}
}
