package BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1463_1로만들기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];

        dp[1] =0;

        for(int i=2; i<=N; i++){
            int idx = i;

            if(i%3==0){
                dp[i]++;
                if(i%2==0){
                    dp[i] +=Math.min(dp[idx-1],(Math.min(dp[idx/3], dp[idx/2])));
                }else{
                    dp[i] +=Math.min(dp[idx-1], dp[idx/3]);
                }
            }else{
                if(i%2==0){
                    dp[i]++;
                    dp[i] += Math.min(dp[idx-1], dp[idx/2]);
                }else{
                    dp[i]++;
                    dp[i] += dp[idx - 1];
                }
            }
        }
        System.out.println(dp[N]);
    }
}
