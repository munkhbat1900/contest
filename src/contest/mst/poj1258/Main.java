package contest.mst.poj1258;

import java.util.Scanner;

/**
 * @author munkhbat
 * Agri-Net
 */
public class Main {
	private static int[][] cost = new int[101][101];
	private static int[] mincost = new int[101];
	private static boolean[] used = new boolean[101];
	private static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			n = sc.nextInt();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					cost[i][j] = sc.nextInt();
				}
			}
			System.out.println(prim());
		}
		sc.close();
	}

	private static int prim() {
		for (int i = 0; i < n; i++) {
			used[i] = false;
			mincost[i] = 1 << 25;
		}

		int res = 0;
		mincost[0] = 0;

		while(true) {
			int v = -1;
			for (int i = 0; i < n; i++) {
				if (!used[i] && (v == -1 || mincost[i] < mincost[v])) {
					v = i;
				}
			}

			if (v == -1) {
				break;
			}
			res += mincost[v];
			used[v] = true;

			for (int i = 0; i < n; i++) {
				mincost[i] = Math.min(mincost[i], cost[v][i]);
			}
		}

		return res;
	}
}
