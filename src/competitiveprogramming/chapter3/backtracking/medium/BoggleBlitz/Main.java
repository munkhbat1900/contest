package competitiveprogramming.chapter3.backtracking.medium.BoggleBlitz;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author munkhbat
 *  UVA 487 - Boggle Blitz
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static String[] table;
	static int n;
	static char[] ans;
	static Map<String, Integer> allAns;

	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}

	static void solve(int x, int y, int len) {
		ans[len] = table[x].charAt(y);
		for (int dx = -1; dx <= 1; dx++) {
			for (int dy = -1; dy <= 1; dy++) {
				int nx = x + dx;
				int ny = y + dy;
				if (nx >= 0 && ny >= 0 && nx < n && ny < n && table[nx].charAt(ny) > table[x].charAt(y)) {
					solve(nx, ny, len + 1);
				}
			}
		}
		if (len >= 2) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i <= len; i++) {
				sb.append(ans[i]);
			}
			
			allAns.put(sb.toString(),  valueOf(sb.length()));
		}
	}

	public static void main(String[] args) throws IOException {
		int count = Integer.parseInt(br.readLine());
		int counter = 0;
		while (count > 0) {
			if (counter > 0) {
				pw.println();
			}
			br.readLine();
			n = Integer.parseInt(br.readLine());
			table = new String[n];
			for (int i = 0; i < n; i++) {
				table[i] = br.readLine();
			}

			allAns = new HashMap<>();

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					ans = new char[n * n];
					solve(i, j, 0);
				}
			}
			List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(allAns.entrySet());
			Collections.sort(list, new ValueThenKeyComparator<String, Integer>());
			for (Map.Entry<String, Integer> e : list) {
				pw.println(e.getKey());
			}
			count--;
			counter++;
		}
		
		br.close();
		pw.flush();
		pw.close();
	}

	static class ValueThenKeyComparator<K extends Comparable<? super K>,
	V extends Comparable<? super V>>
	implements Comparator<Map.Entry<K, V>> {

		public int compare(Map.Entry<K, V> a, Map.Entry<K, V> b) {
			int cmp1 = a.getValue().compareTo(b.getValue());
			if (cmp1 != 0) {
				return cmp1;
			} else {
				return a.getKey().compareTo(b.getKey());
			}
		}

	}
}
