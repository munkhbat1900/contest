package contest.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijkstra {
	private static List<Node> graph;
	private static int e, v, cost;
	private static int s, h;
	private static int st, gl;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		e = sc.nextInt();
		v = sc.nextInt();
		st = sc.nextInt();
		gl = sc.nextInt();

		graph = new ArrayList<Node>();

		for (int i = 0; i < v; i++) {
			Node v = new Node(i);
			graph.add(v);
		}
		for (int k = 0; k < e; k++) {
			s = sc.nextInt();
			h = sc.nextInt();
			cost = sc.nextInt();
			graph.get(s).addAdjacentNode(h, cost);
			graph.get(h).addAdjacentNode(s, cost);
		}
		
		sc.close();
		//dumpGraph();
		dijkstra();
		System.out.println(graph.get(4).minDist);
		showMinPath();
	}
	
	private static void showMinPath() {
		Node prevois = graph.get(4).prev;
		while (prevois != null) {
			System.out.println(prevois.nodeNum);
			prevois = prevois.prev;
		}
	}
	
	private static void dumpGraph() {
		int counter = 0;
		for (Node v : graph) {
			System.out.println(counter++);
			for (Edge e : v.edges) {
				System.out.println(e.to + " " + e.cost);
			}
		}
	}
	
	private static void dijkstra() {
		PriorityQueue<Node> minQue = new PriorityQueue<Node>();
		minQue.add(graph.get(st));
		graph.get(st).minDist = 0;
		
		while (!minQue.isEmpty()) {
			Node n = minQue.poll();
			for (Edge edge : n.edges) {
				int dist = n.minDist + edge.cost;
				Node toNode = graph.get(edge.to);
				if (toNode.minDist > dist) {
					toNode.minDist = dist;
					toNode.prev = n;
					minQue.add(toNode);
				}
			}
		}
	}
	
	private static class Edge {
		private Integer to;
		private int cost;
	}
	
	private static class Node implements Comparable<Node>{
		private List<Edge> edges;
		private int minDist;
		private Node prev;
		private int nodeNum;
		
		public Node(int nodeNum) {
			edges = new ArrayList<Edge>();
			minDist = 1 << 20;
			prev = null;
			this.nodeNum = nodeNum;
		}

		public void addAdjacentNode(int vertexNum, int distance) {
			Edge e = new Edge();
			e.cost = distance;
			e.to = vertexNum;
			edges.add(e);
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(minDist, o.minDist);
		}
	}
}
