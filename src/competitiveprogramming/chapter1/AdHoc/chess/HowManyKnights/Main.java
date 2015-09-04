package competitiveprogramming.chapter1.AdHoc.chess.HowManyKnights;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @author Avirmed Munkhbat
 * UVA 696 - How Many Knights
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			if (n == 0 && m == 0) {
				break;
			}
			int count = 0;
			if (n == 1) {
				count = m;
			} else if (m == 1) {
				count = n;
			} else if ((n == 2 && m % 2 == 1) || (n % 2 == 1 && m == 2)) {
				count = (n * m + 2) / 2;
			} else if (n == 2 && m == 2) {
				count = 4;
			} else if (n == 2 && m % 4 == 2) {
				count = 4 * (m / 4) + 4;
			} else if (m == 2 && n % 4 == 2) {
				count = 4 * (n / 4) + 4;
			} else {
				count = (n * m  + 1) / 2;
			}
			bw.write(count + " knights may be placed on a " + m + " row " + n + " column board.\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}
