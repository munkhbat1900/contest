package competitiveprogramming.chapter3.dp.CoinChange.IngenuousCubrency;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * @author munkhbat
 * UVA 11137 - Ingenuous Cubrency
 * Got Runtime error. But C++ version got AC.
 * I paste C++ code below java version.
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int n;
	static int[] coins = new int[21];
	// dp[m][n] : count of ways we can sum coins[0..m-1] to get n.
	static long[][] dp;

	static void dp() {
		dp = new long[21][10001];
		for (int i = 0; i < 21; i++) {
			coins[i] = (i + 1) * (i + 1) * (i + 1);
		}

		for (int i = 0;  i < 21; i++) {
			dp[i][0] = 1;
		}

		for (int i = 0;  i < 21; i++) {
			for (int j = 1; j < 10001; j++) {
				dp[i][j] = i - 1 >= 0 ? dp[i - 1][j] : 0;
				dp[i][j] += j - coins[i] >= 0 ? dp[i][j - coins[i]] : 0;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		dp();
		while (true) {
			String line = br.readLine();
			
			if (line == null || "".equals(line)) {
				break;
			}
			n = Integer.parseInt(line);
			pw.println(dp[20][n]);
		}
		br.close();
		pw.flush();
		pw.close();
	}
}

//#include <cstdio>
//
//long long dp[21][10001];
//int coins[21];
//
//void solve() {
//		
//		for (int i = 0; i < 21; i++) {
//			coins[i] = (i + 1) * (i + 1) * (i + 1);
//		}
//
//		for (int i = 0;  i < 21; i++) {
//			dp[i][0] = 1;
//		}
//
//		for (int i = 0;  i < 21; i++) {
//			for (int j = 1; j < 10001; j++) {
//				dp[i][j] = i - 1 >= 0 ? dp[i - 1][j] : 0;
//				dp[i][j] += j - coins[i] >= 0 ? dp[i][j - coins[i]] : 0;
//			}
//		}
//	}
//
//int main() {
//	solve();
//	int n;
//	while (scanf("%d", &n) == 1) {
//		printf("%lld\n", dp[20][n]);
//	}
//	return 0;
//}
