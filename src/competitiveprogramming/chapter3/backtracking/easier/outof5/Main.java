package competitiveprogramming.chapter3.backtracking.easier.outof5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author munkhbat
 * UVA 10344 - 23 out of 5
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int[] nums;

	static boolean possible = false;

	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}

	static void solve(int numCount,  boolean[] flags, int sum) {
		if (numCount == 5 && sum == 23) {
			possible = true;
			return;
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (possible) {
					break;
				}
				if (flags[i]) {
					continue;
				}
				flags[i] = true;
				solve(numCount + 1, flags, sum + nums[i]);
				solve(numCount + 1, flags, sum - nums[i]);
				solve(numCount + 1, flags, sum * nums[i]);
				
				flags[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			nums = new int[5];
			for (int i = 0; i < 5; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			if ((nums[0] | nums[1] | nums[2] | nums[3] | nums[4]) == 0) {
				break;
			}
			
			possible = false;
			
			boolean[] flags = new boolean[5];
			for (int i = 0; i < 5; i++) {
				flags[i] = true;
				solve(1, flags, nums[i]);
				flags[i] = false;
			}
			
			if (!possible) {
				pw.println("Impossible");
			} else {
				pw.println("Possible");
			}
		}
		br.close();
		pw.flush();
		pw.close();
	}
}
