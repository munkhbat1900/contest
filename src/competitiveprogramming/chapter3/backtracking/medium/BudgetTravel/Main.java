package competitiveprogramming.chapter3.backtracking.medium.BudgetTravel;

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
 * UVA 222 - Budget Travel
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

	static double distance;
	static double capacity;
	static double consume;
	static int number;
	static List<Station> stationList;
	static double cost;
	static double minCost;

	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}

	static boolean hasReachedGoal(double currentDis, double currentGas) {
		if ((distance - currentDis) / consume <= currentGas) {
			return true;
		}
		return false;
	}

	static boolean ableToReachNextStation(int stationNum, double currentDis, double currentGas) {
		if ((stationList.get(stationNum).dist - currentDis) / consume <= currentGas) {
			return true;
		}
		return false;
	}

	static void solve(int nextStation, double currentGas, double currentDis) {
		if (hasReachedGoal(currentDis, currentGas)) {
			minCost = Math.min(minCost, cost);
			return;
		} else if (nextStation >= number) {
			return;
		} else {
			double gasUse = (stationList.get(nextStation).dist - currentDis) / consume;
			if (ableToReachNextStation(nextStation, currentDis, currentGas) && currentGas > capacity / 2) {
				solve(nextStation + 1, currentGas - gasUse, stationList.get(nextStation).dist);
			} else if (!ableToReachNextStation(nextStation, currentDis, currentGas)) {
				cost += 200 + (capacity - currentGas) * stationList.get(nextStation - 1).price;
				currentGas = capacity;
				solve(nextStation + 1, currentGas - gasUse, stationList.get(nextStation).dist);
			} else {
				//buy
				double tmpCost = cost;
				cost += 200 + (capacity - currentGas) * stationList.get(nextStation - 1).price;
				double tmpGas = currentGas;
				currentGas = capacity;
				solve(nextStation + 1, currentGas - gasUse, stationList.get(nextStation).dist);
				cost = tmpCost;
				currentGas = tmpGas;
				// don't buy
				solve(nextStation + 1, currentGas - gasUse, stationList.get(nextStation).dist);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		int counter = 1;
		while (true) {
			String str = br.readLine();
			if (str.contains("-")) {
				break;
			}

			StringTokenizer st = new StringTokenizer(str);
			distance = Double.parseDouble(st.nextToken());
			st = new StringTokenizer(br.readLine());
			capacity = Double.parseDouble(st.nextToken());
			consume = Double.parseDouble(st.nextToken());
			cost = Double.parseDouble(st.nextToken()) * 100;
			number = Integer.parseInt(st.nextToken());

			stationList = new ArrayList<>();
			minCost  = Integer.MAX_VALUE;

			for (int i = 0; i < number; i++) {
				Station station = new Station();
				st = new StringTokenizer(br.readLine());
				station.dist = Double.parseDouble(st.nextToken());
				station.price = Double.parseDouble(st.nextToken());
				stationList.add(station);
			}
			solve(0, capacity, 0f);
			pw.printf("Data Set #%d\n", valueOf(counter));
			pw.printf("  minimum cost = $%.2f\n", Double.valueOf(minCost / 100));
			counter++;
		}
		br.close();
		pw.flush();
		pw.close();
	}

	private static class Station {
		double dist;
		double price;

	}
}
