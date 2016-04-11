package competitiveprogramming.chapter3.dp.LIS.TestingtheCATCHER;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author munkhbat
 * UVA 231 - Testing the CATCHER
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static List<Integer> input;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		input = new ArrayList<>();
		int counter = 0;
		while (true) {
			String str = br.readLine();
			if (str == null || "".equals(str)) {
				break;
			}
			int k = Integer.parseInt(str);
			if (k != -1) {
				input.add(Integer.valueOf(k));
				continue;
			}
			
			if (input.size() == 0) {
				break;
			}
			
			if (counter > 0) {
				pw.println();
			}
			
			dp = new int[input.size()];
			int max = 0;
			for (int i = 0; i < input.size(); i++) {
				dp[i] = 1;
				for (int j = 0; j < i; j++) {
					if (input.get(i).intValue() <= input.get(j).intValue()) {
						dp[i] = Math.max(dp[j] + 1, dp[i]);
					}
				}
				max = Math.max(max, dp[i]);
			}
			counter++;
			pw.printf("Test #%d:\n", Integer.valueOf(counter));
			pw.printf("  maximum possible interceptions: %d\n", Integer.valueOf(max));
			
			input = new ArrayList<>();
		}
		br.close();
		pw.flush();
		pw.close();
	}
}
