package competitiveprogramming.chapter3.ThreeOrMoreNestedLoopsHarder.TriangleCounting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author Munkhbat
 * UVA 10973 - Triangle Counting
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	private static boolean[][] graph;
	
	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}
	
	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			graph = new boolean[n][n];
			
			for (int j = 0; j < m; j++) {
				st = new StringTokenizer(br.readLine());
				int v1 = Integer.parseInt(st.nextToken()) - 1;
				int v2 = Integer.parseInt(st.nextToken()) - 1;
				
				graph[v1][v2] = true;
				graph[v2][v1] = true;
			}
			
			int count = 0;
			for (int j = 0; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					if (!graph[j][k]) {
						continue;
					}
					for (int p = k + 1; p < n; p++) {
						if (graph[k][p] && graph[p][j]) {
							count++;
						}
					}
				}
			}
			
			pw.println(count);
		}
		
		br.close();
		pw.flush();
		pw.close();
	}
}
