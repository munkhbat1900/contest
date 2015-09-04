package competitiveprogramming.chapter1.AdHoc.chess.MoveTheBishop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author Avirmed Munkhbat
 * UVA 10849 - Move the bishop
 */
public class Main {
	
	static boolean attack(int x, int y, int x1, int y1) {
		return Math.abs(x - x1) == Math.abs(y- y1);
	}
	
	static boolean isSameColor(int x, int y, int x1, int y1) {
		return (x + y) % 2 == (x1 + y1) % 2;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int c = Integer.parseInt(br.readLine());
		while (c > 0) {
			br.readLine();
			int t = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			while (t > 0) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int x1 = Integer.parseInt(st.nextToken());
				int y1 = Integer.parseInt(st.nextToken());
				
				if (x == x1 && y == y1) {
					pw.println("0");
				} else if (!isSameColor(x, y, x1, y1)) {
					pw.println("no move");
				} else if (attack(x, y, x1, y1)) {
					pw.println("1");
				} else {
					pw.println("2");
				}
				
				t--;
				
			}
			c--;
		}
		pw.flush();
		br.close();
		pw.close();
	}
}
