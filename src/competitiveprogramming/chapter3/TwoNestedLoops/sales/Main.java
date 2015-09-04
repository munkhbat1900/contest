package competitiveprogramming.chapter3.TwoNestedLoops.sales;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author munkhbat
 * UVA 1260 - Sales
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}

	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		while (t > 0) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			int[] b = new int[n - 1];
			for (int i = 1; i < n; i++) {
				int counter = 0;
				for (int j = 0; j < i; j++) {
					if (a[i] >= a[j]) {
						counter++;
					}
				}
				b[i - 1] = counter;
			}
			int sum = 0;
			for (int j = 0; j < n - 1; j++) {
				sum += b[j];
			}
			pw.println(sum);
			t--;
		}
		
		br.close();
		pw.flush();
		pw.close();
	}
}
