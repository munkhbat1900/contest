package competitiveprogramming.chapter3.backtracking.easier.TheHammingDistanceProblem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author Avirmed Munkhbat
 * UVA 729 - The Hamming Distance Problem
 * idea 1 : permutation with repetition. this one got time limit exceeded. O(n * n!)
 * idea 2 : choosing 1s and 0s randomly. O(2^n)
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int n;
	static int h;
	
	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}
	
	static void solve(int count, int[] ans, int oneCount) {
		if (count == n && oneCount != h) {
			return;
		}
		if (count == n && oneCount == h) {
			for (int i = 0; i < n; i++) {
				pw.print(ans[i]);
			}
			pw.println();
			return;
		}
		
		// choose 0
		ans[count] = 0;
		solve(count + 1, ans, oneCount);
		
		//choose 1
		ans[count] = 1;
		solve(count + 1, ans, oneCount + 1);
	}
	
	public static void main(String[] args) throws IOException {
		int c = Integer.parseInt(br.readLine());
		while (c > 0) {
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			solve(0, new int[n], 0);
			c--;
			if (c > 0) {
				pw.println();
			}
		}
		br.close();
		pw.flush();
		pw.close();
	}
}


//permutation with repetition
//public class Main {
//	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
//	static int n;
//	static int h;
//	
//	static int[] ans;
//	static int[] data;
//	/**
//	 * give numbers to same element.
//	 */
//	static int[] numbers;
//	
//	static Integer valueOf(int i) {
//		return Integer.valueOf(i);
//	}
//	
//	/**
//	 * @param zeroCount total count of zero
//	 * @param count current count of zero
//	 * @param x 
//	 */
//	static void solve(int count, int[] ans, boolean[] flags) {
//		if (count == n) {
//			for (int i = 0; i < n; i++) {
//				pw.print(data[ans[i]]);
//			}
//			pw.println();
//			return;
//		}
//		
//		for (int i = 0; i < n; i++) {
//			if (flags[i]) {
//				continue;
//			}
//			boolean b = false;
//			for (int j = 0; j < count; j++) {
//				if (data[i] == data[ans[j]] && numbers[ans[j]] > numbers[i]) {
//					b = true;
//					break;
//				}
//			}
//			if (b) {
//				continue;
//			}
//			ans[count] = i;
//			flags[i] = true;
//			solve(count + 1, ans, flags);
//			flags[i] = false;
//		}
//	}
//	
//	public static void main(String[] args) throws IOException {
//		int c = Integer.parseInt(br.readLine());
//		while (c > 0) {
//			br.readLine();
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			n = Integer.parseInt(st.nextToken());
//			h = Integer.parseInt(st.nextToken());
//			data = new int[n];
//			for (int i = 0; i < n - h; i++) {
//				data[i] = 0;
//			}
//			for (int i = n - h; i < n; i++) {
//				data[i] = 1;
//			}
//			
//			numbers = new int[n];
//			for (int i = 0; i < n; i++) {
//				int k = 0;
//				for (int j = 0; j < i; j++) {
//					if (data[i] == data[j]) {
//						k++;
//					}
//				}
//				numbers[i] = k;
//			}
//			
//			solve(0, new int[n], new boolean[n]);
//			c--;
//			if (c > 0) {
//				pw.println();
//			}
//		}
//		br.close();
//		pw.flush();
//		pw.close();
//	}
//}
