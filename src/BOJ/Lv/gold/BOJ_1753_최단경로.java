package BOJ.Lv.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 다익스트라 기본 문제
 */
public class BOJ_1753_최단경로 {

    static int V, E, K;
    static ArrayList<Node>[] arr;
    static int[] d;
    static boolean[] visit;
    static int INF = 100;

    static class Node implements Comparable<Node>{
        int v, w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.w, o.w);
        }
    }

    static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        d[start] = 0;

        while (!pq.isEmpty()) {

            Node now = pq.poll();

            if (!visit[now.v]) {
                visit[now.v] = true;
            }

            for(int i=0; i<arr[now.v].size(); i++){
                Node next = arr[now.v].get(i);

                if (!visit[next.v] && d[next.v] > d[now.v]+ next.w) {
                    d[next.v] = d[now.v] + next.w;
                    pq.add(new Node(next.v, d[next.v]));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        arr = new ArrayList[V + 1];
        d = new int[V + 1];
        visit = new boolean[V + 1];
        Arrays.fill(d, INF);


        for(int i=1; i<=V; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i=1; i<=E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            arr[u].add(new Node(v, w));
        }

        dijkstra(K);

        for (int i = 1; i <=V; i++) {
            System.out.println(d[i] == 100 ? "INF" : d[i]);
        }
    }
}
