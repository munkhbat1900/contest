package competitiveprogramming.chapter3.dp.CoinChange.MakingChange;

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
 * UVA 166 - Making Change
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int n, sum;
	static int[] coins = new int[]{5, 10, 20, 50, 100, 200};
	static int[] coinsHave;
	static int[] dp1, dp2;
	
	static void dp1() {
		dp1 = new int[701];
		Arrays.fill(dp1, Integer.MAX_VALUE);
		dp1[0] = 0;
		for (int i = 1; i < 501; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < coins.length; j++) {
				if (i - coins[j] < 0) {
					continue;
				}
				min = min > dp1[i - coins[j]] ? dp1[i - coins[j]] : min;
			}
			dp1[i] = min == Integer.MAX_VALUE ? min : 1 + min;
		}
	}
	
	
	/**
	 * limited coin.
	 */
	static void dp2() {
		dp2 = new int[sum + 1];
		Arrays.fill(dp2, Integer.MAX_VALUE);
		dp2[0] = 0;
		for (int i = 0; i < coins.length; i++) {
			while (coinsHave[i] > 0) {
				for (int j = sum - coins[i]; j > -1; j--) {
					if (dp2[j] == Integer.MAX_VALUE) {
						continue;
					}
					dp2[j + coins[i]] = Math.min(dp2[j + coins[i]], 1 + dp2[j]);
				}
				coinsHave[i]--;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		dp1();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			coinsHave = new int[6];
			int check = 0;
			sum = 0;
			for (int i = 0; i < 6; i++) {
				coinsHave[i] = Integer.parseInt(st.nextToken());
				check = check | coinsHave[i];
				sum += coinsHave[i] * coins[i];
			}
			if (check == 0) {
				break;
			}
			
			n = (int)(100 * (Float.parseFloat(st.nextToken()) + 0.001));
			dp2();
			int min = Integer.MAX_VALUE;
			int m = n + 200 > sum ? sum : n + 200;
			for (int i = n; i <= m; i++) {
				if (dp2[i] == Integer.MAX_VALUE) {
					continue;
				}
				min = Math.min(dp2[i] + dp1[i - n], min);
			}
			pw.printf("%3d\n", Integer.valueOf(min));
		}
		br.close();
		pw.flush();
		pw.close();
	}
}
