package BOJ.Lv.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1946_신입사원 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            int N = Integer.parseInt(br.readLine());
            int[][] rank = new int[N+1][2];

            for(int i=1; i<=N; i++){
                st = new StringTokenizer(br.readLine());
                int docRank = Integer.parseInt(st.nextToken());
                int itvRank = Integer.parseInt(st.nextToken());

                rank[i][0] = docRank;
                rank[i][1] = itvRank;
            }

            Arrays.sort(rank, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0]-o2[0];
                }
            });

            int maxNum = 1;
            int prev_itv_min_rank = rank[1][1];
            for(int i=2; i<N; i++){
                if(prev_itv_min_rank>rank[i][1]){
                    prev_itv_min_rank = rank[i][1];
                    maxNum++;
                }
            }
            if(rank[N][1]==1)   maxNum++;

            System.out.println(maxNum);
        }
    }
}
