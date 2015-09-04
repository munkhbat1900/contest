package competitiveprogramming.chapter3.TwoNestedLoops.StartGrid;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author munkhbat
 * UVA 12488 - Start Grid
 * just simulate overtake. pick car number from ending grid and overtake cars ahead of this car.
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int n;
	static int[] start, end;

	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}

	public static void main(String[] args) throws IOException {
		while (true) {
			String str = br.readLine();
			if (str == null || str.equals("")) {
				break;
			}
			n = Integer.parseInt(str);
			start = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				start[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			end = new int[n];
			for (int i = 0; i < n; i++) {
				end[i] = Integer.parseInt(st.nextToken());
			}
			
			int counter = 0;
			int pos = 0;
			int num = 0;
			for (int i = 0; i < n; i++) {
				for (int j = i; j < n; j++) {
					if (end[i] == start[j]) {
						pos = j;
						num = start[j];
						break;
					}
				}
				
				for (int j = pos; j > i; j--) {
					start[j] = start[j - 1];
					counter++;
				}
				start[i] = num;
			}
			pw.println(counter);
		}

		br.close();
		pw.flush();
		pw.close();
	}
}
