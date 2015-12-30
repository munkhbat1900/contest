package competitiveprogramming.chapter3.backtracking.medium.sumitup;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author munkhbat
 * UVA 574 - Sum It Up
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int t, n;
	static Integer[] nums;
	static int counter = 0;
	static Map<String, Boolean> sols;
	
	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}
	
	static void print(boolean[] used) {
		StringBuilder key = new StringBuilder();
		for (int i = 0; i < n; i++) {
			if (used[i]) {
				key.append("+");
				key.append(nums[i]);
			}
		}
		if (sols.containsKey(key.toString())) {
			return;
		}
		sols.put(key.toString(), Boolean.TRUE);
		int counter = 0;
		for (int i = 0; i < n; i++) {
			if (used[i]) {
				if (counter > 0) {
					pw.printf("+%d", nums[i]);
				} else {
					pw.printf("%d", nums[i]);
				}
				counter++;
			}
		}
		pw.println();
	}
	
	static void solve(int index, boolean[] used, int sum) {
		if (index == n && sum == t) {
			counter++;
			print(used);
			return;
		} else if (index == n) {
			return;
		}
		used[index] = true;
		solve(index + 1, used, sum + nums[index].intValue());
		used[index] = false;
		solve(index + 1, used, sum);
	}
	
	public static void main(String[] args) throws IOException {
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			t = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			if (n == 0) {
				break;
			}
			
			nums = new Integer[n];
			for (int i = 0; i < n; i++) {
				nums[i] = valueOf(Integer.parseInt(st.nextToken()));
			}
			Arrays.sort(nums, Collections.reverseOrder());
			counter = 0;
			pw.printf("Sums of %d:\n", valueOf(t));
			sols = new HashMap<>();
			solve(0, new boolean[n], 0);
			if (counter == 0) {
				pw.println("NONE");
			}
		}
		br.close();
		pw.flush();
		pw.close();
	}
}
