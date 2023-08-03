package BOJ.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 아직 이해 못함.
 */
public class BOJ_10971_외판원순회2 {

    static int N;
    static int[][] map;
    static boolean[] visit;
    static int minCost = Integer.MAX_VALUE;

    static void dfs(int start, int now, int cost, int depth){
        if (depth==N-1) {
            if (map[now][start] != 0) {
                minCost = Math.min(minCost, cost + map[now][start]);
            }
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visit[i] && map[now][i] != 0) {
                visit[i] = true;
                dfs(start, i, cost + map[now][i], depth + 1);
                visit[i] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        visit = new boolean[N];


        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            visit[i] = true;
            dfs(i, i,0, 0);
        }

        System.out.println(minCost);

    }
}
