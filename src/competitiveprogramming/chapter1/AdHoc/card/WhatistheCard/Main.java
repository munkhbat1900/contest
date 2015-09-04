package competitiveprogramming.chapter1.AdHoc.card.WhatistheCard;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Avirmed Munkhbat
 * UVA 10646 - What is the Card?
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		int c = 0;
		while(t > 0) {
			List<String> deck = new ArrayList<String>();
			while (true) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int counter = 0;
				while (counter < 52) {
					deck.add(st.nextToken());
					counter++;
				}
				break;
			}
			
			// simulation begins
			int y = 0;
			// 27 th card from top
			int initial  = 26;
			for (int i = 0; i < 3; i++) {
				// top card of the remaining pile of the cards
				String card = deck.get(initial);
				//bw.write("top = " + card + " initial = " + initial + "\n");
				int value;
				int v = card.charAt(0) - '0';
				if (v >= 2 && v <= 9) {
					value = v;
				} else {
					value = 10;
				}
				y += value;
				deck.remove(initial);
				for (int j = 1; j <= 10 - value; j++) {
					deck.remove(initial - j);
				}
				initial -= 11 - value;
			}
			
			t--;
			c++;
			bw.write("Case " + c + ": " + deck.get(y - 1) + "\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}
