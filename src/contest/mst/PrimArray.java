package contest.mst;

public class PrimArray {
	private static final int MAX_V = 1000;
	private static int[][] cost = new int[MAX_V][MAX_V];
	private static int[] mincost = new int[MAX_V];
	private static boolean[] used = new boolean[MAX_V];
	private static int v; // vertex number
	
	private static int prim() {
		for (int i = 0; i < v; i++) {
			mincost[i] = 1 << 20;
			used[i] = false;
		}
		
		mincost[0] = 0;
		int res = 0;
		
		while(true) {
			int v = -1;
			
			for (int u = 0; u < v; u++) {
				if (!used[u] && (v == -1 || mincost[u] < mincost[v])) {
					v = u;
				}
			}
			
			if (v == -1) {
				break;
			}
			used[v] = true;
			res += mincost[v];
			
			for (int u = 0; u < v; u++) {
				mincost[u] = Math.min(mincost[u], cost[v][u]);
			}
		}
		
		return res;
	}
		
}
