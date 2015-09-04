package competitiveprogramming.chapter3.TwoNestedLoops.ClosestSums;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * @author munkhbat
 * UVA 10487 - Closest Sums
 * not accepted
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}

	public static void main(String[] args) throws IOException {
		int counter = 0;
		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) {
				break;
			}
			counter++;
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(br.readLine());
			}
			
			Arrays.sort(a);
			int m = Integer.parseInt(br.readLine());
			pw.printf("Case %d:\n", valueOf(counter));
			for (int i = 0; i < m; i++) {
				int s = Integer.parseInt(br.readLine());
				int closest = a[1] + a[0];
				int diff = Math.abs(s - closest);
				for (int j = 0; j < n - 1; j++) {
					for (int k = j + 1; k < n; k++) {
						if (Math.abs(a[j] + a[k] - s) <= diff) {
							closest = a[j] + a[k];
							diff = Math.abs(a[j] + a[k] - s);
						} else {
							break;
						}
					}
				}
				pw.printf("Closest sum to %d is %d.\n", valueOf(s), valueOf(closest));
			}
		}

		br.close();
		pw.flush();
		pw.close();
	}
}
