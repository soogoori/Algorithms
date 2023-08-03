package SDS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 최단경로 -> 다익스트라 알고리즘
 * 가중치 O, 방향 O
 */
public class BaekJoon_1753_최단경로 {

    static int V, E, k;
    static ArrayList<Info>[] list;
    static PriorityQueue<Info> pq;
    static int[] distance;
    static final int INF = Integer.MAX_VALUE;

    static class Info implements Comparable<Info> { // 우선순위 큐 사용하기 위해
        int node, dist;

        Info(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        // 가중치가 적은 순으로 나열-> 오름차순
        @Override
        public int compareTo(Info o) {
            return Integer.compare(dist, o.dist);
        }
    }

    static void dijkstra(int start){
        pq = new PriorityQueue<>();
        distance[start] = 0;

        // 가중치가 적은 순대로 우선순위 큐에 넣기
        pq.add(new Info(start, 0));

        while (!pq.isEmpty()) {
            Info now = pq.poll();

            if (now.dist > distance[now.node]) {
                continue;
            }

            for (Info next : list[now.node]) {
                if(distance[next.node] > distance[now.node] + next.dist){
                    distance[next.node] = distance[now.node] + next.dist;
                    pq.add(new Info(next.node, distance[next.node]));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        list = new ArrayList[V + 1];
        distance = new int[V + 1];

        for(int i=1; i<=V; i++){
            list = new ArrayList[i];
            distance[i]= INF;
        }

        k = Integer.parseInt(br.readLine());

        int u, v, w;
        for(int i=1; i<=E; i++){
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            list[u].add(new Info(v, w));
        }

        dijkstra(k);

        for (int i = 1; i <= V; i++) {
            if(distance[i]!=INF){
                bw.write(distance[i] + "\n");
            }else{
                bw.write("INF" + "\n");
            }
        }

        bw.flush();
        bw.close();

    }
}
