package competitiveprogramming.chapter2.NonLinearDataStructure.map.TheDepartmentofRedundancyDepartment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author Avirmed Munkhbat
 * UVA 484 - The Department of Redundancy Department
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

	static Map<Integer, Integer> map;

	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}

	public static void main(String[] args) throws IOException {
		map = new LinkedHashMap<Integer, Integer>();

		while (true) {
			String s = br.readLine();
			if (s == null || s.equals("")) {
				break;
			}
			StringTokenizer st = new StringTokenizer(s);
			while (st.hasMoreTokens()) {
				Integer key = valueOf(Integer.parseInt(st.nextToken()));
				Integer el = map.get(key);
				if (el == null) {
					map.put(key, valueOf(1));
				} else {
					map.put(key, valueOf(el.intValue() + 1));
				}
			}
		}
		for (Map.Entry<Integer, Integer> val : map.entrySet()) {
			pw.printf("%d %d\n", val.getKey(), val.getValue());
		}

		br.close();
		pw.flush();
		pw.close();
	}
}
