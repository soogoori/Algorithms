package BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * dp 동적계획법. 다이나믹 프로그래밍
 * 미해결
 */
public class BOJ_15989_123더하기4 {

    static long[] dp = new long[10001];

    static void findSum(){
        int cnt=0;

        dp[0]=0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 2; i <= 10000; i++) {

        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            findSum();
            System.out.println(dp[n]);
        }
    }
}
