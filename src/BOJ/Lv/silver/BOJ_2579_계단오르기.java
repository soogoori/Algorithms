package BOJ.Lv.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * DP
 */

public class BOJ_2579_계단오르기 {

    /**
     * 반복문 이용해서 풀기 -> Bottom-Up
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] step = new int[N + 1];
        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            step[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 0;
        dp[1] = step[1];

        if (N >= 2) {
            dp[2] = dp[1] + dp[2];
        }

        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + step[i - 1]) + step[i];
        }
        System.out.println(dp[N]);
    }

    /**
     * 재귀호출 이용해서 풀기 -> Top-Down
     */
    /*static int find(int N) {
        if (dp[N] == null) {
            dp[N] = Math.max(find(N-2), find(N-3)+step[N-1]) + step[N];
        }
        return dp[N];
    }*/
}
