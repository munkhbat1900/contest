package contest.graph.ritopostoffice;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author munkhbat
 * Mr. RITO's post office
 * AOJ 2200
 */
public class Main {
	private static int n, m, r;
	private static int[] townNum;
	// town number where boat left
	private static int boat;
	private static List<Vertex> graph;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			n = sc.nextInt();
			m = sc.nextInt();
			
			if (n == 0 && m == 0) {
				break;
			}
			
			for (int i = 0; i < n; i++) {
				Vertex v = new Vertex(i);
				graph.add(v);
			}
			
			for (int i = 0; i < m; i++) {
				int s = sc.nextInt();
				int t = sc.nextInt();
				int c = sc.nextInt();
				char ty = sc.next().charAt(0);
				graph.get(s - 1).addAdjacentNode(t - 1, c, ty);
				graph.get(t - 1).addAdjacentNode(s - 1, c, ty);
			}
			int r = sc.nextInt();
			for (int i = 0; i < r; i++) {
				townNum[i] = sc.nextInt() - 1;
			}
			boat = townNum[0];
			graph.get(townNum[0]).hasBoat = true;
		}
		sc.close();
	}
	
	private static class Vertex implements Comparable<Vertex>{
		private List<Edge> edges;
		private int minDist;
		private int num;
		private boolean hasBoat;
		
		public Vertex(int i) {
			this.num = i;
			this.minDist = 1 << 20;
			edges = new ArrayList<Edge>();
			hasBoat = false;
		}
		
		public void addAdjacentNode(int vertexNum, int distance, char type) {
			Edge e = new Edge();
			e.cost = distance;
			e.to = vertexNum;
			e.type = type;
			edges.add(e);
		}

		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(minDist, o.minDist);
		}
	}
	
	private static class Edge {
		private int to;
		private int cost;
		private char type;
	}
}
