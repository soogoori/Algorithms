package BOJ.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 다익스트라
 */
public class BOJ_5972_택배배송 {

    static int N, M;
    static boolean[] visit;
    static int[] dist;
    static ArrayList<Info>[] arr;

    static class Info implements Comparable<Info>{
        int v, cost;

        public Info(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Info o) {
            return this.cost - o.cost;
        }
    }

    static void dijkstra(int start){
        PriorityQueue<Info> pq = new PriorityQueue<>();
        pq.add(new Info(start, 0));

        dist[start]=0;

        while (!pq.isEmpty()) {
            Info now = pq.poll();

            if (!visit[now.v]) {
                visit[now.v] = true;
            }

            for (Info next : arr[now.v]) {
                if (!visit[next.v] && dist[next.v] > dist[now.v] + next.cost) {
                    dist[next.v] = dist[now.v] + next.cost;
                    pq.add(new Info(next.v, dist[next.v]));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new int[N + 1];
        arr = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            arr[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        visit = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[a].add(new Info(b, c));
            arr[b].add(new Info(a, c));

        }

        dijkstra(1);

        for (int i : dist) {
            System.out.println("i = " + i);
        }
        System.out.println(dist[N]);
    }
}
