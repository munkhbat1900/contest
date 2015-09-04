package competitiveprogramming.chapter3.ThreeOrMoreNestedLoopsHarder.SafeBreaker;

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
 * UVA 296 - Safebreaker
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static boolean[] checked;
	static String guess;
	static boolean[] used;

	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}
	
	static boolean find(int k, int[] a) {
		for (int i = 0; i < 4; i++) {
			if (guess.charAt(k) - '0' == a[i] && !used[i]) {
				used[i] = true;
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			checked = new boolean[10000];
			Arrays.fill(checked, false);
			int g = Integer.parseInt(br.readLine());
			for (int j = 0; j < g; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				guess = st.nextToken();
				String str = st.nextToken();
				int inPos = str.charAt(0) - '0';
				int misplace = str.charAt(2) - '0';

				int[] a = new int[4];
				for (a[0] = 0; a[0] < 10; a[0]++) {
					for (a[1] = 0; a[1] < 10; a[1]++) {
						for (a[2] = 0; a[2] < 10; a[2]++) {
							for (a[3] = 0; a[3] < 10; a[3]++) {
								if (!checked[a[0] * 1000 + a[1] * 100 + a[2] * 10 + a[3]]) {
									int pos = 0;
									int mis = 0;
									used = new boolean [4];
									Arrays.fill(used, false);
									// check exact position
									for (int k = 0; k < 4; k++) {
										if (guess.charAt(k) - '0' == a[k]) {
											pos++;
											used[k] = true;
										}
									}

									for (int k = 0; k < 4; k++) {
										if (a[k] != guess.charAt(k) - '0' && find(k, a)) {
											mis++;
										}
									}
									if (pos != inPos || mis != misplace) {
										checked[a[0] * 1000 + a[1] * 100 + a[2] * 10 + a[3]] = true;
									}
								}
							}
						}
					}
				}
			}
			
			int candidate = 0;
			int ans = -1;
			
			for (int k = 0; k < 10000; k++) {
				if (!checked[k] && candidate <= 2) {
					candidate++;
					ans = k;
				}
			}
			
			if (candidate == 1) {
				pw.printf("%04d\n", valueOf(ans));
			} else if (candidate > 1) {
				pw.println("indeterminate");
			} else {
				pw.println("impossible");
			}

		}
		br.close();
		pw.flush();
		pw.close();
	}
}
