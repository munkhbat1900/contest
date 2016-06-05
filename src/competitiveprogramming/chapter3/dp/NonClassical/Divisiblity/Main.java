package competitiveprogramming.chapter3.dp.NonClassical.Divisiblity;

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
 * UVA 10036 - Divisibility
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int n,k;
	static int[] arr;
	// dp[i][j] : i index, j = sum % k;
	//	static int[][] dp;


	//	static int solve(int index, int sum) {
	//		if (index == n) {
	//			return sum % k == 0 ? 1 : 0;
	//		}
	//		int j = (k + sum % k) % k;
	//		
	//		if (dp[index][j] != -1) {
	//			return dp[index][j];
	//		}
	//		
	//		dp[index][j] = Math.max(solve(index + 1, sum + arr[index]) , solve(index + 1, sum - arr[index]));
	//		return dp[index][j];
	//	}

	//dp[i][j] : if it is true then means that there are combination of (i,j) exists.
	//i index, j = sum % k; remainder
	static boolean[][] dp;

	static boolean bottomUp() {
		dp = new boolean[n + 1][k];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], false);
		}
		dp[0][0] = true;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < k; j++) {
				if (dp[i][j]) {
					int rem = (k + (arr[i] + j) % k) % k;
					dp[i + 1][rem] = true;
					rem = (k + (j - arr[i]) % k) % k;
					dp[i + 1][rem] = true;
				}
			}
		}
		return dp[n][0];
	}

	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		while (t > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			arr = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			//			dp = new int[n][k];
			//			for (int i = 0; i < n; i++) {
			//				Arrays.fill(dp[i], -1);
			//			}
			//			if (solve(0, 0) == 1) {
			//				pw.println("Divisible");
			//			} else {
			//				pw.println("Not divisible");
			//			}
			if (bottomUp()) {
				pw.println("Divisible");
			} else {
				pw.println("Not divisible");
			}
			t--;
		}
		br.close();
		pw.flush();
		pw.close();
	}
}
