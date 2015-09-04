package competitiveprogramming.chapter3.ThreeOrMoreNestedLoopsEasier.ThePathInTheColoredField;

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
 * 10102 - The path in the colored field
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}

	public static void main(String[] args) throws IOException {
		while(true) {
			String str = br.readLine();
			if (str == null || str.equals("")) {
				break;
			}
			int m = Integer.parseInt(str);
			
			List<Integer> oneX = new ArrayList<Integer>();
			List<Integer> oneY = new ArrayList<Integer>();
			List<Integer> threeX = new ArrayList<Integer>();
			List<Integer> threeY = new ArrayList<Integer>();
			for (int i = 0; i < m; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				str = st.nextToken();
				for (int j = 0; j < m; j++) {
					int c = str.charAt(j) - '0';
					if (c == 1) {
						oneX.add(valueOf(i));
						oneY.add(valueOf(j));
					} else if (c == 3) {
						threeX.add(valueOf(i));
						threeY.add(valueOf(j));
					}
				}
			}
			
			int maxMin = Integer.MIN_VALUE;
			for (int i = 0; i < oneX.size(); i++) {
				int min = Integer.MAX_VALUE;
				int x1 = oneX.get(i).intValue();
				int y1 = oneY.get(i).intValue();
				for (int j = 0; j < threeX.size(); j++) {
					int x2 = threeX.get(j).intValue();
					int y2 = threeY.get(j).intValue();
					min = Math.min(min, Math.abs(x1 - x2) + Math.abs(y1 - y2));
				}
				maxMin = Math.max(maxMin, min);
			}
			pw.println(maxMin);
		}
		br.close();
		pw.flush();
		pw.close();
	}
}
