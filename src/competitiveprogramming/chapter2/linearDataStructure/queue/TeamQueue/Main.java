package competitiveprogramming.chapter2.linearDataStructure.queue.TeamQueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author Avirmed Munkhbat
 * UVA 540 - Team Queue
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static Map<Integer, Integer> elemTeamMap;
	
	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}
	
	public static void main(String[] args) throws IOException {
		int count = 0;
		while(true) {
			int t = Integer.parseInt(br.readLine());
			if (t == 0) {
				break;
			}
			count++;
			// read team data
			elemTeamMap = new HashMap<Integer, Integer>();
			for (int i = 0; i < t; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int m = Integer.parseInt(st.nextToken());
				while (m > 0) {
					elemTeamMap.put(valueOf(Integer.parseInt(st.nextToken())), valueOf(i));
					m--;
				}
			}
			
			List<Queue<Integer>> queueList = new ArrayList<>();
			// team order
			int[] teamOrder = new int[t];
			Arrays.fill(teamOrder, -1);
			pw.printf("Scenario #%d\n", Integer.valueOf(count));
			while (true) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String str = st.nextToken();
				if ("STOP".equals(str)) {
					break;
				} 
				
				if ("ENQUEUE".equals(str)) {
					int elem = Integer.parseInt(st.nextToken());
					int team = elemTeamMap.get(valueOf(elem)).intValue();
					if (teamOrder[team] <= -1) {
						Queue<Integer> q = new ArrayDeque<Integer>();
						q.offer(valueOf(elem));
						queueList.add(q);
						teamOrder[team] = queueList.size() - 1;
					} else {
						queueList.get(teamOrder[team]).offer(valueOf(elem));
					}
				} else {
					int index = -1;
					for (int p = 0; p < teamOrder.length; p++) {
						if (teamOrder[p] == 0) {
							index = p;
						}
					}
					pw.println(queueList.get(teamOrder[index]).poll());
					if (queueList.get(teamOrder[index]).isEmpty()) {
						queueList.remove(teamOrder[index]);
						for (int i = 0; i < teamOrder.length; i++) {
							teamOrder[i]--;
						}
					}
				}
			}
			pw.println();
		}
		pw.flush();
		br.close();
		pw.close();
	}
}
