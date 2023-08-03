package SDS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 냅색 (배낭) 문제
 * DP[i][j] = 1~i번 App까지 확인했을 때 j의 비용으로 확보할 수 있는 최대 메모리 용량
 * DP[N (앱의 개수)][TotalCost (모든 어플을 종료하는데 드는 비용)]
 */
public class BaekJoon_7579_앱 {

    static int n,m;
    static int[] A,C;
    static int[][] dp;
    static int answer;
    static int totalCost;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        A = new int[n + 1];
        C = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            C[i] = Integer.parseInt(st.nextToken());
            totalCost+=C[i];
        }

        dp = new int[n + 1][totalCost + 1];

        for(int i=1; i<=n; i++){
            for (int j = 0; j <= totalCost; j++) {
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                if(j-C[i]>=0){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-C[i]] + A[i]);
                }
            }
        }

        for(int i=1; i<=totalCost; i++){
            if (dp[n][i] >= m) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }




}

