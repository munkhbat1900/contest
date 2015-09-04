package contest.binarysearch.AggressiveCows;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author munkhbat
 *　C(d) = nearest distance between two cows can made to more than d
 * In other words, distance between any 2 cows can mede to more than d.
 */
public class Main {
	private static int n, c;
	private static int[] x;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		c = sc.nextInt();
		x = new int[n];
		for (int i = 0; i < n; i++) {
			x[i] = sc.nextInt();
		}
		
		Arrays.sort(x);
		
		System.out.println(maximize());
		
		sc.close();
	}
	
	private static boolean condition(int d) {
		int last = 0;
		for (int i = 1; i < c; i++) {
			int crt = last + 1;
			while (crt < n && x[crt] - x[last] < d) {
				crt++;
			}
			if (crt >= n) {
				return false;
			}
			last = crt;
		}
		return true;
	}
	
	private static int maximize() {
		int lb = 0;
		int ub = 1000000000;
		
		while (ub - lb > 1) {
			int mid = (ub + lb) / 2; 
			if (condition(mid)) {
				lb = mid;
			} else {
				ub = mid;
			}
		}
		return lb;
	}
}
