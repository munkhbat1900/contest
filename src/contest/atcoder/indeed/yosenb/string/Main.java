package contest.atcoder.indeed.yosenb.string;

import java.util.Scanner;

public class Main {
	private static String s, t;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		s = sc.next();
		t = sc.next();
		
		if (s.length() != t.length()) {
			System.out.println(-1);
			sc.close();
			return;
		}
		
		if (s.equals(t)) {
			System.out.println(0);
			sc.close();
			return;
		}
		
		int l = s.length();
		char[] cs = s.toCharArray();
		for (int i = 1; i < l; i++) {
			rotate(cs);
			boolean b = true;
			for (int k = 0; k < l; k++) {
				if (cs[k] != t.charAt(k)) {
					b = false;
					break;
				}
			}
			if (b) {
				System.out.println(i);
				sc.close();
				return;
			}
		}
		System.out.println(-1);
		sc.close();
	}
	
	private static void rotate(char[] c) {
		char tmp = c[c.length - 1];
		int i;
		for (i = c.length -1; i > 0; i--) {
			c[i] = c[i -1];
		}
		c[i] = tmp;
	}
}
