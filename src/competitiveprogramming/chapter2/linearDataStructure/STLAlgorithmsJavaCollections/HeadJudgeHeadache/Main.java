package competitiveprogramming.chapter2.linearDataStructure.STLAlgorithmsJavaCollections.HeadJudgeHeadache;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author Avirmed Munkhbat
 * UVA 790 - Head Judge Headache
 * not accepted WA
 * Maybe test case #51 from uDebug fails. in local eclipse environment, it inserts new line.
 * And also input specification differs from real input.
 */

class Team implements Comparable<Team> {
	int solved = 0;
	int rank = 0;
	int teamNo;
	int time = 0;
	Map<String, Integer> failedProblems = new HashMap<String, Integer>();
	Map<String, Integer> probTime = new HashMap<String, Integer>();

	public void solved(String prob, int time) {
		int t = getTime(prob, time);
		if (probTime.get(prob) == null) {
			probTime.put(prob, Integer.valueOf(time));
			solved++;
			this.time += t;
		}
		
		if (probTime.get(prob).intValue() > time) {
			this.time -= probTime.get(prob).intValue() - t;
			probTime.put(prob, Integer.valueOf(time));
		}
	}
	
	public void failed(String prob, int time) {
		if (probTime.get(prob) != null && probTime.get(prob).intValue() > time) {
			//probTime.put(prob, Integer.valueOf(probTime.get(prob).intValue() + 20));
			this.time += 20;
		}
		failedProblems.put(prob, Integer.valueOf(time));
	}
	
	public int getTime(String prob, int t) {
		int tt = 0;
		if (failedProblems.get(prob) != null && failedProblems.get(prob).intValue() < t) {
			tt += 20;
		}
		tt += t;
		return tt;
	}

	@Override
	public int compareTo(Team o) {
		int s = Integer.compare(o.solved, solved);
		if (s != 0) {
			return s;
		}
		int t = Integer.compare(time, o.time);
		if (t != 0) {
			return t;
		}
		return Integer.compare(teamNo, o.teamNo);
	}
}

public class Main {
	static int parseTime(String str) {
		String[] s = str.split(":", 0);
		return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		int c = Integer.parseInt(br.readLine());
		br.readLine();
		while (c > 0) {
			Map<Integer, Team> teamMap = new HashMap<Integer, Team>();
			int maxTeam = 0;
			while (true) {
				String line;
				line = br.readLine();
				if (line == null || "".equals(line)) {
					break;
				}
				StringTokenizer st = new StringTokenizer(line);
				int teamNo = Integer.parseInt(st.nextToken());
				String prob = st.nextToken();
				String time = st.nextToken();
				String status = st.nextToken();
				Team team = teamMap.get(Integer.valueOf(teamNo));
				if (team == null) {
					team = new Team();
					teamMap.put(Integer.valueOf(teamNo), team);
					team.teamNo = teamNo;
				}
				if (status.equals("Y")) {
					team.solved(prob, parseTime(time));
				} else {
					team.failed(prob, parseTime(time));
				}

				if (teamNo > maxTeam) {
					maxTeam = teamNo;
				}
			}

			List<Team> teamList = new ArrayList<Team>(teamMap.values());
			Collections.sort(teamList);
			// print result
			int rank = 1;
			boolean[] teams = new boolean[maxTeam];
			Arrays.fill(teams, false);
			pw.println("RANK TEAM PRO/SOLVED TIME");
			boolean hasZeroTime = false;
			//pw.print("case" + c + ":");
			for (int i = 0; i < teamList.size(); i++) {
				Team t = teamList.get(i);
				if (i - 1 >= 0) {
					Team prevT = teamList.get(i - 1);
					if (t.solved < prevT.solved) {
						rank = i + 1;
					} else if (t.time > prevT.time) {
						rank = i + 1;
					}
				}
				if (t.solved == 0) {
					hasZeroTime = true;
				}
				if (t.solved > 0) {
					pw.printf("%4d%5d%5d%11d\n", Integer.valueOf(rank), Integer.valueOf(t.teamNo), Integer.valueOf(t.solved), Integer.valueOf(t.time));
					teams[t.teamNo - 1] = true;
				}
			}
			if (!hasZeroTime) {
				rank++;
			}
			// remaining not submitted team
			for (int i = 0; i < maxTeam; i++) {
				if (!teams[i]) {
					pw.printf("%4d%5d\n", Integer.valueOf(rank), Integer.valueOf(i + 1));
				}
			}

			if (c > 0) {
				pw.println();
			}
			c--;
		}
		br.close();
		pw.flush();
		pw.close();
	}
}