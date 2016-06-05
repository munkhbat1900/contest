package competitiveprogramming.chapter3.dp.CoinChange.CoinChange;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * @author munkhbat
 * UVA 674 - Coin Change
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int n;
	static int[] coins = new int[]{1, 5, 10, 25, 50};
	static int[][] dp;
	static int[][] memoize;
	
	static int solve(int rem, int m) {
		if (rem == 0) {
			return 1;
		}
		
		if (rem < 0 || m == coins.length) {
			return 0;
		}
		
		if (memoize[rem][m] != -1) {
			return memoize[rem][m];
		}
		
		return memoize[rem][m] = solve(rem, m + 1) + solve(rem - coins[m], m);
	}
	
	static int dp() {
		//dp[i][j] : solution including jth coin, and solution excluding jth coin
		
		for (int i = 1; i < n + 1; i++) {
			for (int j = 0; j < coins.length; j++) {
				dp[i][j] = i - coins[j] >= 0 ? dp[i - coins[j]][j] : 0;
				dp[i][j] += j - 1 >= 0 ? dp[i][j - 1] : 0;
			}
		}
		
		return dp[n][coins.length - 1];
	}
	
	public static void main(String[] args) throws IOException {
		memoize = new int[7490][coins.length];
		for (int i = 0; i < 7490; i++) {
			Arrays.fill(memoize[i], -1);
		}
		dp = new int[7490][coins.length];
		for (int i = 0; i < coins.length; i++) {
			dp[0][i] = 1;
		}
		n = 7489;
		dp();
		while (true) {
			String str = br.readLine();
			if (str == null || str.equals("")) {
				break;
			}
			
			n = Integer.parseInt(str);
			pw.println(dp[n][coins.length - 1]);
		}
		br.close();
		pw.flush();
		pw.close();
	}
	
}
