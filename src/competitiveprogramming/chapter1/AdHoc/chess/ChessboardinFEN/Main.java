package competitiveprogramming.chapter1.AdHoc.chess.ChessboardinFEN;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author munkhbat
 * UVA 10284 - Chessboard in FEN
 */
public class Main {
	static String[] board = new String[8];
	static int[][] attack = new int[8][8];

	static void attackPawn(int x, int y, char piece) {
		if (piece == 'P') {
			int dx = x - 1;
			if (dx >= 0) {
				if (y - 1 >= 0) {
					attack[x - 1][y - 1] = 1;
				}
				if (y + 1 < 8) {
					attack[x - 1][y + 1] = 1;
				}
			}
		} else {
			int dx = x + 1;
			if (dx < 8) {
				if (y - 1 >= 0) {
					attack[x + 1][y - 1] = 1;
				}
				if (y + 1 < 8) {
					attack[x + 1][y + 1] = 1;
				}
			}
		}
	}

	static void attackKnight(int x, int y) {
		int[] d = new int[]{-1, 1, 2, -2};
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (Math.abs(d[i]) == Math.abs(d[j])) {
					continue;
				}
				int dx = x + d[i];
				int dy = y + d[j];
				if ((dx >= 0 && dy >= 0) && (dx < 8 && dy < 8)) {
					attack[dx][dy] = 1;
				}
			}
		}
	}

	static void attackBishop(int x, int y) {
		int[] d1 = new int[]{-1, 1};
		int[] d2 = new int[]{-1, 1};
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				int dx = x + d1[i];
				int dy = y + d2[j];
				while ((dx >= 0 && dy >= 0) && (dx < 8 && dy < 8)) {
					if (board[dx].charAt(dy) != '.') {
						break;
					}
					attack[dx][dy] = 1;
					dx += d1[i];
					dy += d2[j];
				}
			}
		}
	}

	static void attackRook(int x, int y) {
		int[] d1 = new int[]{-1, 0, 1, 0};
		int[] d2 = new int[]{0, 1, 0, -1};
		for (int i = 0; i < 4; i++) {
			int dx = x + d1[i];
			int dy = y + d2[i];
			while ((dx >= 0 && dy >= 0) && (dx < 8 && dy < 8)) {
				if (board[dx].charAt(dy) != '.') {
					break;
				}
				attack[dx][dy] = 1;
				dx += d1[i];
				dy += d2[i];
			}
		}
	}

	static void attackQueen(int x, int y) {
		attackBishop(x, y);
		attackRook(x, y);
	}

	static void attackKing(int x, int y) {
		int[] d1 = new int[]{-1, 0, 1, 0, 1, 1, -1, -1};
		int[] d2 = new int[]{0, 1, 0, -1, 1, -1, 1, -1};
		for (int i = 0; i < 8; i++) {
			int dx = x + d1[i];
			int dy = y + d2[i];
			if ((dx >= 0 && dy >= 0) && (dx < 8 && dy < 8)) {
				attack[dx][dy] = 1;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		while (true) {
			String line = br.readLine();
			if (line == null || "".equals(line)) {
				break;
			}

			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					attack[i][j] = 0;
				}
			}

			StringTokenizer st = new StringTokenizer(line);

			// create chess board
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 8; i++) {
				sb = new StringBuilder();
				String str = st.nextToken("/");
				for (int j = 0; j < str.length(); j++) {
					if (!Character.isDigit(str.charAt(j))) {
						sb.append(str.charAt(j));
					} else {
						for (int k = 0; k < str.charAt(j) - '0'; k++) {
							sb.append('.');
						}
					}
				}
				board[i] = sb.toString();
				//pw.print(board[i] + "\n");
			}
			// PNBRQK.
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					char piece = board[i].charAt(j);
					if (piece == '.') {
						continue;
					} else {
						attack[i][j ] = 1;
					}

					if (piece == 'p' || piece == 'P') {
						attackPawn(i, j, piece);
					} else if (piece == 'n' || piece == 'N') {
						attackKnight(i, j);
					} else if (piece == 'b' || piece == 'B') {
						attackBishop(i, j);
					} else if (piece == 'r' || piece == 'R') {
						attackRook(i, j);
					} else if (piece == 'q' || piece == 'Q') {
						attackQueen(i, j);
					} else if (piece == 'k' || piece == 'K') {
						attackKing(i, j);
					}
				}
			}

			int count = 0;
			pw.println();
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					count += attack[i][j];
					//pw.print(attack[i][j]);
				}
				//pw.println();
			}
			// answer will be count of 0.
			pw.print(64 - count);

		}
		pw.flush();
		br.close();
		pw.close();
	}
}
