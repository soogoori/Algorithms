package BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2775_부녀회장이될테야 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i=1; i<=T; i++){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            int[][]dp = new int[k+1][n+1];

            for(int m =1; m<=n; m++){
                dp[0][m] = m;
            }

            for(int j=1; j<=k; j++){
                for(int l=1; l<=n; l++){
                    dp[j][l] = dp[j][l-1]+dp[j-1][l];
                }
            }
            System.out.println(dp[k][n]);
        }
    }
}
