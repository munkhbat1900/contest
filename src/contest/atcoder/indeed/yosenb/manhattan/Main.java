package contest.atcoder.indeed.yosenb.manhattan;

import java.util.Scanner;

/**
 * @author munkhbat
 * http://indeednow-qualb.contest.atcoder.jp/tasks/indeednow_2015_qualb_1å
 * atcoder
 */
public class Main {
	private static int x1, y1, x2, y2;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		x1 = sc.nextInt();
		y1 = sc.nextInt();
		x2 = sc.nextInt();
		y2 = sc.nextInt();
		
		System.out.println(Math.abs(x2 - x1) + Math.abs(y2 - y1) + 1);
		
		sc.close();
	}
}
