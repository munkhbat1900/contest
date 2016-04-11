package competitiveprogramming.chapter3.dp.LIS.MurciasSkyline;

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
 * UVA 11790 - Murcia's Skyline
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static List<Building> buildings;
	static int[] incr, decr;
	
	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		int counter = 1;
		
		while (t > 0) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			buildings = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				Building b = new Building();
				b.h = Integer.parseInt(st.nextToken());
				buildings.add(b);
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				buildings.get(i).w = Integer.parseInt(st.nextToken());
			}
			
			incr = new int[n];
			decr = new int[n];
			
			int max = 0;
			for (int i = 0; i < n; i++) {
				incr[i] = buildings.get(i).w;
				for (int j = 0; j < i; j++) {
					if (buildings.get(i).h > buildings.get(j).h && buildings.get(i).w + incr[j] > incr[i]) {
						incr[i] = buildings.get(i).w + incr[j];
					}
				}
				max = Math.max(max, incr[i]);
			}
			
			int max1 = 0;
			for (int i = n - 1; i >= 0; i--) {
				decr[i] = buildings.get(i).w;
				for (int j = n - 1; j > i; j--) {
					if (buildings.get(i).h > buildings.get(j).h && buildings.get(i).w + decr[j] > decr[i]) {
						decr[i] = buildings.get(i).w + decr[j];
					}
				}
				max1 = Math.max(max1, decr[i]);
			}
			
			if (max >= max1) {
				pw.printf("Case %d. Increasing (%d). Decreasing (%d).\n", 
						Integer.valueOf(counter), Integer.valueOf(max), Integer.valueOf(max1));
			} else {
				pw.printf("Case %d. Decreasing (%d). Increasing (%d).\n", 
						Integer.valueOf(counter), Integer.valueOf(max1), Integer.valueOf(max));
			}
			
			counter++;
			t--;
		}
		br.close();
		pw.flush();
		pw.close();
	}
	
	private static class Building {
		int w, h;
	}
}
