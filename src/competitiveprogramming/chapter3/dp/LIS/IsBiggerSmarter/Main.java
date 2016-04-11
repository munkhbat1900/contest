package competitiveprogramming.chapter3.dp.LIS.IsBiggerSmarter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author munkhbat
 * UVA 10131 - Is Bigger Smarter?
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static List<Elephant> elList, orig;
	static int[] dp;
	static int[] previous;
	
	static void print(int i) {
		if (i < 0) {
			return;
		}
		print(previous[i]);
		pw.println(orig.indexOf(elList.get(i)) + 1);
	}
	
	public static void main(String[] args) throws IOException {
		elList = new ArrayList<>();
		orig = new ArrayList<>();
		while (true) {
			String str = br.readLine();
			if (str == null || "".equals(str)) {
				break;
			}
			StringTokenizer st = new StringTokenizer(str);
			Elephant el = new Elephant();
			el.w = Integer.parseInt(st.nextToken());
			el.iq = Integer.parseInt(st.nextToken());
			elList.add(el);
			orig.add(el);
		}
		
		Collections.sort(elList, (el1, el2) -> el2.iq - el1.iq);
		
		dp = new int[elList.size()];
		previous = new int[elList.size()];
		
		int res = 0;
		int endpos = 0;
		
		for (int i = 0; i < elList.size(); i++) {
			dp[i] = 1;
			int prev = -1;
			for (int j = 0; j < i; j++) {
				if (elList.get(j).w < elList.get(i).w && elList.get(j).iq > elList.get(i).iq && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
					prev = j;
				}
			}
			previous[i] = prev;
			
			if (dp[i] > res) {
				res = dp[i];
				endpos = i;
			}
		}
		
		pw.println(res);
		print(endpos);
		
		br.close();
		pw.flush();
		pw.close();
	}
	
	private static class Elephant {
		int iq;
		int w;
	}
}
