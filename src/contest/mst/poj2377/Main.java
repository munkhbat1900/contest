package contest.mst.poj2377;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author munkhbat
 *
 */
public class Main {
	private static int n, m;
	private static List<List<Edge>> graph;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		graph = new ArrayList<List<Edge>>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<Edge>());
		}
		for (int i = 0; i < m; i++) {
			int s = sc.nextInt();
			int t = sc.nextInt();
			int c = sc.nextInt();
			
			graph.get(s - 1).add(new Edge(t - 1, c));
			graph.get(t - 1).add(new Edge(s - 1, c));
		}
		
		System.out.println(prim());
		
		sc.close();
	}
	
	private static int prim() {
		int res = 0;
		boolean[] used = new boolean[n];
		
		Queue<Edge> q = new PriorityQueue<Edge>();
		q.offer(new Edge(0, 0));
		while (!q.isEmpty()) {
			Edge e = q.poll();
			if (used[e.to]) {
				continue;
			}
			
			used[e.to] = true;
			res += e.cost;
			
			for (Edge e2 : graph.get(e.to)) {
				if (used[e2.to]) {
					continue;
				}
				q.offer(e2);
			}
		}
		
		for (int i = 0; i < n; i++) {
			if (!used[i]) {
				return -1;
			}
		}
		
		return res;
	}
	
	private static class Edge implements Comparable<Edge> {
		private int to;
		private int cost;
		
		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge o) {
			return o.cost - cost;
		}
	}
}
