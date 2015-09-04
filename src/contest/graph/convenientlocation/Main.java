package contest.graph.convenientlocation;

import java.util.Scanner;

/**
 * @author munkhbat
 * AOJ 0189
 * warshall-floyd
 */
public class Main {
	private static int n;
	private static int[][] graph;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			n = sc.nextInt();
			if (n == 0) {
				break;
			}
			
			graph = new int[11][11];
			for (int i = 0; i < 11; i++) {
				for (int j = 0; j < 11; j++) {
					graph[i][j] = 1 << 20;
				}
			}
			
			for (int i = 0; i < 11; i++) {
				graph[i][i] = 0;
			}
			
			int maxNum = Integer.MIN_VALUE;
			
			for (int i = 0; i < n; i++) {
				int s = sc.nextInt();
				int t = sc.nextInt();
				int c = sc.nextInt();
				
				maxNum = Math.max(maxNum, Math.max(s, t));
				
				graph[s][t] = c;
				graph[t][s] = c;
			}
			
			for (int k = 0; k <= maxNum; k++) {
				for (int i = 0; i <= maxNum; i++) {
					for (int j = 0; j <= maxNum; j++) {
						graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
					}
				}
			}
			
			int min = 1 << 20;
			int num = 0;
			for (int i = 0; i <= maxNum; i++) {
				int sum = 0;
				for (int j = 0; j <= maxNum; j++) {
					sum += graph[i][j];
				}
				if (min > sum) {
					num = i;
					min = sum;
				}
			}
			
			System.out.println(num + " " + min);
		}
		sc.close();
	}
}
