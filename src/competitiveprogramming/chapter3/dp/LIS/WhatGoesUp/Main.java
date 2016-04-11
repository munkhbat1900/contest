package competitiveprogramming.chapter3.dp.LIS.WhatGoesUp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author munkhbat
 * UVA 481 - What Goes Up
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int[] dp;
	static List<Integer> input;
	static int[] trace, previous;
	
	/**
	 * returns minimum i where arr[i] >= val
	 * 指定した値以上の先頭のインデクスを返す
	 * @param arr
	 * @param val
	 * @return
	 */
	public static int lowerBound(int[] arr, int val) {
		int low = 0;
		int high = arr.length;
		int mid = 0;
		
		while (low < high) {
			mid = (high + low) / 2;
			if (arr[mid] < val) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		
		return low;
	}
	
	static void print(int i) {
		if (i < 0) {
			return;
		}
		print(previous[i]);
		pw.println(input.get(i));
	}
	
	public static void main(String[] args) throws IOException {
		input = new ArrayList<Integer>();
		while (true) {
			String str = br.readLine();
			if (str == null || "".equals(str)) {
				break;
			}
			input.add(Integer.valueOf(str));
		}
		dp = new int[input.size()];
		trace = new int[input.size()];
		previous = new int[input.size()];
		Arrays.fill(dp, Integer.MAX_VALUE);
		// sequence length
		int length = 0;
		// sequence end index.
		int length_end = 0;
		for (int i = 0; i < input.size(); i++) {
			int pos = lowerBound(dp, input.get(i).intValue());
			dp[pos] = input.get(i).intValue();
			trace[pos] = i;
			previous[i] = pos > 0 ? trace[pos - 1] :-1;
			// if subsequence lengthens
			if (length == pos) {
				length++;
				length_end = i;
			}
		}
		pw.println(length);
		pw.println("-");
		print(length_end);
		
		br.close();
		pw.flush();
		pw.close();
	}
}
