package competitiveprogramming.chapter2.linearDataStructure.queue.FerryLoadingIV;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author Avirmed Munkhbat
 * UVA 11034 - Ferry Loading IV
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int l, m;
	static Queue<Integer> leftBank;
	static Queue<Integer> rightBank;

	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}

	static void load(Queue<Integer> bank) {
		int total = 0;
		while (!bank.isEmpty() && total + bank.peek().intValue() <= l) {
			total += bank.poll().intValue();
		}
	}
	
	public static void main(String[] args) throws IOException {
		int c = Integer.parseInt(br.readLine());
		while (c > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			l = Integer.parseInt(st.nextToken()) * 100;
			m = Integer.parseInt(st.nextToken());
			
			leftBank = new ArrayDeque<Integer>();
			rightBank = new ArrayDeque<Integer>();
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int length = Integer.parseInt(st.nextToken());
				if (st.nextElement().equals("left")) {
					leftBank.offer(valueOf(length));
				} else {
					rightBank.offer(valueOf(length));
				}
			}
			
			boolean isLeft = true;
			int ans = 0;
			while (!leftBank.isEmpty() || !rightBank.isEmpty()) {
				if (isLeft) {
					load(leftBank);
				} else {
					load(rightBank);
				}
				isLeft = !isLeft;
				ans++;
			}
			pw.println(ans);
			c--;
		}
		pw.flush();
		br.close();
		pw.close();
	}
}
