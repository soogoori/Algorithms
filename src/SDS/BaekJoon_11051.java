package SDS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_11051 {


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] cnk = new int[N+1][N+1];

        for(int i=0; i<=N; i++){
            cnk[0][i] = 1;
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=i; j++){
                cnk[i][j] = (cnk[i-1][j-1] + cnk[i-1][j])%10007;
            }
        }

        int answer = cnk[N][K];

        System.out.println(answer);
    }
}