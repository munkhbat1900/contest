package competitiveprogramming.chapter2.linearDataStructure.queue.PrinterQueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author Avirmed Munkhbat
 * UVA 12100 - Printer Queue
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int n, m;
	static List<Integer> queue;
	
	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}
	public static void main(String[] args) throws IOException {
		int c = Integer.parseInt(br.readLine());
		while (c > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			queue = new ArrayList<Integer>();
			for (int i = 0; i < n; i++) {
				queue.add(valueOf(Integer.parseInt(st.nextToken())));
			}
			int ans = 0;
			
			while (m >= 0) {
				int top = queue.get(0).intValue();
				queue.remove(0);
				m--;
				boolean isPrint = true;
				for (Integer el : queue) {
					if (top < el.intValue()) {
						queue.add(valueOf(top));
						if (m < 0) {
							m = queue.size() - 1;
						}
						isPrint = false;
						break;
					}
				}
				if (isPrint) {
					ans++;
				}
			}
			
			pw.println(ans);
			c--;
		}
		pw.flush();
		br.close();
		pw.close();
	}
}
