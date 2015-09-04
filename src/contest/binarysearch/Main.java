package contest.binarysearch;

import java.util.Scanner;

/**
 * @author munkhbat
 * Cable master POJ 1064
 * C(x) :  k cables which are x or more length of cable piece that can be cut
 * from cables in the stock.
 * this problem is solved by maximizing x.
 * 
 */
public class Main {
	private static int n, k;
	private static float[] l;
	
	private static boolean condition(float x) {
		int count = 0;
		for (int i = 0; i < n; i++) {
			count += (int)(l[i] / x);
		}
		return count >= k;
	}
	
	private static float maxiimizeByBs() {
		float eps = 0.001f;
		float lb = 0f;
		float ub = 100000f;
		//while(ub - lb > eps) {
		for (int i = 0; i < 100; i++) {
			float mid = (ub + lb) / 2;
			if (condition(mid)) {
				lb = mid;
			} else {
				ub = mid;
			}
		}
		return lb;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		l = new float[n];
		for (int i = 0; i < n; i++) {
			l[i] = sc.nextFloat();
		}
		
		float max = maxiimizeByBs() * 100;
		
		System.out.printf("%.2f", Math.floor(max / 100));
		System.out.println();
		//System.out.println((int)(max / 100) + "." + (int)(max % 100));
		sc.close();
	}
}
