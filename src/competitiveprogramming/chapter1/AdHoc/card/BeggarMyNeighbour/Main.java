package competitiveprogramming.chapter1.AdHoc.card.BeggarMyNeighbour;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author munkhbat
 * UVA 00162 Beggar My Neighbour
 */

class Player {
	private List<Integer> card = new ArrayList<Integer>();
	private boolean isLost = false;

	public void dealCard(int c) {
		card.add(c);
	}

	public int playCard() {
		if (card.size() == 0) {
			isLost = true;
			return -1;
		}
		int c = card.get(card.size() - 1);
		card.remove(card.size() - 1);
		return c;
	}

	public boolean isLost() {
		return isLost;
	}

	public void takeAll(List<Integer> c) {
		List<Integer> tmp= new ArrayList<Integer>(c);
		Collections.reverse(tmp);
		tmp.addAll(card);
		card = tmp;
	}
	
	public int getCardCount() {
		return card.size();
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			Player player = new Player();
			Player dealer = new Player();
			for (int j = 0; j < 52; j++) {
				String str = sc.next();
				if (str.equals("#")) {
					sc.close();
					return;
				}
				int a = 0;
				switch(str.charAt(1)) {
				case 'A':
					a = 4;
					break;
				case 'J':
					a = 1;
					break;
				case 'Q':
					a = 2;
					break;
				case 'K':
					a = 3;
					break;
				default:
					a = 0;
					break;
				}
				if (j % 2 == 0) {
					player.dealCard(a);
				} else {
					dealer.dealCard(a);
				}
			}
			
			Player[] players = new Player[2];
			players[0] = dealer;
			players[1] = player;
			
			// simulation begins
			List<Integer> stack = new ArrayList<Integer>();
			for (int p = 1; !dealer.isLost() && !player.isLost(); p = 1 - p) {
				if (stack.size() == 0) {
					stack.add(players[p].playCard());
					continue;
				}
				
				int prev = stack.get(stack.size() - 1);
				if (prev == 0) {
					int c = players[p].playCard();
					stack.add(c);
					continue;
				}
				int k = 0;
				boolean isTakeAll= true;
				for (k = 0; k < prev; k++) {
					int c = players[p].playCard();
					if (players[p].isLost()) {
						isTakeAll = false;
						break;
					}
					stack.add(c);
					if (c > 0) {
						isTakeAll = false;
						break;
					}
				}
				if (isTakeAll) {
					players[1 - p].takeAll(stack);
					stack.clear();
				}
			}
			if (player.isLost()) {
				System.out.printf("1%3d\n", dealer.getCardCount());
			} else {
				System.out.printf("2%3d\n", player.getCardCount());
			}
		}
	}
}
