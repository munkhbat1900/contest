package competitiveprogramming.chapter3.backtracking.medium.DNA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * @author munkhbat
 *  UVA 11961 - DNA
 *
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int n, k;
	static String dna;
	static Map<String, Boolean> ans;
	static char[] elem = new char[]{'A', 'G', 'C', 'T'};
	
	static void solve(int m, int index, char[] sol) {
		if (m == k) {
			ans.put(new String(sol), Boolean.TRUE);
			return;
		}
		for (int i = index; i < n; i++) {
			for (int j = 0; j < elem.length; j++) {
				char tmp = sol[i];
				sol[i] = elem[j];
				solve(m + 1, i + 1, sol);
				sol[i] = tmp;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		while (t > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			dna = br.readLine();
			ans = new TreeMap<String, Boolean>();
			ans.put(dna, Boolean.TRUE);
			solve(0, 0, dna.toCharArray());
			pw.println(ans.size());
			for (Entry<String, Boolean> e : ans.entrySet()) {
				pw.println(e.getKey());
			}
			t--;
		}
		br.close();
		pw.flush();
		pw.close();
	}
}
