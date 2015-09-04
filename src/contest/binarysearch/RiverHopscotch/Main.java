package contest.binarysearch.RiverHopscotch;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author munkhbat
 * River Hopscotch
 * POJ 3258
 * C(d) = maximum of the shortest distance
 */
public class Main {
	private static int n, l, m;
	private static int[] d;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		l = sc.nextInt();
		n = sc.nextInt();
		m = sc.nextInt();
		
		d = new int[n + 2];
		d[0] = 0;
		for (int i = 1; i <= n; i++) {
			d[i] = sc.nextInt();
		}
		d[n + 1] = l;
		
		Arrays.sort(d);
		
		System.out.println(maximize());
		
		sc.close();
	}
	
	private static boolean condition(int dis) {
		int last = 0;
		int counter = 0;
		while(last < n + 1) {
			int current = last + 1;
			while (current < n + 2 && d[current] - d[last] < dis) {
				current++;
				counter++;
			}
			if (current >= n + 2 || counter > m) {
				return false;
			}
			last = current;
		}
		return true;
	}
	
	private static int maximize() {
		int lb = 0;
		int ub = 1000000000;
		while (ub -lb > 1) {
			int mid = (lb + ub) / 2;
			if (condition(mid)) {
				lb = mid;
			} else {
				ub = mid;
			}
		}
		return lb;
	}
}
