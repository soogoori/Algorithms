package BOJ.Lv.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_17425_약수의합 {

    static int MAX_SIZE = 1000001;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        long[] dp = new long[MAX_SIZE];
        Arrays.fill(dp, 1);

        for (int i = 2; i < MAX_SIZE; i++) {
            for(int j = i; j<MAX_SIZE; j+=i){ // 시간 복잡도 logN
                dp[j]+=i;
            }
            dp[i] = dp[i-1]+dp[i];
        }


        for(int i=1; i<=T; i++){
            int N = Integer.parseInt(br.readLine());

            System.out.println(dp[N]);

        }
    }
}
