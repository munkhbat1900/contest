package competitiveprogramming.chapter1.AdHoc.card.StackEmUp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @author Avirmed Munkhbat
 * UVA 10205 - Stack 'em Up
 */
public class Main {

	public static void main(String[] args) throws IOException {
		int[] deck = new int[52];

		String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
		String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());
		br.readLine();
		int c = 0;
		while(t > 0) {
			if (c > 0) {
				bw.write("\n");
			}
			
			for (int i = 0; i < 52; i++) {
				deck[i] = i;
			}
			int shuffleCount = Integer.parseInt(br.readLine());
			int[][] shuffles = new int[shuffleCount][52];

			for (int i = 0; i < shuffleCount; i++) {
				int counter = 0;
				while (counter < 52) {
					StringTokenizer st = new StringTokenizer(br.readLine());
					while (st.hasMoreTokens()) {

						shuffles[i][counter] = Integer.parseInt(st.nextToken()) - 1;
						counter++;
					}
				}
			}

			String line;
			while ((line = br.readLine()) != null) {
				if ("".equals(line)) {
					break;
				}
				int[] newDeck = new int[52];
				int shuf = Integer.parseInt(line) - 1;
				for (int j = 0; j < 52; j++) {
					newDeck[j] = deck[shuffles[shuf][j]];
				}
				deck = newDeck;
			}

			for (int i = 0; i < 52; i++) {
				bw.write(ranks[deck[i] % 13] + " of " + suits[deck[i] / 13] + "\n");
			}
			t--;
			c++;
		}

		br.close();
		bw.flush();
		bw.close();
	}
}
