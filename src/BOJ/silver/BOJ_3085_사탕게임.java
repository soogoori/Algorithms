package BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_3085_사탕게임 {

    static char[][] candy;
    static int N;
    static int max=0;

    static void arrCheck(){
        // 가로 체크
        for(int i=1; i<=N; i++){
            int cnt=1;
            for (int j = 1; j < N; j++) {
                if (candy[i][j] == candy[i][j + 1]) {
                    cnt++;
                }else{
                    cnt=1;
                }
                max = Math.max(max, cnt);
            }
        }

        // 세로 체크
        for (int i= 1; i <= N; i++) {
            int cnt = 1;
            for (int j = 1; j <N; j++) {
                if (candy[j][i] == candy[j + 1][i]) {
                    cnt++;
                }else{
                    cnt=1;
                }
                max = Math.max(max, cnt);
            }
        }
    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        candy = new char[N + 1][N + 1];

        for(int i=1; i<=N; i++){
            String line = br.readLine();
            for(int j=1; j<=N; j++){
                candy[i][j] = line.charAt(j-1);
            }
        }

        // 가로로 인접한 사탕 교환 -> 최대 사탕 개수 찾기 -> 원위치 복구
        for(int i=1; i<=N; i++){
            for(int j=1; j<N; j++){
                char temp = candy[i][j];
                candy[i][j] = candy[i][j+1];
                candy[i][j+1] = temp;

                // 최대 사탕 개수 찾기
                arrCheck();

                // 원위치 복구
                temp = candy[i][j];
                candy[i][j] = candy[i][j+1];
                candy[i][j+1] = temp;
            }
        }

        // 세로로 인접한 사탕 교환 -> 최대 사탕 개수 찾기 -> 원위치 복구
        for(int i=1; i<=N; i++){
            for(int j=1; j<N; j++){
                char temp = candy[j][i];
                candy[j][i] = candy[j+1][i];
                candy[j+1][i] = temp;

                // 최대 사탕 개수 찾기
                arrCheck();

                // 원위치 복구
                temp = candy[j][i];
                candy[j][i] = candy[j+1][i];
                candy[j+1][i] = temp;
            }
        }

        System.out.println(max);
    }
}
