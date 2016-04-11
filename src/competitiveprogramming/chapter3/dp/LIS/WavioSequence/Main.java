package competitiveprogramming.chapter3.dp.LIS.WavioSequence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author munkhbat
 * 10534 - Wavio Sequence
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int[] input, dpincrease, dpdecrease, tracein, tracedec;
	static int n;
	
	static int lowerBound(int[] arr, int val) {
		int low = 0;
		int high = arr.length;
		int mid = 0;
		
		while (low < high) {
			mid = (low + high) / 2;
			if (val > arr[mid]) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}
	
	static void LIS() {
		for (int i = 0; i < n; i++) {
			int pos = lowerBound(dpincrease, input[i]);
			dpincrease[pos] = input[i];
			tracein[i] = pos;
		}
	}
	
	static void LDS() {
		for (int i = n - 1; i >= 0; i--) {
			int pos = lowerBound(dpdecrease, input[i]);
			dpdecrease[pos] = input[i];
			tracedec[i] = pos;
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			n = sc.nextInt();
			input = new int[n];
			dpincrease = new int[n];
			for (int i = 0; i < n; i++) {
				input[i] = sc.nextInt();
			}
			dpincrease = new int[n];
			dpdecrease = new int[n];
			tracein = new int[n];
			tracedec = new int[n];
			Arrays.fill(dpincrease, Integer.MAX_VALUE);
			Arrays.fill(dpdecrease, Integer.MAX_VALUE);
			
			LIS();
			LDS();
			
			int max = 0;
			for (int i = 0; i < n; i++) {
				max = Math.max(max, Math.min(tracein[i], tracedec[i]) * 2 + 1);
			}
			
			pw.println(max);
		}
		br.close();
		pw.flush();
		pw.close();
		sc.close();
	}
}
//while (true) {
//String str = br.readLine().trim();
//if (str == null || "".equals(str)) {
//	break;
//}
//n = Integer.parseInt(str);
//input = new int[n];
//dpincrease = new int[n];
//StringTokenizer st = new StringTokenizer(br.readLine());
//for (int i = 0; i < n; i++) {
//	input[i] = Integer.parseInt(st.nextToken());
//}
//
//dpincrease = new int[n];
//dpdecrease = new int[n];
//tracein = new int[n];
//tracedec = new int[n];
//Arrays.fill(dpincrease, Integer.MAX_VALUE);
//Arrays.fill(dpdecrease, Integer.MAX_VALUE);
//
//LIS();
//LDS();
//
//int max = 0;
//for (int i = 0; i < n; i++) {
//	max = Math.max(max, Math.min(tracein[i], tracedec[i]) * 2 + 1);
//}
//
//pw.println(max);
//}