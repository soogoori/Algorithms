package Programmers.DX;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 사이클이 존재하는 관계 중에서 가중치가 가장 적은 것 선택
 * 플로이드 워셜........
 */
public class Manito {

    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] arr = new int[N + 1][N + 1];

            for (int j = 1; j <= N; j++) {
                Arrays.fill(arr[j], INF);
            }

            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());

                arr[x][y] = z;
            }

            for (int j = 1; j <= N; j++) {
                for (int a = 1; a <= N; a++) {
                    if(arr[a][j]==INF)  continue;
                    for (int b = 1; b <= N; b++) {
                        if(arr[j][b] == INF)    continue;
                        arr[a][b] = Math.min(arr[a][b], arr[a][j]+arr[j][b]);
                    }
                }
            }

            int result = INF;

            for (int j = 1; j <= N; j++) {
                result = Math.min(arr[j][j], result);
            }

            if (result == INF) {
                result = -1;
            }
            System.out.println("#" + test_case + " " + result);
        }
    }
}