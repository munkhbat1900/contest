package competitiveprogramming.chapter2.linearDataStructure.stack.AccordianPatience;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Avirmed Munkhbat
 * UVA 127 - "Accordian" Patience
 * comment : At first I used class Stack and was getting TLE. 
 * When I changed to Deque and ArrayDeque, this code got AC.
 */
public class Main {
	static List<Deque<String>> pileList;

	static boolean isMatch(String str1, String str2) {
		if (str1.charAt(0) == str2.charAt(0) || str1.charAt(1) == str2.charAt(1)) {
			return true;
		}
		return false;
	}

	static void moveByStep(int current, int step) {
		String elem = pileList.get(current).pop();
		pileList.get(current - step).push(elem);
		if (pileList.get(current).isEmpty()) {
			pileList.remove(current);
		}
	}

	static void moveCard() {
		int i = 1;
		while (i < pileList.size()) {
			String currentTop = pileList.get(i).peek();
			if (i >= 3 && isMatch(pileList.get(i - 3).peek(), currentTop)) {
				moveByStep(i, 3);
				i -= 4;
			} else if (i >= 1 && isMatch(pileList.get(i - 1).peek(), currentTop)) {
				moveByStep(i, 1);
				i -= 2;
			}
			i++;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		while (true) {
			String line1 = br.readLine();
			if ("#".equals(line1)) {
				break;
			}

			StringBuilder sb = new StringBuilder();
			sb.append(line1);
			sb.append(" ");
			sb.append(br.readLine());
			StringTokenizer st = new StringTokenizer(sb.toString());
			pileList = new ArrayList<Deque<String>>();

			while (st.hasMoreElements()) {
				Deque<String> stack = new ArrayDeque<String>();
				stack.push(st.nextToken());
				pileList.add(stack);
				moveCard();
			}

			pw.printf("%d pile%s remaining: ", Integer.valueOf(pileList.size()), pileList.size() == 1 ? "" : "s");
			for (int i = 0; i < pileList.size(); i++) {
				pw.printf("%d", Integer.valueOf(pileList.get(i).size()));
				if (i != pileList.size() - 1) {
					pw.printf(" ");
				}
			}
			pw.println();
		}

		pw.flush();
		br.close();
		pw.close();
	}
}
