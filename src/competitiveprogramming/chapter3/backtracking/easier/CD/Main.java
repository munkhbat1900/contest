package competitiveprogramming.chapter3.backtracking.easier.CD;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author munkhbat
 * UVA 624 - CD
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int n;
	static int[] lens;
	static List<Integer> tmpSolution;
	static List<Integer> solution;
	static int min = Integer.MAX_VALUE;
	/**
	 * number of tracks
	 */
	static int maxTrackNum = Integer.MIN_VALUE;
	
	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}
	
	static int getSum() {
		int sum = 0;
		for (Integer i : tmpSolution) {
			sum += lens[i.intValue()];
		}
		return sum;
	}
	
	private static void check() {
		int s = getSum();
		if ((n - s < min) || (n - s == min && maxTrackNum < tmpSolution.size())) {
			solution.clear();
			min = n - s;
			for (Integer i : tmpSolution) {
				solution.add(i);
			}
			maxTrackNum = solution.size();
		}
	}
	
	static void solve(int i, int sum) {
		int s = getSum();
		if (s > n) {
			return;
		}
		
		if (i == lens.length) {
			check();
			return;
		}
		
		solve(i + 1, sum);
		
		tmpSolution.add(valueOf(i));
		solve(i + 1, sum + lens[i]);
		tmpSolution.remove(tmpSolution.size() - 1);
	}
	
	public static void main(String[] args) throws IOException {
		while(true) {
			String str = br.readLine();
			if (str == null || str.equals("")) {
				break;
			}
			StringTokenizer st = new StringTokenizer(str);
			n = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			lens = new int[num];
			for (int i = 0; i < num; i++) {
				lens[i] = Integer.parseInt(st.nextToken());
			}
			tmpSolution = new ArrayList<>();
			solution = new ArrayList<>();
			min = Integer.MAX_VALUE;
			maxTrackNum = Integer.MIN_VALUE;
			solve(0, 0);
			for (Integer i : solution) {
				pw.printf("%d ", valueOf(lens[i.intValue()]));
			}
			pw.printf("sum:%d\n", valueOf(n - min));
		}
		br.close();
		pw.flush();
		pw.close();
	}
}
