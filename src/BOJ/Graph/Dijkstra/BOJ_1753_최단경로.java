package BOJ.Graph.Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753_최단경로 {
    static int V, E, K;
    static ArrayList<Info>[] graph;
    static int[] distance;
    static boolean[] visit;
    static int INF = 100;

    static class Info implements Comparable<Info>{
        int v, w;

        public Info(int v, int w) {
            this.v = v;
            this.w = w;
        }
        @Override
        public int compareTo(Info o) {
            return Integer.compare(this.w, o.w);
        }
    }

    static void dijkstra(int start){
        PriorityQueue<Info> pq = new PriorityQueue<>();
        pq.add(new Info(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Info now = pq.poll();

            if (!visit[now.v]) {
                visit[now.v] = true;
            }

            for (int i = 0; i < graph[now.v].size(); i++) {
                Info next = graph[now.v].get(i);

                if (!visit[next.v] && distance[next.v] > distance[now.v] + next.w) {
                    distance[next.v] = distance[now.v] + next.w;
                    pq.add(new Info(next.v, distance[next.v]));
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken()); // 정점 개수
        E = Integer.parseInt(st.nextToken()); // 간선 개수
        K = Integer.parseInt(st.nextToken()); // 시작 정점

        graph = new ArrayList[V+1];
        visit = new boolean[V+1];
        distance = new int[V+1];
        Arrays.fill(distance, INF);

        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Info(v, w));
        }
        dijkstra(K);

        for (int i = 1; i <= V; i++) {
            System.out.println(distance[i]==100 ? "INF" : distance[i]);
        }
    }
}
