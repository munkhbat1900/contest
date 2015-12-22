package competitiveprogramming.chapter3.backtracking.medium.MappingtheSwaps;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author munkhbataa
 * UVA 331 - Mapping the Swaps
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int n;
	static int data[];
	static int ans;
	static boolean found = false;
	
	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}
	
	static boolean isSorted(int[] d) {
		for (int i = 0; i < n - 1; i++) {
			if (d[i] > d[i + 1]) {
				return false;
			}
		}
		return true;
	}
	
	static void solve(int swapCount, int totalSwapCount, int[] d, int lastSwapIndex) {
		if (isSorted(d)) {
			found = true;
			if (swapCount > 0) {
				ans++;
			}
			return;
		}
		if (swapCount == totalSwapCount) {
			return;
		}
		for (int i = 0; i < n - 1; i++) {
			if (i != lastSwapIndex) {
				int tmp = d[i];
				d[i] = d[i + 1];
				d[i + 1] = tmp;
				solve(swapCount + 1, totalSwapCount, d, i);
				tmp = d[i + 1];
				d[i + 1] = d[i];
				d[i] = tmp;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		int counter = 1;
		while (true) {
			String str = br.readLine();
			if (str.length() == 1 && str.charAt(0) == '0') {
				break;
			}

			StringTokenizer st = new StringTokenizer(str);
			n = Integer.parseInt(st.nextToken());
			data = new int[n];
			for (int i = 0; i < n; i++) {
				data[i] = Integer.parseInt(st.nextToken());
			}
			
			found = false;
			ans = 0;
			int c = 0;
			while(!found) {
				solve(0, c, data, -1);
				c++;
			}
			
			pw.printf("There are %d swap maps for input data set %d.\n",valueOf(ans), valueOf(counter));
			counter++;
		}
		br.close();
		pw.flush();
		pw.close();
	}
}
