package competitiveprogramming.chapter3.dp.CoinChange.LetMeCountTheWays;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * @author munkhbat
 * UVA 357 - Let Me Count The Ways
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int n;
	static int[] coins = new int[]{1, 5, 10, 25, 50};
	// dp[m][n] : count of ways we can sum coins[0..m-1] to get n
	static long[][] dp;

	static long dp() {
		dp = new long[coins.length][n + 1];

		for (int i = 0; i < coins.length; i++) {
			dp[i][0] = 1;
		}

		for (int i = 0; i < coins.length; i++) {
			for (int j = 1; j < n + 1; j++) {
				dp[i][j] = j - coins[i] >= 0 ? dp[i][j - coins[i]] : 0;
				dp[i][j] += i > 0 ? dp[i - 1][j] : 0;
			}
		}

		return dp[coins.length - 1][n];
	}

	public static void main(String[] args) throws IOException {
		while (true) {
			String str = br.readLine();
			if (str == null || str.equals("")) {
				break;
			}
			n = Integer.parseInt(str);
			long sol = dp();
			if (sol > 1) {
				pw.printf("There are %d ways to produce %d cents change.\n", Long.valueOf(sol) , Integer.valueOf(n));
			} else {
				pw.printf("There is only %d way to produce %d cents change.\n", Long.valueOf(sol) , Integer.valueOf(n));
			}
		}
		br.close();
		pw.flush();
		pw.close();
	}
}