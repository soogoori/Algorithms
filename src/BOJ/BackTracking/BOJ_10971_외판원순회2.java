package BOJ.BackTracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_10971_외판원순회2 {

    static boolean[] visit;
    static int[][] map;
    static int minCost=Integer.MAX_VALUE, N;

    static void tsp(int start, int now, int cityCnt, int cityCost){

        if (cityCnt == N) {
            if (map[now][start] != 0) {
                minCost = Math.min(minCost, cityCost+map[now][start]);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i] && map[now][i] != 0) {
                visit[i] = true;
                tsp(start, i,cityCnt + 1, cityCost + map[now][i]);
                visit[i] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            visit[i] = true;
            tsp(i, i,1, 0);
        }

        bw.write(minCost+ " ");
        bw.flush();
        bw.close();
    }
}
