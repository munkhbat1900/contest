package competitiveprogramming.chapter3.backtracking.hard.GraphColoring;

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
 * UVA 193 - Graph Coloring
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int n, k;
	static List<Node> graph;
	static List<Integer> blacks;
	static int max;

	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}

	static boolean isPossible(int node) {
		for (Integer i : graph.get(node).adjacent) {
			// 0 means black
			if (graph.get(i.intValue()).color == 0) {
				return false;
			}
		}
		return true;
	}

	static void solve(int index, int count, int[] bs) {
		if (index == n) {
			if (count <= max) {
				return;
			}
			max = count;
			blacks.clear();
			for (int i = 0; i < count; i++) {
				blacks.add(valueOf(bs[i]));
			}
			return;
		}
		if (isPossible(index)) {
			graph.get(index).color = 0;
			bs[count] = index;
			solve(index + 1, count + 1, bs);
			graph.get(index).color = 1;
		}
		solve(index + 1, count, bs);
	}

	public static void main(String[] args) throws IOException {
		int m = Integer.parseInt(br.readLine());
		while(m > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			graph = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				graph.add(new Node());
			}
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				graph.get(u - 1).adjacent.add(valueOf(v - 1));
				graph.get(v - 1).adjacent.add(valueOf(u - 1));
			}

			blacks = new ArrayList<>();
			max = Integer.MIN_VALUE;
			solve(0, 0, new int[100]);
			pw.println(max);
			for (int i = 0; i < max - 1; i++) {
				pw.print(blacks.get(i).intValue() + 1);
				pw.print(" ");
			}
			pw.println(blacks.get(max - 1).intValue() + 1);
			m--;
		}
		br.close();
		pw.flush();
		pw.close();
	}

	private static class Node {
		List<Integer> adjacent;
		int color;

		public Node() {
			adjacent = new ArrayList<>();
			color = 1;
		}
	}
}
