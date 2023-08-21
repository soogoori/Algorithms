package BOJ.Graph.Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 이거 쫌 어렵다.
 */
public class BOJ_1446_지름길 {
    static ArrayList<Info>[] path;
    static int[] distance;
    static int N, D;
    static int INF = Integer.MAX_VALUE;
    static class Info implements Comparable<Info>{
        int start, dist;

        public Info(int start, int dist) {
            this.start =start;
            this.dist = dist;
        }

        @Override
        public int compareTo(Info o) {
            return start-o.start;
        }
    }

    static void dijkstra(){
        distance[0] = 0;
        for (int i = 1; i <= D; i++) {
            if (path[i].size() > 0) {
                for (Info info : path[i]) {
                    if (distance[info.start] + info.dist > distance[i]) continue;
                    distance[i] = Math.min(distance[info.start] + info.dist, distance[i - 1] + 1);
                }
                continue;
            }
            distance[i] = distance[i - 1] + 1;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 지름길 개수
        D = Integer.parseInt(st.nextToken()); // 고속도로 길이
        distance = new int[D + 1];

        path = new ArrayList[100001];

        for (int i = 0; i < 100001; i++) {
            path[i] = new ArrayList<>();
        }

        Arrays.fill(distance, INF);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            if (e - s > d || e<=D) {
                path[e].add(new Info(s, d));
            }
        }
        dijkstra();
        System.out.println(distance[D]);
    }
}
