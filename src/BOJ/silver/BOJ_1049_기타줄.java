package BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1049_기타줄 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] cost =new int[M + 1][M + 1];
        int min = Integer.MAX_VALUE;

        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
        }

        if(N>6){
            for(int i=1; i<=M; i++){
                for(int j=1; j<=M; j++){
                    min = Math.min((N/6+1)*cost[i][0], Math.min(N*cost[i][1],Math.min((N/6)*cost[i][0]+(N%6)*cost[j][1], min)));
                }
            }
        }else{
            for(int i=1; i<=M; i++){
                min = Math.min(N*cost[i][1], Math.min(cost[i][0],min));
            }
        }
        System.out.println(min);
    }
}
