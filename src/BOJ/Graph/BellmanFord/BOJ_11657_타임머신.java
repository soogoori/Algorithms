package BOJ.Graph.BellmanFord;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11657_타임머신 {

    static int N, M;
    static ArrayList<Info>[] bus;
    static long[] dist;
    static int INF = 1000000000;

    static class Info{
        int to, time;

        public Info(int to, int time) {
            this.to = to;
            this.time = time;
        }
    }

    static boolean bellmanFord(){
        dist[1] = 0;

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < bus.length; j++) {
                for (Info next : bus[j]) {

                    if (dist[j] == INF) break;
                    if (dist[next.to] > next.time + dist[j]) {
                        dist[next.to] = next.time + dist[j];
                    }
                }
            }
        }

        for (int j = 1; j < bus.length; j++) {
            for (Info next : bus[j]) {
                if(dist[j] == INF)  break;
                if (dist[next.to] > next.time + dist[j]) {
                    return true; // 음의 사이클 존재
                }
            }
        }
        return false;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        bus = new ArrayList[N + 1];
        dist = new long[N + 1];
        Arrays.fill(dist, INF);

        for(int i=1; i<=N; i++){
            bus[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            bus[a].add(new Info(b, c));
        }

        StringBuilder sb = new StringBuilder();
        if (bellmanFord()) { // 음의 사이클이 있으면 -1 출력
            sb.append("-1");

        } else {
            for (int i = 2; i <= N; i++) {

                if (dist[i] == INF) {
                    sb.append(-1 + "\n");
                }else{
                    sb.append(dist[i] + "\n");
                }
            }
        }
        System.out.println(sb);
    }
}
