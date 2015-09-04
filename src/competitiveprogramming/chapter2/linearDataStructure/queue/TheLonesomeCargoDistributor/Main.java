package competitiveprogramming.chapter2.linearDataStructure.queue.TheLonesomeCargoDistributor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author Avirmed Munkhbat
 * UVA 10172 - The Lonesome Cargo Distributor
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static List<Queue<Integer>> stationQueueList;
	static Deque<Integer> stack;

	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}

	static boolean isOver() {
		if (!stack.isEmpty()) {
			return false;
		}
		for (Queue<Integer> q : stationQueueList) {
			if (!q.isEmpty()) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		int sets = Integer.parseInt(br.readLine());
		while (sets > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());

			stationQueueList = new ArrayList<Queue<Integer>>();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int qi = Integer.parseInt(st.nextToken());
				Queue<Integer> que = new ArrayDeque<Integer>();
				for (int j = 0; j < qi; j++) {
					que.offer(valueOf(Integer.parseInt(st.nextToken()) - 1));
				}
				stationQueueList.add(que);
			}

			//start simulation
			int time = 0;
			int town = 0;
			stack = new ArrayDeque<Integer>();
			while (true) {
				// load
				Queue<Integer> que = stationQueueList.get(town);
				for (; s > stack.size() && que.size() > 0;) {
					time += 1;
					stack.push(que.poll());
				}
				if (isOver()) {
					break;
				}
				// move to next town
				town++;
				time += 2;
				if (town == n) {
					town = 0;
				}
				//unload
				Queue<Integer> qu = stationQueueList.get(town);
				for (; stack.size() > 0;) {
					if (qu.size() >= q && stack.peek().intValue() != town) {
						break;
					}
					
					Integer top = stack.pop();
					time += 1;
					
					if (top.intValue() == town) {
						continue;
					}
					if (qu.size() < q) {
						qu.offer(top);
					}
				}
				if (isOver()) {
					break;
				}
			}
			pw.println(time);
			sets--;
		}
		pw.flush();
		br.close();
		pw.close();
	}
}
