package competitiveprogramming.chapter3.ThreeOrMoreNestedLoopsHarder.Sumsets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * @author Munkhbat
 * UVA 10125 - Sumsets
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static long[] numbers;
	
	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}
	static Long valueOf(long l) {
		return Long.valueOf(l);
	}
	
	public static void main(String[] args) throws IOException {
		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) {
				break;
			}
			
			numbers = new long[n];
			for (int i = 0; i < n; i++) {
				numbers[i] = Long.parseLong(br.readLine());
			}
			
			Arrays.sort(numbers);
			
			boolean found = false;
			long ans = -1;
			for (int i = numbers.length - 1; i >= 0; i--) {
				if (found) {
					break;
				}
				for (int j = 0; j < numbers.length - 1; j++) {
					if (i == j) {
						continue;
					}
					if (found) {
						break;
					}
					for (int k = j + 1; k < numbers.length; k++) {
						if (i == k) {
							continue;
						}
						long c = numbers[i] - numbers[j] - numbers[k];
						int index = Arrays.binarySearch(numbers, c); 
						if (index >= 0 && index != i && index !=  j && index != k) {
							found = true;
							ans = numbers[i];
							break;
						}
					}
				}
			}
			if (!found) {
				pw.println("no solution");
			} else {
				pw.println(ans);
			}
		}
		
		br.close();
		pw.flush();
		pw.close();
	}
}
