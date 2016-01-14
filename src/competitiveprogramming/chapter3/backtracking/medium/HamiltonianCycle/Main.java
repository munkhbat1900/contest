package competitiveprogramming.chapter3.backtracking.medium.HamiltonianCycle;

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
 * @author munkhbat
 * UVA 775 - Hamiltonian Cycle
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int n;
	static List<Vertex> graph;
	static int start;
	static boolean[] visited;
	static int[] path;
	static boolean found = false;
	
	
	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}
	
	static void solve(int s, boolean[] visited, int index, int[] path) {
		if (index == n) {
			for (Integer v : graph.get(s).adjacentVertices) {
				if (v.intValue() == start) {
					found = true;
					path[index] = start;
					for (int j = 0; j < index; j++) {
						pw.print(path[j] + 1 + " ");
					}
					pw.println(path[index] + 1);
				}
			}
			return;
		}
		for (Integer v : graph.get(s).adjacentVertices) {
			if (!visited[v.intValue()] && !found) {
				visited[v.intValue()] = true;
				path[index] = v.intValue();
				solve(v.intValue(), visited, index + 1, path);
				visited[v.intValue()] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		while (true) {
			String str = br.readLine();
			if (str == null || "".equals(str)) {
				break;
			}
			n = Integer.parseInt(str);
			graph = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				graph.add(new Vertex());
			}
			while (true) {
				str = br.readLine();
				if (str.equals("%")) {
					break;
				}
				StringTokenizer st = new StringTokenizer(str);
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				graph.get(u - 1).addAdjacentVertex(v - 1);
				graph.get(v - 1).addAdjacentVertex(u - 1);
			}
			
			found = false;
			for (int i = 0; i < n; i++) {
				visited = new boolean[n];
				visited[i] = true;
				path = new int[n + 1];
				path[0] = i;
				start = i;
				solve(i, visited, 1, path);
			}
			
			if (!found) {
				pw.println("N");
			}
		}
		br.close();
		pw.flush();
		pw.close();
	}
	private static class Vertex {
		List<Integer> adjacentVertices;
		
		public Vertex() {
			adjacentVertices = new ArrayList<Integer>();
		}

		public void addAdjacentVertex(int vertexNum) {
			adjacentVertices.add(valueOf(vertexNum));
		}
	}
}
