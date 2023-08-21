package BOJ.Graph.Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1916_최소비용구하기 {
    static int N, M;
    static ArrayList<Info>[] city;
    static int[] cost;
    static boolean[] visit;
    static int INF = Integer.MAX_VALUE;
    static class Info implements Comparable<Info>{
        int e, c;
        public Info(int e, int c) {
            this.e = e;
            this.c = c;
        }
        @Override
        public int compareTo(Info o) {
            return Integer.compare(this.c, o.c);
        }
    }

    static void dijkstra(int s){
        PriorityQueue<Info> pq = new PriorityQueue<>();
        pq.add(new Info(s, 0));
        cost[s] = 0;

        while (!pq.isEmpty()) {
            Info now = pq.poll();

            if (!visit[now.e]) {
                visit[now.e] = true;
            }

            for (int i = 0; i < city[now.e].size(); i++) {
                Info next = city[now.e].get(i);

                if (!visit[next.e] && cost[next.e] > next.c + cost[now.e]) {
                    cost[next.e] = next.c + cost[now.e];
                    pq.add(new Info(next.e, cost[next.e]));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        city = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        cost = new int[N + 1];

        Arrays.fill(cost, INF);

        for (int i = 1; i <= N; i++) {
            city[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            city[s].add(new Info(e, c));
        }
        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);
        System.out.println(cost[end]);
    }
}
