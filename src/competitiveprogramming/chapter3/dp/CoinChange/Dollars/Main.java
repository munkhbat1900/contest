package competitiveprogramming.chapter3.dp.CoinChange.Dollars;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * @author munkhbat
 * UVA 147 - Dollars
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int n;
	static int[] coins = new int[]{5, 10, 20, 50, 100, 200, 500, 1000, 2000, 5000, 10000};
	// dp[m][n] : count of ways we can sum coins[0..m-1] to get n
	static long[][] dp;
	
	/**
	 * solutions is sum of following 2 solutions.
	 * 1. solution includes mth element.
	 * 2. solution that doesn't include mth element
	 * @param m
	 * @param rem
	 * @return count of ways we can sum coins[0..m-1] coins to get rem
	 */
//	static int solve(int m, int rem) {
//		if (rem == 0) {
//			return 1;
//		}
//		if (rem < 0) {
//			return 0;
//		}
//
//		if (m <= 0 && n >= 1) {
//			return 0;
//		}
//		return solve(m - 1, rem) + solve(m, rem - coins[m - 1]);
//	}
	
	static long dp() {
		dp = new long[coins.length][n + 1];
		for (int i = 0; i < coins.length; i++) {
			dp[i][0] = 1;
		}
		for (int i = 0; i < coins.length; i++) {
			for (int j = 1; j < n + 1; j++) {
				dp[i][j] = (j - coins[i] >= 0) ? dp[i][j - coins[i]] : 0;
				dp[i][j] += i - 1 >= 0 ? dp[i - 1][j] : 0;
			}
		}
		return dp[coins.length - 1][n];
	}
	
	public static void main(String[] args) throws IOException {
		while (true) {
			float f = Float.valueOf(br.readLine()).floatValue();
			if (f == 0.00f) {
				break;
			}
			
			n = (int)((f + 0.001) * 100);
			pw.printf("%6.2f %16d\n", Float.valueOf(f), Long.valueOf(dp()));
		}
		br.close();
		pw.flush();
		pw.close();
	}
}
