package Programmers.Lv2;

/**
 * 풀이법 꽤 다양
 * DP, BFS, Hash 등..
 */
public class Lv2_숫자변환하기 {
    public static void main(String[] args) {
        int x = 2;
        int y = 5;
        int n = 4;

        System.out.println(solution(x, y, n));
    }

    public static int solution(int x, int y, int n) {
        int[] dp = new int[y + 1];

        for (int i = x; i <= y; i++) {
            if (i!=x && dp[i]==0) {
                dp[i]=-1;
                continue;
            }

            if (i * 2 <= y) {
                dp[i*2] = dp[i*2]==0 ? dp[i]+1 : Math.min(dp[i*2], dp[i]+1);
            }

            if (i * 3 <= y) {
                dp[i * 3] = dp[i * 3] == 0 ? dp[i] + 1 : Math.min(dp[i * 3], dp[i] + 1);
            }

            if (i + n <= y) {
                dp[i + n] = dp[i + n] == 0 ? dp[i] + 1 : Math.min(dp[i + n], dp[i] + 1);
            }
        }

        return dp[y];
    }
}
