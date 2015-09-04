package competitiveprogramming.chapter1.AdHoc.chess.Queen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author Avirmed Munkhbat
 * UVA 11494 - Queen
 */
public class Main {
	static boolean isAttack(int x, int y, int x1, int y1) {
		return Math.abs(x - x1) == Math.abs(y- y1) || x == x1 || y == y1;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			if (x == 0 && y == 0 && x1 == 0 && y1 == 0) {
				break;
			}
			
			if (x == x1 && y == y1) {
				pw.println("0");
			} else if (isAttack(x, y, x1, y1)) {
				pw.println("1");
			} else {
				pw.println("2");
			}
		}
		
		pw.flush();
		br.close();
		pw.close();
	}
}
