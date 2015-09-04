package competitiveprogramming.chapter1.AdHoc.chess.CheckTheCheck;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author Avirmed Munkhbat
 * UVA 10196 - Check The Check
 */
public class Main {
	static String[] board = new String[8];
	// positions of kings. whites are represented by uppercase
	static int wkx = 0, wky = 0;
	static int bkx = 0, bky = 0;

	static boolean isEmptyBoard() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board[i].charAt(j) != '.') {
					return false;
				}
			}
		}
		return true;
	}

	static boolean pawnAttacks(int x, int y, int tx, int ty, boolean isWhite) {
		if (isWhite && x - 1 == tx && (y - 1 == ty || y + 1 == ty)) {
			return true;
		} else if (!isWhite && x + 1 == tx && (y - 1 == ty || y + 1 == ty)) {
			return true;
		}
		return false;
	}
	static boolean knightAttacks(int x, int y, int tx, int ty) {
		int[] d = new int[]{-1, -2, 1, 2};
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (Math.abs(d[i]) == Math.abs(d[j])) {
					continue;
				}
				int dx = x + d[i];
				int dy = y + d[j];
				if (tx == dx && ty == dy) {
					return true;
				}
			}
		}
		return false;
	}

	static boolean bishopAttacks(int x, int y, int tx, int ty) {
		int[] d1 = new int[]{-1, 1};
		int[] d2 = new int[]{-1, 1};
		for (int i = 0; i < d1.length; i++) {
			for (int j = 0; j < d2.length; j++) {
				int dx = x + d1[i];
				int dy = y + d2[j];
				while ((dx >= 0 && dy >= 0) && (dx < 8 && dy < 8)) {
					if (tx == dx && ty == dy) {
						return true;
					}
					if (board[dx].charAt(dy) != '.') {
						break;
					}
					dx += d1[i];
					dy += d2[j];
				}
			}
		}
		return false;
	}
	static boolean rookAttacks(int x, int y, int tx, int ty) {
		int[] d1 = new int[]{-1, 0, 1, 0};
		int[] d2 = new int[]{0, 1, 0, -1};
		for (int i = 0; i < 4; i++) {
			int dx = x + d1[i];
			int dy = y + d2[i];
			while ((dx >= 0 && dy >= 0) && (dx < 8 && dy < 8)) {
				if (tx == dx && ty == dy) {
					return true;
				}
				if (board[dx].charAt(dy) != '.') {
					break;
				}
				dx += d1[i];
				dy += d2[i];
			}

		}
		return false;
	}
	static boolean queenAttacks(int x, int y, int tx, int ty) {
		if (bishopAttacks(x, y, tx, ty)) {
			return true;
		}
		if (rookAttacks(x, y, tx, ty)) {
			return true;
		}
		return false;
	}

	static boolean checkWhiteKing() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				char c = board[i].charAt(j);
				if (c == 'p') {
					if(pawnAttacks(i, j, wkx, wky, false)) {
						return true;
					}
				} else if (c == 'n') {
					if(knightAttacks(i, j, wkx, wky)) {
						return true;
					}
				} else if (c == 'b') {
					if(bishopAttacks(i, j, wkx, wky)) {
						return true;
					}
				} else if (c == 'r') {
					if(rookAttacks(i, j, wkx, wky)) {
						return true;
					}
				} else if (c == 'q') {
					if(queenAttacks(i, j, wkx, wky)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	static boolean checkBlackKing() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				char c = board[i].charAt(j);
				if (c == 'P') {
					if(pawnAttacks(i, j, bkx, bky, true)) {
						return true;
					}
				} else if (c == 'N') {
					if(knightAttacks(i, j, bkx, bky)) {
						return true;
					}
				} else if (c == 'B') {
					if(bishopAttacks(i, j, bkx, bky)) {
						return true;
					}
				} else if (c == 'R') {
					if(rookAttacks(i, j, bkx, bky)) {
						return true;
					}
				} else if (c == 'Q') {
					if(queenAttacks(i, j, bkx, bky)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int c = 0;
		while (true) {
			for (int i = 0; i < 8; i++) {
				board[i] = br.readLine();
			}

			if (isEmptyBoard()) {
				break;
			}

			// positions of kings. whites are represented by uppercase
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (board[i].charAt(j) == 'K') {
						wkx = i;
						wky = j;
					} else if (board[i].charAt(j) == 'k') {
						bkx = i;
						bky = j;
					}
				}
			}
			c++;

			if (checkWhiteKing()) {
				bw.write("Game #" + c + ": white king is in check.\n");
			} else if (checkBlackKing()) {
				bw.write("Game #" + c + ": black king is in check.\n");
			} else {
				bw.write("Game #" + c + ": no king is in check.\n");
			}

			br.readLine();
		}

		br.close();
		bw.flush();
		bw.close();
	}
}
