package competitiveprogramming.chapter3.backtracking.easier.TheSettlersofCatan;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


/**
 * @author Munkhbat
 * UVA 539 - The Settlers of Catan
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int n, m;
	private static List<Vertex> graph;
	// visited edges
	static boolean[][] visited = new boolean[30][30];
	
	static int length = 0;
	
	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}
	
	static int solve(int node) {
		int max = 0;
		for (Edge e : graph.get(node).edges) {
			if (!visited[node][e.to]) {
				visited[node][e.to] = visited[e.to][node] = true;
				max = Math.max(max, 1 + solve(e.to));
				visited[node][e.to] = visited[e.to][node] = false;
			}
		}
		return max;
	}
	
	public static void main(String[] args) throws IOException {
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			if (n == 0 && m == 0) {
				break;
			}
			
			graph = new ArrayList<Vertex>();

			for (int i = 0; i < n; i++) {
				Vertex v = new Vertex();
				graph.add(v);
			}
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int h = Integer.parseInt(st.nextToken());
				graph.get(s).addVertex(h);
				graph.get(h).addVertex(s);
			}
			
			int max = Integer.MIN_VALUE;
			
			for (int i = 0; i < 30; i++) {
				for (int j = 0; j < 30; j++) {
					visited[i][j] = false;
				}
			}
			
			//Arrays.fill(visited, Boolean.FALSE);
			
			for (int i = 0; i < n; i++) {
				int res = solve(i);
				if (res > max) {
					max = res;
				}
			}
			
			pw.println(max);
		}
		
		
		br.close();
		pw.flush();
		pw.close();
	}
	
	private static class Vertex {
		List<Edge> edges;
		public Vertex() {
			edges = new ArrayList<Edge>();
		}
		
		public void addVertex(int num) {
			Edge e = new Edge();
			e.to = num;
			edges.add(e);
		}
	}
	
	private static class Edge {
		int to;
	}
		
}
