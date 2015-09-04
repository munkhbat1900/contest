package contest.graph.poj3268;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author munkhbat
 * POJ 3268
 * dijkstra
 */
public class Main {

	private static int n, m, x;
	private static List<Vertex> graph;
	private static List<Vertex> rgraph;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		x = sc.nextInt() - 1;

		graph = new ArrayList<Vertex>();
		rgraph = new ArrayList<Vertex>();
		for (int i = 0; i < n; i++) {
			Vertex v = new Vertex();
			graph.add(v);
			Vertex v1 = new Vertex();
			rgraph.add(v1);
		}

		for (int i = 0; i < m; i++) {
			int s = sc.nextInt();
			int t = sc.nextInt();
			int c = sc.nextInt();
			graph.get(s - 1).addAdjacentNode(t - 1, c);
			rgraph.get(t - 1).addAdjacentNode(s - 1, c);
		}
		sc.close();
		
		dijkstra(graph);
		dijkstra(rgraph);
		
		int max = -1 * (1 << 20);
		for (int i = 0; i < n; i++) {
			int sum = graph.get(i).minDist + rgraph.get(i).minDist;
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}
	
	private static void dijkstra(List<Vertex> g) {
		PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
		g.get(x).minDist = 0;
		pq.add(g.get(x));
		while (!pq.isEmpty()) {
			Vertex v = pq.poll();
			for (Edge e : v.edges) {
				Vertex toV = g.get(e.to);
				int dist = v.minDist + e.cost;
				if (dist < toV.minDist) {
					toV.minDist = dist;
					pq.add(toV);
				}
			}
		}
	}

	private static class Vertex implements Comparable<Vertex>{
		private List<Edge> edges;
		private int minDist;

		public Vertex() {
			this.minDist = 1 << 20;
			edges = new ArrayList<Edge>();
		}

		public void addAdjacentNode(int vertexNum, int distance) {
			Edge e = new Edge();
			e.cost = distance;
			e.to = vertexNum;
			edges.add(e);
		}

		@Override
		public int compareTo(Vertex o) {
			//return Integer.compare(minDist, o.minDist);
			return minDist - o.minDist;
		}
	}

	private static class Edge {
		private int to;
		private int cost;
	}
}
