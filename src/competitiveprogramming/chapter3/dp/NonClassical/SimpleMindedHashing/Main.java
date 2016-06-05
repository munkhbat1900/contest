package competitiveprogramming.chapter3.dp.NonClassical.SimpleMindedHashing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author munkhbat
 * UVA 10912 - Simple Minded Hashing
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

	static int l, s;
	static int[][][] dp;

	//	static int dp() {
	//		
	//	}

	/**
	 * recursive. didn't submit.
	 * @param last
	 * @param len
	 * @param sum
	 * @return
	 */
	static int solve (int last, int len, int sum) {
		if ((sum > s) || sum >= s && len < l) {
			return 0;
		} else if (len == l && sum == s) {
			return 1;
		} else if (len == l) {
			return 0;
		}
		int count = 0;
		for (int i = last + 1; i <= 26; i++) {
			count += solve(i, len + 1, sum + i);
		}
		return count;
	}

	static void dp() {
		//dp[i][j][k] : i : length of word, j: up to jth character, k: sum
		dp = new int[27][27][26 * (26 + 1) / 2 + 1];
		for (int i = 1; i <= 26; i++) {
			dp[1][i][i] = 1;
		}
		for (int i = 1; i <= 26; i++) {
			for (int j = 2; j <= 26; j++) {
				for (int k = 1; k <= 26 * (26 + 1) / 2; k++) {
					// letter j is not selected
					dp[i][j][k] += dp[i][j - 1][k];
					if (k - j >= 0) {
						// letter j is selected.
						dp[i][j][k] += dp[i - 1][j - 1][k - j];
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		int counter = 1;
		dp();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			l = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			if (l == 0 || s == 0) {
				break;
			}
			if (l > 26 || s > 26 * (26 + 1) / 2) {
				pw.printf("Case %d: %d\n", Integer.valueOf(counter), Integer.valueOf(0));
			} else {
				pw.printf("Case %d: %d\n", Integer.valueOf(counter), Integer.valueOf(dp[l][26][s]));
			}
			counter++;
		}
		br.close();
		pw.flush();
		pw.close();
	}
}
