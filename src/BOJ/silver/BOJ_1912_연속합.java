package BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1912_연속합 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] num = new int[n + 1];
        int[] dp = new int[n + 1];
        int[] max = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = num[1];
        for(int i=2; i<n; i++){
            dp[i] = dp[i - 1] + num[i];
        }

        for(int i=1; i<n; i++){
            if(dp[i]+num[i+1]>=max[i]){
                max[i+1] = dp[i]+num[i+1];
            }else{
                max[i+1] = max[i];
            }
        }

        System.out.println(max[n]);
    }
}
