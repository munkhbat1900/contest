package competitiveprogramming.chapter3.dp.max1dRangeSum.TheJackpot;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author munkhbat
 * UVA 10684 - The jackpot
 */
public class Main {
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int n;
		while((n = scanner.nextInt()) != 0) {
			int max = Integer.MIN_VALUE;
			int sum = 0;
			for (int i = 0; i < n; i++) {
				sum += scanner.nextInt();
				max = Integer.max(sum, max);
				if (sum < 0) {
					sum = 0;
				}
			}
			if (max <= 0) {
				pw.println("Losing streak.");
			} else {
				pw.printf("The maximum winning streak is %d.\n", Integer.valueOf(max));
			}
		}
		pw.flush();
		pw.close();
	}
}
