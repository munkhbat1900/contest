package competitiveprogramming.chapter3.backtracking.medium.Transportation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author munkhbat
 * UVA 301 - Transportation
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int n;
	static int b;
	static int allOrders;
	static int[] starting;
	static int[] dest;
	static int[] passangerCount;
	static int max = Integer.MIN_VALUE;

	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}

	static boolean isAccetable(int[] passangerCountAtStation, int order) {
		for (int i = starting[order]; i < dest[order]; i++) {
			if (passangerCountAtStation[i] + passangerCount[order] > n) {
				return false;
			}
		}
		return true;
	}

	static void solve(int order, int[] passangerCountAtStation, boolean[] accepted, int earn) {
		max = Math.max(max, earn);

		for (int i = order; i < allOrders; i++) {
			if (!accepted[i] && isAccetable(passangerCountAtStation, i)) {
				accepted[i] = true;
				for (int j = starting[i]; j < dest[i]; j++) {
					passangerCountAtStation[j] += passangerCount[i];
				}

				solve(i,
						passangerCountAtStation,
						accepted,
						earn + passangerCount[i] * (dest[i] - starting[i]));
				accepted[i] = false;
				for (int j = starting[i]; j < dest[i]; j++) {
					passangerCountAtStation[j] -= passangerCount[i];
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			allOrders = Integer.parseInt(st.nextToken());
			if (n + b + allOrders == 0) {
				break;
			}
			starting = new int[allOrders];
			dest = new int[allOrders];
			passangerCount = new int[allOrders];
			max = Integer.MIN_VALUE;

			for (int i = 0; i < allOrders; i++) {
				st = new StringTokenizer(br.readLine());
				starting[i] = Integer.parseInt(st.nextToken());
				dest[i] = Integer.parseInt(st.nextToken());
				passangerCount[i] = Integer.parseInt(st.nextToken());
			}
			solve(0, new int[b], new boolean[allOrders], 0);
			pw.println(max);
		}
		br.close();
		pw.flush();
		pw.close();
	}
}
