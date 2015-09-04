package competitiveprogramming.chapter3.ThreeOrMoreNestedLoopsHarder.PerfectCubes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * @author Munkhbat
 * UVA 386 - Perfect Cubes
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	
	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}

	public static void main(String[] args) throws IOException {
		for (int a = 6; a <= 200; a++) {
			int a3 = a * a * a;
			for (int b = 2; b < 200; b++) {
				int b3 = b * b * b;
				if (a3 <= b3) {
					break;
				}
				for (int c = b; c < 200; c++) {
					int c3 = c * c * c;
					if (a3 <= b3 + c3) {
						break;
					}
					for (int d = c; d < 200; d++) {
						int d3 = d * d * d;
						if (a3 < b3 + c3 + d3) {
							break;
						}
						if (a3 == b3 + c3 + d3) {
							pw.printf("Cube = %d, Triple = (%d,%d,%d)\n", valueOf(a), valueOf(b), valueOf(c), valueOf(d));
						}
					}
				}
			}
		}
		br.close();
		pw.flush();
		pw.close();
	}
}
