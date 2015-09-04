package contest.graph.secondShortestPath;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author Avirmed Munkhbat
 * Roadblocks POJ 3255
 */
public class Main {
	private static int n, r;
	private static List<Vertex> graph;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		r = sc.nextInt();
		
		graph = new ArrayList<Vertex>();

		for (int i = 0; i < n; i++) {
			Vertex v = new Vertex();
			graph.add(v);
		}
		for (int k = 0; k < r; k++) {
			int s = sc.nextInt();
			int h = sc.nextInt();
			int cost = sc.nextInt();
			graph.get(s - 1).addAdjacentVertex(h - 1, cost);
			graph.get(h - 1).addAdjacentVertex(s - 1, cost);
		}
		
		sc.close();
		dijkstra();
		System.out.println(graph.get( n -1).secondMin);
	}
	
	private static void dijkstra() {
		PriorityQueue<Vertex> minque = new PriorityQueue<Main.Vertex>();
		minque.add(graph.get(0));
		graph.get(0).minDist = 0;
		while (!minque.isEmpty()) {
			Vertex v = minque.poll();
			for (Edge e : v.edges) {
				int cost1 = v.minDist + e.cost;
				int cost2 = v.secondMin + e.cost;
				if (cost1 < graph.get(e.to).minDist) {
					int temp = graph.get(e.to).minDist;
					graph.get(e.to).minDist = cost1;
					cost1 = temp;
					minque.add(graph.get(e.to));
				}
				
				if (cost2 < graph.get(e.to).secondMin && graph.get(e.to).minDist < cost1) {
					graph.get(e.to).secondMin = cost2;
					minque.add(graph.get(e.to));
				}
			}
		}
	}
	
	private static class Vertex implements Comparable<Vertex> {
		private List<Edge> edges;
		private int minDist;
		private int secondMin;
		
		public Vertex() {
			edges = new ArrayList<Edge>();
			minDist = 1 << 20;
			secondMin = 1 << 20;
		}
		
		public void addAdjacentVertex(int vertexNum, int distance) {
			Edge e = new Edge();
			e.cost = distance;
			e.to = vertexNum;
			edges.add(e);
		}

		public int compareTo(Vertex o) {
			return minDist - o.minDist;
		}

//		public int compareTo(Vertex o) {
//			return Integer.compare(minDist, o.minDist);
//		}
	}
	
	private static class Edge {
		private Integer to;
		private int cost;
	}
}
