package competitiveprogramming.chapter3.TwoNestedLoops.VitosFamily;

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
 * 10041 - Vito's Family
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
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(a);
			int min = Integer.MAX_VALUE;
			for (int i = 0; i <n; i++) {
				int sum = 0;
				for (int j = 0; j < n; j++) {
					sum += Math.abs(a[j] - a[i]);
				}
				if (min > sum) {
					min = sum;
				}
			}
			
			pw.println(min);
			t--;
		}
		
		br.close();
		pw.flush();
		pw.close();
	}
}
