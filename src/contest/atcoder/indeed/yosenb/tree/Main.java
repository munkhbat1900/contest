package contest.atcoder.indeed.yosenb.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author munkhbat
 *　http://indeednow-qualb.contest.atcoder.jp/tasks/indeednow_2015_qualc_3
 * prim
 */
public class Main {
	private static List<List<Integer>> graph = new ArrayList<List<Integer>>();;
	private static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		graph = new ArrayList<List<Integer>>();
		
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<Integer>()); 
		}
		
		for (int i = 0; i < n - 1; i++) {
			int s = sc.nextInt();
			int t = sc.nextInt();
			graph.get(s - 1).add(t - 1);
			graph.get(t - 1).add(s - 1);
		}
		
		prim();
		
		sc.close();
	}
	
	static void prim() {
		boolean[] used = new boolean[n];
		
		Queue<Integer> q = new PriorityQueue<Integer>();
		q.offer(0);
		used[0] = true;
		int i = 0;
		StringBuilder sb = new StringBuilder();
		
		while(!q.isEmpty()) {
			int a = q.poll();
			sb.append(a + 1);
			
			if (i != n - 1) {
				sb.append(" ");
			}
			
			i++;
			for (Integer e2 : graph.get(a)) {
				if (used[e2]) {
					continue;
				}
				q.offer(e2);
				used[e2] = true;
			}
		}
		
		System.out.println(sb.toString());
	}
}
