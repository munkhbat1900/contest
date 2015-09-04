package contest.atcoder.contest38;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	private static int[] card;
	private static int n;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		card = new int[n];
		for (int i = 0; i < n; i++) {
			card[i] = sc.nextInt();
		}
		
		Arrays.sort(card);
		
		int sum = 0;
		for (int i = n - 1; i >= 0; i -= 2) {
			if (i < 0) {
				break;
			}
			sum += card[i];
		} 
		System.out.println(sum);
		sc.close();
	}
}
