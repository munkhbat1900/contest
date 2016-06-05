package competitiveprogramming.chapter3.dp.NonClassical.LowestPriceInTown;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author munkhbat
 * UVA 10980 Lowest Price in Town
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int p;
	static int m, max;
	static int[] num;
	static int[] prices;
	static List<Integer> ks;
	
	
	static float solve(int index, float val) {
		if (index <= 0) {
			return val;
		}
		
		float min = Float.MAX_VALUE;
		for (int i = 0; i < num.length; i++) {
			min = Math.min(min, solve(index - num[i], val + prices[i]));
		}
		return min;
	}
	
	static int bottomup(int k) {
		int[] dp = new int[k + max + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 1; i < k + max + 1; i++) {
			for (int j = 0; j < num.length; j++) {
				if (i > k && i - num[j] > k) {
					continue;
				}
				if (i > num[j]) {
					int p = i > k ? k : i;
					dp[p] = Math.min(dp[p], dp[i - num[j]] + prices[j]);
				} else if (dp[i] > prices[j] && i <= k) {
					dp[i] = prices[j];
				}
			}
		}
		return dp[k];
	}
	
	public static void main(String[] args) throws IOException {
		int c = 1;
		while (true) {
			String str = br.readLine();
			if (str == null || "".equals(str)) {
				break;
			}
			StringTokenizer st = new StringTokenizer(str);
			p = (int)((Float.parseFloat(st.nextToken()) + 0.001) * 100);
			m = Integer.parseInt(st.nextToken());
			num = new int[m + 1];
			prices = new int[m + 1];
			num[0] = 1;
			prices[0] = p;
			max = 0;
			for (int i = 1; i < m + 1; i++) {
				st = new StringTokenizer(br.readLine());
				num[i] = Integer.parseInt(st.nextToken());
				max = Math.max(max, num[i]);
				prices[i] = (int)((Float.parseFloat(st.nextToken()) + 0.001) * 100);
			}
			st = new StringTokenizer(br.readLine());
			ks = new ArrayList<>();
			while (st.hasMoreTokens()) {
				ks.add(Integer.valueOf(st.nextToken()));
			}
			pw.printf("Case %d:\n", Integer.valueOf(c));
			for (Integer kk : ks) {
				pw.printf("Buy %d for $%.2f\n", kk, Float.valueOf(((float)(bottomup(kk.intValue())) / 100)));
			}
			c++;
		}
		br.close();
		pw.flush();
		pw.close();
	}
}
