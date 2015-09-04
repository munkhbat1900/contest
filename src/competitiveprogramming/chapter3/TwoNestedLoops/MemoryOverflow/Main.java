package competitiveprogramming.chapter3.TwoNestedLoops.MemoryOverflow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author munkhbat
 * UVA 12583 Memory Overflow
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int n, k;
	static char[] names;
	static char[] memory;

	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}

	public static void main(String[] args) throws IOException {
		int c = Integer.parseInt(br.readLine());
		int count = 0;
		while (c > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			names = st.nextToken().toCharArray();
			
			memory = new char[k];
			Arrays.fill(memory, 'z');
			
			int counter = 0;
			for (int i = 0; i < n; i++) {
				char p = names[i];
				for (int j = 0; j < k; j++) {
					if (p == memory[j]) {
						counter++;
						break;
					}
				}
				
				// update memory
				for (int j = k - 1; j > 0; j--) {
					memory[j] = memory[j - 1];
				}
				memory[0] = p;
			}
			
			count++;
			pw.printf("Case %d: %d\n", valueOf(count), valueOf(counter));
			c--;
		}
		br.close();
		pw.flush();
		pw.close();
	}
}
