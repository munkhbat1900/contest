package competitiveprogramming.chapter2.linearDataStructure.queue.FerryLoadingIII;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author Avirmed Munkhbat
 * UVA 10901 - Ferry Loading III
 * tricky input
1
3 5 7
0 left
1 left
2 left
3 left
5 left
5 right
11 right
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int n, t, m;
	static int time;
	static boolean[] sides; // true : left false : right
	static int[] arrivalTime;
	static int[] crossTime;
	

	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}

	public static void main(String[] args) throws IOException {
		int sets = Integer.parseInt(br.readLine());
		int counter = 0;
		while (sets > 0) {
			if (counter > 0) {
				pw.println();
			}
			StringTokenizer st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			sides = new boolean[m];
			arrivalTime = new int[m];
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				arrivalTime[i] = Integer.parseInt(st.nextToken());
				sides[i] = "left".equals(st.nextToken());
			}

			Queue<Integer> leftBank = new ArrayDeque<Integer>();
			Queue<Integer> rightBank = new ArrayDeque<Integer>();
			Queue<Integer> inBoat = new ArrayDeque<Integer>();
			// start simulation
			time = Integer.MAX_VALUE;
			boolean isLeft = true;
			int index = 0;
			crossTime = new int[m];
			while (index < m || time != Integer.MAX_VALUE) {
				// accumulate left and right bank cars in queues
				if (index < m && arrivalTime[index] <= time) {
					(sides[index] ? leftBank : rightBank).offer(valueOf(index));
					if (time == Integer.MAX_VALUE) {
						time = arrivalTime[index];
					}
					index++;
				} else {
					// unload cars from ferry
					while (!inBoat.isEmpty()) {
						crossTime[inBoat.poll().intValue()] = time;
					}
					// if all the possible cars were transported, wait for next car arrival
					if (leftBank.isEmpty() && rightBank.isEmpty()) {
						time = Integer.MAX_VALUE;
					} else {
						Queue<Integer> currentQ = isLeft ? leftBank : rightBank;
						while (!currentQ.isEmpty() && inBoat.size() < n) {
							inBoat.offer(currentQ.poll());
						}
						// go to opposite bank
						time += t;
						isLeft = !isLeft;
					}
				}
			}
			for (int ti : crossTime) {
				pw.println(ti);
			}
			sets--;
			counter++;
		}
		pw.flush();
		br.close();
		pw.close();
	}
}
