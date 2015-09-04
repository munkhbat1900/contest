package competitiveprogramming.chapter1.CombinationLock;

import java.util.Scanner;

/**
 * @author munkhbat
 * Combination Lock
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int unitDegree = 9; //  9 = 360 / 30
		while (true) {
			int[] a = new int[4];
			for (int i = 0; i < 4; i++) {
				a[i] = sc.nextInt();
			}
			if ((a[0] | a[1] | a[2] | a[3]) == 0) {
				break;
			}
			int totalDegree = 360 * 2 + 360;
			int d1 = a[0] - a[1];
			int d2 = a[2] - a[1];
			int d3 = a[2] - a[3];
			if (d1 < 0) {
				d1 += 40;
			}
			
			if (d2 < 0) {
				d2 += 40;
			}
			
			if (d3 < 0) {
				d3 += 40;
			}
			
			totalDegree += d1 * unitDegree + d2 * unitDegree + d3 * unitDegree;
			System.out.println(totalDegree);
		}
		sc.close();
	}
}
