package competitiveprogramming.chapter3.dp.NonClassical.AGroupingProblem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Avirmed Munkhbat
 * UVA 11026 - A Grouping Problem
 * If you factorize an from all the terms that contain an then the recurrence formula would be derived.
 * I couldn't come up with this solution
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int n, m;
	static BigInteger[][] dp;
	static int[] a;
	
	static void bottomup() {
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i][j] = (dp[i - 1][j - 1].multiply(BigInteger.valueOf(a[i - 1]))).add(dp[i - 1][j]); 
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			a = new int[n];
			if (n == 0 && m == 0) {
				break;
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			dp = new BigInteger[n + 1][n + 1];
			for (int i = 0; i < n + 1; i++) {
				Arrays.fill(dp[i], BigInteger.ZERO);
			}
			for (int i = 0; i < n + 1; i++) {
				dp[i][0] = BigInteger.ONE;
			}
			bottomup();
			int max = 0;
			for (int i = 0; i <= n; i++) {
				int l = dp[n][i].mod(BigInteger.valueOf(m)).intValue();
				max = Math.max(max, l);
			}
			pw.println(max);
		}
		br.close();
		pw.flush();
		pw.close();
	}
}
