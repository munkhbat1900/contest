package competitiveprogramming.chapter3.TwoNestedLoops.TheSkylineProblem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Avirmed Munkhbat
 * UVA 105  The Skyline Problem
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int[] h;

	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}

	public static void main(String[] args) throws IOException {
		h = new int[10001];
		Arrays.fill(h, 0);
		while (true) {
			String str = br.readLine();
			if (str == null || str.equals("")) {
				break;
			}
			StringTokenizer st = new StringTokenizer(str);
			int l = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			for (int i = l; i < r; i++) {
				h[i] = Math.max(h[i], height);
			}
			if (l == r) {
				h[l] = Math.max(h[l], height);
			}
		}
		int prev = 0;
		boolean first = true;
		for (int i = 0; i < 10001; i++) {
			if (prev != h[i]) {
				if (!first) {
					pw.print(" ");
				}
				pw.printf("%d %d", valueOf(i), valueOf(h[i]));
				prev = h[i];
				first = false;
			}
		}
		pw.println();
		br.close();
		pw.flush();
		pw.close();
	}
}
