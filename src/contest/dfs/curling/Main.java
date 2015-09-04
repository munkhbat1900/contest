package contest.dfs.curling;

import java.util.Scanner;

/**
 * @author munkhbat
 * POJ 3009
 * Curling 2.0
 */
public class Main {
	private static int[][] square;
	private static int sx, sy;
	private static int w, h;
	private static int[] dx = new int[]{0, 1, -1, 0};
	private static int[] dy = new int[]{1, 0, 0, -1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			w = sc.nextInt();
			h = sc.nextInt();
			square = new int[h][w];
			if (w == 0 && h == 0) {
				break;
			}
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					square[i][j] = sc.nextInt();
					if (square[i][j] == 2) {
						sx = i;
						sy = j;
					}
				}
			}
			
			int ans = dfs(sy, sx, 0);
			System.out.println((ans > 10 ? -1 : ans));
		}
		sc.close();
	}

	private static int dfs(int y, int x, int depth) {
		if (depth >= 10) {
			return 1 << 10;
		}
		int ans = 1 << 10;
		for (int k = 0; k < 4; k++) {
			int nx = x + dx[k];
			int ny = y + dy[k];
			if (nx < 0 || nx >= h || ny < 0 || ny >= w || square[nx][ny] == 1) {
				continue;
			}
			
			while (nx >= 0 && nx < h && ny >= 0 && ny < w && (square[nx][ny] == 0 || square[nx][ny] == 2)) {
				nx += dx[k];
				ny += dy[k];
			}
			
			if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
				continue;
			}
			
			if (square[nx][ny] == 3) {
				return depth + 1;
			}
			
			if (square[nx][ny] == 1) {
				square[nx][ny] = 0;
				ans = Math.min(ans, dfs(ny - dy[k], nx - dx[k], depth + 1));
				square[nx][ny] = 1;
			}
		}
		return ans;
	}
}
