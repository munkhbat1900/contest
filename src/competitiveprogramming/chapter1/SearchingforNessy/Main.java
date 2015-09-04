package competitiveprogramming.chapter1.SearchingforNessy;

import java.util.Scanner;

/**
 * @author munkhbat
 * Searching for Nessy
 * UVA 11044
 * answer = (n / 3) * (m / 3) not n * m /9
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			System.out.println((int)(n / 3) * (int)(m / 3));
		}
		sc.close();
	}
}
