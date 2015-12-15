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
 * actually there was a more compact solution. I thought my solution was long, so I went for google for other solutions.
 * I added in comment that compact solution.
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

	static double distance;
	static double capacity;
	static double consume;
	static int number;
	static List<Station> stationList;

	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}

	static boolean hasReachedGoal(double currentDis, double currentGas) {
		if (distance - currentDis <= currentGas * consume) {
			return true;
		}
		return false;
	}

	static boolean ableToReachNextStation(int stationNum, double currentDis, double currentGas) {
		if (stationList.get(stationNum).dist - currentDis <= currentGas * consume) {
			return true;
		}
		return false;
	}

	static double solve(int nextStation, double currentGas, double currentDis) {
		if (hasReachedGoal(currentDis, currentGas)) {
			return 0;
		} else if (nextStation >= number) {
			// refill in the last station;
			return 200 + (capacity - currentGas) * stationList.get(stationList.size() - 1).price;
		}
		double minCost = Double.MAX_VALUE;
		double gasUse = (stationList.get(nextStation).dist - currentDis) / consume;
		if (ableToReachNextStation(nextStation, currentDis, currentGas) && currentGas > capacity / 2) {
			return solve(nextStation + 1, currentGas - gasUse, stationList.get(nextStation).dist);
		} else if (!ableToReachNextStation(nextStation, currentDis, currentGas)) {
			double tmp = 200 + (capacity - currentGas) * stationList.get(nextStation - 1).price;
			return tmp + solve(nextStation + 1, capacity - gasUse, stationList.get(nextStation).dist);
		} else {
			double tmp = 200 + (capacity - currentGas) * stationList.get(nextStation - 1).price;
			minCost = Math.min(
					solve(nextStation + 1, currentGas - gasUse, stationList.get(nextStation).dist),
					tmp + solve(nextStation + 1, capacity - gasUse, stationList.get(nextStation).dist)
					);
		}
		return minCost;
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
			double cost = Double.parseDouble(st.nextToken());
			number = Integer.parseInt(st.nextToken());

			stationList = new ArrayList<>();

			for (int i = 0; i < number; i++) {
				Station station = new Station();
				st = new StringTokenizer(br.readLine());
				station.dist = Double.parseDouble(st.nextToken());
				station.price = Double.parseDouble(st.nextToken());
				stationList.add(station);
			}

			pw.printf("Data Set #%d\n", valueOf(counter));
			pw.printf("minimum cost = $%.2f\n", Double.valueOf(solve(0, capacity, 0f) / 100 + cost));
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


//public class Main {
//	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
//	static double distance;
//	static double capacity;
//	static double consume;
//	static int number;
//	static List<Station> stationList;
//
//	static Integer valueOf(int i) {
//		return Integer.valueOf(i);
//	}
//
//
//
//	static double solve(int currentStationNum, double currentDis) {
//		if (currentDis + capacity * consume >= distance || currentStationNum == number) {
//			return 0;
//		}
//
//		double minCost = Double.MAX_VALUE;
//		for (int i = currentStationNum; i < number; i++) {
//			double gasUse = (stationList.get(i).dist - currentDis) / consume;
//			if (capacity - gasUse < 0) {
//				break;
//			}
//
//			if (capacity - gasUse <= capacity / 2) {
//				minCost = Math.min(minCost, 200 + gasUse * stationList.get(i).price + solve(i + 1, stationList.get(i).dist));
//			} else if(capacity - gasUse > capacity / 2 && i + 1 < number && stationList.get(i + 1).dist > currentDis + capacity * consume) {
//				return 200 + gasUse * stationList.get(i).price + solve(i + 1, stationList.get(i).dist);
//
//			}
//
//		}
//
//		return minCost;
//
//	}
//
//	public static void main(String[] args) throws IOException {
//		int counter = 1;
//
//		while (true) {
//			String str = br.readLine();
//			if (str.contains("-")) {
//				break;
//			}
//
//			StringTokenizer st = new StringTokenizer(str);
//			distance = Double.parseDouble(st.nextToken());
//			st = new StringTokenizer(br.readLine());
//			capacity = Double.parseDouble(st.nextToken());
//			consume = Double.parseDouble(st.nextToken());
//			double cost = Double.parseDouble(st.nextToken());
//			number = Integer.parseInt(st.nextToken());
//			stationList = new ArrayList<>();
//			for (int i = 0; i < number; i++) {
//				Station station = new Station();
//				st = new StringTokenizer(br.readLine());
//				station.dist = Double.parseDouble(st.nextToken());
//				station.price = Double.parseDouble(st.nextToken());
//				stationList.add(station);
//			}
//
//			pw.printf("Data Set #%d\n", valueOf(counter));
//			pw.printf("  minimum cost = $%.2f\n", Double.valueOf(solve(0, 0) / 100 + cost));
//			counter++;
//		}
//
//		br.close();
//		pw.flush();
//		pw.close();
//	}
//
//	private static class Station {
//		double dist;
//		double price;
//	}
//}
