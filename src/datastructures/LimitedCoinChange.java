package datastructures;

/**
 * @author munkhbat
 * coin change problem with limited number of coins
 */
public class LimitedCoinChange {
	
	public static void main(String[] args) {
		int[] limit = new int[]{2, 1, 2, 5};
		int[] denoms = new int[]{1, 10, 25, 50};
		int n = 35;
		
		int max = 0;
		for (int i = 1; i < limit.length; i++) {
			max += limit[i] * denoms[i];
		}
		int[] dp = new int[max + 1];
		
		for (int i = 1; i < max + 1; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		dp[0] = 0;
		
		for (int i = 0; i < limit.length; i++) {
			while (limit[i] > 0) {
				for (int j = max - denoms[i]; j > -1; j--) {
					if (dp[j] < Integer.MAX_VALUE) {
						dp[j + denoms[i]] = Math.min(1 + dp[j], dp[j + denoms[i]]);
					}
				}
				limit[i]--;
			}
		}
		for (int i = 1; i < n + 1; i++) {
			System.out.println("dp[" + i + "] = " + dp[i]);
			//dp[i] = Integer.MAX_VALUE;
		}
		
	}
}
