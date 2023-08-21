package BOJ.Lv.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 최장 증가 부분 수열 (LIS)
 */
public class BOJ_11053_가장긴증가하는부분수열 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[] dp = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        for(int i=1; i<=N; i++){
            dp[i] =1;
            for(int j=1; j<i; j++){
                if (arr[j] < arr[i] && dp[i] < dp[j] + 1) {
                    dp[i]=dp[j]+1;
                }
            }
        }

        System.out.println(dp[2]);
    }

    /**
     * 재귀호출 -> Top-Down
     */
    /*static int LIS(int N) {
        if(dp[N]==null){
            dp[N]=1;

            for(int i=N; i>=1; i--){
                if(arr[i] < arr[N]){
                    dp[N] = Math.max(dp[N], LIS(i)+1);
                }
            }
        }
        return dp[N];
    }*/
}
