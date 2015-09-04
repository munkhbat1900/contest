package contest.bfs;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class ShortestPath {
	private static int h, w, sx, sy, gx, gy;
	private static char[][] field;
	private static int[][] distance;
	private static int[] dx = new int[]{0, 0, 1, -1};
	private static int[] dy = new int[]{1, -1, 0, 0};
	private static int INF = 1 << 15;

	public static void main(String[] a) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			w = sc.nextInt();
			h = sc.nextInt();

			if (h == 0 && w == 0) {
				break;
			}

			field = new char[h][w];
			distance = new int[h][w];

			for (int i = 0; i < h; i++) {
				field[i] = sc.next().toCharArray();
				for (int j = 0; j < w; j++) {
					distance[i][j] = INF;
					if (field[i][j] == 'S') {
						sx = i;
						sy = j;
					}
					if (field[i][j] == 'G') {
						gx = i;
						gy = j;
					}
				}
			}
			System.out.println("" + sx + "" + sy + "" + gx + "" + gy );
			System.out.println(bfs());
		}
		sc.close();
	}

	private static int bfs() {
		Queue<Node> queue = new ArrayDeque<Node>();
		Node node = new Node();
		node.setX(sx);
		node.setY(sy);

		queue.add(node);
		distance[sx][sy] = 0;

		while (queue.size() > 0) {
			Node n = queue.peek();
			queue.poll();

			if (gx == n.getX() && gy == n.getY()) {
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nx = n.getX() + dx[i];
				int ny = n.getY() + dy[i];

				if (nx >= 0 && nx < h && ny >= 0 && ny < w && field[nx][ny] != '#' && distance[nx][ny] == INF) {
					// insert cell into queue if it is possible move.
					queue.add(new Node(nx, ny));
					distance[nx][ny] = distance[n.getX()][n.getY()] + 1;
				}
			}
		}
		return distance[gx][gy];
	}

	private static class Node {
		private int x;
		private int y;

		public Node(){}
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
	}
}
