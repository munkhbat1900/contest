package competitiveprogramming.chapter3.dp.knapsack01.DivingforGold;

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
 * UVA 990 - Diving For Gold 
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int t, w, n;
	static int[] d, g;
	static int[][] dp;
	static boolean[][] picked;


	//	/**
	//	 * memoize
	//	 * @param i
	//	 * @param time
	//	 * @return
	//	 */
	//	static int rec(int i, int time) {
	//		if (dp[i][time] >= 0) {
	//			return dp[i][time];
	//		}
	//		
	//		if (i == n) {
	//			return dp[i][time] = 0;
	//		}
	//		
	//		int res;
	//		int td = 3 * w * d[i];
	//		if (td > time) {
	//			res = rec(i + 1, time);
	//		} else {
	//			res = Math.max(rec(i + 1, time), rec(i + 1, time - td) + g[i]);
	//		}
	//		return dp[i][time] = res;
	//	}

	//	/**
	//   * batcktracking
	//	 * returns the maximum gold.
	//	 * @param i ith treasure
	//	 * @param time remaining time
	//	 * @return
	//	 */
	//	static int rec(int i, int time) {
	//		// there is no treasure to take
	//		if (i == n) {
	//			return 0;
	//		}
	//		int td = 3 * w * d[i];
	//		
	//		if (td > time) {
	//			// can't get treasure because  air is not enough to dive
	//			return rec(i + 1, time);
	//		} else {
	//			return Math.max(rec(i + 1, time), rec(i + 1, time - td) + g[i]);
	//		}
	//	}

	static void dp() {
		// dp[i + 1][j] : maximum value of gold, when we select treasures
		// from 0 to ith and has time j
		// dp[0][j] = 0

		//dp[i + 1][j] = dp[i][j], where j < 3 * w * d[i]
		//dp[i + 1][j] = max(dp[i][j], dp[i][j - 3 * w * d[i]] + g[i])
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= t; j++) {
				dp[i + 1][j] = dp[i][j];
				
				if (j >= 3 * w * d[i] && dp[i + 1][j] < dp[i][j - 3 * w * d[i]] + g[i]) {
					dp[i + 1][j] = dp[i][j - 3 * w * d[i]] + g[i];
					picked[i + 1][j] = true;
				}
			}
		}

	}
	
	static void printSol(int i, int j, int count) {
		if (i == 0) {
			pw.println(count);
			return;
		}
		if (picked[i][j]) {
			printSol(i - 1, j - 3 * w * d[i - 1], count + 1);
			pw.printf("%d %d\n", Integer.valueOf(d[i - 1]), Integer.valueOf(g[i - 1]));
		} else {
			printSol(i - 1, j, count);
		}
		
	}

	public static void main(String[] args) throws IOException {
		int counter = 0;
		while (true) {
			String str = br.readLine();
			if (str == null || "".equals(str)) {
				break;
			}
			StringTokenizer st = new StringTokenizer(str);
			t = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(br.readLine());

			d = new int[n];
			g = new int[n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				d[i] = Integer.parseInt(st.nextToken());
				g[i] = Integer.parseInt(st.nextToken());
			}

			dp = new int[n + 1][t + 1];
			//			for (int[] arr : dp) {
			//				Arrays.fill(arr, -1);
			//			}

			for (int[] arr : dp) {
				Arrays.fill(arr, 0);
			}

			if (counter > 0) {
				pw.println();
			}
			picked = new boolean[n + 1][t + 1];
			for (boolean[] arr : picked) {
				Arrays.fill(arr, false);
			}
			dp();
			pw.println(dp[n][t]);
			printSol(n, t, 0);
			counter++;
			br.readLine();
		}

		br.close();
		pw.flush();
		pw.close();
	}
}
