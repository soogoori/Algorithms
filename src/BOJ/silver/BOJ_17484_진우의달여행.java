package BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 미해결
 */
public class BOJ_17484_진우의달여행 {

    static int N, M;
    static int[][] space;
    static int[][] dp;
    static int[] x = {-1, 0, 1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        space = new int[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < M; i++) {
            dp[0][i] = space[0][i];
        }

        int pre=-1;

        for (int i = 1; i < N; i++) {
            for (int j = 0; j <M; j++) {
                for (int k = 0; k < 3; k++) {
                    if (pre != k) {
                        int nx = j+x[k];

                        if(nx>=0 && nx<M){
                            if (dp[i - 1][nx] + space[i][j] < dp[i][j]) {
                                dp[i][j] = dp[i - 1][nx] + space[i][j];
                                pre = k;
                            }
                        }
                    }
                }

            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.println("dp = " + dp[i][j]);
            }
        }
        int ans=Integer.MAX_VALUE;

        for (int i = 0; i < M; i++) {
            ans = Math.min(ans, dp[N-1][i]);
        }

        System.out.println("ans = " + ans);
    }
}
