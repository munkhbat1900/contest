package competitiveprogramming.chapter1.AdHoc.chess.CorrectMove;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @author Avirmed Munkhbat
 * UVA 255 - Correct Move
 */
public class Main {
	static boolean isBetween (int x1, int x2, int b) {
		if (x1 > x2) {
			if (b >= x1 || b <= x2) {
				return false;
			}
		} else {
			if (b <= x1 || b >= x2) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String line;
		while (true) {
			line = br.readLine();
			if (line == null || line.equals("")) {
				break;
			}
			StringTokenizer st = new StringTokenizer(line);
			int king = Integer.parseInt(st.nextToken());
			int queen = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());

			int qcolumn = queen / 8;
			int qrow = queen % 8;

			int targetColumn = target / 8;
			int targetRow = target % 8;

			int kingColumn = king / 8;
			int kingRow = king % 8;
			// 1
			if (king == queen) {
				bw.write("Illegal state\n");
			} else if (qcolumn != targetColumn && qrow != targetRow) {
				bw.write("Illegal move\n");
				continue;
			} else if (queen == target || target == king) {
				bw.write("Illegal move\n");
			} else {
				if (qcolumn == targetColumn && qcolumn == kingColumn && isBetween(qrow, targetRow, kingRow)) {
					bw.write("Illegal move\n");
				} else if (qrow == targetRow && qrow == kingRow && isBetween(qcolumn, targetColumn, kingColumn)) {
					bw.write("Illegal move\n");
				} else if (kingRow == targetRow && Math.abs(kingColumn - targetColumn) == 1) {
					bw.write("Move not allowed\n");
				} else if (kingColumn == targetColumn &&  Math.abs(kingRow - targetRow) == 1) {
					bw.write("Move not allowed\n");
				} else if ((king == 0 && target == 9) || (king == 56 && target == 49) || (king == 7 && target == 14) || (king == 63 && target == 54)) {
					bw.write("Stop\n");
				} else{
					bw.write("Continue\n");
				}
			}


		}
		br.close();
		bw.flush();
		bw.close();
	}
}
