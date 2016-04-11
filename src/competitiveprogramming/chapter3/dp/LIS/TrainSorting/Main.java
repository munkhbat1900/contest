package competitiveprogramming.chapter3.dp.LIS.TrainSorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * @author munkhbat
 * UVA 11456 - Trainsorting
 *  LIS(i) + LDS(i) - 1. LIS(i) is LIS starting from ith element.
 * 
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int[] input, dpinc, dpdec;
	
	
	static void LIS() {
		dpinc = new int[input.length];
		for (int j = input.length - 1; j >= 0; j--) {
			dpinc[j] = 1;
			for (int k = j + 1; k < input.length; k++) {
				if (input[j] < input[k] && dpinc[j] < 1 + dpinc[k]) {
					dpinc[j] = 1 + dpinc[k];
				}
			}
		}
	}
	
	static void LDS() {
		dpdec = new int[input.length];
		for (int j = input.length - 1; j >= 0; j--) {
			dpdec[j] = 1;
			for (int k = j + 1; k < input.length; k++) {
				if (input[j] > input[k] && dpdec[j] < 1 + dpdec[k]) {
					dpdec[j] = 1 + dpdec[k];
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		while (t > 0) {
			int n = Integer.parseInt(br.readLine());
			input = new int[n];
			for (int i = 0; i < n; i++) {
				input[i] = Integer.parseInt(br.readLine());
			}
			
			
			int max = 0;
			LIS();
			LDS();
			for (int i = 0; i < n; i++) {
				max = Math.max(max, dpinc[i] + dpdec[i] - 1);
			}
			pw.println(max);
			t--;
		}
		br.close();
		pw.flush();
		pw.close();
	}
}
