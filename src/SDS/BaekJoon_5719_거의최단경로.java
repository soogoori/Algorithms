package SDS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 다익스트라 최단경로 응용문제
 * 1. 다익스트라로 최단경로 찾기 -> tracking set에 경로 저장
 * 2. tracking data set 이용해서 최단경로 간선 표시 -> 이 간선들을 사용하지 않기 위해서
 * 3. 다시 다익스트라 수행 -> 거의 최단경로 찾기
 */

public class BaekJoon_5719_거의최단경로 {
    static int n,m,s,d;
    static int u, v, p;
    static ArrayList<Info>[] list;
    static ArrayList<Integer>[] tracking; // Tracking[i] = i 와 인접한 정점중에서 최단경로로 올때 거치는 정점들
    static int[] distance;
    static boolean[][] isShortest; // 최단경로의 간선에 표시를 하는 배열, isShortest[i][j] = true, i 에서 j 로 가는 간선이 최단경로에 포함된다.
    static final int INF = Integer.MAX_VALUE;

    static class Info implements Comparable<Info>{
        int node; int len;

        public Info(int node, int len) {
            this.node = node;
            this.len = len;
        }

        @Override
        public int compareTo(Info o) {
            return Integer.compare(node, o.node);
        }
    }

    static void findShortestEdge(int now, int end) { // tracking data set 이용해서 최단경로 간선 선택 -> 백트래킹
        if (now == end) { // 도착했으면 끝
            return;
        }
        for (int next : tracking[now]) {
            if (isShortest[next][now] == false) {
                isShortest[next][now] = true; // 최단경로임을 체크해줌
                findShortestEdge(next, end);
            }
        }
    }

    static void dijkstra(int start){
        for(int i=0; i<n; i++){
            tracking[i] = new ArrayList<>();
        }
        Arrays.fill(distance, INF);
        PriorityQueue<Info> pq = new PriorityQueue<>();
        distance[start] = 0; // 출발지 비용=0
        pq.add(new Info(start, 0));

        while (!pq.isEmpty()) {
            Info now = pq.poll();

            // 더 큰 가중치로 도착한다면 패스
            if(now.len > distance[now.node]){
                continue;
            }
            for(Info info : list[now.node]){
                if (isShortest[now.node][info.node]) { // 2번째 다익스트라 호출 시 필요
                    continue;
                }

                // 최단경로 모두를 넣어줘야하므로, 다른 최단경로일 경우 백트래킹 대상(tracking)에 추가
                if(distance[info.node] == distance[now.node] + info.len){
                    tracking[info.node].add(now.node);
                }

                // 최단 경로 갱신
                if (distance[info.node] > distance[now.node] + info.len) {
                    tracking[info.node].clear();
                    tracking[info.node].add(now.node);
                    distance[info.node] = distance[now.node] + info.len;
                    pq.add(new Info(info.node, distance[info.node]));

                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if(n==0 && m==0){
                break;
            }

            list = new ArrayList[n+1];
            tracking = new ArrayList[n+1];
            distance = new int[n+1];
            isShortest = new boolean[n+1][n+1];

            for(int i=0; i<n; i++){
                list[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine(), " ");

            s = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            for(int i=1; i<=m; i++){
                st = new StringTokenizer(br.readLine(), " ");
                u = Integer.parseInt(st.nextToken());
                v = Integer.parseInt(st.nextToken());
                p = Integer.parseInt(st.nextToken());

                list[u].add(new Info(v, p));
            }

            dijkstra(s);

            if (distance[d] == INF) {
                bw.write(-1 + "\n");
                continue;
            }

            findShortestEdge(d, s);
            dijkstra(s);

            if (distance[d] == INF) {
                bw.write(-1 + "\n");
            }else{
                bw.write(distance[d] + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
