package contest.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SimpleGraph {
	/**
	 * key : vertex number
	 * value : vertex
	 */
	private static List<Vertex> graph;
	private static int e, v;
	private static int s, h;

	public static void main(String[] a) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			e = sc.nextInt();
			v = sc.nextInt();
			if (e == 0 && v == 0) {
				break;
			}

			graph = new ArrayList<Vertex>();

			for (int i = 0; i < v; i++) {
				Vertex v = new Vertex();
				graph.add(v);
			}
			for (int k = 0; k < e; k++) {
				s = sc.nextInt();
				h = sc.nextInt();
				graph.get(s).addAdjacentVertex(h);
				graph.get(h).addAdjacentVertex(s);
			}
			break;
		}
		int counter = 0;
		for (Vertex v : graph) {
			List<Integer> adj = v.getAdjacencies();
			System.out.println(counter);
			for (Integer n : adj) {
				System.out.print(" " + n);
			}
			System.out.println();
			counter++;
		}
		sc.close();
	}

	private static class Vertex {
		private List<Integer> adjacentVertices;
		public Vertex() {
			adjacentVertices = new ArrayList<Integer>();
		}

		public void addAdjacentVertex(int vertexNum) {
			adjacentVertices.add(vertexNum);
		}

		public List<Integer> getAdjacencies() {
			return adjacentVertices;
		}
	}
}
