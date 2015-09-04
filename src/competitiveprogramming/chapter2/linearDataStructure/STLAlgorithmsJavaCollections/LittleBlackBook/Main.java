package competitiveprogramming.chapter2.linearDataStructure.STLAlgorithmsJavaCollections.LittleBlackBook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Avirmed Munkhbat
 * UVA 450 - Little Black Book
 */

class Person implements Comparable<Person> {
	String degree;
	String first;
	String second;
	String dep;
	String street;
	String homephone;
	String workphone;
	String campusbox;
	
	@Override
	public int compareTo(Person o) {
		return this.second.compareTo(o.second);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(degree);
		sb.append(" ");
		sb.append(first);
		sb.append(" ");
		sb.append(second);
		sb.append("\n");
		sb.append(street);
		sb.append("\n");
		sb.append("Department: ");
		sb.append(dep);
		sb.append("\n");
		sb.append("Home Phone: ");
		sb.append(homephone);
		sb.append("\n");
		sb.append("Work Phone: ");
		sb.append(workphone);
		sb.append("\n");
		sb.append("Campus Box: ");
		sb.append(campusbox);
		sb.append("\n");
		return sb.toString();
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		
		int c = Integer.parseInt(br.readLine());
		List<Person> pList = new ArrayList<Person>();
		while (c > 0) {
			String dep = br.readLine();
			while (true) {
				String line = br.readLine();
				if (line == null || "".equals(line)) {
					break;
				}
				String[] str = line.split(",", 0);
				Person p = new Person();
				p.dep = dep;
				p.degree = str[0];
				p.first = str[1];
				p.second = str[2];
				p.street = str[3];
				p.homephone = str[4];
				p.workphone = str[5];
				p.campusbox = str[6];
				pList.add(p);
			}
			c--;
		}
		Collections.sort(pList);
		for (Person p : pList) {
			pw.println("----------------------------------------");
			pw.print(p.toString());
		}
		
		br.close();
		pw.flush();
		pw.close();
	}
}
