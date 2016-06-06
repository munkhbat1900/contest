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
 */
public class Main {
	//static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int[] coins;
	static int all, m;
	// 
	static int[][] topdown;
	static int[] bottomup;
	
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
	
//	static int bottomup() {
//		bottomup = new int[m + 1];
//		bottomup[0] = coins[0];
//		
//		for (int i = 1; i < m; i++) {
////			for (int j = i; j < )
//			if (bottomup[i - 1] < 0) {
//				bottomup[i] = bottomup[i - 1] + coins[i];
//			} else {
//				bottomup[i] = bottomup[i - 1] - coins[i];
//			}
//		}
//		return Math.abs(bottomup[m - 1]);
//	}
	
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
//			topdown = new int[m + 1][all + 1];
//			for (int i = 0; i < m + 1; i++) {
//				Arrays.fill(topdown[i], -1);
//			}
//			
//			pw.println(topdown(0, 0));
			
			pw.println(bottomup());
			n--;
		}
		sc.close();
		pw.flush();
		pw.close();
	}
}
