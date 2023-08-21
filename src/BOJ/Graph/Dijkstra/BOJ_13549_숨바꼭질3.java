package BOJ.Graph.Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13549_숨바꼭질3 {
    static int N, K;
    static boolean[] visit;
    static int min = Integer.MAX_VALUE;

    static class Info{
        int K, time;

        public Info(int k, int time) {
            K = k;
            this.time = time;
        }
    }

    static void bfs(){
        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(N, 0));

        while (!queue.isEmpty()) {
            Info now = queue.poll();

            if (now.K == K) {
                min = Math.min(min, now.time);
            }

            if (now.K * 2 <= 100000 && !visit[now.K * 2]) {
                queue.add(new Info(now.K * 2, now.time));
                visit[now.K*2] = true;
            }

            if (now.K + 1 <= 100000 && !visit[now.K + 1]) {
                queue.add(new Info(now.K + 1, now.time + 1));
                visit[now.K+1] = true;
            }

            if (now.K - 1 >= 0 && !visit[now.K - 1]) {
                queue.add(new Info(now.K - 1, now.time + 1));
                visit[now.K-1] = true;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visit = new boolean[100001];
        bfs();
        System.out.println(min);

    }
}
