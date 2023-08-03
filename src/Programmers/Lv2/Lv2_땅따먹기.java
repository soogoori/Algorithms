package Programmers.Lv2;

public class Lv2_땅따먹기 {
    public static void main(String[] args) throws Exception{
        int[][] land = {{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}};
        System.out.println(solution(land));
    }

    static int solution(int[][] land) {

        int ans=0;
        int[][] dp = new int[land.length][4];

        for (int i = 0; i < 4; i++) {
            dp[0][i] = land[0][i];
        }

        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (j != k) {
                        dp[i][j] = Math.max(land[i][j] + dp[i - 1][k], dp[i][j]);
                    }
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            ans = Math.max(ans, dp[land.length-1][i]);
        }

        return ans;
    }

}
