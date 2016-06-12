package competitiveprogramming.chapter3.dp.NonClassical.Weddingshopping;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Avirmed Munkhbat
 * UVA 11450 - Wedding shopping
 * 
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

	static int m, c, k;
	static int[][] topdown;
	static List<List<Integer>> garmets;
	static boolean[][] bottomup; 
	
	static int topdown(int id, int remM) {
		if (remM < 0) {
			return Integer.MAX_VALUE / 2;
		}
		if (id == -1) {
			return remM;
		}
		if (topdown[id][remM] != Integer.MAX_VALUE) {
			return topdown[id][remM];
		}
		for (int v : garmets.get(id)) {
			topdown[id][remM] = Math.min(topdown[id][remM], topdown(id - 1, remM - v));
		}
		return topdown[id][remM];
	}
	
	static int bottomup() {
		// bottomup[i][j] : i th garmet, j remaining money.
		bottomup = new boolean[c + 1][m + 1];
		bottomup[0][m] = true;
		
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < m + 1; j++) {
				for (int v : garmets.get(i)) {
					if (j + v > m) {
						continue;
					}
					bottomup[i + 1][j] |= bottomup[i][j + v];
				}
			}
		}
		
		for (int j = 0; j < m + 1; j++) {
			if (bottomup[c][j]) {
				return j;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		while (n > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			garmets = new ArrayList<>();
			for (int i = 0; i < c; i++) {
				st = new StringTokenizer(br.readLine());
				k = Integer.parseInt(st.nextToken());
				List<Integer> ls = new ArrayList<>();
				for (int j = 0; j < k; j++) {
					ls.add(Integer.valueOf(st.nextToken()));
				}
				garmets.add(ls);
			}
//			topdown = new int[c + 1][m + 1];
//			for (int i = 0; i <= c; i++) {
//				Arrays.fill(topdown[i], Integer.MAX_VALUE);
//			}
//			int ans = topdown(c - 1, m);
//			if (ans == Integer.MAX_VALUE || ans == Integer.MAX_VALUE / 2) {
//				pw.println("no solution");
//			} else {
//				pw.println(m - ans);
//			}
			int ans = bottomup();
			if (ans == -1) {
				pw.println("no solution");
			} else {
				pw.println(m - ans);
			}
			n--;
		}
		br.close();
		pw.flush();
		pw.close();
	}
}
