package competitiveprogramming.chapter3.backtracking.easier.HanoiTowerTroublesAgain;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * @author munkhbat
 *  UVA 10276 - Hanoi Tower Troubles Again!
 *
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int n;
	/**
	 * top numbers of each pegs.
	 */
	static int[] pegs;
	static int sol;
	
	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}
	
	static boolean check(int ballNum, int pegNum) {
		if (pegs[pegNum] == 0) {
			return true;
		}
		int sum = ballNum + pegs[pegNum];
		int root = (int) Math.sqrt(sum);
		return root * root == sum;
	}
	
	static void solve(int ballNum) {
//		int tmp;
		for (int i = 0; i < n; i++) {
			if (check(ballNum, i) && sol < ballNum) {
//				tmp = pegs[i];
				pegs[i] = ballNum;
				if (sol < ballNum) {
					sol = ballNum;
				}
				solve(ballNum + 1);
//				pegs[i] = tmp;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		int c = Integer.parseInt(br.readLine());
		while (c > 0) {
			n = Integer.parseInt(br.readLine());
			pegs = new int[n];
			sol = 0;
			solve(1);
			pw.println(sol);
			c--;
		}
		br.close();
		pw.flush();
		pw.close();
	}
}
