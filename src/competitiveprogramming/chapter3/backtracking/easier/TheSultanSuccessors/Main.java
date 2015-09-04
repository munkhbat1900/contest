package competitiveprogramming.chapter3.backtracking.easier.TheSultanSuccessors;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author Munkhbat
 * UVA 167 - The Sultan's Successors
 * row[i] describes column position in ith column
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	
	static int[][] board;
	static int[] row;
	static int max;
	
	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}
	
	static boolean place(int c, int r) {
		for (int prev = 0; prev < c; prev++) {
			if (row[prev] == r || (Math.abs(row[prev] - r) == Math.abs(prev - c))) {
				return false;
			}
		}
		return true;
	}
	
	static void backtrack(int c) {
		if (c == 8) {
			int sum = 0;
			for (int i = 0; i < 8; i++) {
				sum += board[row[i]][i];
			}
			if (sum > max) {
				max = sum;
			}
			return;
		}
		
		for (int r = 0; r < 8; r++) {
			if (place(c, r)) {
				row[c] = r;
				backtrack(c + 1);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine().trim());
		while (t > 0) {
			board = new int[8][8];
			row = new int[8];
			max = Integer.MIN_VALUE;
			for (int i = 0; i < 8; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < 8; j++) {
					board[i][j] = Integer.parseInt(st.nextToken().trim());
				}
			}
			t--;
			
			backtrack(0);
			pw.printf("%5d\n", valueOf(max));
		}
		
		br.close();
		pw.flush();
		pw.close();
	}
}
