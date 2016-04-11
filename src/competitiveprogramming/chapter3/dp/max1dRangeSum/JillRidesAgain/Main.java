package competitiveprogramming.chapter3.dp.max1dRangeSum.JillRidesAgain;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * @author munkhbat
 * UVA 507 - Jill Rides Again
 * I used trim method to get AC. without this method UVA gave me Runtime error
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int s;
	static int[] nice;
	
	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}
	
	public static void main(String[] args) throws IOException {
		int r = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < r; i++) {
			s = Integer.parseInt(br.readLine().trim());
			nice = new int[s - 1];
			for (int j = 0; j < s - 1; j++) {
				nice[j] = Integer.parseInt(br.readLine().trim());
			}
			
			int sum = 0, ans = 0;
			int start = 0, end = 0;
			int startMax = 0;
			for (int j = 0; j < s - 1; j++) {
				sum += nice[j];
				if (ans < sum || (sum == ans && j - start > end - startMax)) {
					end = j;
					ans = sum;
					startMax = start;
				}
				if (sum < 0) {
					start = j + 1;
					sum = 0;
				}
			}
			if (ans == 0) {
				pw.printf("Route %d has no nice parts\n", valueOf(i + 1));
			} else {
				pw.printf("The nicest part of route %d is between stops %d and %d\n", valueOf(i + 1), valueOf(startMax + 1), valueOf(end + 2));
			}
		}
		br.close();
		pw.flush();
		pw.close();
	}
}
