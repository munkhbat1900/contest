package competitiveprogramming.chapter3.TwoNestedLoops.Division;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * @author munkhbat
 * UVA 725 - Division
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}

	static boolean isDuplicate(String n) {
		boolean[] used = new boolean[10];
		Arrays.fill(used, false);
		for (int k = 0; k < n.length(); k++) {
			if (used[n.charAt(k) - '0']) {
				return true;
			} else {
				used[n.charAt(k) - '0'] = true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		int counter = 0;
		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) {
				break;
			}
			if (counter > 0) {
				pw.println();
			}
			counter++;
			boolean ans = false;
			for (int i = 12345; i < 98765; i++) {
				if (i % n != 0) {
					continue;
				}

				String d = Integer.toString(i / n);
				
				if (isDuplicate(Integer.toString(i)) || isDuplicate(d)) {
					continue;
				}

				if (d.length() < 4 || (d.length() == 4 && d.contains("0"))) {
					continue;
				}
				
				if (d.length() == 4) {
					d = "0" + d;
				}
				
				if (isDuplicate(Integer.toString(i) + d)) {
					continue;
				}
				
				ans = true;
				pw.printf("%d / %s = %d\n", valueOf(i), d, valueOf(n));

			}
			if (!ans) {
				pw.printf("There are no solutions for %d.\n", valueOf(n));
			}
		}
		br.close();
		pw.flush();
		pw.close();
	}
}
