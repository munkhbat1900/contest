package competitiveprogramming.chapter3.backtracking.easier.CallForwarding;

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
 * @author Munkhbat
 * UVA 380 - Call Forwarding
 */
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static List<CallForward> system;
	static String from;
	
	static Integer valueOf(int i) {
		return Integer.valueOf(i);
	}
	
	private static String solve(int time, String to) {
		for (CallForward forward : system) {
			if (forward.source.equals(to) && time >= forward.start && time <= forward.start + forward.duration) {
				if (!from.equals(forward.target)) {
					return solve(time, forward.target);
				} else {
					return "9999";
				}
			}
		}
		return to;
	}
	
	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(br.readLine());
		int counter = 0;
		
		pw.println("CALL FORWARDING OUTPUT");
		
		while (t > 0) {
			system = new ArrayList<CallForward>();
			
			//call forwarding system input
			while (true) {
				String str = br.readLine();
				if ("0000".equals(str)) {
					break;
				}
				StringTokenizer st = new StringTokenizer(str);
				CallForward sys = new CallForward();
				sys.source = st.nextToken();
				sys.start = Integer.parseInt(st.nextToken());
				sys.duration = Integer.parseInt(st.nextToken());
				sys.target = st.nextToken();
				system.add(sys);
			}
			
			
			pw.println("SYSTEM " + (counter + 1));
			// calls to call forwarding system
			while (true) {
				String str = br.readLine();
				if ("9000".equals(str)) {
					break;
				}
				StringTokenizer st = new StringTokenizer(str);
				int time = Integer.parseInt(st.nextToken());
				String to = st.nextToken();
				from = to;
				pw.printf("AT %04d CALL TO %s RINGS %s\n", valueOf(time), to, solve(time, to));
			}
			counter++;
			t--;
		}
		
		pw.println("END OF OUTPUT");
		
		br.close();
		pw.flush();
		pw.close();
	}
	
	private static class CallForward {
		String source;
		String target;
		int start;
		int duration;
	}
}
