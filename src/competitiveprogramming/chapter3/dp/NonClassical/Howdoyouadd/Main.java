package competitiveprogramming.chapter3.dp.NonClassical.Howdoyouadd;

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
 * @author Munkhbat
 * UVA 10943 - How do you add?
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int n, k;
	static BigInteger[][] dp;
	
	static void bottomup() {
		for (int i = 1; i < 101; i++) {
			for (int j = 2; j < 101; j++) {
				for (int x = 0; x <= i; x++) {
					dp[i][j] = dp[i][j].add(dp[i - x][j - 1]);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		dp = new BigInteger[101][101];
		for (int i = 0; i < 101; i++) {
			Arrays.fill(dp[i], BigInteger.ZERO);
		}
		Arrays.fill(dp[0], BigInteger.ONE);
		for (int i = 0; i < 101; i++) {
			dp[i][1] = BigInteger.ONE;
		}
		bottomup();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			if (n == 0 && k == 0) {
				break;
			}
			pw.println(dp[n][k].mod(BigInteger.valueOf(1000000)).longValue());
		}
		br.close();
		pw.flush();
		pw.close();
	}
}
