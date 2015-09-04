package competitiveprogramming.chapter3.TwoNestedLoops.TourdeFrance;

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
 *　UVA 11242 Tour de France
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int f, r;
	static int[] fa, ra;
	
	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}

	public static void main(String[] args) throws IOException {
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			f = Integer.parseInt(st.nextToken());
			if (f == 0) {
				break;
			}
			r = Integer.parseInt(st.nextToken());
			fa = new int[f];
			ra = new int[r];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < f; i++) {
				fa[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < r; i++) {
				ra[i] = Integer.parseInt(st.nextToken());
			}
			
			float[] dratio = new float[f * r];
			int counter = 0;
			for (int i = 0; i < f; i++) {
				for (int j = 0; j < r; j++) {
					dratio[counter] = (float)ra[j] / (float)fa[i];
					counter++;
				}
			}
			
			Arrays.sort(dratio);
			float max = Float.MIN_VALUE;
			for (int i = 0; i < f * r - 1; i++) {
				if (dratio[i + 1] / dratio[i] > max) {
					max = dratio[i + 1] / dratio[i];
				}
			}
			pw.printf("%.2f\n", Float.valueOf(max));
		}

		br.close();
		pw.flush();
		pw.close();
	}
}
