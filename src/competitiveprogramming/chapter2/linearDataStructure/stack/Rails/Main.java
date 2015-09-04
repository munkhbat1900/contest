package competitiveprogramming.chapter2.linearDataStructure.stack.Rails;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * @author Avirmed Munkhbat
 * UVA 514 - Rails
 */
public class Main {
	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0) {
				break;
			}

			while (true) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int k = 1;
				boolean isOver = false;
				Deque<Integer> stationStack = new ArrayDeque<>();
				for (int i = 0; i < n; i++) {
					int car = Integer.parseInt(st.nextToken());
					if (car == 0) {
						isOver = true;
						break;
					}
					if (stationStack.size() > 0 && car == stationStack.peek().intValue()) {
						stationStack.pop();
						continue;
					} 
					for (;k <= car; k++) {
						stationStack.push(valueOf(k));
					}
					if (stationStack.size() > 0 && car == stationStack.peek().intValue()) {
						stationStack.pop();
					}
				}
				if (!isOver) {
					if (stationStack.size() == 0) {
						pw.println("Yes");
					} else {
						pw.println("No");
					}
				} else {
					pw.println();
					break;
				}
			}
		}

		pw.flush();
		br.close();
		pw.close();
	}
}
