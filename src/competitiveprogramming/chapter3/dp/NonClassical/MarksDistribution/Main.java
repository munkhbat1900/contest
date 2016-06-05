package competitiveprogramming.chapter3.dp.NonClassical.MarksDistribution;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author munkhbat
 * UVA 10910 - Marks Distribution
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	
	static int n, t, p;
	static int[][] dp;
	
	static int dp() {
		for (int i = p; i < t + 1; i++) {
			dp[0][i] = 1;
		}
		for (int i = 0; i < n; i++) {
			for (int j = p; j < t + 1; j++) {
				for (int k = p; k <= j; k++) {
					dp[i + 1][j] += dp[i][j - k];
				}
			}
		}
		return dp[n - 1][t];
	}
	
	public static void main(String[] args) throws IOException {
		int c = Integer.parseInt(br.readLine());
		while (c > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			dp = new int[n + 1][t + 1];
			pw.println(dp());
			c--;
		}
		br.close();
		pw.flush();
		pw.close();
	}
}
