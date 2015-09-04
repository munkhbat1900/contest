package contest.dfs.redblack;

import java.util.Scanner;

/**
 * @author munkhbat
 * POJ 1979 RED And BLACK
 */
public class Main {
	private static int h, w;
	private static char[][] field;
	private static int[] dx = new int[]{0, 0, 1, -1};
	private static int[] dy = new int[]{1, -1, 0, 0};
	private static int counter;

	public static void main(String[] a) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			w = sc.nextInt();
			h = sc.nextInt();

			if (h == 0 && w == 0) {
				break;
			}

			field = new char[h][w];

			for (int i = 0; i < h; i++) {
				field[i] = sc.next().toCharArray();
			}
			
			counter = 0;

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (field[i][j] == '@') {
						dfs(i, j);
						System.out.println(counter);
					}
				}
			}
		}
		sc.close();
	}
	private static void dfs(int x, int y) {
		counter++;
		field[x][y] = '#';
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx >= 0 && nx < h && ny >= 0 && ny < w && field[nx][ny] == '.') {
				dfs(nx, ny);
			}
		}
	}
}
