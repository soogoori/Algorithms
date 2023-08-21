package BOJ.Lv.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11724_연결요소의개수 {

    static int[][] graph;
    static boolean[] visit;
    static int N, M;

    static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            visit[now]= true;
            for (int j = 1; j <= N; j++) {
                if (graph[now][j] == 1 && !visit[j]) {
                    queue.add(j);
                    visit[j]= true;
                }
            }
        }
    }

    static void dfs(int i) {
        visit[i] = true;
        for (int j = 1; j <= N; j++) {
            if (graph[i][j] == 1 && !visit[j]) {
                dfs(j);
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];
        visit = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i][i] = 0;
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        int cnt =0;
        for (int i = 1; i <= N; i++) {
            if (!visit[i]) {
                bfs(i); //dfs(i);
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
