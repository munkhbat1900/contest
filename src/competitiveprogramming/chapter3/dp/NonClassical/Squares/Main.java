package competitiveprogramming.chapter3.dp.NonClassical.Squares;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * @author Avirmed Munkhbat
 * UVA 11407 - Squares
 * 
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	
	static int n;
	static int[] dp;
	
	static void bottomup() {
		for (int i = 2; i < 10001; i++) {
			for (int j = 1; j <= Math.sqrt(i); j++) {
				if (dp[i - j * j] == Integer.MAX_VALUE) {
					continue;
				}
				dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		dp = new int[10001];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		dp[1] = 1;
		bottomup();
		int c = Integer.parseInt(br.readLine());
		while (c > 0) {
			n = Integer.parseInt(br.readLine());
			pw.println(dp[n]);
			c--;
		}
		br.close();
		pw.flush();
		pw.close();
	}
}
