package BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149_RGB거리 {

    static int N;
    static int[][] cost;
    static int[][] dp;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        cost = new int[N + 1][4];
        dp = new int[N + 1][4];


        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=3; j++){
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=3; j++){
                if(j==1){
                    dp[i][j] = Math.min(dp[i - 1][j +1], dp[i - 1][j + 2]) + cost[i][j];
                }else if(j==2){
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j + 1]) + cost[i][j];
                }else{
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j -2]) + cost[i][j];
                }
            }
        }

        int ans=Integer.MAX_VALUE;
        for(int i=1; i<=3; i++){
            if(ans>dp[N][i]) {
                ans = dp[N][i];
            }
        }
        System.out.println("ans = " + ans);
    }
}
