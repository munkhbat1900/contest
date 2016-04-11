package competitiveprogramming.chapter3.dp.LIS.HistoryGrading;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author munkhbat
 * UVA 111 - History Grading
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int n;
	static int[] dp;
	static int[] order;
	static int[] ans;
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		order = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			order[i] = Integer.parseInt(st.nextToken()) - 1;
		}
		
		while (true) {
			String str = br.readLine();
			if (str == null || "".equals(str)) {
				break;
			}
			st = new StringTokenizer(str);
			ans = new int[n];
			dp = new int[n];
			for (int i = 0; i < n; i++) {
				ans[Integer.parseInt(st.nextToken()) - 1] = i;
			}
			
			int res = 0;
			for (int i = 0; i < n; i++) {
				dp[i] = 1;
				for (int j = 0; j < i; j++) {
					if (order[ans[i]] > order[ans[j]]) {
						dp[i] = Math.max(dp[i], dp[j] + 1);
					}
				}
				res = Math.max(res, dp[i]);
			}
			pw.println(res);
		}
		
		br.close();
		pw.flush();
		pw.close();
	}
}
