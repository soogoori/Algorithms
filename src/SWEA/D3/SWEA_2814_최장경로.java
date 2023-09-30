package SWEA.D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_2814_최장경로 {

    static int[][] map;
    static boolean[] visit;
    static int N,M,cnt;
    static int max = Integer.MIN_VALUE;

    static void dfs(int start, int cnt){

        for (int i = 1; i <= N; i++) {
            if ((i != start) && !visit[i] && map[start][i] == 1) {
                visit[i] = true;
                dfs(i, cnt + 1);
                //visit[i] = false;
            }
        }

        max = Math.max(max, cnt);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {

            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new int[N + 1][N + 1];

            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[x][y]=1;
                map[y][x]=1;
            }

            for (int j = 1; j <= N; j++) {
                visit = new boolean[N + 1];
                visit[j] = true;
                dfs(j, 1);
                visit[j] = false;
            }

            bw.write("#" + i + " " + max + "\n");
        }
        bw.flush();
        bw.close();
    }
}
