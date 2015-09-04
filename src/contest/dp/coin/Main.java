package contest.dp.coin;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author munkhbat
 * Coin change AOJ
 * http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=DPL_1_A
 * Find the minimum number of coins to make change for n cents 
 * using coins of denominations d1, d2,.., dm. The coins can be used any number of times.
 */
public class Main {
	private static int n, m;
	private static int[] dp;
	private static int[] denominations;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		dp = new int[n + 1];
		denominations = new int[m];
		
		for (int i = 0; i < m; i++) {
			denominations[i] = sc.nextInt();
		}
		
		sc.close();
		
		Arrays.fill(dp, 1 << 25);
		dp[0] = 0;
		// i : cents to change
		for (int i = 1; i < n + 1; i++) {
			for (int j = 0; j < m; j++) {
				if (denominations[j] <= i && dp[i - denominations[j]] + 1 < dp[i]) {
					dp[i] = dp[i - denominations[j]] + 1;
				}
			}
		}
		
		System.out.println(dp[n]);
	}
}
