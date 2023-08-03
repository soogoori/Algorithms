package BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_15988_123더하기3 {

    static long[] dp;
    static int n;

    static long getSum(int num){

        for (int i = 4; i <= n; i++) {
            dp[i] = (dp[i-1]+ dp[i-2] + dp[i-3])%1000000009;
        }

        return dp[num];
    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        dp = new long[1000001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 1; i <= T; i++) {
            n = Integer.parseInt(br.readLine());
            System.out.println(getSum(n));
        }
    }
}
