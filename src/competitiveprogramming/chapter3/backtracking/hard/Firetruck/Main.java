package competitiveprogramming.chapter3.backtracking.hard.Firetruck;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author munkhbat
 * UVA 208 - Firetruck
 * I had to sort the adjacency list to get accepted this code.
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static Node[] graph;
	static int fire;
	static int maxNode;
	static int count;
	static boolean[] reachable;
	
	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}
	
	static void markReachable(int target, boolean[] visited) {
		visited[target] = true;
		reachable[target] = true;
		
		for (int i : graph[target].adjacent) {
			if (visited[i]) {
				continue;
			}
			markReachable(i, visited);
		}
	}
	
	static void solve(int s, int index, boolean[] visited, int[] path) {
		visited[s] = true;
		path[index] = s;
		
		if (s == fire) {
			for (int i = 0; i < index; i++) {
				pw.print(path[i] + 1);
				pw.print(" ");
			}
			pw.println(path[index] + 1);
			count++;
			return;
		}
		
		for (int i : graph[s].adjacent) {
			if (visited[i] || !reachable[i]) {
				continue;
			}
			solve(i, index + 1, visited, path);
			visited[i] = false;
		}
	}
	
	public static void main(String[] args) throws IOException {
		int counter = 1;
		
		while(true) {
			String str = br.readLine();
			if (str == null || str.equals("")) {
				break;
			}
			fire = Integer.parseInt(str);
			fire--;
			
			graph = new Node[22];
			maxNode = Integer.MIN_VALUE;
			for (int i = 0; i < 22; i++) {
				graph[i] = new Node();
			}
			
			while (true) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim());
				int n = Integer.parseInt(st.nextToken());
				int m = Integer.parseInt(st.nextToken());
				if (n == 0 && m == 0) {
					break;
				}
				graph[n - 1].adjacent.add(valueOf(m - 1));
				graph[m - 1].adjacent.add(valueOf(n - 1));
				maxNode = Math.max(Math.max(n, m), maxNode);
			}
			for (int i = 0; i < 22; i++) {
				Collections.sort(graph[i].adjacent);
			}
			
			count = 0;
			reachable = new boolean[22];
			
			markReachable(fire, new boolean[22]);
			
			pw.printf("CASE %d:\n", valueOf(counter));
			solve(0, 0, new boolean[22], new int[22]);
			pw.printf("There are %d routes from the firestation to streetcorner %d.\n", valueOf(count), valueOf(fire + 1));
			counter++;
			
		}
		
		br.close();
		pw.flush();
		pw.close();
	}
	
	private static class Node {
		List<Integer> adjacent;

		public Node() {
			adjacent = new ArrayList<Integer>();
		}
	}
}
