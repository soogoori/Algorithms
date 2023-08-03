package Programmers.Lv2;

public class Lv2_멀리뛰기 {
    public static void main(String[] args) {
        int n= 4;
        System.out.println(solution(n));
    }

    public static long solution(int n) {
        long answer = 0;

        long[] dp = new long[n+1];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        answer = dp[n]%1234567;

        return answer;
    }
}
