package contest.mst;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Prim {
	static List<List<Edge>> graph;
	static int vNum;
	
	static int prim() {
		int total = 0;
		
		Queue<Edge> q = new PriorityQueue<Prim.Edge>();
		q.offer(new Edge(0, 0));
		boolean[] use = new boolean[vNum];
		
		while(!q.isEmpty()) {
			Edge e = q.poll();
			if (use[e.to]) {
				continue;
			}
			
			use[e.to] = true;
			total += e.cost;
			
			for (Edge e2 : graph.get(e.to)) {
				if (use[e2.to]) {
					continue;
				}
				q.offer(e2);
			}
		}
		
		return total;
	}
	
	public static void main(String[] args) {
		
	}
	
	private static class Edge implements Comparable<Edge> {
		int to;
		int cost;
		
		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}
}
