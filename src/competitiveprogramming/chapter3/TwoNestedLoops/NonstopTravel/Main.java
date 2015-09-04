package competitiveprogramming.chapter3.TwoNestedLoops.NonstopTravel;

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
 * @author Avirmed Munkhbat
 * UVA 617 - Nonstop Travel
 * input format doesn't follow the input format in problem description
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int n;
	static float[] l;
	static int[] g, y, r;
	
	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}

	public static void main(String[] args) throws IOException {
		int counter = 0;
		while (true) {
			String line = br.readLine().trim();
			if (line == null || line.equals("")) {
				continue;
			}
			n = Integer.parseInt(line);
			if (n == -1) {
				break;
			}
			
			counter++;
			l = new float[n];
			g = new int[n];
			y = new int[n];
			r = new int[n];
			
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				l[i] = Float.parseFloat(st.nextToken());
				g[i] = Integer.parseInt(st.nextToken());
				y[i] = Integer.parseInt(st.nextToken());
				r[i] = Integer.parseInt(st.nextToken());
			}
			
			List<Integer> speedList = new ArrayList<Integer>();
			
			for (int speed = 30; speed <= 60; speed++) {
				boolean canGo = true;
				for (int i = 0; i < n; i++) {
					// time to reach traffic light in hours.
					float time = l[i] / speed;
					// which light lights
					float remaingSec = (time * 60 * 60) % (g[i] + y[i] + r[i]);
					// if red light then break
					if (remaingSec > g[i] + y[i]) {
						canGo = false;
						break;
					}
				}
				if (canGo) {
					speedList.add(valueOf(speed));
				}
			}
			
			if (speedList.size() == 0) {
				pw.printf("Case %d: No acceptable speeds.\n", valueOf(counter));
				continue;
			}
			
			int start = speedList.get(0).intValue();
			boolean isContinuous = false;
			pw.printf("Case %d: ", valueOf(counter));
			for (int i = 1; i < speedList.size(); i++) {
				if (speedList.get(i).intValue() - speedList.get(i - 1).intValue() == 1) {
					isContinuous = true;
					continue;
				} else if (isContinuous) {
					pw.printf("%d-%d", valueOf(start), speedList.get(i - 1));
					isContinuous = false;
					start = speedList.get(i).intValue();
				} else if (!isContinuous) {
					pw.printf("%d", speedList.get(i - 1));
					start = speedList.get(i).intValue();
				}
				pw.print(", ");
			}
			
			// the last answer
			if (isContinuous) {
				pw.printf("%d-%d\n", valueOf(start), speedList.get(speedList.size() - 1));
			} else {
				pw.printf("%d\n", speedList.get(speedList.size() - 1));
			}
		}
		br.close();
		pw.flush();
		pw.close();
	}
}
