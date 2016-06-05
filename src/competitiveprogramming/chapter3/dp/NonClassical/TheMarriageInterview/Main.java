package competitiveprogramming.chapter3.dp.NonClassical.TheMarriageInterview;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author munkhbat
 * UVA 10446 - The Marriage Interview :-)
 * java code got Runtime error.
 * So I wrote C++ code. which is below of java code
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int n, back;
	static BigInteger[][] dp;

	static BigInteger trib(int n, int back) {
		if (n <= 1) {
			return BigInteger.valueOf(1l);
		}
		
		if (dp[n][back].compareTo(BigInteger.valueOf(0l)) != 0l) {
			return dp[n][back];
		}
		dp[n][back] = BigInteger.valueOf(1l);
		for(int i=1;i <= back;i++) {
			dp[n][back] = dp[n][back].add(trib(n-i,back));
		}
		
		return dp[n][back];
	}

	public static void main(String[] args) throws IOException {
		dp = new BigInteger[62][62];
		for (int i = 0; i < 62; i++) {
			Arrays.fill(dp[i], BigInteger.valueOf(0));
		}
		int counter = 1;
		while (true) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			if (n > 60) {
				break;
			}
			back = Integer.parseInt(st.nextToken());
			//try {
			dp[n][back] = trib(n, back);
			pw.printf("Case %d: ", Integer.valueOf(counter));
			pw.println(dp[n][back]);
			//} catch(Exception e) {}
			counter++;
		}

		br.close();
		pw.flush();
		pw.close();
	}
}
//#include <cstdio>
//
//int n, back;
//unsigned long long dp[62][62] = {0};
//
//unsigned long long trib(int n, int back) {
//	if (n <= 1) {
//		return 1;
//	}
//
//	if (dp[n][back] != 0) {
//		return dp[n][back];
//	}
//	dp[n][back] = 1;
//	for(int i=1;i <= back;i++) {
//		dp[n][back] += trib(n-i,back);
//	}
//
//	return dp[n][back];
//}
//
//int main() {
//	int counter = 1;
//	while (scanf("%d %d", &n, & back), n < 61) {
//		printf("Case %d: %llu\n", counter, trib(n, back));
//		counter++;
//	}
//}
//
