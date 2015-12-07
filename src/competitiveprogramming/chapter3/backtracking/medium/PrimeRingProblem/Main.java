package competitiveprogramming.chapter3.backtracking.medium.PrimeRingProblem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * @author munkhbat
 * UVA 524 - Prime Ring Problem
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int n;
	static int[] ring;
	
	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}
	
	static boolean isPrime(int sum) {
		if (sum % 2 == 0) {
			return false;
		}
		
		for (int i = 3; i <= Math.sqrt(sum); i += 2) {
			if (sum % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	static boolean isPrime(int index, int d) {
		if (index < n - 1) {
			return isPrime(ring[index - 1] + d);
		} else {
			return isPrime(ring[0] + d) && isPrime(ring[index - 1] + d);
		}
	}
	
	static void print() {
		pw.print(ring[0]);
		for (int i = 1; i < n; i++) {
			pw.print(" " + ring[i]);
		}
		pw.println();
	}
	
	static void solve(int index, boolean[] used) {
		if (index == n) {
			print();
		} else {
			for (int i = 2; i <= n; i++) {
				if (!used[i] && isPrime(index, i)) {
					ring[index] = i;
					used[i] = true;
					solve(index + 1, used);
					used[i] = false;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		int counter = 1;
		while (true) {
			String str = br.readLine();
			if (str == null || "".equals(str)) {
				break;
			}
			if (counter != 1) {
				pw.println();
			}
			n = Integer.parseInt(str);
			ring = new int[n];
			boolean[] b = new boolean[n + 1];
			b[0] = true;
			b[1] = true;
			ring[0] = 1;
			pw.printf("Case %d:\n", valueOf(counter));
			solve(1, b);
			counter++;
		}
		br.close();
		pw.flush();
		pw.close();
	}
}
