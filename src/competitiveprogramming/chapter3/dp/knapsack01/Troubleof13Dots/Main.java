package competitiveprogramming.chapter3.dp.knapsack01.Troubleof13Dots;

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
 * UVA 10819 - Trouble of 13-Dots
 * 
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int budget, n;
	static int[] prices, favors;
	static int[][] topdown;
	
	static int topdown(int i, int m) {
		if (m > budget + 200) {
			return -10000;
		}
		if (m > budget && m < 1801) {
			return -10000;
		}
		if (i == n) {
			if (m > budget && m <= 2000) {
				return -10000;
			}
			return 0;
		}
		if (topdown[i][m] != -1) {
			return topdown[i][m];
		}
		
		return topdown[i][m] = Math.max(topdown(i + 1, m), topdown(i + 1, m + prices[i]) + favors[i]);
	}

	public static void main(String[] args) throws IOException {
		while (true) {
			String str = br.readLine();
			if (str == null || "".equals(str)) {
				break;
			}
			StringTokenizer st = new StringTokenizer(str);
			budget = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());

			prices = new int[n];
			favors = new int[n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				prices[i] = Integer.parseInt(st.nextToken());
				favors[i] = Integer.parseInt(st.nextToken());
			}

			topdown = new int[n + 1][budget + 201];
			for (int i = 0; i < n + 1; i++) {
				Arrays.fill(topdown[i], -1);
			}
			pw.println(topdown(0, 0));
		}

		br.close();
		pw.flush();
		pw.close();
	}
}
