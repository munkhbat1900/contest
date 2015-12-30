package competitiveprogramming.chapter3.backtracking.medium.BundlingNewspapers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author munkhbat
 * UVA 598 - Bundling Newspapers
 * it is also solvable by constructing all subsets then print only subset that satisfies then length.
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int a, b;
	static String[] data;
	static int n;
	static String[] sol;
	
	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}
	
	static void solve(int size, int k, int m) {
		if (k == size) {
			for (int j = 0; j < size; j++) {
				if (j != size - 1) {
					pw.printf("%s, ", sol[j]);
				} else {
					pw.print(sol[j]);
				}
			}
			pw.println();
			return;
		}
		for (int i = m; i < n; i++) {
			sol[k] = data[i];
			solve(size, k + 1, i + 1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		int m = Integer.parseInt(br.readLine());
		br.readLine();
		while (m > 0) {
			String str = br.readLine();
			if (str.equals("*")) {
				a = -1;
				b = -1;
			} else {
				StringTokenizer st = new StringTokenizer(str);
				a = Integer.parseInt(st.nextToken());
				if (st.hasMoreTokens()) {
					b = Integer.parseInt(st.nextToken());
				} else {
					b = -1;
				}
			}
			data = new String[12];
			n = 0;
			while(true) {
				String s = br.readLine();
				if (s == null || s.equals("")) {
					break;
				}
				data[n] = s;
				n++;
			}
			if (a == -1 && b == -1) {
				a = 1;
				b = n;
			}
			if (b == -1) {
				b = a;
			}
			for (int i = a; i <= b; i++) {
				sol = new String[i];
				pw.printf("Size %d\n", valueOf(i));
				solve(i, 0, 0);
				pw.println();
			}
			
			m--;
			if (m > 0) {
				pw.println();
			}
		}
		br.close();
		pw.flush();
		pw.close();
	}
}
