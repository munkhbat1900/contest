package competitiveprogramming.chapter3.dp.CoinChange.ExactChange;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * @author munkhbat
 * UVA 11517 - Exact Change
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int price, sum;
	static int[] coins;
	static int[] dp;

	static void dp() {
		for (int i = 0; i < coins.length; i++) {
			for (int j = sum - coins[i]; j > -1; j--) {
				if (dp[j] == Integer.MAX_VALUE) {
					continue;
				}
				dp[j + coins[i]] = Math.min(dp[j + coins[i]], 1 + dp[j]);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		while (t > 0) {
			price = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			coins = new int[n];
			sum = 0;
			for (int i = 0; i < n; i++) {
				coins[i] = Integer.parseInt(br.readLine());
				sum += coins[i];
			}
			dp = new int[sum + 1];
			Arrays.fill(dp, Integer.MAX_VALUE);
			dp[0] = 0;
			dp();

			for (int i = price; i <= sum; i++) {
				if (dp[i] != Integer.MAX_VALUE) {
					pw.printf("%d %d\n", Integer.valueOf(i), Integer.valueOf(dp[i]));
					break;
				}
			}
			
			t--;
		}
		br.close();
		pw.flush();
		pw.close();
	}
}
