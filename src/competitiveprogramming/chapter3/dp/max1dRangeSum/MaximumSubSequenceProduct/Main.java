package competitiveprogramming.chapter3.dp.max1dRangeSum.MaximumSubSequenceProduct;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author munkhbat
 * UVA 787 - Maximum Sub-sequence Product
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static List<Long> input;
	static BigInteger[][] dp;
	
	static Long valueOf(long i) {
		return Long.valueOf(i);
	}
	
	public static void main(String[] args) throws IOException {
		while (true) {
			String str = br.readLine();
			if (str == null || "".equals(str)) {
				break;
			}
			input = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(str);
			while (st.hasMoreElements()) {
				int inp = Integer.parseInt(st.nextToken());
				if (inp != -999999) {
					input.add(valueOf(inp));
				}
			}
			dp = new BigInteger[input.size()][input.size()];
			BigInteger maxbi = BigInteger.valueOf(Long.MIN_VALUE);
			for (int i = 0; i < input.size(); i++) {
				BigInteger bi = BigInteger.valueOf(1);
				for (int j = i; j < input.size(); j++) {
					bi = bi.multiply(BigInteger.valueOf(input.get(j).longValue()));
					dp[i][j] = bi;
					if (bi.compareTo(maxbi) > 0) {
						maxbi = bi;
					}
					if (BigInteger.ZERO == bi) {
						bi = BigInteger.valueOf(1);
					}
				}
			}
			pw.println(maxbi);
			
//			for (int i = 0; i < input.size(); i++) {
//				for (int j = i; j < input.size(); j++) {
//					pw.print(dp[i][j] + " ");
//				}
//				pw.println();
//			}
		}
		br.close();
		pw.flush();
		pw.close();
	}
}
