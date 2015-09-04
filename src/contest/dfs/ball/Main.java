package contest.dfs.ball;

import java.util.Scanner;

/**
 * @author munkhbat
 * AOJ 033 ball
 */
public class Main {
	public static int[] balls = new int[10];
	private static int n;
	
	public static void main(String[] a) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 10; j++) {
				balls[j] = sc.nextInt();
			}
			
			System.out.println(dfs(0, 0, 0) == true ? "YES" : "NO");
		}
		sc.close();
	}
	
	/**
	 * @param a last number in A box
	 * @param b last number in B box
	 * @param num
	 * @return
	 */
	private static boolean dfs(int a, int b, int num) {
		if (num >= 10) {
			return true;
		}
		
		if (a < balls[num]) {
			return dfs(balls[num], b, ++num);
		}
		
		if (b < balls[num]) {
			return dfs(a, balls[num], ++num);
		}
		
		return false;
	}
}
