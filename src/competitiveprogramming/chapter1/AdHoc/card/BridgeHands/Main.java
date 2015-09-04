package competitiveprogramming.chapter1.AdHoc.card.BridgeHands;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Avirmed Munkhbat
 * UVA 555 Bridge Hands
 */
class Card implements Comparable<Card> {
	int suit;
	int rank;
	final String ranking = "23456789TJQKA";
	final String suitRanking = "CDSH";

	public Card(char s, char r) {
		setSuit(s);
		setRank(r);
	}

	private void setSuit(char s) {
		for (int i = 0; i < suitRanking.length(); i++) {
			if (s == suitRanking.charAt(i)) {
				this.suit = i;
			}
		}
	}

	private void setRank(char s) {
		for (int i = 0; i < ranking.length(); i++) {
			if (s == ranking.charAt(i)) {
				this.rank = i;
			}
		}
	}

	public void printCard(BufferedWriter bf) throws IOException {
		bf.write(Character.toString(suitRanking.charAt(suit)) + ranking.charAt(rank));
	}

	@Override
	public int compareTo(Card o) {
		int c = Integer.compare(this.suit, o.suit);
		if (c != 0) {
			return c;
		}
		return Integer.compare(this.rank, o.rank);
	}
}

/**
 * @author Avirmed Munkhbat
 * UVA 555 Bridge Hands
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String dealer = br.readLine();
			if ("#".equals(dealer)) {
				break;
			}

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 2; i++) {
				String str = br.readLine();
				sb.append(str);
			}

			String cardStr = sb.toString();
			List<Card> cards = new ArrayList<Card>();
			for (int i = 0; i < 104; i += 2) {
				String ca = cardStr.substring(i, i + 2);
				Card card = new Card(ca.charAt(0), ca.charAt(1));
				cards.add(card);
			}

			//			for (Card c : cards) {
			//				System.out.println(c.suit + " " + c.rank);
			//			}

			// 4 players
			int divider = 0;
			switch (dealer) {
			case "N": 
				divider = 2;
				break;
			case "E":
				divider = 1;
				break;
			case "S":
				divider = 4;
				break;
			case "W":
				divider = 3;
				break;
			}

			String orient = "SWNE";
			for (int j = 0; j < 4; j++) {
				if (divider > 4) {
					divider = 1;
				}
				
				bw.write(Character.toString(orient.charAt(j)) + ": ");

				List<Card> hand = new ArrayList<>();
				for (int i = divider - 1; i < 52; i += 4) {
					hand.add(cards.get(i));
				}
				Collections.sort(hand);
				for (int c = 0; c < 13; c++) {
					hand.get(c).printCard(bw);
					if (c != 12) {
						bw.write(" ");
					}
				}
				bw.write("\n");
				divider++;
			}
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
