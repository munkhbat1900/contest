package competitiveprogramming.chapter3.dp.NonClassical.ChestofDrawers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author Avirmed Munkhbat
 *
 * UVA 11420 - Chest of Drawers 
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	
	static int n, s;
	static int[][] dp;
	
	static void bottomup() {
		
	}
	
	static int countSecure(boolean[] locked) {
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (locked[i] && (i == 0 || locked[i - 1])) {
				count++;
			}
		}
		return count;
	}
	
	static int solve(boolean[] locked) {
		int count = countSecure(locked);
		if (count == s) {
			return 1;
		}
		if (count > s) {
			return 0;
		}
		count = 0;
		for (int i = 0; i < n; i++) {
			if (locked[i]) {
				continue;
			}
			locked[i] = true;
			count += solve(locked);
			locked[i] = false;
		}
		return count;
	}
	
	public static void main(String[] args) throws IOException {
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			if (n < 0 && s < 0) {
				break;
			}
			pw.println(solve(new boolean[n]));
		}
		br.close();
		pw.flush();
		pw.close();
	}
}
