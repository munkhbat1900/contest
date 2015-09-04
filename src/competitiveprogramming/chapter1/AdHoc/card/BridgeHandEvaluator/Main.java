package competitiveprogramming.chapter1.AdHoc.card.BridgeHandEvaluator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author munkhbat
 * UVA 462 - Bridge Hand Evaluator
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String line;
		while ((line = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(line);
			if (line == null || "".equals(line)) {
				break;
			}
			
			int point1_4 = 0;
			int point5_7 = 0;
			Map<String, Boolean> stopped = new HashMap<String, Boolean>();
			stopped.put("S", Boolean.FALSE);
			stopped.put("H", Boolean.FALSE);
			stopped.put("D", Boolean.FALSE);
			stopped.put("C", Boolean.FALSE);

			Map<String, Integer> suits = new HashMap<String, Integer>();
			suits.put("S", 0);
			suits.put("H", 0);
			suits.put("D", 0);
			suits.put("C", 0);
			// key : A, K, Q, J value : suit list S, H, D, C
			Map<String, List<String>> pointCards = new HashMap<String, List<String>>();
			pointCards.put("A", new ArrayList<String>());
			pointCards.put("K", new ArrayList<String>());
			pointCards.put("Q", new ArrayList<String>());
			pointCards.put("J", new ArrayList<String>());

			for (int i = 0; i < 13; i++) {
				String str = st.nextToken();
				char c = str.charAt(0);
				char c1 = str.charAt(1);
				String c1Str = Character.toString(c1);
				

				if (c == 'A') {
					point1_4 += 4;
					pointCards.get("A").add(c1Str);
					// set stopped
					stopped.put(c1Str, Boolean.TRUE);
				} else if (c == 'K') {
					point1_4 += 3;
					pointCards.get("K").add(c1Str);
				} else if (c == 'Q') {
					point1_4 += 2;
					pointCards.get("Q").add(c1Str);
				} else if (c == 'J') {
					point1_4 += 1;
					pointCards.get("J").add(c1Str);
				}

				suits.put(c1Str, suits.get(c1Str) + 1);
			}

//			for (Map.Entry<String, Integer> e : suits.entrySet()) { 
//				System.out.println(e.getKey() + " : " + e.getValue()); 
//			}
			
			// rule 2
			for (String suit : pointCards.get("K")) {
				if (suits.get(suit) == 1) {
					point1_4 -= 1;
				} else {
					stopped.put(suit, true);
				}
			}

			// rule 3
			for (String suit : pointCards.get("Q")) {
				if (suits.get(suit) <= 2) {
					point1_4 -= 1;
				} else {
					stopped.put(suit, true);
				}
			}

			// rule 4
			for (String suit : pointCards.get("J")) {
				if (suits.get(suit) <= 3) {
					point1_4 -= 1;
				}
			}
			if (point1_4 >= 16) {
				// check stopped
				boolean b = true;
				for (Map.Entry<String, Boolean> e : stopped.entrySet()) {
					if (!e.getValue()) {
						b = false;
						break;
					}
				}
				if (b) {
					bw.write("BID NO-TRUMP\n");
					continue;
				}
			}
			
			//rule 5
			for (Map.Entry<String, Integer> e : suits.entrySet()) {
				if (e.getValue() == 2) {
					point5_7 += 1;
				}
			}
			
			// rule 6
			for (Map.Entry<String, Integer> e : suits.entrySet()) {
				if (e.getValue() == 1) {
					point5_7 += 2;
				}
			}
			
			// rule 7
			for (Map.Entry<String, Integer> e : suits.entrySet()) {
				if (e.getValue() == 0) {
					point5_7 += 2;
				}
			}
			
			if (point1_4 + point5_7 < 14) {
				bw.write("PASS\n");
				continue;
			}
			
			int max = -1000;
			String s = "";
			for (Map.Entry<String, Integer> e : suits.entrySet()) {
				if (e.getValue() >= max) {
					max = e.getValue();
					s = e.getKey();
				}
			}
			bw.write("BID " + s + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
