package competitiveprogramming.chapter3.dp.knapsack01.FerryLoading;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author munkhbat
 * UVA 10261 - Ferry Loading
 * topdown got AC in 0.400 secs
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int totalLen, currLen, sum = 0;
	static List<Integer> cars;
	static int[][] topDown;
	static int[][] load;

	/**
	 * true if car can be loaded on port side
	 */
	static int[][] prev;

	static int getRemR(int id, int reml) {
		int s = 0;
		for (int i = 0; i < id; i++) {
			s += cars.get(i).intValue();
		}
		return totalLen - (s - (totalLen - reml));
	}

	/**
	 * backtracking
	 * @param id
	 * @param reml
	 * @return
	 */
	static int topdown(int id, int reml) {
		int remR = getRemR(id, reml);
		if (id >= cars.size() || (reml < cars.get(id).intValue() && remR < cars.get(id).intValue())) {
			return id;
		}
		if (topDown[id][reml] != -1) {
			return topDown[id][reml];
		}
		if (reml >= cars.get(id).intValue()) {
			int res = topdown(id + 1, reml - cars.get(id).intValue());
			if (res > topDown[id][reml]) {
				topDown[id][reml] = res;
				load[id][reml] = reml - cars.get(id).intValue();
			}
		}
		if (remR >= cars.get(id).intValue()) {
			int res = topdown(id + 1, reml);
			if (res > topDown[id][reml]) {
				topDown[id][reml] = res;
				load[id][reml] = reml;
			}
		}
		return topDown[id][reml];
	}

	static void printSol(int id, int reml, int ans) {
		if (id >= ans) {
			return;
		}
		if (load[id][reml] == reml) {
			pw.println("starboard");
			printSol(id + 1, reml, ans);
		} else if (load[id][reml] == reml - cars.get(id).intValue()) {
			pw.println("port");
			printSol(id + 1, reml - cars.get(id).intValue(), ans);
		}
	}

	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		int counter = 0;
		while (t > 0) {
			br.readLine();
			if (counter > 0) {
				pw.println();
			}

			totalLen = Integer.parseInt(br.readLine()) * 100;
			cars = new ArrayList<>();

			while (true) {
				currLen = Integer.parseInt(br.readLine());
				if (currLen == 0) {
					break;
				}
				cars.add(Integer.valueOf(currLen));
				sum += currLen;
			}
			topDown = new int[cars.size()][totalLen + 1];
			load = new int[cars.size()][totalLen + 1];
			for (int i = 0; i < cars.size(); i++) {
				Arrays.fill(topDown[i], -1);
				Arrays.fill(load[i], -1);
			}
			int ans = topdown(0, totalLen);
			pw.println(ans);
			printSol(0, totalLen, ans);
			counter++;
			t--;
		}
		br.close();
		pw.flush();
		pw.close();
	}
}
