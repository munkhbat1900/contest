package competitiveprogramming.chapter3.OneLoop.QuirksomeSquares;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Avirmed Munkhbat
 * UVA 256 - Quirksome Squares
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int n;
	static Map<Integer, List<String>> ansMap = new HashMap<Integer, List<String>>();
	static List<Integer> squares = new ArrayList<Integer>();

	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}

	static String getAns(int dig, int num) {
		int orig = num;
		
		int first = 0;
		for (int p = 0; p < dig / 2; p++) {
			if (num > 0) {
				first = (int) (first + (num % 10) * Math.pow(10, p));
			}
			num /= 10;
		}
		
		int second = 0;
		for (int p = 0; p < dig / 2; p++) {
			if (num > 0) {
				second = (int) (second + (num % 10) * Math.pow(10, p));
			}
			num /= 10;
		}
		if ((first + second) * (first + second) != orig) {
			return null;
		}
		String ans = Integer.toString(orig);
		for (int k = ans.length(); k < dig; k++) {
			ans = "0" + ans;
		}
		return ans;
	}

	public static void main(String[] args) throws IOException {
		
		for (int i = 0; i < 10000; i++) {
			squares.add(valueOf(i * i));
		}
		
		for (int i = 2; i < 9; i += 2) {
			List<String> ans = new ArrayList<String>();
			for (int num : squares) {
				if (Integer.toString(num).length() > i) {
					break;
				}
				String res = getAns(i, num);
				if (res != null) {
					ans.add(res);
				}
			}
			ansMap.put(valueOf(i), ans);
		}
		
		
		while(true) {
			String s = br.readLine();
			if (s == null || s.equals("")) {
				break;
			}

			n = Integer.parseInt(s);
			List<String> ans = ansMap.get(valueOf(n));
			for (String str : ans) {
				pw.println(str);
			}
		}

		br.close();
		pw.flush();
		pw.close();
	}
}
