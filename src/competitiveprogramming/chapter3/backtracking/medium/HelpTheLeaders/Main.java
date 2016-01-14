package competitiveprogramming.chapter3.backtracking.medium.HelpTheLeaders;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * @author munkhbat
 * UVA 10475 Help the Leaders
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int t, p, s;
	static String[] topics;
	static String[] prohibited1;
	static String[] prohibited2;
	static String[] ans;
	
	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}
	
	static boolean isProhibited(String newWord, int k) {
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < p; j++) {
				if ((prohibited1[j].equals(newWord) && prohibited2[j].equals(ans[i]))
						|| (prohibited1[j].equals(ans[i]) && prohibited2[j].equals(newWord))) {
					return true;
				}
			}
		}
		return false;
	}
	
	static void solve(int k, int m) {
		if (k == s) {
			for (int i = 0; i < ans.length; i++) {
				if (i != ans.length - 1) {
					pw.print(ans[i] + " ");
				} else {
					pw.println(ans[i]);
				}
			}
			return;
		}
		
		for (int i = m; i < topics.length; i++) {
			if (!isProhibited(topics[i], k)) {
				ans[k] = topics[i];
				solve(k + 1, i + 1);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int counter = 0;
		while (n > 0) {
			counter++;
			StringTokenizer st = new StringTokenizer(br.readLine());
			t = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			
			topics = new String[t];
			prohibited1 = new String[p];
			prohibited2 = new String[p];
			ans = new String[s];
					
			for (int i = 0; i < t; i++) {
				topics[i] = br.readLine().toUpperCase();
			}
			
			Arrays.sort(topics, new Comp());
			
			for (int i = 0; i < p; i++) {
				st = new StringTokenizer(br.readLine());
				prohibited1[i] = st.nextToken().toUpperCase();
				prohibited2[i] = st.nextToken().toUpperCase();
			}
			
			pw.printf("Set %d:\n", valueOf(counter));
			solve(0, 0);
			if (counter > 0) {
				pw.println();
			}
			n--;
		}
		
		br.close();
		pw.flush();
		pw.close();
	}
	
	private static class Comp implements Comparator<String> {

		@Override
		public int compare(String o1, String o2) {
			if (Integer.compare(o1.length(), o2.length()) > 0) {
				return -1;
			} else if (Integer.compare(o1.length(), o2.length()) < 0) {
				return 1;
			} else {
				return o1.compareTo(o2);
			}
		}
		
	}
}
