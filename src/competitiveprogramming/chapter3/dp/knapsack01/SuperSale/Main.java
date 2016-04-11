package competitiveprogramming.chapter3.dp.knapsack01.SuperSale;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author munkhbat
 * UVA 10130 - SuperSale
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int n, g, maxfamw = Integer.MIN_VALUE;
	static int[] p, w, famw;
	// dp[i + 1][j] = i番までの品物で重さj以下のものの価値の最大値
	// dp[i + 1][j] = max(dp[i][j], dp[i][j - w[i]] + p[i])
	static int[][] dp;
	
	static void dp() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= maxfamw; j++) {
				if (j < w[i]) {
					dp[i + 1][j] = dp[i][j];
				} else {
					dp[i + 1][j] = Math.max(dp[i][j], dp[i][j - w[i]] + p[i]);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		
		while (t > 0) {
			n = Integer.parseInt(br.readLine());
			p = new int[n];
			w = new int[n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				p[i] = Integer.parseInt(st.nextToken());
				w[i] = Integer.parseInt(st.nextToken());
			}
			g = Integer.parseInt(br.readLine());
			famw = new int[g];
			for (int i = 0; i < g; i++) {
				famw[i] = Integer.parseInt(br.readLine());
				maxfamw = Math.max(maxfamw, famw[i]);
			}
			
			dp = new int[n + 1][maxfamw + 1];
			dp();
			int sol = 0;
			for (int i = 0; i < g; i++) {
				sol += dp[n][famw[i]];
			}
			pw.println(sol);
			t--;
		}
		
		
		br.close();
		pw.flush();
		pw.close();
	}
}
