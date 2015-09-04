package competitiveprogramming.chapter2.linearDataStructure.queue.ThrowingCardsAwayI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Avirmed Munkhbat
 * UVA 10935 - Throwing cards away I
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int n;
	static Queue<Integer> q;
	static Queue<Integer> ans;

	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}

	public static void main(String[] args) throws IOException {
		while (true) {
			n = Integer.parseInt(br.readLine());
			if (n == 0) {
				break;
			}

			q = new ArrayDeque<Integer>();
			ans = new ArrayDeque<Integer>();
			for (int i = 0; i < n; i++) {
				q.offer(valueOf(i + 1));
			}
			while (q.size() > 1) {
				ans.offer(q.poll());
				Integer i = q.poll();
				q.offer(i);
			}
			if (ans.isEmpty()) {
				pw.print("Discarded cards:");
			} else {
				pw.print("Discarded cards: ");
			}
			while (!ans.isEmpty()) {
				if (ans.size() > 1) {
					pw.printf("%d, ", ans.poll());
				} else {
					pw.printf("%d", ans.poll());
				}
			}
			pw.printf("\nRemaining card: %d\n", q.poll());

		}

		pw.flush();
		br.close();
		pw.close();
	}
}
