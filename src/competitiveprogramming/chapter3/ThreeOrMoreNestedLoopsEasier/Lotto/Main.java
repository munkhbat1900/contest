package competitiveprogramming.chapter3.ThreeOrMoreNestedLoopsEasier.Lotto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author munkhbat
 * UVA 441 - Lotto
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}

	public static void main(String[] args) throws IOException {
		int counter = 0;
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			if (k == 0) {
				break;
			}
			if (counter > 0) {
				pw.println();
			}
			counter++;
			int[] a = new int[k];
			for (int i = 0; i < k; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(a);
			
			for (int i = 0; i < k; i++) {
				for (int j = i + 1; j < k; j++) {
					for (int p = j + 1; p < k; p++) {
						for (int q = p + 1; q < k; q++) {
							for (int w = q + 1; w < k; w++) {
								for (int v = w + 1; v < k; v++) {
									pw.printf("%d %d %d %d %d %d\n", valueOf(a[i]), valueOf(a[j]), valueOf(a[p]), valueOf(a[q]), valueOf(a[w]), valueOf(a[v]));
								}
							}
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
