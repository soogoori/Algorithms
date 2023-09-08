package BOJ.Graph.BellmanFord;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1865_웜홀 {

    static int n, m, w; // n=지점의 수, m=도로의 수, w=웜홀의 수
    static ArrayList<Info>[] graph;
    static int INF = 1000000000;
    static int[] dist;

    static class Info{
        int e, t;

        public Info(int e, int t) {
            this.e = e;
            this.t = t;
        }
    }

    static boolean bellmanFord(){
        dist[1] =0;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < graph.length; j++) {
                for (Info next : graph[j]) {
                    if (dist[next.e] > dist[j] + next.t) {
                        dist[next.e] = dist[j] + next.t;
                        System.out.println("next.e = " + next.e);
                        System.out.println("dist[next.e] = " + dist[next.e]);
                    }
                }
            }
            System.out.println("i = " + i);
        }

        for (int j = 1; j < graph.length; j++) {
            for (Info next : graph[j]) {
                if (dist[next.e] > dist[j] + next.t) {
                    System.out.println("N번째 :  next.e = " + next.e);
                    System.out.println("dist[j] = " + dist[j]);
                    System.out.println("next.t = " + next.t);
                    System.out.println("N번째 : dist[j] + next.t = " + (dist[j] + next.t));
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        for (int i = 0; i < TC; i++) {

            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            dist = new int[n + 1];
            Arrays.fill(dist, INF);
            graph = new ArrayList[n + 1];

            for (int j = 0; j < n + 1; j++) {
                graph[j] = new ArrayList<>();
            }


            // 도로의 정보
            //  S와 E는 연결된 지점의 번호, T는 이 도로를 통해 이동하는데 걸리는 시간
            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());

                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                graph[s].add(new Info(e, t));
                graph[e].add(new Info(s, t));
            }

            // 웜홀의 정보
            for (int j = 0; j < w; j++) {
                st = new StringTokenizer(br.readLine());

                int s = Integer.parseInt(st.nextToken()); // 시작 지점
                int e = Integer.parseInt(st.nextToken()); // 도착 지점
                int t = Integer.parseInt(st.nextToken()); // 줄어드는 시간

                graph[s].add(new Info(e, -t));
            }

            if (bellmanFord()) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
