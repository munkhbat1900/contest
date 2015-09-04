package contest.graph.shortestMeanDegree;

import java.util.Scanner;

/**
 * @author munkhbat
 * POJ 2139
 */
public class Main {
	private static int n;
	private static int m;
	private static int[][] d;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		d = new int[320][320];
		
		for (int k = 0; k < 320; k++) {
			for (int i = 0; i < 320; i++) {
				d[k][i] = 1 << 20;
				if (i == k) {
					d[k][i] = 0;
				}
			}
		}
		
		for (int j = 0; j < m; j++) {
			int cowCount = sc.nextInt();
			int c[] = new int[cowCount];
			for (int k = 0; k < cowCount; k++) {
				c[k] = sc.nextInt() - 1;
			}
			
			for (int k = 0; k < cowCount; k++) {
				for (int i = k + 1; i < cowCount; i++) {
					d[c[k]][c[i]] = d[c[i]][c[k]] = 1;
				}
			}
		}
		
		// warshall floyd
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
				}
			}
		}
		
		int res = 1 << 22;
		for (int k = 0; k < n; k++) {
			int tmp = 0;
			for (int i = 0; i < n; i++) {
				tmp += d[k][i];
			}
			if (res > tmp) {
				res = tmp;
			}
		}
		
		System.out.println((int)((100 * res) / (n - 1)));
	}
}
