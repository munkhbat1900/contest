package contest.unionfind;

/**
 * @author munkhbat
 * 
 */
public class UnionFind {
	private static int[] par = new int[100];
	private static int[] rank = new int[100];
	
	private static void init(int n) {
		for (int i = 0; i < n; i++) {
			par[i] = i;
			rank[i] = 0;
		}
	}
	
	/**
	 * finds root
	 * @param x
	 * @return
	 */
	private static int find(int x) {
		if (par[x] == x) {
			return x;
		} else {
			return par[x] = find(par[x]);
		}
	}
}
