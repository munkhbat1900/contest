package competitiveprogramming.chapter2.NonLinearDataStructure.priorityQueue.ICanGuesstheDataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author Avirmed Munkhbat
 * UVA 11995 - I Can Guess the Data Structure!
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static PriorityQueue<Integer> pq;
	static Deque<Integer> stack;
	static Queue<Integer> queue;
	
	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}
	
	public static void main(String[] args) throws IOException {
		while(true) {
			String s = br.readLine();
			if (s == null || s.equals("")) {
				break;
			}
			StringTokenizer st = new StringTokenizer(s);
			int n = Integer.parseInt(st.nextToken());
			boolean isStack = true;
			boolean isQueue = true;
			boolean isPriorityQueue = true;
			pq = new PriorityQueue<Integer>();
			stack = new ArrayDeque<Integer>();
			queue = new ArrayDeque<Integer>();
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int op = Integer.parseInt(st.nextToken());
				int val = Integer.parseInt(st.nextToken());
				if (op == 1) {
					pq.offer(valueOf(-val));
					stack.push(valueOf(val));
					queue.offer(valueOf(val));
				} else if (!pq.isEmpty()) {
					int a1 = pq.poll().intValue();
					int a2 = stack.pop().intValue();
					int a3 = queue.poll().intValue();
					if (a1 != -val) {
						isPriorityQueue = false;
					}
					if (a2 != val) {
						isStack = false;
					}
					if (a3 != val) {
						isQueue = false;
					}
				} else if (pq.isEmpty()) {
					isPriorityQueue = false;
					isStack = false;
					isQueue = false;
				}
			}
			
			if (!(isStack || isPriorityQueue || isQueue)) {
				pw.println("impossible");
			} else if ((isStack && isPriorityQueue) || (isPriorityQueue && isQueue) || (isStack && isQueue)) {
				pw.println("not sure");
			} else if (isStack && isPriorityQueue && isQueue) {
				pw.println("not sure");
			} else if (isStack) {
				pw.println("stack");
			} else if (isPriorityQueue) {
				pw.println("priority queue");
			} else if (isQueue) {
				pw.println("queue");
			}
			
		}
		br.close();
		pw.flush();
		pw.close();
	}
}
