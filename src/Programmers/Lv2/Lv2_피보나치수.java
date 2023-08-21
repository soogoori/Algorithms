package Programmers.Lv2;

public class Lv2_피보나치수 {
    public static void main(String[] args){
        int n=5;
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int answer = 0;

        int[] dp = new int[10001];
        dp[0]=0;
        dp[1]=1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        answer = dp[n];
        return answer;
    }
}
