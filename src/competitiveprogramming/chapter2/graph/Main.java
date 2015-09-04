package competitiveprogramming.chapter2.graph;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Munkhbat
 * 599 - The Forrest for the Trees
 * 
 * solution : if graph is a tree then e = n - 1
 * number of connected components = v - e
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}

	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			boolean[] verticesUsed = new boolean[26];
			Arrays.fill(verticesUsed, false);
			int edgeCount = 0;
			while (true) {
				String str = br.readLine();
				if (str.contains("*")) {
					break;
				}

				int v1 = str.charAt(1) - 'A';
				verticesUsed[v1] = true;
				int v2 = str.charAt(3) - 'A';
				verticesUsed[v2] = true;
				edgeCount++;
			}

			StringTokenizer st = new StringTokenizer(br.readLine(), ",");
			int totalVertexCount = 0;
			int acornCount = 0;
			while (st.hasMoreTokens()) {
				totalVertexCount++;
				int v = st.nextToken().charAt(0) - 'A';
				if (!verticesUsed[v]) {
					acornCount++;
				}
			}

			int treeVertexCount = totalVertexCount - acornCount;
			int treeCount = treeVertexCount - edgeCount;
			pw.printf("There are %d tree(s) and %d acorn(s).\n", valueOf(treeCount),
					valueOf(acornCount));
		}
		br.close();
		pw.flush();
		pw.close();
	}
}
