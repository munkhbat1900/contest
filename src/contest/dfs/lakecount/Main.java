package contest.dfs.lakecount;

import java.util.Scanner;

/**
 * @author Munkhbat
 * POJ 2386 lake count
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		//sc.skip("\n");
		char[][] field = new char[n][m];
		for (int i = 0; i < n; i++) {
			field[i] = sc.next().toCharArray();
		}
		
		System.out.println(solve(field));
		sc.close();
	}
	
	public static int solve(char[][] field) {
		int counter = 0;
		for (int x = 0; x < field.length; x++) {
			for (int y = 0; y < field[x].length; y++) {
				if (field[x][y] == 'W') {
					dfs(field, x, y);
					counter++;
				}
			}
		}
		return counter;
	}
	
	public static void dfs(char[][] field, int x, int y) {
		field[x][y] = '.';
		for (int dx = -1; dx <= 1; dx++) {
			for (int dy = -1; dy <= 1; dy++) {
				int nx = x + dx;
				int ny = y + dy;
				if (nx >= 0 && nx < field.length && ny >= 0 && ny < field[nx].length && field[nx][ny] == 'W') {
					dfs(field, nx, ny);
				}
			}
		}
	}
}
