package competitiveprogramming.chapter3.dp.NonClassical.GameShowMath;

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
 * UVA 10400 - Game Show Math
 * when I submitted wthout dp then I got TLE(over 20secs)
 * after introducing dp I got AC in 0.140sec
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int p, target;
	static int[] arr;
	static char[] symbols;
	static int[][] dp;

	static int solve(int index, int res) {
		if (index == p && res == target) {
			return 1;
		} else if (index == p && res != target) {
			return 0;
		}
		if (dp[index][res < 0 ? 64000 + res : res] != -1) {
			return dp[index][res < 0 ? 64000 + res : res];
		}
		int b = -1;
		int r = res + arr[index];
		if (r <= 32000 && r >= -32000) {
			b = solve(index + 1, r);
			if (r < 0) {
				
			}
			dp[index + 1][r < 0 ? 64000 + r : r] = b;
			symbols[index - 1] = '+';
		}
		r = res - arr[index];
		if (r <= 32000 && r >= -32000 && b != 1) {
			b = solve(index + 1, r);
			dp[index + 1][r < 0 ? 64000 + r : r] = b;
			symbols[index - 1] = '-';
		}
		r = res * arr[index];
		if (r <= 32000 && r >= -32000 && b != 1) {
			b = solve(index + 1, r);
			dp[index + 1][r < 0 ? 64000 + r : r] = b;
			symbols[index - 1] = '*';
		}
		r = res / arr[index];
		if (res % arr[index] == 0 && b != 1) {
			b = solve(index + 1, res / arr[index]);
			dp[index + 1][r < 0 ? 64000 + r : r] = b;
			symbols[index - 1] = '/';
		}
		return b;
	}

	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		while (t > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			p = Integer.parseInt(st.nextToken());
			arr = new int[p];
			for (int i = 0; i < p; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			target = Integer.parseInt(st.nextToken());
			symbols = new char[p - 1];
			dp = new int[p + 1][64002];
			for (int i = 0; i < p; i++) {
				Arrays.fill(dp[i], -1);
			}
			if(solve(1, arr[0]) == 1) {
				for (int i = 0; i < p; i++) {
					pw.print(arr[i]);
					if (i < p - 1) {
						pw.print(symbols[i]);
					}
				}
				pw.print("=" + target);
				pw.println();
			} else {
				pw.println("NO EXPRESSION");
			}
			t--;
		}
		br.close();
		pw.flush();
		pw.close();
	}
}
