package competitiveprogramming.chapter3.ThreeOrMoreNestedLoopsHarder.RatAttack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author munkhbat
 * UVA 10360 - Rat Attack
 * input format is little weird. I got several runtime error.
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

	static int n, d;
	static int x, y, size;
	static int[][] killed;

	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}

	public static void main(String[] args) throws IOException {
		String str = br.readLine();
		int s = Integer.parseInt(str);
		for (int i = 0; i < s; i++) {
			String str1 = br.readLine().trim();
			if (str1 == null || str1.equals("")) {
				str1 = br.readLine().trim();
			}
			d = Integer.parseInt(str1);
			n = Integer.parseInt(br.readLine().trim());
			killed = new int[1025][1025];
			for (int j = 0; j < n; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				size = Integer.parseInt(st.nextToken());

				for (int p = x - d; p <= x + d; p++) {
					for (int q = y - d; q <= y + d; q++) {
						if (p >= 0 && p < 1025 && q >= 0 && q < 1025) {
							killed[p][q] += size;
						}
					}
				}
			}

			int max = Integer.MIN_VALUE;
			int h = 0, w = 0;
			for (int p = 0; p < 1025; p++) {
				for (int q = 0; q < 1025; q++) {
					if (max < killed[p][q]) {
						max = killed[p][q];
						w = p;
						h = q;
					}
				}
			}
			pw.printf("%d %d %d\n", valueOf(w), valueOf(h), valueOf(max));
		}

		br.close();
		pw.flush();
		pw.close();
	}
}
