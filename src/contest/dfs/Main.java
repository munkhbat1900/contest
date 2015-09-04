package contest.dfs;

import java.util.Scanner;

/**
 * @author munkhbat
 * Red and Black POJ 1979
 */
public class Main {
	private static int[] dx = new int[] {1, 0, -1, 0};
	private static int[] dy = new int[] {0, 1, 0, -1};
	private static int counter = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int w, h;
		while (true) {
			w = sc.nextInt();
			h = sc.nextInt();
			if (w == 0 && h == 0) {
				break;
			}
			
			char[][] c = new char[h][w];
			for (int i = 0; i < h; i++) {
				c[i] = sc.next().toCharArray();
			}
			
			counter = 0;
			solve(w, h, c);
			System.out.println(counter);
		}
		sc.close();
	}
	
	public static void solve(int w, int h, char[][] c) {
		for (int x = 0; x < h; x++) {
			for (int y = 0; y < w; y++) {
				if (c[x][y] == '@') {
					dfs(x, y, c);
					return;
				}
			}
		}
	}
	
	public static void dfs(int h, int w, char[][] c) {
		counter++;
		c[h][w] = 'V';
		for (int i = 0; i < 4; i++) {
			int nw = w + dy[i];
			int nh = h + dx[i];
			if (nh < c.length && nh >= 0 && nw >= 0 && c[nh].length > nw && c[nh][nw] == '.') {
				dfs(nh, nw, c);
			}
		}
	}
}
