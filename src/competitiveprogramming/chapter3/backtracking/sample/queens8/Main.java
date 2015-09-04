package competitiveprogramming.chapter3.backtracking.sample.queens8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Munkhbat
 * UVA 750 - 8 Queens Chess Problem
 * row[i] describes row position in the ith column.
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int a,b;
	static int[] row;
	static int lineCounter = 0;

	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}
	
	static boolean place(int r, int c) {
		for (int prev = 0; prev < c; prev ++) {
			if (row[prev] == r || (Math.abs(row[prev] - r) == Math.abs(prev - c))) {
				return false;
			}
		}
		return true;
	}

	static void backtrack(int c) {
		if (c == 8 && row[b] == a) {
			pw.printf("%2d      %d", valueOf(++lineCounter), valueOf(row[0] + 1));
			for (int j = 1; j < 8; j++) {
				pw.printf(" %d", valueOf(row[j] + 1));
			}
			pw.println();
		}
		
		for (int r = 0; r < 8; r++) {
			if (place(r, c)) {
				row[c] = r;
				backtrack(c + 1);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken()) - 1;
			b = Integer.parseInt(st.nextToken()) - 1;
			row = new int[8];
			lineCounter = 0;
			
			Arrays.fill(row, 0);
			pw.println("SOLN       COLUMN");
			pw.println(" #      1 2 3 4 5 6 7 8");
			pw.println();
			
			backtrack(0);
			if (i < t - 1) {
				pw.println();
			}
		}


		br.close();
		pw.flush();
		pw.close();
	}
}
