package competitiveprogramming.chapter3.backtracking.easier.BacktoThe8Queens;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author munkhbataa
 * UVA 11085 - Back to the 8-Queens
 * row[i] describes row position in ith column
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	
	static int[] row;
	// all possible arrangements of queens which are no two queen attack each other.
	static List<Integer> arrangements;
	
	static int[] input;
	
	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}
	
	static boolean place(int r, int c) {
		for (int prev = 0; prev < c; prev++) {
			if (row[prev] == r || (Math.abs(row[prev] - r) == Math.abs(prev - c))) {
				return false;
			}
		}
		return true;
	}
	
	static void backtrack(int c) {
		if (c == 8) {
			for (int i = 0; i < 8; i++) {
				arrangements.add(valueOf(row[i]));
			}
			return;
		}
		
		for (int r = 0; r < 8; r++) {
			if (place(r, c)) {
				row[c] = r;
				backtrack(c + 1);
			}
		}
	}
	
	static int findMin() {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arrangements.size(); i += 8) {
			int moveCount = 0;
			for (int j = i; j < i + 8; j++) {
				if (arrangements.get(j).intValue() + 1 != input[j - i]) {
					moveCount++;
				}
			}
			if (min > moveCount) {
				min = moveCount;
			}
		}
		return min;
	}
	
	public static void main(String[] args) throws IOException {
		row = new int[8];
		arrangements = new ArrayList<>();
		backtrack(0);
		
		int c = 1;
		
		while (true) {
			String str = br.readLine();
			if (str == null || "".equals(str)) {
				break;
			}
			StringTokenizer st = new StringTokenizer(str);
			input = new int[8];
			for (int i = 0; i < 8; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			pw.printf("Case %d: %d\n",valueOf(c), valueOf(findMin()));
			c++;
		}
		
		br.close();
		pw.flush();
		pw.close();
	}
}
