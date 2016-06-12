package competitiveprogramming.chapter3.dp.knapsack01.Dividingcoins;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author munkhbat
 * UVA 562 - Dividing coins
 * topdown got AC in 0.260 secs, bottomup got AC in 0.130 secs.
 */
public class Main {
	//static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int[] coins;
	static int all, m;
	// 
	static int[][] topdown;
	static boolean[] bottomup;

	/**
	 * recursive memoize solution.
	 * i番までに獲得コインの総額sumの時、i番目以降のコインで最小の差分はいくつか？
	 * @param i
	 * @param sum
	 * @return
	 */
	static int topdown(int i, int sum) {
		if (i < coins.length && topdown[i][sum] >= 0) {
			return topdown[i][sum];
		}
		if (i >= coins.length) {
			return Math.abs(all - 2 * sum);
		}

		return topdown[i][sum] = Math.min(topdown(i + 1, sum), topdown(i + 1, sum + coins[i]));
	}

	static int bottomup() {
		bottomup = new boolean[all + 1];
		bottomup[0] = true;
		for (int j = 0; j < m; j++) {
			for (int i = all; i >= 0; i--) {
				if (bottomup[i]) {
					bottomup[i + coins[j]] = true;
				}
			}
		}
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i <= all; i++) {
			if (bottomup[i]) {
				ans = Math.min(ans, Math.abs(all - 2 * i));
			}
		}
		return ans;
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while (n > 0) {
			m = sc.nextInt();
			coins = new int[m];
			all = 0;
			for (int i = 0; i < m; i++) {
				coins[i] = sc.nextInt();
				all += coins[i];
			}
						topdown = new int[m + 1][all + 1];
						for (int i = 0; i < m + 1; i++) {
							Arrays.fill(topdown[i], -1);
						}
						
						pw.println(topdown(0, 0));

//			pw.println(bottomup());
			n--;
		}
		sc.close();
		pw.flush();
		pw.close();
	}
}
