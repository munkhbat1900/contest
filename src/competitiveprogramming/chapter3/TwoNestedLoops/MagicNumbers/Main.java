package competitiveprogramming.chapter3.TwoNestedLoops.MagicNumbers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * @author Avirmed Munkhbat
 * 471 - Magic Numbers
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static long n;

	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}

	static boolean isDiff(long a) {
		boolean[] used = new boolean[10];
		for (int i = 0; i < 10; i++) {
			used[i] = false;
		}
		
		String str = Long.toString(a);
		for (int i = 0; i < str.length(); i++) {
			if (used[str.charAt(i) - '0']) {
				return false;
			} else {
				used[str.charAt(i) - '0'] = true;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		int c = Integer.parseInt(br.readLine());
		int counter = 0;
		while (c > 0) {
			if (counter > 0) {
				pw.println();
			}
			br.readLine();
			n = Long.parseLong(br.readLine());
			for (long s2 = 1; s2 * n  < 10000000000l; s2++) {
				long s1 = s2 * n;
				if (isDiff(s1) && isDiff(s2)) {
					pw.printf("%d / %d = %d\n", Long.valueOf(s1), Long.valueOf(s2), Long.valueOf(n));
				}
			}
			counter++;
			c--;
		}
		br.close();
		pw.flush();
		pw.close();
	}
}
