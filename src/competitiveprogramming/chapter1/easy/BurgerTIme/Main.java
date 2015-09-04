package competitiveprogramming.chapter1.easy.BurgerTIme;

import java.util.Scanner;

/**
 * @author munkhbat
 * 11661 - Burger Time?
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int l = sc.nextInt();
			if (l == 0) {
				break;
			}
			String s = sc.next();
			int currD = -1;
			int currR = -1;
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == 'Z') {
					min = 0;
					break;
				}
				if (s.charAt(i) == 'R') {
					if (currD != -1 && min > i - currD) {
						min = i -currD;
					}
					currR = i;
				}
				
				if (s.charAt(i) == 'D') {
					if (currR != -1 && min > i - currR) {
						min = i -currR;
					}
					currD = i;
				}
			}
			System.out.println(min);
		}
		sc.close();
	}
}
