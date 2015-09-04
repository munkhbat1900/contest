package competitiveprogramming.chapter2.NonLinearDataStructure.map.WordIndex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Avirmed Munkhbat
 * UVA 417 - Word Index
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	
	static Map<String, Integer> wordMap;
	
	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}
	
	public static void main(String[] args) throws IOException {
		wordMap = new TreeMap<String, Integer>();
		int count = 1;
		for (char i = 'a'; i <= 'z'; i++) {
			wordMap.put(Character.toString(i), valueOf(count++));
		}
		
		for (char i = 'a'; i <= 'y'; i++) {
			for (char j = (char)(i + 1); j <= 'z'; j++) {
				wordMap.put("" + i + j, valueOf(count++));
			}
		}
		
		for (char i = 'a'; i <= 'x'; i++) {
			for (char j = (char)(i + 1); j <= 'y'; j++) {
				for (char k = (char)(j + 1); k <= 'z'; k++) {
					wordMap.put("" + i + j + k, valueOf(count++));
				}
			}
		}
		
		for (char i = 'a'; i <= 'w'; i++) {
			for (char j = (char)(i + 1); j <= 'x'; j++) {
				for (char k = (char)(j + 1); k <= 'y'; k++) {
					for (char p = (char)(k + 1); p <= 'z'; p++) {
						wordMap.put("" + i + j + k + p, valueOf(count++));
					}
				}
			}
		}
		
		for (char i = 'a'; i <= 'v'; i++) {
			for (char j = (char)(i + 1); j <= 'w'; j++) {
				for (char k = (char)(j + 1); k <= 'x'; k++) {
					for (char p = (char)(k + 1); p <= 'y'; p++) {
						for (char q = (char)(p + 1); q <= 'z'; q++) {
							wordMap.put("" + i + j + k + p + q, valueOf(count++));
						}
					}
				}
			}
		}
		
		while (true) {
			String word = br.readLine();
			if (word == null || word.equals("")) {
				break;
			}
			Integer i = wordMap.get(word);
			if (i == null) {
				pw.println("0");
			} else {
				pw.println(i);
			}
		}
		pw.flush();
		br.close();
		pw.close();
	}
}
