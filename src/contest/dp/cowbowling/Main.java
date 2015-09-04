package contest.dp.cowbowling;

import java.util.Scanner;

/**
 * @author munkhbat
 * POJ 3176
 */
public class Main {
	private static int n;
	private static int[][] dp;
	private static int[][] input;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		dp = new int[n][n];
		input = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				dp[i][j] = 0;
				input[i][j] = 0;
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				input[i][j] = sc.nextInt();
			}
		}
		
		dp[0][0] = input[0][0];
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j <= i + 1; j++) {
				if (j == 0) {
					dp[i + 1][j] = dp[i][j] + input[i + 1][j];
					continue;
				}
				
				if (j == n - 1) {
					dp[i + 1][j] = dp[i][j - 1] + input[i + 1][j]; 
					continue;
				}
				dp[i + 1][j] = Math.max(dp[i][j], dp[i][j - 1]) + input[i + 1][j];
			}
		}
		
		int res = -1 * 1 << 25;
		for (int i = 0; i < n; i++) {
			if (dp[n - 1][i] > res) {
				res = dp[n - 1][i];
			}
		}
		
		System.out.println(res);
		
		sc.close();
	}
}
