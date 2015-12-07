package competitiveprogramming.chapter3.backtracking.easier.Marcus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int n, m;
	static String[] challenge;
	static List<String> sol;
	static String key = "IEHOVA#";
	static int[] dx = new int[]{0, 0, -1};
	static int[] dy = new int[]{-1, 1, 0};
	static boolean found = false;

	static String getDirection(int i) {
		if (i == 0) {
			return "left";
		}
		if (i == 1) {
			return "right";
		}
		return "forth";
	}

	static void print() {
		pw.print(sol.get(0));
		for (int i = 1; i < sol.size(); i++) {
			pw.print(" " + sol.get(i));
		}
		pw.println();
	}

	static void solve(int x, int y, int count) {
		if (challenge[x].charAt(y) == '#') {
			found = true;
			print();
			return;
		}

		for (int i = 0; i < 3; i ++) {
			if (found) {
				break;
			}
			int dxx = x + dx[i];
			int dyy = y + dy[i];
			if (0 > dxx || 0 > dyy || dxx >= n || dyy >= m) {
				continue;
			}
			if ( challenge[dxx].charAt(dyy) == key.charAt(count)) {
				sol.add(getDirection(i));
				solve(dxx, dyy, count + 1);
				sol.remove(sol.size() - 1);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		int c = Integer.parseInt(br.readLine());
		while (c > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			challenge = new String[n];
			for (int i = 0; i < n; i++) {
				challenge[i] = br.readLine();
			}
			
			sol = new ArrayList<>();
			found = false;
			for (int i = 0; i < m; i++) {
				if (challenge[n - 1].charAt(i) == '@') {
					solve(n - 1, i, 0);
				}
			}
			c--;
		}
		br.close();
		pw.flush();
		pw.close();
	}
}
