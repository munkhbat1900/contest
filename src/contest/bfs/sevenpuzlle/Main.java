package contest.bfs.sevenpuzlle;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author munkhbat
 * AOJ 0121
 * 7 puzzle
 * calculate from reverse. calculate all minimum move count from state "01234567" to every state.
 */
public class Main {
	private static int[] d = new int[]{1, -1, 4, -4};
	
	/**
	 * key : puzzle state, value : minimum move count of hand.
	 */
	private static Map<String, Integer> map;
	private static String state;

	public static void main(String[] a) {
		map = new HashMap<String, Integer>();
		bfs();
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 8; i++) {
				sb.append(sc.nextInt());
			}
			state = sb.toString();
			System.out.println(map.get(state));
		}
		sc.close();
	}
	
	private static int getInitialPos(String str) {
		return str.indexOf('0');
	}
	
	private static void bfs() {
		Queue<String> queue = new LinkedList<String>();
		queue.add("01234567");
		map.put("01234567", 0);
		int initialPos = 0;
		
		while (queue.size() > 0) {
			String p = queue.poll();
			
			initialPos = getInitialPos(p);
			
			for (int i = 0; i < 4; i++) {
				int pos = initialPos + d[i];
				if (pos < 0 || pos >= 8) {
					continue;
				}
				
				if (initialPos == 3 && pos == 4) {
					continue;
				}
				
				if (initialPos == 4 && pos == 3) {
					continue;
				}
				
				char[] tmp = p.toCharArray();
				tmp[initialPos] = p.charAt(pos);
				tmp[pos] = '0';
				String newStr = new String(tmp);
				if (map.get(newStr) == null) {
					queue.add(newStr);
					map.put(newStr, map.get(p) + 1);
				}
			}
		}
	}
}
