package competitiveprogramming.chapter2.unionFind;

/**
 * @author Avirmed Munkhbat
 * Union-Find Disjoint sets implementation
 */
public class UnionFind {
	private int[] parent, rank;
	
	public UnionFind(int n) {
		parent = new int[n];
		rank = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
	}
	
	public int findRoot(int i) {
		return (parent[i] == i) ? i : (parent[i] = findRoot(parent[i]));
	}
	
	public boolean isSameSet(int i, int j) {
		return findRoot(i) == findRoot(j);
	}
	
	public void unite(int i, int j) {
		int x = findRoot(i);
		int y = findRoot(j);
		if (rank[x] > rank[y]) {
			parent[y] = x;
		} else {
			parent[x] = y;
			if (rank[x] == rank[y]) {
				rank[y]++;
			}
		}
	}
}
