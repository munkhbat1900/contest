package competitiveprogramming.chapter1.AdHoc.card.CardsExchange;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Avirmed Munkhbat
 * UVA 11678 - Cards' Exchange
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while (true) {
			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (a == 0 && b == 0) {
				break;
			}
			
			int[] c1 = new int[a];
			int[] c2 = new int[b];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < a; i++) {
				c1[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < b; i++) {
				c2[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(c1);
			Arrays.sort(c2);
			
			int prev = -Integer.MIN_VALUE;
			int count1 = 0;
			for (int i = 0; i < a; i++) {
				if (prev == c1[i]) {
					continue;
				}
				prev = c1[i];
				if (Arrays.binarySearch(c2, c1[i]) < 0) {
					count1++;
				}
			}
			
			prev = -Integer.MIN_VALUE;
			int count2 = 0;
			for (int i = 0; i < b; i++) {
				if (prev == c2[i]) {
					continue;
				}
				prev = c2[i];
				if (Arrays.binarySearch(c1, c2[i]) < 0) {
					count2++;
				}
			}
			
			bw.write((count1 > count2 ? count2 : count1) + "\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}
