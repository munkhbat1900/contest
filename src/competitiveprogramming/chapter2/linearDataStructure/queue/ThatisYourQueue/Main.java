package competitiveprogramming.chapter2.linearDataStructure.queue.ThatisYourQueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author Avirmed Munkhbat
 * UVA 12207 - That is Your Queue
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int p, c;
	static Queue<Integer> queue;
	static Deque<Integer> deque;
	
	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}
	public static void main(String[] args) throws IOException {
		int counter = 0;
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			p = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			if (p == 0 && c == 0) {
				break;
			}
			
			counter++;
			
			queue = new ArrayDeque<Integer>();
			for (int i = 0; i < (p > 1000 ? 1000 : p); i++) {
				queue.offer(valueOf(i + 1));
			}
			
			deque = new ArrayDeque<Integer>();
			pw.printf("Case %d:\n", valueOf(counter));
			
			for (int i = 0; i < c; i++) {
				st = new StringTokenizer(br.readLine());
				if (st.nextElement().equals("N")) {
					Integer ii = queue.poll();
					pw.println(ii);
					queue.offer(ii);
				} else {
					int num = Integer.parseInt(st.nextToken());
					while (!queue.isEmpty()) {
						if (queue.peek().intValue() != num) {
							deque.offerFirst(queue.poll());
						} else {
							queue.poll();
						}
					}
					if (queue.isEmpty()) {
						queue.offer(valueOf(num));
					}
					while (!deque.isEmpty()) {
						queue.offer(deque.pollLast());
					}
				}
			}
		}
		pw.flush();
		br.close();
		pw.close();
	}
}
