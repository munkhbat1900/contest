package contest.binarysearch.MonthlyExpense;

import java.util.Scanner;

/**
 * @author munkhbat
 * POJ 3273
 * Monthly Expense
 */
public class Main {
	private static int n, m;
	private static int[] money;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		money = new int[n];
		for (int i = 0; i < n; i++) {
			money[i] = sc.nextInt();
		}

		System.out.println(minimize());

		sc.close();
	}

	/**
	 * with maximum expense of maxMoney, can farmer create budget of m fiscal period?
	 * maxMoneyの予算でm個のfiscal period作れるか
	 * @param maxMoney
	 * @return
	 */
	private static boolean condition(int maxMoney) {
		int current = 0;
		for (int j = 0; j < m; j++) {
			int sum = 0;
			while (current < n && sum <= maxMoney) {
				sum += money[current];
				current++;
			}
			current--;
			if (current == n - 1) {
				return true;
			}
		}
		return false;
	}

	private static int minimize() {
		int lb = 0;
		int ub = 1000000000;
		while (ub -lb > 1) {
			int mid = (lb + ub) / 2;
			if (condition(mid)) {
				ub = mid;
			} else {
				lb = mid;
			}
		}
		return ub;
	}
}
