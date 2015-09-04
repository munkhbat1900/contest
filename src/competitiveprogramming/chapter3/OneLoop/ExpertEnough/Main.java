package competitiveprogramming.chapter3.OneLoop.ExpertEnough;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * @author Avirmed Munkhbat
 * UVA 1237 - Expert Enough?
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static String[] maker;
	static int[] low;
	static int[] high;
	static int d;
	
	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}
	
	static String find(int p) {
		int count = 0;
		int res = -1;
		for (int i = 0; i < d; i++) {
			if (low[i] <= p && high[i] >= p) {
				count++;
				res = i;
			}
		}
		if (count == 1) {
			return maker[res];
		}
		return "UNDETERMINED";
	}
	
	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		int counter = 0;
		while(t > 0) {
			if (counter > 0) {
				pw.println();
			}
			counter++;
			d = Integer.parseInt(br.readLine());
			maker = new String[d];
			low = new int[d];
			high = new int[d];
			
			for (int i = 0; i < d; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				maker[i] = st.nextToken();
				low[i] = Integer.parseInt(st.nextToken());
				high[i] = Integer.parseInt(st.nextToken());
			}
			
			int q = Integer.parseInt(br.readLine());
			for (int i = 0; i < q; i++) {
				int p = Integer.parseInt(br.readLine());
				pw.println(find(p));
			}
			
			t--;
		}
		
		br.close();
		pw.flush();
		pw.close();
	}
}
