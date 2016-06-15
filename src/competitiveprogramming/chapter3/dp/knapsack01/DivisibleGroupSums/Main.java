package competitiveprogramming.chapter3.dp.knapsack01.DivisibleGroupSums;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author munkhbat
 *　UVA 10616 - Divisible Group Sums
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int n, q, m, d;
	static int[] input;
	// i番までで
	static long[][][] topdown;
	
	static long topdown(int p, int q, int rem) {
		if (p == m && rem == 0) {
			return 1;
		} else if (p == m) {
			return 0;
		}
		if (topdown[p][q][rem] != -1) {
			return topdown[p][q][rem];
		}
		int res = 0;
		for (int i = q; i < n; i++) {
			res += topdown(p + 1, i + 1, (rem + (input[i] % d)) % d);
		}
		if (res > -1) {
			return topdown[p][q][rem] = res;
		}
		return 0;
	}


	public static void main(String[] args) throws IOException {
		int counter = 0;
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());
			if (n == 0 && q == 0) {
				break;
			}
			counter++;
			input = new int[n];

			for (int i = 0; i < n; i++) {
				input[i] = Integer.parseInt(br.readLine());
			}
			
			pw.printf("SET %d:\n", Integer.valueOf(counter));
			for (int i = 0; i < q; i++) {
				st = new StringTokenizer(br.readLine());
				d = Integer.parseInt(st.nextToken());
				m = Integer.parseInt(st.nextToken());
				topdown = new long[m + 1][n + 1][d];
				for (int k = 0; k < m + 1; k++) {
					for (int e = 0; e < n + 1; e++) {
						Arrays.fill(topdown[k][e], -1);
					}
				}
				pw.printf("QUERY %d: %d\n", Integer.valueOf(i + 1), Long.valueOf(topdown(0, 0, 0)));
			}
		}
		br.close();
		pw.flush();
		pw.close();
	}
}
