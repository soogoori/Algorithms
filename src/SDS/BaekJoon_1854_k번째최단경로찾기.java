package SDS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 1. 출발지 거리 0으로 초기화 + 우선순위 큐에 넣기
 * 2. 우선순위 큐가 빈상태가 될때까지 아래 반복
 *      (1) 우선순위 큐에서 꺼내서 노드/거리 확인
 *      (2) 현재 저장된 최단거리와 비교해서 더 큰 경우 -> continue
 *      -> 이미 확정된 노드는 더이상 탐색 X. BUT 이 문제에서는 k번만큼 확정해야 함. => visit 배열 사용해서 확정한 횟수 기록
 *      (3) 인접 정점들을 순회하면서 최단거리 배열 갱신 -> 갱신되는 경우에는 다시 우선순위 큐에 넣음
 */
public class BaekJoon_1854_k번째최단경로찾기 {

    static int n,m,k;
    static ArrayList<Info>[] list;
    static int[] cost;
    static int[] visit;
    static final int INF = Integer.MAX_VALUE;

    static class Info implements Comparable<Info>{
        int city; int time;

        public Info(int city, int time) {
            this.city = city;
            this.time = time;
        }

        @Override
        public int compareTo(Info o) {
            return Integer.compare(time, o.time);
        }
    }

    static void dijkstra(int start) {
        PriorityQueue<Info> pq = new PriorityQueue<>();
        pq.add(new Info(start, 0));

        while (!pq.isEmpty()) {
            Info now = pq.poll();

            if (visit[now.city] == k) {
                continue;
            }

            visit[now.city]++;
            cost[now.city] = now.time;

            for (Info next : list[now.city]) {
                if(visit[next.city] <k){
                    pq.add(new Info(next.city, next.time + cost[now.city]));
                }
            }
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        cost = new int[n + 1];
        visit = new int[n + 1];

        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<>();
            cost[i] = INF;
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Info(b, c));
        }

        dijkstra(1);
    }
}
