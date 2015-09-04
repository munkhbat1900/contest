package competitiveprogramming.chapter2.NonLinearDataStructure.priorityQueue.Argus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static PriorityQueue<Query> pq;
	static int k;

	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}

	public static void main(String[] args) throws IOException {
		pq = new PriorityQueue<Query>();
		k = 0;
		String s;
		while(!(s = br.readLine()).equals("#")) {
			StringTokenizer st = new StringTokenizer(s);
			st.nextToken();
			Query q = new Query();
			q.num = Integer.parseInt(st.nextToken());
			q.period = Integer.parseInt(st.nextToken());
			q.shokiPeriod = q.period;
			
			pq.offer(q);
		}
		k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {
			Query q = pq.poll();
			pw.println(q.num);
			
			q.period += q.shokiPeriod;
			pq.offer(q);
		}

		br.close();
		pw.flush();
		pw.close();
	}
}

class Query implements Comparable<Query> {
	int num;
	int period;
	int shokiPeriod;
	
	@Override
	public int compareTo(Query o) {
		int a = Integer.compare(period, o.period);
		if (a != 0) {
			return a;
		}
		return Integer.compare(num, o.num);
	}
	
}
