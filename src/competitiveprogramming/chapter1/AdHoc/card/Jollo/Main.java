package competitiveprogramming.chapter1.AdHoc.card.Jollo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author Avirmed Munkhbat
 * UVA 12247 - Jollo
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] s = new int[3];
			int[] b = new int[2];

			s[0] = Integer.parseInt(st.nextToken());
			s[1] = Integer.parseInt(st.nextToken());
			s[2] = Integer.parseInt(st.nextToken());
			b[0] = Integer.parseInt(st.nextToken());
			b[1] = Integer.parseInt(st.nextToken());

			if (s[0] == 0 && s[1] == 0 && s[2] == 0 && b[0] == 0 && b[1] == 0) {
				break;
			}

			Arrays.sort(s);
			Arrays.sort(b);

			int counter3 = 0;
			int counter2 = 0;
			for (int k = 0; k < 2; k++) {
				boolean bb3 = true;
				boolean bb2 = true;
				for (int i = 0; i < 3; i++) {
					if (s[i] > b[k]) {
						bb3 = false;
					}
					
					if (i < 2 && s[i] > b[k]) {
						bb2 = false;
					}
				}
				if (bb3) {
					counter3++;
				} else if (bb2) {
					counter2++;
				}
			}
			
			if (counter3 == 2) {
				// if 2 of card dealt to prince are higher than every card that princess owns,
				// dealing the least value card is enough for prince to win
				boolean found = false;
				for (int i = 1; i <=52; i++) {
					if (Arrays.binarySearch(s, i) < 0 && Arrays.binarySearch(b, i) < 0) {
						bw.write(i + "\n");
						found = true;
						break;
					}
				}
				if (!found) {
					bw.write("-1\n");
				}
				continue;
			}
			
			if (counter3 == 1 && counter2 == 1) {
				// if one card is higher than all of pricess' card
				// and 1 card is higher than two of princess' card
				boolean found = false;
				for (int i = 1; i <=52; i++) {
					if (Arrays.binarySearch(s, i) < 0 && Arrays.binarySearch(b, i) < 0 && i > s[1]) {
						bw.write(i + "\n");
						found = true;
						break;
					}
				}
				if (!found) {
					bw.write("-1\n");
				}
				continue;
			}
			
			if (counter3 == 1) {
				boolean found = false;
				for (int i = 1; i <=52; i++) {
					if (Arrays.binarySearch(s, i) < 0 && Arrays.binarySearch(b, i) < 0 && i > s[2]) {
						bw.write(i + "\n");
						found = true;
						break;
					}
				}
				if (!found) {
					bw.write("-1\n");
				}
				continue;
			}
			
			if (counter3 == 0 && counter2 == 2) {
				boolean found = false;
				for (int i = 1; i <=52; i++) {
					if (Arrays.binarySearch(s, i) < 0 && Arrays.binarySearch(b, i) < 0 && i > s[1]) {
						bw.write(i + "\n");
						found = true;
						break;
					}
				}
				if (!found) {
					bw.write("-1\n");
				}
				continue;
			}
			
			bw.write("-1\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}
}
