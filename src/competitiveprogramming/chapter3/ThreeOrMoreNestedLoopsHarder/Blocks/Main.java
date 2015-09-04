package competitiveprogramming.chapter3.ThreeOrMoreNestedLoopsHarder.Blocks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * @author Munkhbat
 * UVA 10365 - Blocks
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int n;
	
	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}

	public static void main(String[] args) throws IOException {
		int tc = Integer.parseInt(br.readLine());
		for (int i = 0; i < tc; i++) {
			n = Integer.parseInt(br.readLine());
			int min = Integer.MAX_VALUE;
			
			for (int a = 1; a <= n; a++) {
				for (int b = a; b <= n; b++) {
					if (n % (a * b) == 0) {
						int c = n / (a * b);
						int square = a * b * 2 + a * c * 2 + b * c * 2;
						if (square < min) {
							min = square;
						}
					}
				}
			}
			
			pw.println(min);
		}

		br.close();
		pw.flush();
		pw.close();
	}
}
