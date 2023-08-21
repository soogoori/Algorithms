package BOJ.Lv.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 최대 이익 구하기_dfs
 */
public class BOJ_14501_퇴사_dfs {

    static int[][] consult;
    static int N, result;

    static void dfs(int day, int profit){

        if(day>=N){
            result = Math.max(profit, result);
            return;
        }
        if(day+consult[day][0]<=N){
            dfs(day+consult[day][0], profit+consult[day][1]);
        }else{
            dfs(day+consult[day][0], profit);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        consult = new int[N + 1][2];

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            consult[i][0] = T;
            consult[i][1] = P;
        }

    }
}
