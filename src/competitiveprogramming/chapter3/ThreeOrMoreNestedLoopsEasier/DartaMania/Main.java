package competitiveprogramming.chapter3.ThreeOrMoreNestedLoopsEasier.DartaMania;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

/**
 * @author munkhbat
 * UVA 735 - Dart-a-Mania
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static Set<Integer> scores;

	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}

	public static void main(String[] args) throws IOException {
		scores = new HashSet<>();
		scores.add(valueOf(0));
		scores.add(valueOf(50));
		for (int i = 1; i <= 20; i++) {
			scores.add(valueOf(i));
			scores.add(valueOf(i * 2));
			scores.add(valueOf(i * 3));
		}

		Integer[] s = scores.toArray(new Integer[scores.size()]);

		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n <= 0) {
				break;
			}

			int comb = 0;
			int perm = 0;
			for (int i = 0; i < s.length; i++) {
				if (n > 180) {
					break;
				}
				for (int j = i; j < s.length; j++) {
					for (int p = j; p < s.length; p++) {
						int sum = s[i].intValue() + s[j].intValue() + s[p].intValue();
						if (sum == n) {
							comb++;
							//pw.printf("%d %d %d.\n", s[i], s[j], s[p]);
							//count perms
							if (i ==j && i == p) {
								perm += 1;
							} else if (i != j && i != p && j != p) {
								perm += 6;
							} else {
								perm += 3;
							}
							break;
						}
					}
				}
			}
			if (comb != 0) {
				pw.printf("NUMBER OF COMBINATIONS THAT SCORES %d IS %d.\n", valueOf(n), valueOf(comb));
				pw.printf("NUMBER OF PERMUTATIONS THAT SCORES %d IS %d.\n", valueOf(n), valueOf(perm));
			} else {
				pw.printf("THE SCORE OF %d CANNOT BE MADE WITH THREE DARTS.\n", valueOf(n));
			}
			pw.printf("**********************************************************************\n");
		}
		pw.println("END OF OUTPUT");
		br.close();
		pw.flush();
		pw.close();
	}
}
