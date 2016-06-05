package datastructures;
import java.io.*;
import java.util.*;

public class LongestCommonSubsequence {
    static  int[] a, b;
    static int n, m;
    static  int[][] dp;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    
    static void backtrack(int i, int j) {
        if (i <= -1 || j <= -1) {
            return;
        } else if (a[i] == b[j]) {
            backtrack(i - 1, j - 1);
            pw.print(a[i] + " ");
        } else if (dp[i + 1][j] > dp[i][j + 1]) {
            backtrack(i , j - 1);
        } else {
            backtrack(i - 1, j);
        }
    }
    
    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
       
        a = new int[n];
        b = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < m; j++) {
            b[j] = Integer.parseInt(st.nextToken());
        }
        
        dp = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i] == b[j]) {
                    dp[i + 1][j + 1] = 1 + dp[i][j];
                } else {
                     dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        backtrack(n - 1, m - 1);
        br.close();
		pw.flush();
		pw.close();
    }
}