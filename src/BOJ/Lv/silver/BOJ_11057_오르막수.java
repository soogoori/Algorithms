package BOJ.Lv.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_11057_오르막수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N+1][10];


        for(int i=0; i<10; i++){
           dp[1][i] =1;
        }

        for(int i=2; i<=N; i++){
            for(int j=0; j<10; j++){
                for(int k=j; k<10; k++){
                    dp[i][j] += dp[i-1][k];
                    dp[i][j]%=10007;
                }
            }
        }

        int answer = 0;

        for(int j=0; j<10; j++){
            answer += dp[N][j];
        }

        System.out.println(answer%10007);
    }
}
