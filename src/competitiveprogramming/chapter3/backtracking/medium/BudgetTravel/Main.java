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

	static float distance;
	static float capacity;
	static float consume;
	static int number;
	static List<Station> stationList;
	static float cost;
	static float minCost;

	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}

	static boolean hasReachedGoal(float currentDis, float currentGas) {
		if ((distance - currentDis) / consume <= currentGas) {
			return true;
		}
		return false;
	}

	static boolean ableToReachNextStation(int stationNum, float currentDis, float currentGas) {
		if (stationList.get(stationNum).dist - currentDis / consume <= currentGas) {
			return true;
		}
		return false;
	}

	static void solve(int currentStationNum, float currentGas, float currentDis) {
		if (hasReachedGoal(currentDis, currentGas)) {
			minCost = Math.min(minCost, cost);
			return;
		} else {
			for (int i = currentStationNum + 1; i < stationList.size(); i++) {
				if (ableToReachNextStation(i, currentDis, currentGas) && currentGas > capacity / 2) {
					solve(currentStationNum + 1,
							currentGas - (stationList.get(i).dist - currentDis) / consume,
							stationList.get(i).dist);
					continue;
				}
				if (!ableToReachNextStation(i, currentGas, currentDis)) {
					cost += (capacity - currentGas) * stationList.get(i).price;
					cost += 2.00;
					currentGas = capacity;
					solve(currentStationNum + 1,
							currentGas - (stationList.get(i).dist - currentDis) / consume,
							stationList.get(i).dist);
					continue;
				}
				
				// don't buy
				solve(i,
						currentGas - (stationList.get(i).dist - currentDis) / consume,
						stationList.get(i).dist);
				
				//buy
				cost += (capacity - currentGas) * stationList.get(i).price;
				cost += 2.00;
				currentGas = capacity;
				solve(currentStationNum + 1,
						currentGas - (stationList.get(i).dist - currentDis) / consume,
						stationList.get(i).dist);
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

			cost = 0;
			StringTokenizer st = new StringTokenizer(str);
			distance = Float.parseFloat(st.nextToken());
			st = new StringTokenizer(br.readLine());
			capacity = Float.parseFloat(st.nextToken());
			consume = Float.parseFloat(st.nextToken());
			cost += Float.parseFloat(st.nextToken());
			number = Integer.parseInt(st.nextToken());

			stationList = new ArrayList<>();
			minCost  = Integer.MAX_VALUE;

			for (int i = 0; i < number; i++) {
				Station station = new Station();
				st = new StringTokenizer(br.readLine());
				station.dist = Float.parseFloat(st.nextToken());
				station.price = Float.parseFloat(st.nextToken());
				stationList.add(station);
			}
			solve(0, capacity, 0f);
			pw.printf("Data Set #%d", valueOf(counter));
			pw.printf("  minimum cost = %f\n", Float.valueOf(minCost));
		}
		br.close();
		pw.flush();
		pw.close();
	}

	private static class Station {
		float dist;
		float price;

	}
}
