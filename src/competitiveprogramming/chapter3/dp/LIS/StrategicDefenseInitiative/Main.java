package competitiveprogramming.chapter3.dp.LIS.StrategicDefenseInitiative;

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
 * UVA 497 - Strategic Defense Initiative
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static List<Integer> input;
	static int[] dp, trace, previous;
	
	static int lowerBound(int[] arr, int val) {
		int low = 0;
		int high = arr.length;
		int mid = 0;
		
		while (low < high) {
			mid = (low + high) / 2;
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
		int t = Integer.parseInt(br.readLine());
		int counter = 0;
		br.readLine();
		while (t > 0) {
			if (counter > 0) {
				pw.println();
			}
			input = new ArrayList<>();
			while (true) {
				String str = br.readLine();
				if (str == null || "".equals(str)) {
					break;
				}
				input.add(Integer.valueOf(str));
			}
			
			dp = new int[input.size()];
			Arrays.fill(dp, Integer.MAX_VALUE);
			trace = new int[input.size()];
			previous = new int[input.size()];
			
			int length = 0;
			int length_end = 0;
			
			
			for (int i = 0; i < input.size(); i++) {
				int pos = lowerBound(dp, input.get(i).intValue());
				dp[pos] = input.get(i).intValue();
				trace[pos] = i;
				previous[i] = pos > 0 ? trace[pos - 1] : -1;
				// if subsequence have more elements. we lengthen the length
				if (length == pos) {
					length++;
					length_end = i;
				}
			}
			
			pw.printf("Max hits: %d\n", Integer.valueOf(length));
			print(length_end);
			t--;
			counter++;
		}
		
		br.close();
		pw.flush();
		pw.close();
	}
}
