package competitiveprogramming.chapter3.OneLoop.IntegerSequencesfromAdditionofTerms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author Avirmed Munkhbat
 * UVA 927 - Integer Sequences from Addition of Terms
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int[] coeffs;
	static int d, k;

	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}

	public static void main(String[] args) throws IOException {
		
		int c = Integer.parseInt(br.readLine());
		while (c > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int degree = Integer.parseInt(st.nextToken());
			coeffs = new int[degree + 1];
			for (int i = 0; i <= degree; i++) {
				coeffs[i] = Integer.parseInt(st.nextToken());
			}
			d = Integer.parseInt(br.readLine());
			k = Integer.parseInt(br.readLine());
			
			// solve element number
			int index = 1;
			int count = 0;
			while (count < k) {
				count += index * d;
				index++;
			}
			index--;
			
			long res = 0;
			for (int i = 0; i <= degree; i++) {
				res += coeffs[i] * Math.pow(index, i);
			}
			
			pw.println(res);
			
			c--;
		}

		br.close();
		pw.flush();
		pw.close();
	}
}
