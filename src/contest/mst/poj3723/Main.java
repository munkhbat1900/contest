package contest.mst.poj3723;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;


/**
 * @author munkhbat
 * poj 3723
 * apply prim for each connected graph
 */
public class Main {
	private static List<List<Edge>> graph = new ArrayList<List<Edge>>();;
	private static int n, m, r;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int casen = sc.nextInt();
		for (int i = 0; i < casen; i++) {
			n = sc.nextInt();
			m = sc.nextInt();
			r = sc.nextInt();
//			for (List<Edge> es : graph) {
//				es.clear();
//			}
//			graph.clear();
			graph = new ArrayList<List<Edge>>();

			for (int j = 0; j < n + m; j++) {
				graph.add(new ArrayList<Edge>());
			}

			for (int k = 0; k < r; k++) {
				int b = sc.nextInt();
				int g = sc.nextInt();
				int d = sc.nextInt();
				graph.get(b).add(new Edge(n + g, -d));
				graph.get(n + g).add(new Edge(b, -d));
			}

			System.out.println(10000 * (n + m) + prim());
		}
		sc.close();
	}

	private static int prim () {
		int min = 0;
		boolean[] used = new boolean[n + m];
//		for (int p = 0; p < n + m; p++) {
//			used[p] = false;
//		}
		for (int p = 0; p < n + m; p++) {
			if (used[p]) {
				continue;
			}
			Queue<Edge> q = new PriorityQueue<Edge>();
			q.offer(new Edge(p, 0));

			while(!q.isEmpty()) {
				Edge e = q.poll();
				if (used[e.to]) {
					continue;
				}
				min += e.cost;
				used[e.to] = true;
				for (Edge e2 : graph.get(e.to)) {
					if (used[e2.to]) {
						continue;
					}
					q.offer(e2);
				}
			}
		}
		return min;
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
