package contest.bfs.cheese;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author munkhbat
 * Cheese
 * AOJ 0558
 * BFS
 */
public class Main {
	private static int h, w, n;
	private static int sx, sy;
	private static int gx, gy;
	private static char[][] town;
	private static int[] dx = new int[]{0, 0, 1, -1};
	private static int[] dy = new int[]{1, -1, 0, 0};
	private static int distance = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		h = sc.nextInt();
		w = sc.nextInt();
		n = sc.nextInt();

		town = new char[h][w];
		for (int i = 0; i < h; i++) {
			town[i] = sc.next().toCharArray();
			for (int j = 0; j < w; j++) {
				if (town[i][j] == 'S') {
					sx = i;
					sy = j;
				}
			}
		}
		bfs(1);
		System.out.println(distance);
		sc.close();
	}

	public static void bfs(int num) {
		if (num > n) {
			return;
		}

		int[][] d = new int[h][w];

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				d[i][j] = 1 << 20;
			}
		}

		d[sx][sy] = 0;

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(getNodeNumber(sx, sy));
		setTargetPos(num);
		boolean found = false;

		while (queue.size() > 0) {
			int node = queue.poll();
			int x = getX(node);
			int y = getY(node);

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || nx >= h || ny < 0 || ny >= w || town[nx][ny] == 'X') {
					continue;
				}

				if (d[nx][ny] != 1 << 20) {
					continue;
				}

				if (nx == gx && ny == gy) {
					town[nx][ny] = '.';
					sx = gx;
					sy = gy;
					d[gx][gy] = d[x][y] + 1;
					distance += d[gx][gy];
					found = true;
					break;
				}
				queue.add(getNodeNumber(nx, ny));
				d[nx][ny] = d[x][y] + 1;
			}
			if (found) {
				break;
			}
		}
		bfs(++num);
	}

	private static void setTargetPos(int num) {
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (town[i][j] == Character.forDigit(num, 10)) {
					gx = i;
					gy = j;
				}
			}
		}
	}

	private static int getNodeNumber(int x, int y) {
		return 10000 * x + y;
	}

	private static int getX(int nodeNumber) {
		return nodeNumber / 10000;
	}

	private static int getY(int nodeNumber) {
		return nodeNumber % 10000;
	}
}
