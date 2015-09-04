package competitiveprogramming.chapter3.TwoNestedLoops.Run;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * @author Avirmed Munkhbat
 * UVA 347 Run, Run, Runaround Numbers 
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int r;
	static boolean[] used;
	static int[] solution = new int[9876545];

	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}

	static boolean isRun(int n) {
		String str = Integer.toString(n);
		int start = str.charAt(0) - '0';
		int tmp = start;
		int index = 0;
		used = new boolean[10];
		for (int p = 1; p <= 9; p++) {
			used[p] = false;
		}
		for (int i = 0; i < str.length(); i++) {
			for (int j = 0; j < tmp; j++) {
				index++;
				if (index >= str.length()) {
					index = 0;
				}
			}
			tmp = str.charAt(index) - '0';
			if (used[tmp]) {
				return false;
			} else {
				used[tmp] = true;
			}
		}
		return tmp == start;
	}

	public static void main(String[] args) throws IOException {
		int c = 1;
		used = new boolean[10];
		for (int i = 9876543; i > 9 ; i--) {
			for (int p = 1; p <= 9; p++) {
				used[p] = false;
			}
			String str = Integer.toString(i);
			boolean b = false;
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == '0') {
					b = true;
					break;
				}
				if (used[str.charAt(j) - '0']) {
					b = true;
					break;
				} else {
					used[str.charAt(j) - '0'] = true;
				}
			}
			if (b) {
				solution[i] = solution[i + 1];
				continue;
			}
			if (isRun(i)) {
				solution[i] = i;
			} else {
				solution[i] = solution[i + 1];
			}
		}
		while (true) {
			r = Integer.parseInt(br.readLine());
			if (r == 0) {
				break;
			}
			pw.printf("Case %d: %d\n", valueOf(c), valueOf(solution[r]));
			c++;
		}
		br.close();
		pw.flush();
		pw.close();
	}
}
