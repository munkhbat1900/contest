package competitiveprogramming.chapter3.ThreeOrMoreNestedLoopsHarder.TheSumEqualstheProduct;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author Munkhbat
 * UVA 10483 - The Sum Equals the Product
 * not accepted
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

	static int n, d;
	static int x, y, size;
	static int[][] killed;

	static Float valueOf(float i) {
		return Float.valueOf(i);
	}

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int minRange = (int)Float.parseFloat(st.nextToken()) * 100;
		int maxRange = (int)Float.parseFloat(st.nextToken()) * 100;

		for (int f = minRange; f <= maxRange; f++) {
			for (int a = 1; a < maxRange; a++) {
				for (int b = a; b < maxRange; b++) {
					float c = (f - a - b) / 100;
					float c1 = f / (a * b * 100);
					
					if (c == c1) {
						pw.printf("%.2f = %.2f + %.2f + %.2f = %.2f * %.2f * %.2f\n",
								valueOf(f / 100), valueOf(a / 100), valueOf(b / 100), valueOf(c / 100),
								valueOf(a / 100), valueOf(b / 100), valueOf(c / 100));
					}
				}
			}
		}
		
		br.close();
		pw.flush();
		pw.close();
	}
}
