package BOJ.Graph.Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 단방향 그래프 -> 역방향으로 리스트 하나 더 만들고 구현
 */
public class BOJ_1238_파티 {
    static int N, M, X;
    static int start, end, T;
    static ArrayList<Info>[] village, backVillage;
    static int INF = Integer.MAX_VALUE;

    static class Info implements Comparable<Info> {
        int e, c;

        public Info(int e, int c) {
            this.e = e;
            this.c = c;
        }
        @Override
        public int compareTo(Info o) {
            return c-o.c;
        }
    }

    static int[] dijkstra(ArrayList<Info>[] list, int start) {
        PriorityQueue<Info> pq = new PriorityQueue<>();
        int[] distance = new int[N + 1];
        boolean[] visit = new boolean[N + 1];
        Arrays.fill(distance, INF);

        distance[start] = 0;
        pq.add(new Info(start, 0));

        while (!pq.isEmpty()) {
            Info now = pq.poll();

            if (!visit[now.e]) {
                visit[now.e] =true;
            }

            for (int i = 0; i < list[now.e].size(); i++) {
                Info next = list[now.e].get(i);

                if (distance[next.e] > distance[now.e] + next.c) {
                    distance[next.e] = distance[now.e] + next.c;
                    pq.add(new Info(next.e, distance[next.e]));
                }
            }
        }
        return distance;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        village = new ArrayList[N + 1];
        backVillage = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            village[i] = new ArrayList<>();
            backVillage[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            T = Integer.parseInt(st.nextToken());

            village[start].add(new Info(end, T));
            backVillage[end].add(new Info(start, T));
        }
        int[] cost = dijkstra(village, X);
        int[] reverseCost = dijkstra(backVillage, X);

        int result=0;
        for (int i = 1; i <= N; i++) {
            result = Math.max(result, cost[i] + reverseCost[i]);
        }
        System.out.println(result);
    }
}
