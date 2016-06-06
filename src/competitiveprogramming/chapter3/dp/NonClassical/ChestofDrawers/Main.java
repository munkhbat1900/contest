package competitiveprogramming.chapter3.dp.NonClassical.ChestofDrawers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
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
	static long[][][] bottomup, topdown;

	static void bottomup() {
		// think of drawer as stack.
		// if we put an unlocked drawer on top of unlocked drawer, the number of secure drawer doesn'change
		// if we put an unlocked drawer on top of locked drawer, the number of secure drawer decreases by 1 
		// if we put an locked drawer on top of locked drawer, the number of secure drawer increases by 1.
		// if we put an locked drawer on top of unlocked drawer, the number of secure drawer increases by 1.
		// top drawer dp[i][j][k] : i th drawer, j secure,
		bottomup[1][1][1] = 1;bottomup[1][0][0] = 1;
		for (int i = 2; i < 66; i++) {
			for (int j = 0; j <= i; j++) {
				if (j > 0) {
					bottomup[i][j][1] = bottomup[i - 1][j - 1][1] + bottomup[i - 1][j - 1][0];
				}
				bottomup[i][j][0] = bottomup[i - 1][j][0] + bottomup[i - 1][j + 1][1];
			}
		}
	}

	/**
	 * @param id
	 * @param lockCount
	 * @param isLocked represents one above drawer locked or not
	 * @return
	 */
	static long topdown(int id, int lockCount, int isLocked) {
		if (id < 0 || lockCount < 0) {
			return 0;
		}
		if (id == 0 && lockCount == 0) {
			return 1;
		}
		if (topdown[id][lockCount][isLocked] != -1) {
			return topdown[id][lockCount][isLocked];
		}
		long count = 0;
		if (isLocked == 1) {
			count += topdown(id - 1, lockCount - 1, 1);
			count += topdown(id - 1, lockCount, 0);
		} else {
			count += topdown(id - 1, lockCount, 1);
			count += topdown(id - 1, lockCount, 0);
		}

		return topdown[id][lockCount][isLocked] = count;
	}

	public static void main(String[] args) throws IOException {
		//		topdown = new long[66][66][2];
		//		for (int i = 0; i < 66; i++) {
		//			for (int j = 0; j < 66; j++) {
		//				Arrays.fill(topdown[i][j], -1);
		//			}
		//		}
		bottomup = new long[66][67][2];
		bottomup();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			if (n < 0 && s < 0) {
				break;
			}
			//			pw.println(topdown(n, s, 1));
			pw.println(bottomup[n][s][0] + bottomup[n][s][1]);
		}
		br.close();
		pw.flush();
		pw.close();
	}
}
