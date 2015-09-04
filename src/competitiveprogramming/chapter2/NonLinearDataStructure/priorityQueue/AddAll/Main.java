package competitiveprogramming.chapter2.NonLinearDataStructure.priorityQueue.AddAll;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @author Avirmed Munkhbat
 * UVA 10954 - Add All
 * Greedy
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static PriorityQueue<Integer> pq;
	
	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}
	
	public static void main(String[] args) throws IOException {
		
		int s;
		while((s = Integer.parseInt(br.readLine())) != 0) {
			pq = new PriorityQueue<Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < s; i++) {
				pq.offer(valueOf(Integer.parseInt(st.nextToken())));
			}
			int cost = 0;
			int tmpCost = 0;
			while (pq.size() != 1) {
				tmpCost = pq.poll().intValue() + pq.poll().intValue();
				cost += tmpCost;
				pq.offer(valueOf(tmpCost));
			}
			pw.println(cost);
		}
		br.close();
		pw.flush();
		pw.close();
	}
}
