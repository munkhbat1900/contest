package competitiveprogramming.chapter3.backtracking.medium.TheDominoesSolitaire;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author munkhbat
 * UVA 10503 The dominoes solitaire
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int n, m;
	static int[][] dominoes;
	static boolean found = false;

	static void solve(int spaces, int dotCount, boolean[] used) {
		if (spaces == n) {
			found = true;
			pw.println("YES");
			return;
		}
		for (int i = 2; i < m + 2; i++) {
			if (found) {
				break;
			}
			if (used[i - 2]) {
				continue;
			}
			for (int j = 0; j < 2; j++) {
				if (found) {
					break;
				}
				int k = j == 1 ? 0 : 1;
				if (spaces == n - 1) {
					if (dotCount == dominoes[i][j] && dominoes[1][0] == dominoes[i][k]) {
						solve(spaces + 1, dotCount, used);
					}
				} else if (dominoes[i][j] == dotCount) {
					used[i - 2] = true;
					solve(spaces + 1, dominoes[i][k], used);
					used[i - 2] = false;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		while (true) {
			n = Integer.parseInt(br.readLine());
			if (n == 0) {
				break;
			}
			m = Integer.parseInt(br.readLine());
			dominoes = new int [m + 2][2];
			for (int i = 0; i < m + 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				dominoes[i][0] = Integer.parseInt(st.nextToken());
				dominoes[i][1] = Integer.parseInt(st.nextToken());
			}
			found = false;
			solve(0, dominoes[0][1], new boolean[m]);

			if (!found) {
				pw.println("NO");
			} 
		}
		br.close();
		pw.flush();
		pw.close();
	}
}
