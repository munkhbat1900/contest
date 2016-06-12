package competitiveprogramming.chapter3.dp.knapsack01.SumofDifferentPrimes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Munkhbat
 * UVA 1213 - Sum of Different Primes
 * bottom up got AC in 0.060 secs. topdown got AC in 0.250
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	// dp1[i][j] = iをj個の素数で何個作れるか？
	static int[][][] topdown;
	static int[][] bottomup;
	static List<Integer> primes;
	static int n, k;


	static boolean isPrime(int m) {
		for (int i = 2; i <= Math.sqrt(m); i++) {
			if (m % i == 0) {
				return false;
			}
		}
		return true;
	}

	static void buildPrimes() {
		for (int i = 2; i <= 1119; i++) {
			if (isPrime(i)) {
				primes.add(Integer.valueOf(i));
			}
		}
	}

	static int topdown(int id, int remn, int remk) {
		if (id <= primes.size() && remk == 0 && remn == 0){
			return 1;
		} else if (id == primes.size() || remk <= 0 || remn <= 0) {
			return 0;
		}
		if (topdown[id][remn][remk] != -1) {
			return topdown[id][remn][remk];
		}
		topdown[id][remn][remk] = topdown(id + 1, remn, remk) + topdown(id + 1, remn - primes.get(id).intValue(), remk - 1);

		return topdown[id][remn][remk];
	}

	static void bottomup() {
		bottomup[0][0] = 1;

		for (int i = 0; i < primes.size(); i++) {
			for (int j = 1120; j >= primes.get(i).intValue(); j--) {
				for (int k = 1; k < 16; k++) {
					bottomup[j][k] += bottomup[j - primes.get(i).intValue()][k - 1];
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		primes = new ArrayList<>();
		buildPrimes();
		topdown = new int[primes.size()][1121][16];
		for (int i = 0; i < primes.size(); i++) {
			for (int j = 0; j < 1121; j++) {
				Arrays.fill(topdown[i][j], -1);
			}
		}
//		bottomup = new int[1121][16];
//		bottomup();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			if (n == 0 && k == 0) {
				break;
			}
			pw.println(topdown(0, n, k));
			//			pw.println(bottomup[n][k]);
		}
		br.close();
		pw.flush();
		pw.close();
	}
}
