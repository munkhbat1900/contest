package competitiveprogramming.chapter3.TwoNestedLoops.Antiarithmetic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author munkhbat
 * UVA 10730 - Antiarithmetic?
 * not accepted WA
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int n;
	static int[] a;

	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}
	
	static boolean solve() {
		boolean[] checked = new boolean[n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(checked, false);
			for (int k = 0; k <= i; k++) {
				checked[a[k]] = true;
			}
			for (int j = i + 1; j < n - 1; j++) {
				checked[a[j]] = true;
				int next = a[j] + a[j] - a[i];
				if (next > n - 1 || next < 0 || checked[next]) {
					continue;
				}
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			if (str.contains("0")) {
				break;
			}
			str = str.substring(0, str.length() - 1);
			n = Integer.parseInt(str);
			a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			
			if (solve()) {
				pw.println("yes");
			} else {
				pw.println("no");
			}
		}

		br.close();
		pw.flush();
		pw.close();
	}
}
