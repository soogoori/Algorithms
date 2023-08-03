package Programmers.Lv2;

public class Lv2_2xn타일링 {
    public static void main(String[] args) {

        int n=60000;
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int answer = 0;

        int[] dp = new int[n + 1];

        dp[1]=1;
        dp[2]=2;

        if (n == 1) {
            return answer=1;
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2])%1000000007;
        }

        answer = dp[n];
        return answer;
    }
}
